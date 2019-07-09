package cn.hfbin.seckill.common;

/**
 * 
 * @Title: Const.java 
 * @Package cn.hfbin.seckill.common 
 * @Description: TODO(RedisCacheExtime缓存) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:00:54 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public class Const {

    public interface RedisCacheExtime{
        int REDIS_SESSION_EXTIME = 60 * 30;//30分钟
        int GOODS_LIST = 60 * 30 * 24;//1分钟
        int GOODS_ID = 60;//1分钟
        int SECKILL_PATH = 60;//1分钟
        int GOODS_INFO = 60;//1分钟
    }
}
