package cn.hfbin.seckill.redis;
/**
 * 
 * @Title: GoodsKey.java 
 * @Package cn.hfbin.seckill.redis 
 * @Description: TODO(商品键类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午8:56:15 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public class GoodsKey extends BasePrefix{

	private GoodsKey(String prefix) {
		super(prefix);
	}
	public static GoodsKey getGoodsList = new GoodsKey("gl");
	public static GoodsKey getGoodsDetail = new GoodsKey("gd");
	public static GoodsKey getSeckillGoodsStock= new GoodsKey( "gs");
}
