package com.java.config;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @Title: ControllerLog.java 
 * @Package com.java.config 
 * @Description: TODO(ControllerLog日志注解类) 
 * @author 刘云升  
 * @date 2019年7月5日 下午2:01:18 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ControllerLog {
	String value()  default "";  
}
