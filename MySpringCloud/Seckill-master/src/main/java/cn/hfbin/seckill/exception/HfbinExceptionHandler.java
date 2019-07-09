package cn.hfbin.seckill.exception;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import cn.hfbin.seckill.result.CodeMsg;
import cn.hfbin.seckill.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @Title: HfbinExceptionHandler.java 
 * @Package cn.hfbin.seckill.exception 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:08:10 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@ControllerAdvice
@ResponseBody
public class HfbinExceptionHandler {
	@ExceptionHandler(value=Exception.class)
	public Result<String> exceptionHandler(HttpServletRequest request, Exception e){
		e.printStackTrace();
		if(e instanceof HfbinException) {
			HfbinException ex = (HfbinException)e;
			return Result.error(ex.getCm());
		}else if(e instanceof BindException) {
			BindException ex = (BindException)e;
			List<ObjectError> errors = ex.getAllErrors();
			ObjectError error = errors.get(0);
			String msg = error.getDefaultMessage();
			return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
		}else {
			return Result.error(CodeMsg.SERVER_ERROR);
		}
	}
}
