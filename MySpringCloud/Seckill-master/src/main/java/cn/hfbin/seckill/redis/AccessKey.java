package cn.hfbin.seckill.redis;
/**
 * 
 * @Title: AccessKey.java 
 * @Package cn.hfbin.seckill.redis 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 刘云升  
 * @date 2019年6月13日 上午8:55:38 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public class AccessKey extends BasePrefix{

	private AccessKey( String prefix) {
		super(prefix);
	}
	
	public static AccessKey withExpire = new AccessKey("access");

}
