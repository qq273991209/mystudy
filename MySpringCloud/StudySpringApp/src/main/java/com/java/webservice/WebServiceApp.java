/**
 * Project Name:mySpringboot
 * File Name:WebServiceApp.java
 * Package Name:com.java.webservice
 * Date:2019年5月21日上午9:53:06
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.webservice;

//import javax.jws.WebService;

/**   
 * @Title: WebServiceApp.java 
 * @Package com.java.webservice 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 刘云升  
 * @date 2019年5月21日 上午9:53:06 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */

//@WebService(name = "WebServiceApp", // 暴露服务名称
//    targetNamespace = "http://WebServiceApp.webservice.java.com"// 命名空间,一般是接口的包名倒序
//)
public interface WebServiceApp {
	
	public String sayHello(String user);
}
