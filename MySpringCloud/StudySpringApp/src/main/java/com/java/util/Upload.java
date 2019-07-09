/**
 * Project Name:app-express
 * File Name:Upload.java
 * Package Name:com.amt.component
 * Date:2019年3月21日下午3:51:35
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.util;

import java.util.Map;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


import com.github.pagehelper.util.StringUtil;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Title: Upload.java 
 * @Package com.amt.component 
 * @Description: TODO(文件上传配置类) 
 * @author 刘云升 
 * @date 2019年5月21日 下午3:51:35 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
//@Component
//@ConfigurationProperties("upload")
@Slf4j
@Data
public class Upload {

	// 获取存放位置
	private Map<String, String> localtion;
	
	// 单个文件大小
	private String maxFileSize;
	
	// 上次总文件大小
	private String maxRequestSize;

	//文件访问前缀/域名
	private String fileAccessPrefix;
	
	public String getBasePath() {
		String location = "";
		String os = System.getProperty("os.name");
		if(os.toLowerCase().startsWith("win")) {
			location = this.getLocaltion().get("windows");
		} else {
			location = this.getLocaltion().get("linux");
		}
		return location;
	}
	
	/**
	 * @description: 获取解密后的文件全路径
	 * @param str 加密的文件路径
	 * @return 解密的文件全路径
	 */
	public String getFilePath(String str) {
		if (StringUtil.isEmpty(str)) {
			return null;
		}
		String path = this.fileAccessPrefix + Base64Util.decodeData(str);
		return path;
	}
	
	/**
	 * @Title: multipartConfigElement 
	 * @Description: TODO(初始化文件上传) 
	 * @return MultipartConfigElement    返回类型
	 */
	//@Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        // 设置文件大小限制 ,超出设置页面会抛出异常信息，
        // 这样在文件上传的地方就需要进行异常信息的处理了;
        factory.setMaxFileSize(this.getMaxFileSize()); // KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(this.getMaxRequestSize());
        // 设置文件临时路径
        factory.setLocation(this.getBasePath());
        log.info("Initialization upload parameter is successful. (初始化文件上传参数成功。)");
        return factory.createMultipartConfig();
    }
}
