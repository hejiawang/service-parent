package com.wang.service.service.permission;

import com.wang.core.ServiceResult;
import com.wang.service.entity.permission.PermissionUserInfoEntity;

/**
 * 
 * 登录、注册、注销 service
 * 
 * @author HeJiawang
 * @date   2016.09.21
 *
 */
public interface PermissionLoginService {

	/**
	 * 用户登录
	 * @param loginName 登录名
	 * @param password  密码
	 * @param ip        登录ip(预留)
	 * @return          用户信息
	 */
	ServiceResult<PermissionUserInfoEntity> doLogin(String loginName, String password, String ip);

}
