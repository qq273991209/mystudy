package cn.hfbin.seckill.exception;


import cn.hfbin.seckill.result.CodeMsg;
/**
 * 
 * @Title: HfbinException.java 
 * @Package cn.hfbin.seckill.exception 
 * @Description: TODO(HfbinException) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:00:21 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public class HfbinException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private CodeMsg cm;
	
	public HfbinException(CodeMsg cm) {
		super(cm.toString());
		this.cm = cm;
	}
	public CodeMsg getCm() {
		return cm;
	}

}
