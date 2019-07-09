package cn.hfbin.seckill.mq;

import cn.hfbin.seckill.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * @Title: MQSender.java 
 * @Package cn.hfbin.seckill.mq 
 * @Description: TODO(MQ消息发送类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午8:54:05 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Service
public class MQSender {

	private static Logger log = LoggerFactory.getLogger(MQSender.class);
	
	@Autowired
	AmqpTemplate amqpTemplate ;
	
	public void sendSeckillMessage(SeckillMessage mm) {
		String msg = RedisService.beanToString(mm);
		log.info("send message:"+msg);
		amqpTemplate.convertAndSend(MQConfig.MIAOSHA_QUEUE, msg);
	}

}
