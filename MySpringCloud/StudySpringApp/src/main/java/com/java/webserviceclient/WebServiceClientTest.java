/**
 * Project Name:mySpringboot
 * File Name:WebServiceClientTest.java
 * Package Name:com.java.webserviceclient
 * Date:2019年5月21日上午10:43:14
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.webserviceclient;

//import org.apache.cxf.endpoint.Client;
//import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

import com.java.util.WebServiceUtil;
import com.java.util.XmlUtil;

//import org.apache.cxf.endpoint.Client;
//import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
//import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
//import org.apache.cxf.transport.http.HTTPConduit;
//import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

//import com.java.webservice.WebServiceApp;
//import com.java.webservice.WebServiceAppImpl;
/**
 * @Title: WebServiceClientTest.java
 * @Package com.java.webserviceclient
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 刘云升
 * @date 2019年5月21日 上午10:43:14 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
public class WebServiceClientTest {

	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
//		String address = "http://localhost:9998/spring/webservice/api?wsdl";
		String address = "http://www.webxml.com.cn/WebServices/TranslatorWebService.asmx?wsdl"; 
		// 创建动态客户端
//		JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
//		Client client = dcf.createClient("http://localhost:9998/spring/webservice/api?wsdl");
//
//		// 需要密码的情况需要加上用户名和密码
//		// client.getOutInterceptors().add(new
//		// ClientLoginInterceptor(USER_NAME,PASS_WORD));
//		Object[] objects = new Object[0];
//
//		// invoke("方法名",参数1,参数2,参数3....); 
//		objects = client.invoke("sayHello", "wyj");
//		System.out.println("返回数据:" + objects[0]);
		// 创建动态客户端
//		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
//		Client client = factory.createClient(address);
//		// 需要密码的情况需要加上用户名和密码
//		// client.getOutInterceptors().add(new
//		// ClientLoginInterceptor(USER_NAME,PASS_WORD));
//		HTTPConduit conduit = (HTTPConduit) client.getConduit();
//		HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
//		httpClientPolicy.setConnectionTimeout(2000); // 连接超时
//		httpClientPolicy.setAllowChunking(false); // 取消块编码
//		httpClientPolicy.setReceiveTimeout(120000); // 响应超时
//		conduit.setClient(httpClientPolicy);
//		// client.getOutInterceptors().addAll(interceptors);//设置拦截器
		Object[] objects = new Object[0];
//		// invoke("方法名",参数1,参数2,参数3....);
//		objects = client.invoke("getEnCnTwoWayTranslator", "ssdsd");
//		System.out.println("返回数据:" + objects[0]);
		
//		// 代理工厂
//		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		// 设置代理地址
//		jaxWsProxyFactoryBean.setAddress(address);
//		// 设置接口类型
//		jaxWsProxyFactoryBean.setServiceClass(WebServiceApp.class);
//		// 创建一个代理接口实现
//		WebServiceApp cs = (WebServiceApp) jaxWsProxyFactoryBean.create();
		// 数据准备
//		@SuppressWarnings("unused")
//		String userName = "Leftso";
		// 调用代理接口的方法调用并返回结果
//		String result = cs.sayHello(userName);
//		System.out.println("返回结果:" + result);
//		WebServiceUtil serviceUtil = new WebServiceUtil();
//		String xml = "<qqCode>273991209</qqCode>";
//		System.out.println(WebServiceUtil.requestWSDL(address, "qqCheckOnline",null, xml));
//		System.out.println(XmlUtil.parse(WebServiceUtil.requestWSDL(address, "qqCheckOnline",null, xml)));
		
		
		
		

	}

}
