/**
 * Project Name:spring-eureka-clietTwo
 * File Name:UserServiceFeignImpl.java
 * Package Name:com.java.service.impl
 * Date:2019年7月4日下午4:32:33
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.service.impl;

import org.springframework.stereotype.Component;

import com.java.service.UserServiceFeign;

/**   
 * @Title: UserServiceFeignImpl.java 
 * @Package com.java.service.impl 
 * @Description: TODO(降级处理类) 
 * @author 刘云升  
 * @date 2019年7月4日 下午4:32:33 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Component
public class UserServiceFeignImpl implements UserServiceFeign {

	@Override
	public String getUser(String info) {
		
		return "服务出现故障";
	}

}
