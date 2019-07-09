/**
 * Project Name:mySpringboot
 * File Name:Producer.java
 * Package Name:com.java.jms
 * Date:2019年5月21日下午3:00:42
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.jms;
import javax.jms.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
/**
 * @Title: Producer.java
 * @Package com.java.jms
 * @Description: TODO(消息生产者)
 * @author 刘云升
 * @date 2019年5月21日 下午3:00:42 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
@Component
public class Producer {

	@Autowired // 也可以注入JmsTemplate，JmsMessagingTemplate对JmsTemplate进行了封装
	private JmsMessagingTemplate jmsTemplate;

	// 发送消息，destination是发送到的队列，message是待发送的消息
	public void sendMessage(Destination destination, final String message) {
		jmsTemplate.convertAndSend(destination, message);
	}
}
