package cn.hfbin.seckill.redis;
/**
 * 
 * @Title: BasePrefix.java 
 * @Package cn.hfbin.seckill.redis 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 刘云升  
 * @date 2019年6月13日 上午8:55:44 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public abstract class BasePrefix implements KeyPrefix{


	private String prefix;

	public BasePrefix( String prefix) {
		this.prefix = prefix;
	}

	public String getPrefix() {
		String className = getClass().getSimpleName();
		return className+":" + prefix;
	}

}
