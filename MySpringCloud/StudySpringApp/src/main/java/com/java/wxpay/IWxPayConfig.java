/**
 * Project Name:StudySpringApp
 * File Name:IWxPayConfig.java
 * Package Name:com.java.wxpay
 * Date:2019年5月23日上午10:34:40
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.wxpay;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Title: IWxPayConfig.java
 * @Package com.java.wxpay
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 刘云升
 * @date 2019年5月23日 上午10:34:40 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
public class IWxPayConfig extends WXPayConfig {
	
	private byte[] certData;
	
	private WechatProperties wechatProperties;
	
	public IWxPayConfig( WechatProperties wechatProperties) throws IOException {
		this.wechatProperties = wechatProperties;
		String certPath = wechatProperties.getCertUrl();
		File file = new File(certPath);
		InputStream certStream = new FileInputStream(file);
		this.certData = new byte[(int) file.length()];
		certStream.read(this.certData);
		certStream.close();
	}
	public IWxPayConfig() throws IOException {
		
	}
	

	@Override
	InputStream getCertStream() {
		
		return new ByteArrayInputStream(this.certData);
	}

	@Override
	IWXPayDomain getWXPayDomain() {//这个方法需要这样实现, 否则无法正常初始化WXPay
		 IWXPayDomain iwxPayDomain = new IWXPayDomain() {
			
			@Override
			public void report(String domain, long elapsedTimeMillis, Exception ex) {
				
			}
			@Override
			public DomainInfo getDomain(WXPayConfig config) {
				
				return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API, true);
			}
			
		};
		return iwxPayDomain;
	}
	
	public String getAppID() {
		
		return this.wechatProperties.getAppid();
	}
	
	public String getMchID() {
		
		return this.wechatProperties.getMchId();
	}
	
	public String getKey() {
		
		return this.wechatProperties.getKey();
	}

}
