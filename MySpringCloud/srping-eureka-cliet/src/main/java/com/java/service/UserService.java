/**
 * Project Name:mySpringboot
 * File Name:UserService.java
 * Package Name:com.java.service.impl
 * Date:2019年5月20日下午2:08:39
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.service;

import com.java.entity.UserEntity;

/**   
 * @Title: UserService.java 
 * @Package com.java.service.impl 
 * @Description: TODO(用户服务层接口) 
 * @author 刘云升 
 * @date 2019年5月20日 下午2:08:39 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public interface UserService {
	
	
	public int insertUser(UserEntity entity);

}
