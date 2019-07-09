///**
// * Project Name:mySpringboot
// * File Name:Producer.java
// * Package Name:com.java.jms
// * Date:2019年5月21日下午3:00:42
// * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
//*/
//package com.java.rabbitmq;
//
//import java.util.Date;
//
//import org.springframework.amqp.core.AmqpTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @Title: Producer.java
// * @Package com.java.jms
// * @Description: TODO(消息生产者)
// * @author 刘云升
// * @date 2019年5月21日 下午3:00:42 Copyright (c) ©1994-2019 Scjydz.com All Rights
// *       Reserved.
// */
//@Component
//public class Producer {
//
//	
//	@Autowired
//	private AmqpTemplate rabbitTemplate;
//
//	public void send() {
//		String context = "hello " + new Date();
//		System.out.println("发送了一个队列消息 : " + context);
//		this.rabbitTemplate.convertAndSend("hello", context);//发送队列消息
//	}
//	 
//	public void send1() {
//	    String context = "hi, i am message 1";
//	   
//	    this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
//	}
//	 
//	public void send2() {
//	    String context = "hi, i am messages 2";
//	    this.rabbitTemplate.convertAndSend("exchange", "topic.messages", context);
//	}
//	public void sendA() {
//	    String context = "messages A";
//	    this.rabbitTemplate.convertAndSend("fanout.A", context);
//	}
//	public void sendB() {
//	    String context = "messages B";
//	    this.rabbitTemplate.convertAndSend("fanout.B", context);
//	}
//	public void sendC() {
//	    String context = "am messages C";
//	    this.rabbitTemplate.convertAndSend("fanout.C", context);
//	}
//}
