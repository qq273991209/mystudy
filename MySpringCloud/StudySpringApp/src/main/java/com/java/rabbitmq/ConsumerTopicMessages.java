///**
// * Project Name:mySpringboot
// * File Name:Consumer.java
// * Package Name:com.java.jms
// * Date:2019年5月21日下午3:02:13
// * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
//*/
//package com.java.rabbitmq;
//
//import org.springframework.amqp.rabbit.annotation.RabbitHandler;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//
///**
// * @Title: Consumer.java
// * @Package com.java.jms
// * @Description: TODO(消息消费者)
// * @author 刘云升
// * @date 2019年5月21日 下午3:02:13 Copyright (c) ©1994-2019 Scjydz.com All Rights
// *       Reserved.
// */
//@Component
//@RabbitListener(queues = "topic.messages")
//public class ConsumerTopicMessages {
//
//	@RabbitHandler
//	public void process(String hello) {
//		System.out.println("topic.messages收到队列消息  : " + hello);
//	}
//}
