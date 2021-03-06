package com.wang.service.service.permission;

import java.util.List;
import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.service.param.permission.PermissionRoleParam;

/**
 * 角色service
 * @author HeJiawang
 * @date   2016.10.12
 */
public interface PermissionRoleService {

	/**
	 * 获取分页角色
	 * @param role  角色参数
	 * @return     角色集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	ServiceResult<Map<String, Object>> pageRole(PermissionRoleParam role);

	/**
	 * 查看角色
	 * @param roleID 角色ID
	 * @return 角色信息
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	ServiceResult<Map<String, Object>> getRoleByID(Integer roleID);

	/**
	 * 删除角色
	 * @param roleID 角色ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	ServiceResult<Void> deleteRoleByID(Integer roleID);

	/**
	 * 新增角色
	 * @param role 角色信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	ServiceResult<Void> addRole(PermissionRoleParam role);

	/**
	 * 修改角色
	 * @param role 角色信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	ServiceResult<Void> updateRole(PermissionRoleParam role);

	/**
	 * 为角色分配权限
	 * @param role 角色信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.28
	 */
	ServiceResult<Void> raisePermission(PermissionRoleParam role);

	/**
	 * 获取角色树</br>
	 * 即、全部角色
	 * @return 角色树
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	ServiceResult<List<PermissionRoleParam>> queryRoleForTree();

}
