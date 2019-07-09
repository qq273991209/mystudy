package cn.hfbin.seckill.dao;

import cn.hfbin.seckill.entity.SeckillGoods;
/**
 * 
 * @Title: SeckillGoodsMapper.java 
 * @Package cn.hfbin.seckill.dao 
 * @Description: TODO(秒杀Mapper) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:05:15 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public interface SeckillGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeckillGoods record);

    int insertSelective(SeckillGoods record);

    SeckillGoods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillGoods record);

    int updateByPrimaryKey(SeckillGoods record);
}