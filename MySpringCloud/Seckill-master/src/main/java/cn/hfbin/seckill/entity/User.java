package cn.hfbin.seckill.entity;

import lombok.*;

import java.util.Date;
/**
 * 
 * @Title: User.java 
 * @Package cn.hfbin.seckill.entity 
 * @Description: TODO(用户实体类) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:07:43 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private int id;
	private String userName;
	private String phone;
	private String password;
	private String salt;
	private String head;
	private int loginCount;
	private Date registerDate;
	private Date lastLoginDate;
}
