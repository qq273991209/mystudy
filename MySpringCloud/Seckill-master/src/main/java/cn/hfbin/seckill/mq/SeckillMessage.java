package cn.hfbin.seckill.mq;


import cn.hfbin.seckill.entity.User;
/**
 * 
 * @Title: SeckillMessage.java 
 * @Package cn.hfbin.seckill.mq 
 * @Description: TODO(秒杀消息类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午8:54:30 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public class SeckillMessage {
	private User user;
	private long goodsId;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public long getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
}
