package com.java.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.github.pagehelper.PageHelper;
import com.java.entity.UserEntity;
import com.java.entity.WechatPublicPayParam;
import com.java.entity.WechatPublicPayResult;
import com.java.mapper.CheckupReportingMapper;
import com.java.mapper.UserEntityMapper;
//import com.java.rabbitmq.Producer;
import com.java.service.SynthesisPayService;
import com.java.util.ResponseData;
import com.java.util.ResultMsg;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.entity.Example;

/**
 * 
 * @Title: LoginController.java
 * @Package com.java.controller
 * @Description: TODO(测试控制器)
 * @author 刘云升
 * @date 2019年5月20日 下午1:46:18 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
@Api(tags = "用户API")
@RestController
@Slf4j
public class LoginController {
	private static final String URL = "http://127.0.0.1:8888/spring/getUser?name={name}&email={email}";
	
//	@Value("${server.port}")
//	private String port;
	
	@Autowired
	private UserEntityMapper userMapper;
	
	@Autowired
	private CheckupReportingMapper reportingMapper;

//	@Autowired
//	private Producer producer;
	
//	@Autowired
//    private RedisTemplate<Serializable, Object> redisTemplate;

//	@Autowired
//	private SynthesisPayService synthesisPayService;
	
//	@Autowired
//	private RestTemplate restTemplate;

	@ApiOperation(value = "用户登录测试", notes = "根据User对象查询用户")
//	 @ApiImplicitParam(name = "id", value = "userid", required = true, paramType =
////	 "query")
	@ApiResponses({ @ApiResponse(code = 200, message = "查询成功", response = UserEntity.class),
			@ApiResponse(code = 201, message = "无查询数据", response = Void.class) })
	@PostMapping("/getUserInfo")
	public ResponseData login() {
//		Example example = new Example(UserEntity.class);// 实例化
//		@SuppressWarnings("unused")
//		Example.Criteria criteria = example.createCriteria();
		// criteria.andEqualTo("id", UserInfo.getId());
		// System.out.println(UserInfo.getRealName());
		// criteria.andLike("realName", "%" + UserInfo.getRealName() + "%");
		ResponseData data = new ResponseData();
		// int row = userMapper.insertUser(UserInfo);
		// data.getData().put("user", userMapper.select(UserInfo));
		// data.getData().put("user", userMapper.selectByExample(example));
		 data.getData().put("user", userMapper.selectAll());
//		Map<String, String> params = new HashMap<>();
//		params.put("name", "lys");
//		params.put("email", "12345");
//		String rest = restTemplate.getForObject(URL, String.class, params);
//		if(rest!=null&&!"".equals(rest)) {
//			data.getData().put("user",rest);
			return data;
//		}
//		data.getData().put("user", PageHelper.startPage(1, 10).doSelectPageInfo(() -> userMapper.selectAll()));
//		Destination destination = new ActiveMQQueue("mytest.queue");  
//        
//		for (int i = 0; i < 2; i++) {
//			producer.send();
//			producer.send1();
//			producer.send2();
//		}
//		
//		for (int i = 0; i < 3; i++) {
//			producer.sendA();
//			producer.sendB();
//			producer.sendC();
//		}
		
//		Object redisuser = redisTemplate.opsForValue().get("userinfo");
//		if(redisuser==null) {
//			log.info("进入数据库查询======================");
////			UserEntity user = new UserEntity();
////			user.setId(Long.valueOf(18));
////			UserEntity userinfo = userMapper.selectOne(user);
//			List<UserEntity> userinfo = userMapper.selectAll();
//			data.getData().put("user",userinfo);
//			log.info("存入Redis中》》》》》》》》》》》》》》》");
//			redisTemplate.opsForValue().set("userinfo", userinfo);
//			return data;
//		}
//		else {
//			log.info("进入Redis查询》》》》》》》》》》》》》》》》》");
//			data.getData().put("user", redisuser);
//			return data;
//		}
	}

//	@ApiOperation(value = "微信公众平台支付", notes = "返回微信公众平台支付参数")
//	@ApiResponses({ @ApiResponse(code = 200, message = "支付成功", response = WechatPublicPayResult.class),
//			@ApiResponse(code = 201, message = "操作失败原因", response = Void.class) })
//	@PostMapping("/wechatPublicPay")
//	public ResultMsg wechatPublicPay(@RequestBody WechatPublicPayParam params) throws Exception {
//		ResultMsg result = synthesisPayService.getWechatPublicPayResult(params);
//		log.info(result.toString());
//		return result;
//	}

//	@PostMapping("login")
//	public ResponseData Login(String pre) {
//
//		log.info("收到login请求：参数" + pre);
//		ResponseData data = new ResponseData();
//		data.getData().put("user", "123456789");
//		return data;
//	}
//
//	// Nginx代理测试
//	@PostMapping("hi")
//	public String sayHi() {
//		return "My port is " + port;
//	}
//	
	
	
	
}
