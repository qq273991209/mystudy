package com.java.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.java.mapper")
@SpringBootApplication(scanBasePackages = "com.java.*")
@EnableScheduling
public class StudySpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudySpringAppApplication.class, args);
	}

}
