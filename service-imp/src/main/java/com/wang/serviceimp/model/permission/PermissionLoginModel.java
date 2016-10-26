package com.wang.serviceimp.model.permission;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.core.util.MD5;
import com.wang.service.entity.permission.PermissionUserInfoEntity;
import com.wang.serviceimp.dao.permission.read.PermissionLoginReadDao;

/**
 * 
 * 登录、注册、注销 Model
 * 
 * @author HeJiawang
 * @date   2016.09.21
 *
 */
@Service
public class PermissionLoginModel {

	private final Logger logger = LoggerFactory.getLogger(PermissionLoginModel.class);
	
	@Autowired
	private PermissionLoginReadDao loginReadDao;
	
	/**
	 * 用户登录
	 * @param loginName 登录名
	 * @param password  密码
	 * @param ip        登录ip(预留)
	 * @return          用户信息
	 */
	public PermissionUserInfoEntity doLogin(String loginName, String password, String ip) {
		Assert.notNull(loginReadDao, "Property 'loginReadDao' is required.");
		if (StringUtils.isBlank(loginName)) {
			throw new BusinessException("登录名不能为空");
		}
		if (StringUtils.isBlank(password)) {
			throw new BusinessException("密码不能为空");
		}
		password = MD5.getInstrance().getMD5String4(password);
		return loginReadDao.getUserEntityByLoginNameAndPwd(loginName, password);
	}

}
