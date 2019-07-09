/**
 * Project Name:mySpringboot
 * File Name:WebServiceAppImpl.java
 * Package Name:com.java.webservice
 * Date:2019年5月21日上午9:55:12
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.webservice;

import java.util.Date;

import javax.jws.WebService;

/**   
 * @Title: WebServiceAppImpl.java 
 * @Package com.java.webservice 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 刘云升  
 * @date 2019年5月21日 上午9:55:12 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */

@WebService(serviceName = "WebServiceApp", // 与接口中指定的name一致
        targetNamespace = "http://com.java.webservice.WebServiceApp", // 与接口中的命名空间一致,一般是接口的包名倒
        endpointInterface = "com.java.webservice.WebServiceApp"// 接口地址
)
public class WebServiceAppImpl implements WebServiceApp {

	@Override
	public String sayHello(String user) {
		
		return user+"，time："+"("+new Date()+")";
	}
}
