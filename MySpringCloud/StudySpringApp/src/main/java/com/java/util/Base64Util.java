/**
 * Project Name:app-express
 * File Name:Base64Util.java
 * Package Name:com.amt.util
 * Date:2019年3月21日下午3:26:10
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
*/
package com.java.util;

import java.io.UnsupportedEncodingException;

import org.apache.tomcat.util.codec.binary.Base64;

import lombok.extern.slf4j.Slf4j;

/**   
 * @Title: Base64Util.java 
 * @Package com.amt.util 
 * @Description: TODO(Base64工具类) 
 * @author 刘云升  
 * @date 2019年5月21日 下午3:26:10 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Slf4j
public class Base64Util {

	//编码集
    private static final String UTF_8 = "UTF-8";

    /**
     * @description: 对给定的字符串进行base64解码操作
     * @param inputData
     */
    public static String decodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.decodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            log.error(inputData, e);
        }

        return null;
    }

    /**
     * @description: 对给定的字符串进行base64加密操作
     * @param inputData
     */
    public static String encodeData(String inputData) {
        try {
            if (null == inputData) {
                return null;
            }
            return new String(Base64.encodeBase64(inputData.getBytes(UTF_8)), UTF_8);
        } catch (UnsupportedEncodingException e) {
            log.error(inputData, e);
        }

        return null;
    }
}
