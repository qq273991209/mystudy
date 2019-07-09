/**
 * Project Name:mySpringboot
 * File Name:UserService.java
 * Package Name:com.java.service.impl
 * Date:2019年5月20日下午2:08:39
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.service.impl.UserServiceFeignImpl;

/**   
 * @Title: UserService.java 
 * @Package com.java.service.impl 
 * @Description: TODO(用户服务层接口) 
 * @author 刘云升 
 * @date 2019年5月20日 下午2:08:39 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@FeignClient(name = "appclientOne",fallback=UserServiceFeignImpl.class)
public interface UserServiceFeign {
	
	
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	public String getUser(String info);

}
