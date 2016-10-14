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
import com.wang.service.param.permission.PermissionRoleParam;
import com.wang.service.service.permission.PermissionRoleService;
import com.wang.serviceimp.model.permission.PermissionRoleModel;

/**
 * 角色service imp
 * 
 * @author HeJiawang
 * @date   2016.10.12
 */
@Service
public class PermissionRoleServiceImp implements PermissionRoleService {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionRoleServiceImp.class);
	
	/**
	 * permissionRoleModel
	 */
	@Autowired
	private PermissionRoleModel permissionRoleModel;

	/**
	 * 获取分页角色
	 * @param role  角色参数
	 * @return     角色集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageRole(PermissionRoleParam role) {
		Assert.notNull(permissionRoleModel, "Property 'permissionRoleModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionRoleModel.pageRole(role));
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
	 * 查看角色
	 * @param roleID 角色ID
	 * @return 角色信息
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	@Override
	public ServiceResult<Map<String, Object>> getRoleByID(Integer roleID) {
		Assert.notNull(permissionRoleModel, "Property 'permissionRoleModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionRoleModel.getRoleByID(roleID));
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
	 * 删除角色
	 * @param roleID 角色ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	@Override
	public ServiceResult<Void> deleteRoleByID(Integer roleID) {
		Assert.notNull(permissionRoleModel, "Property 'permissionRoleModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean deleteResult = permissionRoleModel.deleteRoleByID(roleID);
			if( deleteResult ){
				serviceResult.setMessage("删除角色成功");
			}else{
				serviceResult.setMessage("删除角色失败");
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
	 * 新增角色
	 * @param role 角色信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	@Override
	public ServiceResult<Void> addRole(PermissionRoleParam role) {
		Assert.notNull(permissionRoleModel, "Property 'permissionRoleModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean existName = permissionRoleModel.checkExistRoleName(role);	//检查角色名称是否重复
			if(existName){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("角色编码重复,新增角色失败");
			} else {
				permissionRoleModel.addRole(role);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("新增角色成功");
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
	 * 修改角色
	 * @param role 角色信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	@Override
	public ServiceResult<Void> updateRole(PermissionRoleParam role) {
		Assert.notNull(permissionRoleModel, "Property 'permissionRoleModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean existName = permissionRoleModel.checkExistRoleName(role);	//检查角色名称是否重复
			if(existName){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("角色编码重复,新增角色失败");
			} else {
				permissionRoleModel.updateRole(role);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("新增角色成功");
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

}
