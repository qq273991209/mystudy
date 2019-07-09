/**
 * Project Name:mySpringboot
 * File Name:Consumer.java
 * Package Name:com.java.jms
 * Date:2019年5月21日下午3:02:13
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.activemq;

//import org.springframework.jms.annotation.JmsListener;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

/**   
 * @Title: Consumer.java 
 * @Package com.java.jms 
 * @Description: TODO(消息消费者) 
 * @author 刘云升  
 * @date 2019年5月21日 下午3:02:13 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
//@Component
public class Consumer {
	  // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息  
    //@JmsListener(destination = "mytest.queue")  
    public void receiveQueue(String text) {  
        System.out.println("Consumer收到的报文为:"+text);  
    }  
}
