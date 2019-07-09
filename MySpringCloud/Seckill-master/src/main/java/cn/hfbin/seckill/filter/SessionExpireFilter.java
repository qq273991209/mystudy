package cn.hfbin.seckill.filter;
import cn.hfbin.seckill.common.Const;
import cn.hfbin.seckill.entity.User;
import cn.hfbin.seckill.redis.RedisService;
import cn.hfbin.seckill.redis.UserKey;
import cn.hfbin.seckill.util.CookieUtil;
import cn.hfbin.seckill.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
/**
 * 
 * @Title: SessionExpireFilter.java 
 * @Package cn.hfbin.seckill.filter 
 * @Description: TODO(重新设置用户session在redis的有效期) 
 * @author 刘云升  
 * @date 2019年6月12日 下午5:59:19 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Component
public class SessionExpireFilter implements Filter {
    @Autowired
    RedisService redisService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;

        String loginToken = CookieUtil.readLoginToken(httpServletRequest);

        if(StringUtils.isNotEmpty(loginToken)){
            //判断logintoken是否为空或者""；
            //如果不为空的话，符合条件，继续拿user信息
            User user = redisService.get(UserKey.getByName,loginToken, User.class);
            if(user != null){
                //如果user不为空，则重置session的时间，即调用expire命令
                redisService.expice(UserKey.getByName , loginToken, Const.RedisCacheExtime.REDIS_SESSION_EXTIME);
            }
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }


    @Override
    public void destroy() {

    }
}
