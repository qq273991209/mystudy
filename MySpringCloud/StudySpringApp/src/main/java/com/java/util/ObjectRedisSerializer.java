/**
 * Project Name:StudySpringApp
 * File Name:ObjectRedisSerializer.java
 * Package Name:com.java.util
 * Date:2019年6月12日下午2:26:44
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @Title: ObjectRedisSerializer.java
 * @Package com.java.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author lys
 * @date 2019年6月12日 下午2:26:44 Copyright (c) ©1994-2019 Scjydz.com All Rights
 *       Reserved.
 */
public class ObjectRedisSerializer implements RedisSerializer<Object> {

	/**
	 * 定义序列化和反序列化转化类
	 */
	private Converter<Object, byte[]> serializer = new SerializingConverter();
	private Converter<byte[], Object> deserializer = new DeserializingConverter();

	/**
	 * 定义转换空字节数组
	 */
	private static final byte[] EMPTY_ARRAY = new byte[0];

	@Override
	public byte[] serialize(Object obj) throws SerializationException {
		byte[] byteArray = null;
		if (null == obj) {
			System.err.println("----------------------------->:Redis待序列化的对象为空.");
			byteArray = EMPTY_ARRAY;
		} else {
			try {
				byteArray = serializer.convert(obj);
			} catch (Exception e) {
				System.err.println("----------------------------->Redis序列化对象失败,异常：" + e.getMessage());
				byteArray = EMPTY_ARRAY;
			}
		}
		return byteArray;
	}

	@Override
	public Object deserialize(byte[] datas) throws SerializationException {
		Object obj = null;
		if ((null == datas) || (datas.length == 0)) {
			System.out.println("---------------------------------->Redis待反序列化的对象为空.");
		} else {
			try {
				obj = deserializer.convert(datas);
			} catch (Exception e) {
				System.out.println("------------------------------------->Redis反序列化对象失败,异常：" + e.getMessage());
			}
		}
		return obj;
	}
}
