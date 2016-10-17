package com.wang.serviceimp.dao.permission.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;

/**
 * 
 * 资源--操作 write dao
 * 
 * @author HeJiawang
 * @date   2016.10.17
 *
 */
@MyBatisRepository
public interface PermissionPermissionWriteDao {

	/**
	 * 为资源存储可用的操作
	 * @param operationID 操作ID
	 * @param resourceID  资源ID
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	void addPermission(@Param("operationID") String operationID, 
			@Param("resourceID") Integer resourceID);

	/**
	 * 删除所有该资源绑定的操作权限
	 * @param resourceID 资源ID
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	Integer deletePermissionByResourceID(@Param("resourceID") Integer resourceID);

}
