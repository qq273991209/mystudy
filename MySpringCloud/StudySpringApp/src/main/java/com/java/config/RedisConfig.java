/**
 * Project Name:StudySpringApp
 * File Name:RedisConfig.java
 * Package Name:com.java.config
 * Date:2019年6月12日下午2:25:01
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.config;

import java.io.Serializable;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.java.util.ObjectRedisSerializer;

/**   
 * @Title: RedisConfig.java 
 * @Package com.java.config 
 * @Description: TODO(Redis配置类) 
 * @author lys  
 * @date 2019年6月12日 下午2:25:01 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Configuration
public class RedisConfig {
 
    @Bean
    public RedisTemplate<Serializable, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Serializable, Object> template = new RedisTemplate<Serializable, Object>();
        template.setConnectionFactory(connectionFactory);
        template.afterPropertiesSet();
        // redis存取对象的关键配置
        template.setKeySerializer(new StringRedisSerializer());
        // ObjectRedisSerializer类为java对象的序列化和反序列化工具类
        template.setValueSerializer(new ObjectRedisSerializer());
        return template;
    }
}
