package com.java.config;
//import java.util.ArrayList;
//import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import com.google.common.base.Function;
//import com.google.common.base.Optional;
//import com.google.common.base.Predicate;
//import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @Title: Swagger2.java 
 * @Package com.java.config 
 * @Description: TODO(Swagger2插件类) 
 * @author 刘云升  
 * @date 2019年5月20日 下午2:26:17 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
	
	/**
	 * @description: 文档@ApiOperation注解来给API增加说明、 通过@ApiImplicitParams、@ApiImplicitParam注解来给参数增加说明。
	 */
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.java.controller"))
				.paths(PathSelectors.any()).build();
				//.globalOperationParameters(this.setHeaderToken());
				
	}

	/**
	 * @description: 版本信息备注
	 */
	@SuppressWarnings("deprecation")
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("API")
				.description("接口文档")
				.termsOfServiceUrl("http://scqjyx.cn/")
				.contact("jiangwei@qjyx.info")
				.version("1.0").build();
	}

	/**
	 * @description: 设置自定义参数
	 */
//	private List<Parameter> setHeaderToken() {
//		ParameterBuilder tokenPar = new ParameterBuilder();
//		List<Parameter> pars = new ArrayList<>();
//		tokenPar.name("access_token")
//				.description("认证令牌")
//				.modelRef(new ModelRef("string"))
//				.parameterType("header")
//				.required(false)
//				.build();
//		pars.add(tokenPar.build());
//		return pars;
//	}
	
}
