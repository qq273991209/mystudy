package cn.hfbin.seckill.dao;

import cn.hfbin.seckill.entity.OrderInfo;
/**
 * 
 * @Title: OrdeInfoMapper.java 
 * @Package cn.hfbin.seckill.dao 
 * @Description: TODO(订单Mapper) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:04:55 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public interface OrdeInfoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(OrderInfo record);

    int insertSelective(OrderInfo record);

    OrderInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(OrderInfo record);

    int updateByPrimaryKey(OrderInfo record);
}