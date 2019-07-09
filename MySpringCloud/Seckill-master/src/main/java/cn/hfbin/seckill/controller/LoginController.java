package cn.hfbin.seckill.controller;

import cn.hfbin.seckill.common.Const;
import cn.hfbin.seckill.entity.User;
import cn.hfbin.seckill.exception.HfbinException;
import cn.hfbin.seckill.param.LoginParam;
import cn.hfbin.seckill.redis.RedisService;
import cn.hfbin.seckill.redis.UserKey;
import cn.hfbin.seckill.result.CodeMsg;
import cn.hfbin.seckill.result.Result;
import cn.hfbin.seckill.service.UserService;
import cn.hfbin.seckill.util.CookieUtil;
import cn.hfbin.seckill.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
/**
 * 
 * @Title: LoginController.java 
 * @Package cn.hfbin.seckill.controller 
 * @Description: TODO(用户页面控制器) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:03:02 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    RedisService redisService;
    @Autowired
    UserService userService;
    @RequestMapping("/login")
    @ResponseBody
    public Result<User> doLogin(HttpServletResponse response, HttpSession session , @Valid LoginParam loginParam) {
        Result<User> login = userService.login(loginParam);
        if (login.isSuccess()){
            CookieUtil.writeLoginToken(response,session.getId());
            redisService.set(UserKey.getByName , session.getId() ,login.getData(), Const.RedisCacheExtime.REDIS_SESSION_EXTIME );
        }
        return login;
    }

    @RequestMapping("/logout")
    public String doLogout(HttpServletRequest request, HttpServletResponse response) {
        String token = CookieUtil.readLoginToken(request);
        CookieUtil.delLoginToken(request , response);
        redisService.del(UserKey.getByName , token);
        return "login";
    }
}
