package cn.hfbin.seckill.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @Title: Goods.java 
 * @Package cn.hfbin.seckill.entity 
 * @Description: TODO(商品实体类) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:06:10 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Long id;

    private String goodsName;

    private String goodsTitle;

    private String goodsImg;

    private BigDecimal goodsPrice;

    private Integer goodsStock;

    private Date createDate;

    private Date updateDate;

    private String goodsDetail;
}