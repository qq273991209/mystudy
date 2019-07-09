package cn.hfbin.seckill.dao;

import cn.hfbin.seckill.entity.User;
import org.apache.ibatis.annotations.Param;
/**
 * 
 * @Title: UserMapper.java 
 * @Package cn.hfbin.seckill.dao 
 * @Description: TODO(用户Mapper) 
 * @author 刘云升  
 * @date 2019年6月12日 下午6:05:52 
 * Copyright (c) ©1994-2019 Scjydz.com All Rights Reserved.
 */
public interface UserMapper {

    User selectByPhoneAndPassword(@Param("phone") String phone , @Param("password") String password);

    User checkPhone(@Param("phone") String phone );
}
