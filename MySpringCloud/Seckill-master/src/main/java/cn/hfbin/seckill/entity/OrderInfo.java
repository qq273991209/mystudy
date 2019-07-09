package cn.hfbin.seckill.entity;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @Title: OrderInfo.java 
 * @Package cn.hfbin.seckill.entity 
 * @Description: TODO(订单实体类) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:06:29 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {
    private Long id;

    private Long userId;

    private Long goodsId;

    private Long addrId;

    private String goodsName;

    private Integer goodsCount;

    private BigDecimal goodsPrice;

    private Integer orderChannel;

    private Integer status;

    private Date createDate;

    private Date payDate;

}