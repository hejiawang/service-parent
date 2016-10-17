package com.wang.serviceimp.service.imp.permission;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.service.entity.permission.PermissionResourceEntity;
import com.wang.service.service.permission.PermissionResourceService;
import com.wang.serviceimp.model.permission.PermissionResourceModel;

/**
 * 资源service imp
 * 
 * @author HeJiawang
 * @date   2016.10.17
 */
@Service
public class PermissionResourceServiceImp implements PermissionResourceService {
	
	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionResourceServiceImp.class);
	
	/**
	 * permissionResourceModel
	 */
	@Autowired
	private PermissionResourceModel permissionResourceModel;

	/**
	 * 根据应用系统ID获取对对应的资源
	 * @param appID 应用系统ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	@Override
	public ServiceResult<PermissionResourceEntity> getResourceByAppID(Integer appID) {
		Assert.notNull(permissionResourceModel, "Property 'permissionResourceModel' is required.");
		ServiceResult<PermissionResourceEntity> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionResourceModel.getResourceByAppID(appID));
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
