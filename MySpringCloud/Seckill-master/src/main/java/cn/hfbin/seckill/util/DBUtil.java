package cn.hfbin.seckill.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
/**
 * 
 * @Title: DBUtil.java 
 * @Package cn.hfbin.seckill.util 
 * @Description: TODO(数据库获取连接对象类) 
 * @author 刘云升  
 * @date 2019年6月13日 上午9:04:29 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public class DBUtil {
	
	private static Properties props;
	
	static {
		try {
			InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("application.properties");
			props = new Properties();
			props.load(in);
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConn() throws Exception{
		String url = props.getProperty("spring.datasource.url");
		String username = props.getProperty("spring.datasource.username");
		String password = props.getProperty("spring.datasource.password");
		String driver = props.getProperty("spring.datasource.driver-class-name");
		Class.forName(driver);
		return DriverManager.getConnection(url,username, password);
	}
}
