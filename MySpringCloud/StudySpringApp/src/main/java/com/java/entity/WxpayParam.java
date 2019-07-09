/**
 * Project Name:StudySpringApp
 * File Name:WxpayParam.java
 * Package Name:com.java.entity
 * Date:2019年5月23日下午2:19:31
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.entity;

import java.math.BigDecimal;

/**
 * @Title: WxpayParam.java
 * @Package com.java.entity
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 刘云升
 * @date 2019年5月23日 下午2:19:31 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
public class WxpayParam {

	/**
	 * 微信支付的金额是String类型 并且是以分为单位 下面举个例子单位是元是怎么转为分的
	 */
	BigDecimal totalPrice = new BigDecimal(1); // 此时的单位是元
	
	private String body = "xxx等商品信息";
	private String totalFee = totalPrice.multiply(new BigDecimal(100)).toBigInteger().toString();
	/** 随机数字字符串 */
	private String outTradeNo = "4784984230432842944";
	
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public String getOutTradeNo() {
		return outTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

}
