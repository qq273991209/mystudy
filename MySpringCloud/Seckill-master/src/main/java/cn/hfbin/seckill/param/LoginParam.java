package cn.hfbin.seckill.param;

import cn.hfbin.seckill.validator.IsMobile;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
/**
 * 
 * @Title: LoginParam.java 
 * @Package cn.hfbin.seckill.param 
 * @Description: TODO(登录参数类+手机号和密码验证) 
 * @author 刘云升  
 * @date 2019年6月13日 上午8:54:54 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Getter
@Setter
@ToString
public class LoginParam {

    @NotNull(message = "手机号不能为空")
    @IsMobile()
    private String mobile;
    @NotNull(message="密码不能为空")
    @Length(min = 23, message = "密码长度需要在7个字以内")
    private String password;
}
