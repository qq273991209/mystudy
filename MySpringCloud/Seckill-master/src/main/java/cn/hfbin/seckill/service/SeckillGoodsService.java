package cn.hfbin.seckill.service;

import cn.hfbin.seckill.bo.GoodsBo;

import java.util.List;
/**
 * 
 * @Title: SeckillGoodsService.java 
 * @Package cn.hfbin.seckill.service 
 * @Description: TODO(秒杀商品服务类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午9:01:58 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public interface SeckillGoodsService {

    List<GoodsBo> getSeckillGoodsList();

    GoodsBo getseckillGoodsBoByGoodsId(long goodsId);

    int reduceStock(long goodsId);
}
