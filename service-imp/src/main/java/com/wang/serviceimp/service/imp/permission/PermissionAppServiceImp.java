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
import com.wang.service.param.permission.PermissionAppParam;
import com.wang.service.service.permission.PermissionAppService;
import com.wang.serviceimp.model.permission.PermissionAppModel;

/**
 * 应用系统service imp
 * 
 * @author HeJiawang
 * @date   2016.10.17
 */
@Service
public class PermissionAppServiceImp implements PermissionAppService {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionAppServiceImp.class);
	
	/**
	 * permissionAppModel
	 */
	@Autowired
	private PermissionAppModel permissionAppModel;
	
	/**
	 * 获取分页应用系统
	 * @param app 应用系统参数
	 * @return 应用系统集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageApp(PermissionAppParam app) {
		Assert.notNull(permissionAppModel, "Property 'permissionAppModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionAppModel.pageApp(app));
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
	 * 新增应用系统
	 * @param app 应用系统信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	@Override
	public ServiceResult<Void> addApp(PermissionAppParam app) {
		Assert.notNull(permissionAppModel, "Property 'permissionAppModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean existName = permissionAppModel.checkExistAppName(app);	//检查系统名称是否重复
			if(existName){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("系统名称重复,新增系统失败");
			} else {
				permissionAppModel.addApp(app);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("新增系统成功");
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
	 * 修改应用系统
	 * @param app 应用系统信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	@Override
	public ServiceResult<Void> updateApp(PermissionAppParam app) {
		Assert.notNull(permissionAppModel, "Property 'permissionAppModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean existName = permissionAppModel.checkExistAppName(app);	//检查系统名称是否重复
			if(existName){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("系统名称重复,新增系统失败");
			} else {
				permissionAppModel.updateApp(app);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("修改系统成功");
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
	 * 删除应用系统
	 * @param appID 应用系统ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	@Override
	public ServiceResult<Void> deleteAppByID(Integer appID) {
		Assert.notNull(permissionAppModel, "Property 'permissionAppModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean deleteResult = permissionAppModel.deleteAppByID(appID);
			if( deleteResult ){
				serviceResult.setMessage("删除应用系统成功");
			}else{
				serviceResult.setMessage("删除应用系统失败");
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
	 * 应用系统查看
	 * @param appID 应用系统ID
	 * @return 应用系统信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	@Override
	public ServiceResult<PermissionAppParam> getApp(Integer appID) {
		Assert.notNull(permissionAppModel, "Property 'permissionAppModel' is required.");
		ServiceResult<PermissionAppParam> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionAppModel.getApp(appID));
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
