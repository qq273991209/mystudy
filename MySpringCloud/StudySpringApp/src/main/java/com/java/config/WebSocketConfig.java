/**
 * Project Name:StudySpringApp
 * File Name:WebSocketConfig.java
 * Package Name:com.java.config
 * Date:2019年6月13日上午10:14:45
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @Title: WebSocketConfig.java
 * @Package com.java.config
 * @Description: TODO(WebSocketConfig配置类)
 * @author 刘云升
 * @date 2019年6月13日 上午10:14:45 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
@Configuration
public class WebSocketConfig {
	@Bean
	public ServerEndpointExporter serverEndpointExporter() {
		return new ServerEndpointExporter();
	}
}
