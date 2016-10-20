package com.wang.serviceimp.service.imp.permission;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.service.entity.permission.PermissionOperationEntity;
import com.wang.service.service.permission.PermissionOperationService;
import com.wang.serviceimp.model.permission.PermissionOperationModel;

/**
 * 操作service imp
 * @author HeJiawang
 * @date   2016.10.17
 */
@Service
public class PermissionOperationServiceImp implements PermissionOperationService {
	
	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionOperationServiceImp.class);
	
	/**
	 * permissionOperationModel
	 */
	@Autowired
	private PermissionOperationModel permissionOperationModel;
	
	/**
	 * 获取应用系统可用的操作
	 * @return 应用系统可用的操作
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	@Override
	public ServiceResult<List<PermissionOperationEntity>> getOperationForApp() {
		Assert.notNull(permissionOperationModel, "Property 'permissionOperationModel' is required.");
		ServiceResult<List<PermissionOperationEntity>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionOperationModel.getOperationForApp());
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

	/**
	 * 根据资源ID获取操作ID集合
	 * @param resourceID 资源ID
	 * @return ServiceResult
 	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	@Override
	public ServiceResult<List<Integer>> getOperationIDByResourceID(Integer resourceID) {
		Assert.notNull(permissionOperationModel, "Property 'permissionOperationModel' is required.");
		ServiceResult<List<Integer>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionOperationModel.getOperationIDByResourceID(resourceID));
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
