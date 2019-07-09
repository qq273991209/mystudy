package com.java.entity;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Title: WechatPublicPayParam.java 
 * @Package com.amt.pojo 
 * @Description: TODO(微信公众平台预支付参数类) 
 * @author 刘云升 
 * @date 2018年12月11日 下午2:29:06 
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@Data
public class WechatPublicPayParam {

	@ApiModelProperty(value="订单号", example="123456", required = true)
	private Long orderId;
	
	@ApiModelProperty(value="订单类型", example="体检预约tjyy 检验检查预约jyjc 陪护床位phyy 住院床位zyyy 病历寄送bljs", required = true)
	private String orderType;
	
	@ApiModelProperty(value="订单金额(两位小数)", example="0.01", required = true)
	private BigDecimal money;
	
	@ApiModelProperty(value="用户openid", example="ouuPRvjLUzW0M1DNJ9c-rvwjyfeI", required = true)
	private String openid;
	
	@ApiModelProperty(value="用户姓名(或微信昵称)", example="张三", required = true)
	private String username;
	
	@ApiModelProperty(value="交易类型", example="体检预约缴费", required = true)
	private String dealType;
	
	@ApiModelProperty(value="支付类型:1普通商户版  2服务商版", example="2", required = true)
	private Integer payType;
	
}
