package cn.hfbin.seckill.service;

import cn.hfbin.seckill.bo.GoodsBo;
import cn.hfbin.seckill.entity.OrderInfo;
import cn.hfbin.seckill.entity.SeckillOrder;
import cn.hfbin.seckill.entity.User;

/**
 * 
 * @Title: SeckillOrderService.java 
 * @Package cn.hfbin.seckill.service 
 * @Description: TODO(秒杀订单服务类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午9:02:16 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public interface SeckillOrderService {

    SeckillOrder getSeckillOrderByUserIdGoodsId(long userId , long goodsId);


    OrderInfo insert(User user , GoodsBo goodsBo);

    OrderInfo getOrderInfo(long orderId);

    long getSeckillResult(Long userId, long goodsId);

    boolean checkPath(User user, long goodsId, String path);

    String createMiaoshaPath(User user, long goodsId);

}
