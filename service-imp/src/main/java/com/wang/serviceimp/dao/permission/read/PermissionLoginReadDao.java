package com.wang.serviceimp.dao.permission.read;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.entity.permission.PermissionUserInfoEntity;

/**
 * 
 * 登录、注册、注销 read dao
 * 
 * @author HeJiawang
 * @date   2016.09.21
 *
 */
@MyBatisRepository
public interface PermissionLoginReadDao {

	/**
	 * 用户登录
	 * @param loginName 登录名
	 * @param password  密码
	 * @return          用户信息
	 */
	PermissionUserInfoEntity getUserEntityByLoginNameAndPwd(@Param("loginName")String loginName, 
			@Param("password")String password);

}
