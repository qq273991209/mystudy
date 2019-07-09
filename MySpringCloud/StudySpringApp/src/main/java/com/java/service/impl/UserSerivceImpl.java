/**
 * Project Name:mySpringboot
 * File Name:UserSerivceImpl.java
 * Package Name:com.java.service.impl
 * Date:2019年5月20日下午2:11:13
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.java.entity.UserEntity;
import com.java.mapper.UserEntityMapper;
import com.java.service.UserService;

/**   
 * @Title: UserSerivceImpl.java 
 * @Package com.java.service.impl 
 * @Description: TODO(用户接口实现层) 
 * @author 刘云升  
 * @date 2019年5月20日 下午2:11:13 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Service
@Transactional(propagation=Propagation.REQUIRED)
public class UserSerivceImpl implements UserService {
	
	@Autowired
	private UserEntityMapper userMapper;
	
	@Override
	public int insertUser(UserEntity entity) {
		
		
		return userMapper.insertUser(entity);
	}
}
