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
import com.wang.service.param.permission.PermissionPermissionOperationParam;
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
	 * 获取菜单可用的操作
	 * @return 菜单可用的操作
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	@Override
	public ServiceResult<List<PermissionOperationEntity>> getOperationForMenu() {
		Assert.notNull(permissionOperationModel, "Property 'permissionOperationModel' is required.");
		ServiceResult<List<PermissionOperationEntity>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionOperationModel.getOperationForMenu());
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

	/**
	 * 角色所有的资源的操作权限ID
	 * @param roleID 角色ID
	 * @param resourceID 资源ID
	 * @return 操作权限ID
 	 * @author HeJiawang
	 * @date   2016.10.28
	 */
	@Override
	public ServiceResult<List<Integer>> getOperationByRoleIDAndResourceID(Integer roleID, Integer resourceID) {
		Assert.notNull(permissionOperationModel, "Property 'permissionOperationModel' is required.");
		ServiceResult<List<Integer>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionOperationModel.getOperationByRoleIDAndResourceID(roleID, resourceID));
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
	 * 获取操作和操作权限
	 * @param resourceID 资源ID
	 * @return 操作权限ID
 	 * @author HeJiawang
	 * @date   2016.10.28
	 */
	@Override
	public ServiceResult<List<PermissionPermissionOperationParam>> getOperationAndPermissionByResourceID(Integer resourceID) {
		Assert.notNull(permissionOperationModel, "Property 'permissionOperationModel' is required.");
		ServiceResult<List<PermissionPermissionOperationParam>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionOperationModel.getOperationAndPermissionByResourceID(resourceID));
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
