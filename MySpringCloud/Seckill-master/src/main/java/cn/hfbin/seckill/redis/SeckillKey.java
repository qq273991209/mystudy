package cn.hfbin.seckill.redis;
/**
 * 
 * @Title: SeckillKey.java 
 * @Package cn.hfbin.seckill.redis 
 * @Description: TODO(秒杀KEY类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午8:59:16 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public class SeckillKey extends BasePrefix{

	private SeckillKey(String prefix) {
		super(prefix);
	}
	public static SeckillKey isGoodsOver = new SeckillKey("go");
	public static SeckillKey getSeckillPath = new SeckillKey("mp");
}
