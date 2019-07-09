/**
 * Project Name:app-express
 * File Name:FileUploadResponse.java
 * Package Name:com.amt.pojo
 * Date:2019年3月21日下午3:31:06
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**   
 * @Title: FileUploadResponse.java 
 * @Package com.amt.pojo 
 * @Description: TODO(文件上传返回通用类) 
 * @author 刘云升  
 * @date 2019年5月21日 下午3:31:06 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Data
public class FileUploadResponse {

	// 结果标识 success || fail
	@ApiModelProperty("结果标识：成功：success  失败：fail")
	private String result;

	// 状态码
	@ApiModelProperty("状态码")
	private Integer status;
	
	// 消息
	@ApiModelProperty("消息")
	private String message;

	// 文件类型
	@ApiModelProperty("文件类型")
	private String contentType;

	// 文件名称
	@ApiModelProperty("文件名称")
	private String fileName;

	// 加密后的文件路径
	@ApiModelProperty("加密后的文件路径，用于数据保存")
	private String url;

	// 未加密的文件路径
	@ApiModelProperty("未加密的文件路径，仅用于页面展示")
	private String decryptUrl;
	
}
