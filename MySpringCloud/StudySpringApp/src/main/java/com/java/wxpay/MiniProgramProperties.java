package com.java.wxpay;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @Title: MiniProgramProperties.java 
 * @Package com.amt.wechat 
 * @Description: TODO(微信小程序配置类) 
 * @author 江伟  
 * @date 2018年11月21日 下午2:54:23 
 * Copyright (c) ©1994-2018 Scjydz.com All Rights Reserved.
 */
@Component
@ConfigurationProperties("miniprogram")
@Data
public class MiniProgramProperties  {
	//公众账号ID
	private String appid;
	//公众号appkey
	private String appsecret;
	 
	
}
