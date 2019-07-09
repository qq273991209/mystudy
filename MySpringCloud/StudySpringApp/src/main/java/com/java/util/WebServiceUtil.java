/**
 * Project Name:StudySpringApp
 * File Name:WebSeriveUtil.java
 * Package Name:com.java.util
 * Date:2019年6月17日下午5:20:33
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

/**
 * @Title: WebServiceUtil.java
 * @Package com.java.util
 * @Description: TODO(远程调用webService)
 * @author 刘云升
 * @date 2019年6月17日 下午5:20:33 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
public class WebServiceUtil {

	/**
	 * 
	 * @description: HttpURLConnection远程执行POST方法调用外部接口
	 * @param address     外部url地址
	 * @param method      接口方法
	 * @param RequestCode 业务代码
	 * @param xml         传参格式为<id>1</id><name>张三</name>
	 * @return 接口调用XML字符串
	 * @throws Exception io异常
	 */
	public static String requestWSDL(String address, String method, String RequestCode, String xml) throws Exception {
		// 创建服务地址
		URL url = new URL(address);
		// 打开一个通向服务地址的连接
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		// 设置参数
		// 发送方式设置：POST必须大写
		connection.setRequestMethod("POST");
		// 设置数据格式：content-type
		connection.setRequestProperty("content-type", "text/xml;charset=utf-8");
		// 设置输入输出，因为默认新创建的connection没有读写权限，
		connection.setDoInput(true);
		connection.setDoOutput(true);
		// 设置SOAP数据，发送请求
		String soapXML = getXML(null, xml, method);
		// 将信息以流的方式发送出去
		OutputStream os = connection.getOutputStream();
		os.write(soapXML.getBytes());
		// 接收服务端响应
//		int responseCode = connection.getResponseCode();
		StringBuilder sb = new StringBuilder();
//		if (200 == responseCode) {// 服务端响应成功
		// 获取当前连接请求返回的数据流
		InputStream is = connection.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String temp = null;
		while (null != (temp = br.readLine())) {
			sb.append(temp);
		}
		is.close();
		isr.close();
		br.close();
//		}
		os.close();
		
		return sb.toString();
	}

	/**
	 * 
	 * @description: 组装格式xml
	 * @param RequestCode 业务代码
	 * @param xml         传参格式为<id>1</id><name>张三</name>
	 * @param method      接口方法
	 * @return 完整soapXML传参信息
	 */
	private static String getXML(String RequestCode, String xml, String method) {

		StringBuffer requestXML = new StringBuffer();
		requestXML.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		requestXML.append(
				"<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\">");
		requestXML.append("<soap:Body>");
		requestXML.append("<" + method + " xmlns=\"http://WebXml.com.cn/\">");
		if (StringUtils.isNotEmpty(RequestCode)) {
			requestXML.append("<RequestCode>" + RequestCode + "</RequestCode>");
		}
		if (StringUtils.isNotEmpty(xml)) {
			requestXML.append(xml);
		}

		requestXML.append("</" + method + ">");
		requestXML.append("</soap:Body>");
		requestXML.append("</soap:Envelope>");

		return requestXML.toString();
	}

	public static void main(String[] args) throws Exception {
		//测试方法，测试接口为例，url地址
		String address = " http://www.webxml.com.cn/WebServices/WeatherWebService.asmx?wsdl";
		//设置传参
		String xml = "<byProvinceName>重庆</byProvinceName>";
		//调用工具方法并填入调用接口名称
		String repString = WebServiceUtil.requestWSDL(address, "getSupportCity",null, xml);
		System.out.println(repString);
		System.out.println(XmlUtil.parse(repString));
	}

}
