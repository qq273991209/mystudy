package cn.hfbin.seckill.bo;

import cn.hfbin.seckill.entity.Goods;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
/**
 * 
 * @Title: GoodsBo.java 
 * @Package cn.hfbin.seckill.bo 
 * @Description: TODO(GoodsBo类) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:00:03 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class GoodsBo{

	private BigDecimal seckillPrice;

	private Integer stockCount;

	private Date startDate;

	private Date endDate;

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
