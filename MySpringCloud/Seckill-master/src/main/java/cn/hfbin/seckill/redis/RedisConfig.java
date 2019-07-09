package cn.hfbin.seckill.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 
 * @Title: RedisConfig.java 
 * @Package cn.hfbin.seckill.redis 
 * @Description: TODO(RedisConfig配置类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午8:57:08 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Component
@ConfigurationProperties(prefix="redis")
public class RedisConfig {
	private String host;//地址
	private int port;//端口号
	private int timeout;//秒
	private String password;//密码
	private int poolMaxTotal;
	private int poolMaxIdle;
	private int poolMaxWait;//秒
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPoolMaxTotal() {
		return poolMaxTotal;
	}
	public void setPoolMaxTotal(int poolMaxTotal) {
		this.poolMaxTotal = poolMaxTotal;
	}
	public int getPoolMaxIdle() {
		return poolMaxIdle;
	}
	public void setPoolMaxIdle(int poolMaxIdle) {
		this.poolMaxIdle = poolMaxIdle;
	}
	public int getPoolMaxWait() {
		return poolMaxWait;
	}
	public void setPoolMaxWait(int poolMaxWait) {
		this.poolMaxWait = poolMaxWait;
	}
}
