package com.wang.serviceimp.service.imp.permission;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.Constants;
import com.wang.core.ServiceResult;
import com.wang.core.exception.BusinessException;
import com.wang.service.param.permission.PermissionMenuParam;
import com.wang.service.service.permission.PermissionMenuService;
import com.wang.serviceimp.model.permission.PermissionMenuModel;

/**
 * 菜单service imp
 * @author HeJiawang
 * @date   2016.10.18
 */
@Service
public class PermissionMenuServiceImp implements PermissionMenuService {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionMenuServiceImp.class);
	
	/**
	 * permissionMenuModel
	 */
	private PermissionMenuModel permissionMenuModel;
	
	/**
	 * 获取分页菜单
	 * @param menu 菜单参数
	 * @return 菜单集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageMenu(PermissionMenuParam menu) {
		Assert.notNull(permissionMenuModel, "Property 'permissionMenuModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionMenuModel.pageMenu(menu));
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
