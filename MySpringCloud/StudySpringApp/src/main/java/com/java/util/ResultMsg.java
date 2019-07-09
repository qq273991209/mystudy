package com.java.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;
/**
 * 
 * @Title: ResultMsg.java 
 * @Package com.java.util 
 * @Description: TODO(统一返回参数) 
 * @author 刘云升  
 * @date 2019年5月20日 下午2:54:13 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@ApiModel(value = "ResultMsg", description = "消息返回类")
@ApiIgnore
@Data
public class ResultMsg {

	// 状态码
	@ApiModelProperty("状态码")
	private Integer status;
	
	// 消息内容
	@ApiModelProperty("消息内容")
	private String message;
	
	//权限令牌
	@ApiModelProperty("权限令牌")
	private String token;
	
	//返回数据
	@ApiModelProperty("返回数据")
	private Object data;
	
	public ResultMsg() {
		super();
	}
	
	public ResultMsg(Integer status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public ResultMsg(Integer status, String message, String token) {
		this.status = status;
		this.message = message;
		this.token = token;
	}
	
	public ResultMsg(Integer status, String message, String token, Object data) {
		this.status = status;
		this.message = message;
		this.token = token;
		this.data = data;
	}
	
	public ResultMsg(Integer status, Object data) {
		this.status = status;
		this.data = data;
	}
	
	public ResultMsg(Integer status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}
	
}
