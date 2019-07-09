/**
 * Project Name:app-express
 * File Name:FileUploadUtil.java
 * Package Name:com.amt.util
 * Date:2019年3月21日下午3:07:03
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**   
 * @Title: FileUploadUtil.java 
 * @Package com.amt.util 
 * @Description: TODO(文件上传工具类) 
 * @author 刘云升 
 * @date 2019年5月21日 下午3:07:03 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Api(tags = "文件上传")
//@Controller
@RequestMapping("userAuth/systemUser")
@Slf4j
public class FileUploadUtil {
	
	//@Autowired
	private Upload upload;
	
	@ApiOperation(value = "多个文件上传")
	@RequestMapping(value = "/uploadListFile", method = RequestMethod.POST)
	@ResponseBody
	public List<FileUploadResponse> uploadListFile(@RequestParam("file") MultipartFile[]  files, HttpServletRequest request) {
		List<FileUploadResponse> list = new ArrayList<FileUploadResponse>();
		// 获取文件存放根路径
		String basePath = upload.getBasePath();
		// 文件存放分支路径
		String location = DateUtil.format(new Date(), "yyyy-MM-dd") + "/";
		// 文件类型
		String contentType = null;
		// 原文件名称
		String fileName = null;
		// 存放名称
		String saveName = null;
		// 图片后缀
		String imgSuffix = null;
		// 判断文件夹是否存在，不存在则
		File targetFile = new File(basePath + location);
		if(!targetFile.exists()){
			targetFile.setWritable(true, false);
			targetFile.mkdirs();
		}
		for(MultipartFile file : files) {
			FileUploadResponse rs = new FileUploadResponse();
			contentType = file.getContentType();
			fileName = file.getOriginalFilename();
			//log.info(contentType + "============"+ fileName);
			imgSuffix = fileName.substring(fileName.lastIndexOf("."));
			saveName =  "systemUser_" + System.currentTimeMillis() + imgSuffix;
			try {
				// java7中新增特性
				// ATOMIC_MOVE	原子性的复制
				// COPY_ATTRIBUTES	将源文件的文件属性信息复制到目标文件中
				// REPLACE_EXISTING	替换已存在的文件
				Files.copy(file.getInputStream(), Paths.get(upload.getBasePath() + location, saveName), StandardCopyOption.REPLACE_EXISTING);
				rs.setContentType(contentType);
				rs.setFileName(fileName);
				rs.setDecryptUrl(upload.getFileAccessPrefix() + location + saveName);
	            rs.setUrl(Base64Util.encodeData(location + saveName));
				rs.setResult("success");
				rs.setStatus(200);
			} catch (Exception e) {
				rs.setStatus(201);
				rs.setResult("fail");
				rs.setMessage("文件上传失败！");
				log.error("上传文件失败，" + e);
			}
			list.add(rs);
		}
		//返回json
		//log.info("文件上传json========="+JSON.toJSONString(list));
		return list;
		
	}
	
	
	@ApiOperation(value = "单个文件上传")
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public FileUploadResponse uploadFile(@RequestParam("file") MultipartFile  file, HttpServletRequest request) {
//		List<FileUploadResponse> list = new ArrayList<FileUploadResponse>();
		FileUploadResponse rs = new FileUploadResponse();
		// 获取文件存放根路径
		String basePath = upload.getBasePath();
		// 文件存放分支路径
		String location = DateUtil.format(new Date(), "yyyy-MM-dd") + "/";
		// 文件类型
		String contentType = null;
		// 原文件名称
		String fileName = null;
		// 存放名称
		String saveName = null;
		// 图片后缀
		String imgSuffix = null;
		// 判断文件夹是否存在，不存在则
		File targetFile = new File(basePath + location);
		if(!targetFile.exists()){
			targetFile.setWritable(true, false);
			targetFile.mkdirs();
		}
//		for(MultipartFile file : files) {
			
			contentType = file.getContentType();
			fileName = file.getOriginalFilename();
			//log.info(contentType + "============"+ fileName);
			imgSuffix = fileName.substring(fileName.lastIndexOf("."));
			saveName =  "systemUser_" + System.currentTimeMillis() + imgSuffix;
			try {
				// java7中新增特性
				// ATOMIC_MOVE	原子性的复制
				// COPY_ATTRIBUTES	将源文件的文件属性信息复制到目标文件中
				// REPLACE_EXISTING	替换已存在的文件
				Files.copy(file.getInputStream(), Paths.get(upload.getBasePath() + location, saveName), StandardCopyOption.REPLACE_EXISTING);
				rs.setContentType(contentType);
				rs.setFileName(fileName);
				rs.setDecryptUrl(upload.getFileAccessPrefix() + location + saveName);
	            rs.setUrl(Base64Util.encodeData(location + saveName));
				rs.setResult("success");
				rs.setStatus(200);
			} catch (Exception e) {
				rs.setStatus(201);
				rs.setResult("fail");
				rs.setMessage("文件上传失败！");
				log.error("上传文件失败，" + e);
			}
//			list.add(rs);
//		}
		//返回json
//		log.info("文件上传json========="+JSON.toJSONString(list));
		return rs;
		
	}
	 

}
