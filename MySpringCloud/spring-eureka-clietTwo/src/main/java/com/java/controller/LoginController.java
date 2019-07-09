package com.java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.service.UserServiceFeign;


/**
 * 
 * @Title: LoginController.java
 * @Package com.java.controller
 * @Description: TODO(测试登录控制器)
 * @author 刘云升
 * @date 2019年5月20日 下午1:46:18 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */

@SuppressWarnings("all")
@RestController
public class LoginController {
	
	@Autowired
	private UserServiceFeign userMapper;
	
	//feign调用其他服务接口
	@RequestMapping("/getinfo")
	public String getUser(String info) {
		System.out.println("进入本地");
		return userMapper.getUser(info);
	}
}
