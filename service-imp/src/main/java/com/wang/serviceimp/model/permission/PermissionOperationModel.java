package com.wang.serviceimp.model.permission;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.service.entity.permission.PermissionOperationEntity;
import com.wang.service.param.permission.PermissionPermissionOperationParam;
import com.wang.serviceimp.dao.permission.read.PermissionOperationReadDao;

/**
 * 操作 model
 * 
 * @author HeJiawang
 * @date   2016.10.17
 */
@Service
public class PermissionOperationModel {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionOperationModel.class);

	/**
	 * permissionOperationReadDao
	 */
	@Autowired
	private PermissionOperationReadDao permissionOperationReadDao;
	
	
	/**
	 * 获取应用系统可用的操作
	 * @return 应用系统可用的操作
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	public List<PermissionOperationEntity> getOperationForApp() {
		Assert.notNull(permissionOperationReadDao, "Property 'permissionOperationReadDao' is required.");
		
		return permissionOperationReadDao.getOperationForApp();
	}

	/**
	 * 获取菜单可用的操作
	 * @return 菜单可用的操作
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	public List<PermissionOperationEntity> getOperationForMenu() {
		Assert.notNull(permissionOperationReadDao, "Property 'permissionOperationReadDao' is required.");
		
		return permissionOperationReadDao.getOperationForMenu();
	}
	
	/**
	 * 根据资源ID获取操作ID集合
	 * @param resourceID 资源ID
	 * @return ServiceResult
 	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	public List<Integer> getOperationIDByResourceID(Integer resourceID) {
		Assert.notNull(permissionOperationReadDao, "Property 'permissionResourceReadDao' is required.");
		if( resourceID == null ) throw new BusinessException("资源ID不能为空");
		
		return permissionOperationReadDao.getOperationIDByResourceID(resourceID);
	}

	/**
	 * 角色所有的资源的操作权限ID
	 * @param roleID 角色ID
	 * @param resourceID 资源ID
	 * @return 操作权限ID
 	 * @author HeJiawang
	 * @date   2016.10.28
	 */
	public List<Integer> getOperationByRoleIDAndResourceID(Integer roleID, Integer resourceID) {
		Assert.notNull(permissionOperationReadDao, "Property 'permissionResourceReadDao' is required.");
		if( resourceID == null ) throw new BusinessException("资源ID不能为空");
		
		return permissionOperationReadDao.getOperationByRoleIDAndResourceID(roleID, resourceID);
	}

	/**
	 * 获取操作和操作权限
	 * @param resourceID 资源ID
	 * @return 操作权限ID
 	 * @author HeJiawang
	 * @date   2016.10.28
	 */
	public List<PermissionPermissionOperationParam> getOperationAndPermissionByResourceID(Integer resourceID) {
		Assert.notNull(permissionOperationReadDao, "Property 'permissionResourceReadDao' is required.");
		if( resourceID == null ) throw new BusinessException("资源ID不能为空");
		
		return permissionOperationReadDao.getOperationAndPermissionByResourceID(resourceID);
	}

}
