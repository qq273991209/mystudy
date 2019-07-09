package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@EnableEurekaClient
@MapperScan(basePackages="com.java.mapper")//扫描mybatis mapper包路径
@ComponentScan(basePackages="com.java.*")
@SpringBootApplication
@EnableSwagger2
@EnableFeignClients
@Slf4j
public class SrpingEurekaClietApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrpingEurekaClietApplication.class, args);
		log.info("客户端一启动完成");
	}

}
