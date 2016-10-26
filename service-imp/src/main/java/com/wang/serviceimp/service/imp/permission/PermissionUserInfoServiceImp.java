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
import com.wang.service.param.permission.PermissionUserInfoParam;
import com.wang.service.service.permission.PermissionUserInfoService;
import com.wang.serviceimp.model.permission.PermissionUserInfoModel;

/**
 * 用户信息 service imp
 * 
 * @author HeJiawang
 * @date   2016.10.25
 */
@Service
public class PermissionUserInfoServiceImp implements PermissionUserInfoService {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionUserInfoServiceImp.class);
	
	/**
	 * permissionUserInfoModel
	 */
	@Autowired
	private PermissionUserInfoModel permissionUserInfoModel;
	
	/**
	 * 新增用户信息
	 * @param userInfo 用户信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	@Override
	public ServiceResult<Void> addUserInfo(PermissionUserInfoParam userInfo) {
		Assert.notNull(permissionUserInfoModel, "Property 'permissionUserInfoModel' is required.");
		ServiceResult<Void> serviceResult = new ServiceResult<>();
		try {
			Boolean existLoginName = permissionUserInfoModel.checkExistUserLoginName(userInfo);	//检查用户登录名时候重复
			if(existLoginName){
				serviceResult.setSuccess(false);
				serviceResult.setMessage("登录名重复,新增用户失败");
			} else {
				permissionUserInfoModel.addUserInfo(userInfo);
				serviceResult.setSuccess(true);
				serviceResult.setMessage("新增用户成功");
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
	 * 根据用户ID获取该用户角色ID集合
	 * @param userID 用户ID
	 * @return 角色ID集合
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	@Override
	public ServiceResult<List<Integer>> getRoleIDListByUserID(Integer userID) {
		Assert.notNull(permissionUserInfoModel, "Property 'permissionUserInfoModel' is required.");
		ServiceResult<List<Integer>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionUserInfoModel.getRoleIDListByUserID(userID));
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
