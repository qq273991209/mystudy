package cn.hfbin.seckill.service;

import cn.hfbin.seckill.entity.OrderInfo;
/**
 * 
 * @Title: OrderService.java 
 * @Package cn.hfbin.seckill.service 
 * @Description: TODO(订单服务类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午9:01:33 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public interface OrderService {

    long addOrder(OrderInfo orderInfo);

    OrderInfo getOrderInfo(long rderId);
}
