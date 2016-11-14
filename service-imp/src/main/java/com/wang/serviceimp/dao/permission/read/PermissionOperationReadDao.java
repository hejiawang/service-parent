package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.entity.permission.PermissionOperationEntity;
import com.wang.service.param.permission.PermissionPermissionOperationParam;

/**
 * 
 * 操作read dao
 * 
 * @author HeJiawang
 * @date   2016.10.17
 *
 */
@MyBatisRepository
public interface PermissionOperationReadDao {

	/**
	 * 获取应用系统可用的操作
	 * @return 应用系统可用的操作
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	List<PermissionOperationEntity> getOperationForApp();

	/**
	 * 获取菜单可用的操作
	 * @return 菜单可用的操作
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	List<PermissionOperationEntity> getOperationForMenu();
	
	/**
	 * 获取页面元素可用的操作
	 * @return 页面元素可用的操作
	 * @author HeJiawang
	 * @date   2016.11.14
	 */
	List<PermissionOperationEntity> getOperationForElement();
	
	/**
	 * 根据资源ID获取操作ID集合
	 * @param resourceID 资源ID
	 * @return ServiceResult
 	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	List<Integer> getOperationIDByResourceID(@Param("resourceID")Integer resourceID);

	/**
	 * 根据系统资源ID获取用逗号连接的操作ID和用逗号连接的操作名称
	 * @param appID 应用系统ID
	 * @return 应用系统信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	Map<String, String> getOperationStringArgsByResourceID( @Param("resourceID") Integer resourceID);

	/**
	 * 角色所有的资源的操作权限ID
	 * @param roleID 角色ID
	 * @param resourceID 资源ID
	 * @return 操作权限ID
 	 * @author HeJiawang
	 * @date   2016.10.28
	 */
	List<Integer> getOperationByRoleIDAndResourceID(@Param("roleID")Integer roleID, @Param("resourceID")Integer resourceID);

	/**
	 * 获取操作和操作权限
	 * @param resourceID 资源ID
	 * @return 操作权限ID
 	 * @author HeJiawang
	 * @date   2016.10.28
	 */
	List<PermissionPermissionOperationParam> getOperationAndPermissionByResourceID(@Param("resourceID")Integer resourceID);

}
