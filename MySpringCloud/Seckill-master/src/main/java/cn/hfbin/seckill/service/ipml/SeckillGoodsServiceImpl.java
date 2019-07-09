package cn.hfbin.seckill.service.ipml;

import cn.hfbin.seckill.bo.GoodsBo;
import cn.hfbin.seckill.dao.GoodsMapper;
import cn.hfbin.seckill.service.SeckillGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 
 * @Title: SeckillGoodsServiceImpl.java 
 * @Package cn.hfbin.seckill.service.ipml 
 * @Description: TODO(秒杀商品服务实现类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午9:00:23 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Service("seckillGoodsService")
public class SeckillGoodsServiceImpl implements SeckillGoodsService {
    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public List<GoodsBo> getSeckillGoodsList() {
        return goodsMapper.selectAllGoodes();
    }

    @Override
    public GoodsBo getseckillGoodsBoByGoodsId(long goodsId) {
        return goodsMapper.getseckillGoodsBoByGoodsId(goodsId);
    }

    @Override
    public int reduceStock(long goodsId) {
        return goodsMapper.updateStock(goodsId);
    }
}
