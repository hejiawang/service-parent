package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionRoleParam;

/**
 * 
 * 角色read dao
 * 
 * @author HeJiawang
 * @date   2016.10.14
 *
 */
@MyBatisRepository
public interface PermissionRoleReadDao {

	/**
	 * 获取分页角色
	 * @param role 角色参数
	 * @return     角色集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	List<Map<String, Object>> getPageList(PermissionRoleParam role);

	/**
	 * 查看角色
	 * @param roleID 角色ID
	 * @return 角色信息
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	Map<String, Object> getRoleByID(@Param("roleID") Integer roleID);

	/**
	 * 检查角色名称是否重复
	 * @param role 角色信息
	 * @return True	重复
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	Integer checkExistRoleName(PermissionRoleParam role);

}
