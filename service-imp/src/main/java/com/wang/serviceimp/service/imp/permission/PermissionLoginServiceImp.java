package com.wang.serviceimp.service.imp.permission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.service.entity.permission.PermissionUserInfoEntity;
import com.wang.service.service.permission.PermissionLoginService;
import com.wang.serviceimp.model.permission.PermissionLoginModel;

/**
 * 
 * 登录、注册、注销 service
 * 
 * @author HeJiawang
 * @date   2016.09.21
 *
 */
@Service
public class PermissionLoginServiceImp implements PermissionLoginService {

	private final Logger logger = LoggerFactory.getLogger(PermissionLoginServiceImp.class);
	
	@Autowired
	private PermissionLoginModel loginModel;
	
	/**
	 * 用户登录
	 * @param loginName 登录名
	 * @param password  密码
	 * @param ip        登录ip(预留)
	 * @return          用户信息
	 */
	@Override
	public ServiceResult<PermissionUserInfoEntity> doLogin(String loginName, String password, String ip) {
		Assert.notNull(loginModel, "Property 'loginModel' is required.");
		ServiceResult<PermissionUserInfoEntity> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(loginModel.doLogin(loginName, password, ip));
		} catch (BusinessException e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setSuccess(false);
		} catch (Exception e) {
			serviceResult.setMessage(e.getMessage());
			serviceResult.setError(Constants.SERVICE_RESULT_CODE_SYS_ERROR, Constants.SERVICE_RESULT_EXCEPTION_SYS_ERROR);
			logger.error("发生未知异常!", e);
		}
		return serviceResult;
	}
	

}
