/**
 * Project Name:mySpringboot
 * File Name:RestTemplateConfig.java
 * Package Name:com.java.config
 * Date:2019年6月12日上午10:43:40
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Title: RestTemplateConfig.java
 * @Package com.java.config
 * @Description: TODO(RestTemplateBean配置类)
 * @author 刘云升
 * @date 2019年6月12日 上午10:43:40 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
@Configuration
public class RestTemplateConfig {

	@Bean
	public RestTemplate restTemplate(ClientHttpRequestFactory factory) {
		return new RestTemplate(factory);
	}

	@Bean
	public ClientHttpRequestFactory simpleClientHttpRequestFactory() {
		SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
		factory.setConnectTimeout(15000);
		factory.setReadTimeout(5000);
		return factory;
	}

}
