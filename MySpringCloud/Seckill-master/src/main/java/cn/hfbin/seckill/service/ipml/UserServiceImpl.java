package cn.hfbin.seckill.service.ipml;

import cn.hfbin.seckill.entity.User;
import cn.hfbin.seckill.dao.UserMapper;
import cn.hfbin.seckill.param.LoginParam;
import cn.hfbin.seckill.result.CodeMsg;
import cn.hfbin.seckill.result.Result;
import cn.hfbin.seckill.service.UserService;
import cn.hfbin.seckill.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @Title: UserServiceImpl.java 
 * @Package cn.hfbin.seckill.service.ipml 
 * @Description: TODO(用户服务实现类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午9:01:09 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    @Override
    public Result<User> login(LoginParam loginParam) {

        User user = userMapper.checkPhone(loginParam.getMobile());
        if(user == null){
            return Result.error(CodeMsg.MOBILE_NOT_EXIST);
        }
        String dbPwd= user.getPassword();
        String saltDB = user.getSalt();
        String calcPass = MD5Util.formPassToDBPass(loginParam.getPassword(), saltDB);
        if(!StringUtils.equals(dbPwd , calcPass)){
            return Result.error(CodeMsg.PASSWORD_ERROR);
        }
        user.setPassword(StringUtils.EMPTY);
        return Result.success(user);
    }
}
