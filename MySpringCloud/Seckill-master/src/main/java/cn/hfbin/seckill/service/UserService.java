package cn.hfbin.seckill.service;

import cn.hfbin.seckill.entity.User;
import cn.hfbin.seckill.param.LoginParam;
import cn.hfbin.seckill.result.Result;
/**
 * 
 * @Title: UserService.java 
 * @Package cn.hfbin.seckill.service 
 * @Description: TODO(用户服务类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午9:02:37 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public interface UserService {
    Result<User> login(LoginParam loginParam);
}
