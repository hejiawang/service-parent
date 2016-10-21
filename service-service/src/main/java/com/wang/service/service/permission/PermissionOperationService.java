package com.wang.service.service.permission;

import java.util.List;

import com.wang.core.ServiceResult;
import com.wang.service.entity.permission.PermissionOperationEntity;

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
	 * 根据资源ID获取操作ID集合
	 * @param resourceID 资源ID
	 * @return ServiceResult
 	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	ServiceResult<List<Integer>> getOperationIDByResourceID(Integer resourceID);

}
