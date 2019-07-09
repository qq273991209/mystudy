package cn.hfbin.seckill.dao;

import cn.hfbin.seckill.entity.SeckillOrder;
import org.apache.ibatis.annotations.Param;
/**
 * 
 * @Title: SeckillOrderMapper.java 
 * @Package cn.hfbin.seckill.dao 
 * @Description: TODO(秒杀订单Mapper) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:05:32 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public interface SeckillOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SeckillOrder record);

    int insertSelective(SeckillOrder record);

    SeckillOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SeckillOrder record);

    int updateByPrimaryKey(SeckillOrder record);

    SeckillOrder selectByUserIdAndGoodsId(@Param("userId") long userId , @Param("goodsId") long goodsId );
}