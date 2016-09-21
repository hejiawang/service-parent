package com.wang.serviceimp.dao.user.read;

import org.apache.ibatis.annotations.Param;

import com.wang.service.entity.user.UserEntity;

/**
 * 
 * 登录、注册、注销 read dao
 * 
 * @author HeJiawang
 * @date   2016.09.21
 *
 */
public interface LoginReadDao {

	/**
	 * 用户登录
	 * @param loginName 登录名
	 * @param password  密码
	 * @return          用户信息
	 */
	UserEntity getUserEntityByLoginNameAndPwd(@Param("loginName")String loginName, 
			@Param("password")String password);

}
