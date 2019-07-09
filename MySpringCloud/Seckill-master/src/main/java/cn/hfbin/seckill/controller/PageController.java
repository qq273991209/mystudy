package cn.hfbin.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @Title: PageController.java 
 * @Package cn.hfbin.seckill.controller 
 * @Description: TODO(用户路径控制器) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:03:26 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Controller
@RequestMapping("/page")
public class PageController {


    @RequestMapping("login")
    public String loginPage(){

        return "login";
    }
}
