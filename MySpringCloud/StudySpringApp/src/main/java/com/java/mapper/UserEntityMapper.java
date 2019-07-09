/*
*
* UserEntityMapper.java
* Copyright(C) 2017-2020 fendo��˾
* @date 2019-05-20
*/
package com.java.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.java.entity.UserEntity;
import com.java.util.MyMapper;
public interface UserEntityMapper extends MyMapper<UserEntity> {
	
	public int insertUser(UserEntity entity);
	
	
	@Select("select * form ")
	public List<UserEntity> getAllUser();
	
}