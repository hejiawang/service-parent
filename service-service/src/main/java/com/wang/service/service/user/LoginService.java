package com.wang.service.service.user;

import com.wang.core.ServiceResult;
import com.wang.service.entity.user.UserEntity;

/**
 * 
 * 登录、注册、注销 service
 * 
 * @author HeJiawang
 * @date   2016.09.21
 *
 */
public interface LoginService {

	/**
	 * 用户登录
	 * @param loginName 登录名
	 * @param password  密码
	 * @param ip        登录ip(预留)
	 * @return          用户信息
	 */
	ServiceResult<UserEntity> doLogin(String loginName, String password, String ip);

}
