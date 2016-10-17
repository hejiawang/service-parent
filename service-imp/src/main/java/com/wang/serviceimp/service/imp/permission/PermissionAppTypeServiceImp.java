package com.wang.serviceimp.service.imp.permission;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.service.entity.permission.PermissionAppTypeEntity;
import com.wang.service.param.permission.PermissionAppTypeParam;
import com.wang.service.service.permission.PermissionAppTypeService;
import com.wang.serviceimp.model.permission.PermissionAppTypeModel;

/**
 * 系统类型service imp
 * 
 * @author HeJiawang
 * @date   2016.10.16
 */
@Service
public class PermissionAppTypeServiceImp implements PermissionAppTypeService {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionAppTypeServiceImp.class);
	
	/**
	 * permissionAppTypeModel
	 */
	@Autowired
	private PermissionAppTypeModel permissionAppTypeModel;

	/**
	 * 获取分页系统类型
	 * @param appType  系统类型参数
	 * @return     系统类型集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageAppType(PermissionAppTypeParam appType) {
		Assert.notNull(permissionAppTypeModel, "Property 'permissionAppTypeModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionAppTypeModel.pageAppType(appType));
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
	 * 查看系统类型
	 * @param appTypeID 系统类型ID
	 * @return 系统类型信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	@Override
	public ServiceResult<Map<String, Object>> getAppTypeByID(Integer appTypeID) {
		Assert.notNull(permissionAppTypeModel, "Property 'permissionAppTypeModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionAppTypeModel.getAppTypeByID(appTypeID));
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
	 * 删除系统类型
	 * @param appTypeID 系统类型ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	@Override
	public ServiceResult<Void> deleteAppTypeByID(Integer appTypeID) {
		Assert.notNull(permissionAppTypeModel, "Property 'permissionAppTypeModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean deleteResult = permissionAppTypeModel.deleteAppTypeByID(appTypeID);
			if( deleteResult ){
				serviceResult.setMessage("删除系统类型成功");
			}else{
				serviceResult.setMessage("删除系统类型失败");
			}
			serviceResult.setSuccess(deleteResult);
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
	 * 新增系统类型
	 * @param appType 系统类型信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	@Override
	public ServiceResult<Void> addAppType(PermissionAppTypeParam appType) {
		Assert.notNull(permissionAppTypeModel, "Property 'permissionAppTypeModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean existName = permissionAppTypeModel.checkExistAppTypeName(appType);	//检查系统类型名称是否重复
			if(existName){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("系统类型名称重复,新增系统类型失败");
			} else {
				permissionAppTypeModel.addAppType(appType);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("新增系统类型成功");
			}
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
	 * 修改系统类型
	 * @param appType 系统类型信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	@Override
	public ServiceResult<Void> updateAppType(PermissionAppTypeParam appType) {
		Assert.notNull(permissionAppTypeModel, "Property 'permissionAppTypeModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean existName = permissionAppTypeModel.checkExistAppTypeName(appType);	//检查系统类型名称是否重复
			if(existName){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("系统类型名称重复,新增系统类型失败");
			} else {
				permissionAppTypeModel.updateAppType(appType);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("新增系统类型成功");
			}
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
	 * 获取系统类型树信息
	 * @return 系统类型树信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	@Override
	public ServiceResult<List<PermissionAppTypeEntity>> getAllAppType() {
		Assert.notNull(permissionAppTypeModel, "Property 'permissionAppTypeModel' is required.");
		ServiceResult<List<PermissionAppTypeEntity>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionAppTypeModel.getAllAppType());
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
