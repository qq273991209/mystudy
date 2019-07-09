/**
 * Project Name:StudySpringApp
 * File Name:WechatProperties.java
 * Package Name:com.java.wxpay
 * Date:2019年5月23日上午10:12:46
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.wxpay;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @Title: WechatProperties.java
 * @Package com.java.wxpay
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 刘云升
 * @date 2019年5月23日 上午10:12:46 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
@Component
@ConfigurationProperties("wechat")
@Data
public class WechatProperties {

	// 公众账号ID
	private String appid;
	// 公众号appkey
	private String appsecret;
	// 商户号
	private String mchId;
	// 子商户公众账号
	private String subAppid;
	// 子商户号
	private String subMchId;
	// 设备号
	private String deviceInfo;
	// 指定支付方式
	private String limitPay;
	// 商户key
	private String key;
	// 回调地址
	private String notifyUrl;
	// 证书地址
	private String certUrl;
}
