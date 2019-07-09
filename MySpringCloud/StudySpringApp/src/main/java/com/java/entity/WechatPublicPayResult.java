package com.java.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Title: WechatPublicPayResult.java 
 * @Package com.amt.pojo 
 * @Description: TODO(微信公众平台支预付返回参数类) 
 * @author 江伟  
 * @date 2019年4月30日 下午2:50:30 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Data
public class WechatPublicPayResult {
	// 公众号id
	@ApiModelProperty(value="公众号id", example="123456")
	private String appId;
	// 时间戳
	@ApiModelProperty(value="时间戳，自1970年以来的秒数", example="123456")
	private String timeStamp;
	// 随机字符串
	@ApiModelProperty(value="随机字符串", example="123456")
	private String nonceStr;
	// 微信签名方式
	@ApiModelProperty(value="微信签名方式", example="MD5")
	private String signType;
	// 微信签名 
	@ApiModelProperty(value="微信签名 ", example="123456")
	private String paySign;
	// 订单详情扩展字符串
	@ApiModelProperty(value="订单详情扩展字符串", example="123456")
	private String orderNumber;
	// 订单编号
	@ApiModelProperty(value="订单编号", example="123456")
	private String orderId;
	// 订单金额(两位小数)
	@ApiModelProperty(value="订单金额(两位小数)", example="11.21")
	private String money;
	 
}
