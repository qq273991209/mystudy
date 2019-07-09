package cn.hfbin.seckill.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/**
 * 
 * @Title: AccessLimit.java 
 * @Package cn.hfbin.seckill.annotations 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 刘云升  
 * @date 2019年6月12日 下午5:59:55 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Retention(RUNTIME)
@Target(METHOD)
public @interface AccessLimit {
	int seconds();
	int maxCount();
	boolean needLogin() default true;
}
