package cn.hfbin.seckill.redis;
/**
 * 
 * @Title: UserKey.java 
 * @Package cn.hfbin.seckill.redis 
 * @Description: TODO(用户KEY类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午8:59:33 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public class UserKey extends BasePrefix{

	private UserKey(String prefix) {
		super(prefix);
	}
	public static UserKey getById = new UserKey("id");
	public static UserKey getByName = new UserKey("name");
}
