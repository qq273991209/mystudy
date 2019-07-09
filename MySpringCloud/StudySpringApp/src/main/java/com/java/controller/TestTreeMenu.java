///**
// * Project Name:StudySpringApp
// * File Name:TestTreeMenu.java
// * Package Name:com.java.controller
// * Date:2019年6月14日下午2:17:05
// * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
//*/
//package com.java.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.java.entity.SystemMenuAndChildrenVO;
//import com.java.mapper.systemMenuEntityMapper;
//import com.java.util.MenuTreeUtil;
//import com.java.util.ResponseData;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
//
///**   
// * @Title: TestTreeMenu.java 
// * @Package com.java.controller 
// * @Description: TODO(测试菜单组合控制器) 
// * @author lys
// * @date 2019年6月14日 下午2:17:05 
// * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
// */
//@Api(tags = "测试TestTreeMenuAPI")
//@RestController
//@Slf4j
//public class TestTreeMenu {
//	
//	@Autowired
//	private systemMenuEntityMapper menuEntityMapper;
//	
//	
//	@ApiOperation(value = "菜单测试", notes = "菜单组合测试")
//	@ApiResponses({ @ApiResponse(code = 200, message = "查询成功", response =SystemMenuAndChildrenVO.class),
//			@ApiResponse(code = 201, message = "无查询数据", response = Void.class) })
//	@GetMapping("/testTreeMenu")
//	public ResponseData testTreeMenu() {
//		//统一参数返回
//		ResponseData data = new ResponseData();
//		//查询所有菜单准备组装数据
//		List<SystemMenuAndChildrenVO> Menus = menuEntityMapper.selectAll();//这里只需要一个查询菜单表所有数据即可
//		//获得递归组装工具
//		MenuTreeUtil treeUtil  = new MenuTreeUtil();
//		//组装数据
//		List<Object> info = treeUtil.menuList(Menus);
//		//日志打印看看组装结构
//		log.info(info.toString());
//		data.getData().put("Menus", info);
//		return data;
//	}
//	
//}
