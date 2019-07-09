package cn.hfbin.seckill.dao;

import cn.hfbin.seckill.bo.GoodsBo;
import cn.hfbin.seckill.entity.Goods;

import java.util.List;
/**
 * 
 * @Title: GoodsMapper.java 
 * @Package cn.hfbin.seckill.dao 
 * @Description: TODO(商品Mapper) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:04:35 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public interface GoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Goods record);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKeyWithBLOBs(Goods record);

    int updateByPrimaryKey(Goods record);

    List<GoodsBo> selectAllGoodes ();

    GoodsBo getseckillGoodsBoByGoodsId(long goodsId);

    int updateStock(long goodsId);
}