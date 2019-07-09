package com.java.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.entity.WechatPublicPayParam;
import com.java.util.ResultMsg;

/**
 * @Title: WechatAuthService.java 
 * @Package com.amt.service 
 * @Description: TODO(综合支付服务接口) 
 * @author 江伟  
 * @date 2018年11月21日 上午10:28:13 
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
public interface SynthesisPayService {

	/**
	 * @description: 微信公众平台支付操作
	 * @param params 微信公众平台预支付参数类
	 * @throws Exception
	 */
	ResultMsg getWechatPublicPayResult(WechatPublicPayParam params) throws Exception;

	/**
	 * @description: 微信公众平台接口回调
	 * @param request
	 * @param response
	 * @throws Exception 
	 */
	void getWechatPublicBack(HttpServletRequest request, HttpServletResponse response) throws Exception;

//	/**
//	 * @description: 支付宝接口回调
//	 * @param request
//	 * @param response
//	 * @throws Exception 
//	 */
//	void getAliBack(HttpServletRequest request, HttpServletResponse response) throws Exception;
//
//	/**
//	 * @description: 移动扫码支付回调
//	 * @param object 移动支付回调请求参数类
//	 */
//	ResultMsg getMobileScanPayBack(MobileScanPayParam object);
// 
//
//	/**
//	 * @description: 微信公众号退款操作
//	 * @param params 退款参数类
//	 */
//	ResultMsg getWechatPublicRefund(WechatPublicRefundParam params);

	 
	
	
}
