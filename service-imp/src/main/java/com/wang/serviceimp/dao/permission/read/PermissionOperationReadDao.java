package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.entity.permission.PermissionOperationEntity;

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

}
