package com.wang.serviceimp.model.permission;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.service.entity.permission.PermissionResourceEntity;
import com.wang.serviceimp.dao.permission.read.PermissionResourceReadDao;

/**
 * 资源 model
 * 
 * @author HeJiawang
 * @date   2016.10.17
 */
@Service
public class PermissionResourceModel {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionResourceModel.class);

	/**
	 * permissionResourceReadDao
	 */
	@Autowired
	private PermissionResourceReadDao permissionResourceReadDao;
	
	/**
	 * 根据应用系统ID获取对对应的资源
	 * @param appID 应用系统ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	public PermissionResourceEntity getResourceByAppID(Integer appID) {
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		if( appID == null ) throw new BusinessException("应用系统ID不能为空");
		
		return permissionResourceReadDao.getResourceByAppID(appID);
	}

}
