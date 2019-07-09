package cn.hfbin.seckill.service.ipml;

import cn.hfbin.seckill.dao.OrdeInfoMapper;
import cn.hfbin.seckill.entity.OrderInfo;
import cn.hfbin.seckill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
/**
 * 
 * @Title: OrderServiceImpl.java 
 * @Package cn.hfbin.seckill.service.ipml 
 * @Description: TODO(订单服务实现类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午9:00:00 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdeInfoMapper ordeInfoMapper;

    @Override
    public long addOrder(OrderInfo orderInfo) {
        return ordeInfoMapper.insertSelective(orderInfo);
    }

    @Override
    public OrderInfo getOrderInfo(long orderId) {
        return ordeInfoMapper.selectByPrimaryKey(orderId);
    }
}
