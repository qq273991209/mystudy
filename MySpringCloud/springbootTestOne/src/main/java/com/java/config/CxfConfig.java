///**
// * Project Name:mySpringboot
// * File Name:CxfConfig.java
// * Package Name:com.java.config
// * Date:2019年5月21日上午9:57:35
// * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
//*/
//package com.java.config;
//import javax.xml.ws.Endpoint;
//import org.apache.cxf.Bus;
//import org.apache.cxf.bus.spring.SpringBus;
//import org.apache.cxf.jaxws.EndpointImpl;
//import org.apache.cxf.transport.servlet.CXFServlet;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import com.java.webservice.WebServiceApp;
//import com.java.webservice.WebServiceAppImpl;
///**
// * @Title: CxfConfig.java
// * @Package com.java.config
// * @Description: TODO(Cxf配置类)
// * @author 刘云升
// * @date 2019年5月21日 上午9:57:35 Copyright (c) ©1994-2019 Scjydz.com All Rights
// *       Reserved.
// */
//@Configuration
//public class CxfConfig {
//	
//	//发布服务名称，可以访问该路径查看拥有的webservice
//	@Bean
//	public ServletRegistrationBean dispatcherServlet() {
//		return new ServletRegistrationBean(new CXFServlet(), "/webservice/*");
//	}
//
//	@Bean(name = Bus.DEFAULT_BUS_ID)
//	public SpringBus springBus() {
//		return new SpringBus();
//	}
//
//	@Bean
//	public WebServiceApp WebService() {
//		return new WebServiceAppImpl();
//	}
//	/**
//     * 绑定接口类，描述接口实现方法，以及接口名称.如果有多个接口需要实现，可以添加多个该方法(设置方法名不同，发布路径不同即可)
//     * @return
//     */
//	@Bean
//	public Endpoint endpoint() {
//		EndpointImpl endpoint = new EndpointImpl(springBus(), WebService());
//		endpoint.publish("/api");
//		return endpoint;
//	}
//
//}
