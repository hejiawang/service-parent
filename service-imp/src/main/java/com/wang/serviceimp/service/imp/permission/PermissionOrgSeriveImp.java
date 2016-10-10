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
import com.wang.service.param.permission.PermissionOrgParam;
import com.wang.service.service.permission.PermissionOrgService;
import com.wang.serviceimp.model.permission.PermissionOrgModel;

/**
 * 机构service imp
 * 
 * @author HeJiawang
 * @date   2016.10.10
 */
@Service
public class PermissionOrgSeriveImp implements PermissionOrgService {
	
	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionOrgSeriveImp.class);
	
	/**
	 * permissionOrgModel
	 */
	@Autowired
	private PermissionOrgModel permissionOrgModel;
	
	/**
	 * 获取分页机构
	 * @param org  机构参数
	 * @return     机构集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.10
	 */
	@Override
	public ServiceResult<Map<String, Object>> pageOrg(PermissionOrgParam org) {
		Assert.notNull(permissionOrgModel, "Property 'permissionOrgModel' is required.");
		ServiceResult<Map<String, Object>> serviceResult = new ServiceResult<>();
		try {
			serviceResult.setResult(permissionOrgModel.pageOrg(org));
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
