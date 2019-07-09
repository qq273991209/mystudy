///**
// * Project Name:StudySpringApp
// * File Name:TestRedisContoller.java
// * Package Name:com.java.controller
// * Date:2019年6月14日上午11:22:57
// * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
//*/
//package com.java.controller;
//
//import java.io.Serializable;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.java.entity.UserEntity;
//import com.java.mapper.UserEntityMapper;
//import com.java.util.ResponseData;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import lombok.extern.slf4j.Slf4j;
//
///**   
// * @Title: TestRedisContoller.java 
// * @Package com.java.controller 
// * @Description: TODO(用一句话描述该文件做什么) 
// * @author lys 
// * @date 2019年6月14日 上午11:22:57 
// * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
// */
//@Api(tags = "测试RedisAPI")
//@RestController
//@Slf4j
//public class TestRedisContoller {
//	
//	@Autowired
//	private UserEntityMapper userMapper;
//	
//	@Autowired
//    private RedisTemplate<Serializable, Object> redisTemplate;
//	
//	
//	@ApiOperation(value = "Redis测试", notes = "Redis测试")
//	@ApiResponses({ @ApiResponse(code = 200, message = "查询成功", response = UserEntity.class),
//			@ApiResponse(code = 201, message = "无查询数据", response = Void.class) })
//	@GetMapping("/testRedis")
//	public ResponseData testRedis() {
//		//返回数据统一
//		ResponseData data = new ResponseData();
//		//在Redis中获取数据
//		Object redisuser = redisTemplate.opsForValue().get("userinfo1");
//		if(redisuser==null) {
//			log.info("进入数据库查询======================");
//			List<UserEntity> userinfo = userMapper.selectAll();//这里是从数据库查的数据，根据你实际的数据来，测试也可用假数据
//			data.getData().put("user",userinfo);
//			log.info("存入Redis中》》》》》》》》》》》》》》》");
//			redisTemplate.opsForValue().set("userinfo1", userinfo);
//			return data;
//		}
//		else {
//			log.info("进入Redis查询》》》》》》》》》》》》》》》》》");
//			data.getData().put("user", redisuser);
//			return data;
//		}
//		
//	}
//	
//	
//}
