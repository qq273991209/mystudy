package com.java;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;
/**
 * @Title: Application.java 
 * @Package com.java.application 
 * @Description: TODO(启动服务) 
 * @author 刘云升  
 * @date 2019年5月20日 下午1:45:00 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@MapperScan(basePackages="com.java.mapper")//扫描mybatis mapper包路径
@ComponentScan(basePackages="com.java.*")
@SpringBootApplication
@EnableSwagger2
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
