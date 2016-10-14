package com.wang.serviceimp.dao.permission.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionRoleParam;

/**
 * 
 * 角色writer dao
 * 
 * @author HeJiawang
 * @date   2016.10.14
 *
 */
@MyBatisRepository
public interface PermissionRoleWriteDao {

	/**
	 * 删除角色
	 * @param roleID 角色ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	Integer deleteRoleByID(@Param("roleID")Integer roleID);

	/**
	 * 新增角色
	 * @param role 角色信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	void addRole(PermissionRoleParam role);

	/**
	 * 修改角色
	 * @param role 角色信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.13
	 */
	void updateRole(PermissionRoleParam role);

}
