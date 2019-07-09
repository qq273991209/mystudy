package cn.hfbin.seckill.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @Title: SeckillGoods.java 
 * @Package cn.hfbin.seckill.entity 
 * @Description: TODO(商品秒杀类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午8:52:19 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SeckillGoods {
    private Long id;

    private Long goodsId;

    private BigDecimal seckilPrice;

    private Integer stockCount;

    private Date startDate;

    private Date endDate;

}