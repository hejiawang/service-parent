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
import com.wang.service.param.permission.PermissionAppParam;
import com.wang.service.service.permission.PermissionCoreService;
import com.wang.serviceimp.model.permission.PermissionCoreModel;

/**
 * 菜单、页面元素权限 service Imp
 * 
 * @author HeJiawang
 * @date   2016.11.04
 */
@Service
public class PermissionCoreServiceImp implements PermissionCoreService {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionCoreServiceImp.class);
	
	/**
	 * permissionCoreModel
	 */
	@Autowired
	private PermissionCoreModel permissionCoreModel;
	
	/**
	 * 初始化当前登录者的APP列表
	 * @param currentUserID 当前登陆者ID
	 * @param changeApp 所选择的APP信息
	 * @return APP列表HTML
	 * @author HeJiawang
	 * @date   2016.11.04
	 */
	@Override
	public ServiceResult<String> changeApp(PermissionUserInfoEntity userCurrent, PermissionAppParam changeApp) {
		Assert.notNull(permissionCoreModel, "Property 'permissionCoreModel' is required.");
		ServiceResult<String> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionCoreModel.changeApp(userCurrent, changeApp));
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
