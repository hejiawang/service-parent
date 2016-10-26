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
import com.wang.service.entity.permission.PermissionResourceEntity;
import com.wang.service.param.permission.PermissionResourceParam;
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

	/**
	 * 根据菜单ID获取对对应的资源
	 * @param menuID 菜单ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	@Override
	public ServiceResult<PermissionResourceEntity> getResourceByMenuID(Integer menuID) {
		Assert.notNull(permissionResourceModel, "Property 'permissionResourceModel' is required.");
		ServiceResult<PermissionResourceEntity> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionResourceModel.getResourceByMenuID(menuID));
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
	 * 根据资源ID获取资源信息
	 * @param resourceID 资源ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	@Override
	public ServiceResult<PermissionResourceParam> getResourceByID(Integer resourceID) {
		Assert.notNull(permissionResourceModel, "Property 'permissionResourceModel' is required.");
		ServiceResult<PermissionResourceParam> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionResourceModel.getResourceByID(resourceID));
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
	 * 获取所有应用系统对应的资源信息
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	@Override
	public ServiceResult<List<PermissionResourceParam>> getResourceForApp() {
		Assert.notNull(permissionResourceModel, "Property 'permissionResourceModel' is required.");
		ServiceResult<List<PermissionResourceParam>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionResourceModel.getResourceForApp());
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
	 * 根据父ID(资源父ID)获取菜单资源信息
	 * @param parentID 资源父ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	@Override
	public ServiceResult<List<PermissionResourceParam>> getResourceForMenu(Integer parentID) {
		Assert.notNull(permissionResourceModel, "Property 'permissionResourceModel' is required.");
		ServiceResult<List<PermissionResourceParam>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionResourceModel.getResourceForMenu(parentID));
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
	 * 根据父ID(资源父ID)获取页面元素资源信息
	 * @param parentID 资源父ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.26
	 */
	@Override
	public ServiceResult<List<PermissionResourceParam>> getResourceForElement(Integer parentID) {
		Assert.notNull(permissionResourceModel, "Property 'permissionResourceModel' is required.");
		ServiceResult<List<PermissionResourceParam>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionResourceModel.getResourceForElement(parentID));
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
	 * 根据父ID(资源父ID)获取菜单资源信息<br>
	 * 菜单下有页面元素信息时，为父资源
	 * @param parentID 资源父ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.26
	 */
	@Override
	public ServiceResult<List<PermissionResourceParam>> getResourceForMenuElement(Integer parentID) {
		Assert.notNull(permissionResourceModel, "Property 'permissionResourceModel' is required.");
		ServiceResult<List<PermissionResourceParam>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionResourceModel.getResourceForMenuElement(parentID));
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
