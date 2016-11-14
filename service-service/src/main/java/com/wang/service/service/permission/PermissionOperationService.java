package com.wang.service.service.permission;

import java.util.List;

import com.wang.core.ServiceResult;
import com.wang.service.entity.permission.PermissionOperationEntity;
import com.wang.service.param.permission.PermissionPermissionOperationParam;

/**
 * 操作service
 * @author HeJiawang
 * @date   2016.10.17
 */
public interface PermissionOperationService {

	/**
	 * 获取应用系统可用的操作
	 * @return 应用系统可用的操作
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	ServiceResult<List<PermissionOperationEntity>> getOperationForApp();
	
	/**
	 * 获取菜单可用的操作
	 * @return 菜单可用的操作
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	ServiceResult<List<PermissionOperationEntity>> getOperationForMenu();
	
	/**
	 * 获取页面元素可用的操作
	 * @return 页面元素可用的操作
	 * @author HeJiawang
	 * @date   2016.11.14
	 */
	ServiceResult<List<PermissionOperationEntity>> getOperationForElement();
	
	/**
	 * 根据资源ID获取操作ID集合
	 * @param resourceID 资源ID
	 * @return ServiceResult
 	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	ServiceResult<List<Integer>> getOperationIDByResourceID(Integer resourceID);

	/**
	 * 角色所有的资源的操作权限ID
	 * @param roleID 角色ID
	 * @param resourceID 资源ID
	 * @return 操作权限ID
 	 * @author HeJiawang
	 * @date   2016.10.28
	 */
	ServiceResult<List<Integer>> getOperationByRoleIDAndResourceID(Integer roleID, Integer resourceID);

	/**
	 * 获取操作和操作权限
	 * @param resourceID 资源ID
	 * @return 操作权限ID
 	 * @author HeJiawang
	 * @date   2016.10.28
	 */
	ServiceResult<List<PermissionPermissionOperationParam>> getOperationAndPermissionByResourceID(Integer resourceID);

}
