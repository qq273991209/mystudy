package com.java.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
/**
 * 工具类,统一返回值类型
 * @author lys
 *
 * 2019年3月21日
 */
//@Component
public class ResponseData {
	private int code = 200;
	private String message = "ok";
	private Map<String, Object> data = new HashMap<String, Object>();

	public ResponseData() {
		super();
	}

	public ResponseData(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public static ResponseData ok() {

		return new ResponseData(200, "ok");
	}

	public static ResponseData noFound() {

		return new ResponseData(400, "no found resource");
	}

	public static ResponseData unauthorized() {

		return new ResponseData(401, "unauthorized");
	}
}
