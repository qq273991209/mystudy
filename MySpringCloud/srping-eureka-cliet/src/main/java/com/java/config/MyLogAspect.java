/**
 * Project Name:srping-eureka-cliet
 * File Name:MyLogAspect.java
 * Package Name:com.java.config
 * Date:2019年7月5日下午2:02:25
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.config;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**   
 * @Title: MyLogAspect.java 
 * @Package com.java.config 
 * @Description: TODO(日志切面类) 
 * @author 刘云升  
 * @date 2019年7月5日 下午2:02:25 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Aspect
@Component
@Slf4j
public class MyLogAspect {
	
	/**
	 * @description: Controller层切点
	 */
	@Pointcut("@annotation(com.java.config.ControllerLog)")
	public void controllerAspect() {
		
	}
	
//	/**
//	 * @description: Service层切点
//	 */
//	@Pointcut("@annotation(com.amt.component.ServiceLog)")
//	public void serviceAspect() {
//		
//	}
	 
	
	/**
	 * @description: 前置通知 用于拦截Controller层记录用户的操作
	 * @param joinPoint
	 */
	@Before(value = "controllerAspect()")
	public void doBefore(JoinPoint joinPoint) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
		this.save(request, joinPoint, null);
	}
	 
//	/** 
//	 * @description: 异常通知 用于拦截service层记录异常日志
//	 * @param joinPoint
//	 * @param e
//	 */
//	@AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
//	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
//		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();    
//		this.save(request, joinPoint, e);
//	}
	
	/**
	 * @description: 保存日志内容
	 * @param request
	 * @param joinPoint
	 * @param e
	 */
	public void save(HttpServletRequest request, JoinPoint joinPoint, Throwable e) {
        //请求的IP    
        String ip = request.getRemoteAddr();  
        
        try {
        	// 获取用户请求方法的参数并序列化为JSON格式字符串, 自带的HttpServletRequest, HttpServletResponse不管
        	String params = "";
			if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
				for (Object o : joinPoint.getArgs()) {
                    if (o instanceof HttpServletRequest || o instanceof HttpServletResponse) {
                        continue;
                    }
                    params += JSON.toJSONString(o) + ";";
                }
			}
			
			// 控制台输出
            log.info("=======================通知开始=======================");
            if(e != null) {
            	log.info("异常代码:" + e.getClass().getName());
            	log.info("异常信息:" + e.getMessage());
            	log.info("异常方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            	log.info("异常参数:" + params);
            }
            log.info("方法描述:" + getMethodDescription(joinPoint));
            log.info("请求方法:" + (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
            log.info("请求参数:" + params);
            log.info("请求IP:" + ip);
			log.info("=======================通知结束=======================");
		} catch (Exception e1) {
			//记录本地异常日志    
			log.error("前置通知异常信息:{}", e1.getMessage()); 
			e1.printStackTrace();
			log.info("=======================通知结束=======================");
		}
	}
	
	
	/**
	 * @Description: 获取注解中对方法的描述信息 用于Controller层注解
	 * @param @param joinPoint 切点
	 * @param @return
	 * @param @throws Exception    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	private String getMethodDescription(JoinPoint joinPoint)  throws Exception {    
        String targetName = joinPoint.getTarget().getClass().getName();    
        String methodName = joinPoint.getSignature().getName();    
        Object[] arguments = joinPoint.getArgs();    
        Class<?> targetClass = Class.forName(targetName);    
        Method[] methods = targetClass.getMethods();    
        String description = "";    
         for (Method method : methods) {    
             if (method.getName().equals(methodName)) {    
                Class<?>[] clazzs = method.getParameterTypes();    
                 if (clazzs.length == arguments.length) {    
                    description = method.getAnnotation(ControllerLog. class).value();
                     break;    
                }    
            }    
        }    
         return description;    
    }

}
