package com.java.controller;

import javax.jms.Destination;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageHelper;
import com.java.config.ControllerLog;
import com.java.entity.UserEntity;
import com.java.jms.Producer;
import com.java.mapper.UserEntityMapper;
import com.java.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import tk.mybatis.mapper.entity.Example;
/**
 * 
 * @Title: LoginController.java
 * @Package com.java.controller
 * @Description: TODO(测试登录控制器)
 * @author 刘云升
 * @date 2019年5月20日 下午1:46:18 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
@Api(tags = "用户API")
@RestController
@SuppressWarnings("all")
public class LoginController {
	@Autowired
	private UserEntityMapper userMapper;

	//@Autowired
	//private Producer producer;

	@ApiOperation(value = "用户登录测试", notes = "根据User对象查询用户")
//	 @ApiImplicitParam(name = "id", value = "userid", required = true, paramType =
//	 "query")
	@ApiResponses({ @ApiResponse(code = 200, message = "查询成功", response = UserEntity.class),
			@ApiResponse(code = 201, message = "无查询数据", response = Void.class) })
	@RequestMapping("/getUser")
	@ControllerLog("测试方法")
	public ResponseData login() {
		System.out.println("收到getUser请求");
		Example example = new Example(UserEntity.class);// 实例化
		Example.Criteria criteria = example.createCriteria();
		//criteria.andEqualTo("id", UserInfo.getId());
		//System.out.println(UserInfo.getRealName());
		//criteria.andLike("realName", "%" + UserInfo.getRealName() + "%");
		ResponseData data = new ResponseData();
		// int row = userMapper.insertUser(UserInfo);
		// data.getData().put("user", userMapper.select(UserInfo));
		// data.getData().put("user", userMapper.selectByExample(example));
		// data.getData().put("user", userMapper.selectAll());
		data.getData().put("user", PageHelper.startPage(1, 3).doSelectPageInfo(() -> userMapper.selectAll()));
		//Destination destination = new ActiveMQQueue("mytest.queue");  
//		System.out.println(data.getData());
//        data.getData().put("端口号:", port);
//        for(int i=0; i<10; i++){  
            //producer.sendMessage(destination, "myname is chhliu!!!"); 
//        }  
		return data;
	}
//	//Nginx代理测试
//		@Value("${server.port}")
//	    private String port;
//	 
//	    @RequestMapping("hi")
//	    public  String sayHi(){
//	        return "Hi,My port is "+ port;
//	    }
}
