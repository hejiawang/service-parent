package com.wang.serviceimp.model.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.service.param.permission.PermissionRoleParam;
import com.wang.serviceimp.dao.permission.read.PermissionRoleReadDao;
import com.wang.serviceimp.dao.permission.write.PermissionRoleWriteDao;

/**
 * 角色 model
 * 
 * @author HeJiawang
 * @date   2016.10.12
 */
@Service
public class PermissionRoleModel {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionRoleModel.class);
	
	/**
	 * permissionRoleReadDao
	 */
	@Autowired
	private PermissionRoleReadDao permissionRoleReadDao;
	
	/**
	 * permissionRoleWriteDao
	 */
	@Autowired
	private PermissionRoleWriteDao permissionRoleWriteDao;

	/**
	 * 获取分页角色
	 * @param role  角色参数
	 * @return     角色集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	public Map<String, Object> pageRole(PermissionRoleParam role) {
		Assert.notNull(permissionRoleReadDao, "Property 'permissionRoleReadDao' is required.");
		if( role.getPageSize() == null || role.getPageNumber() == null || role.getDraw() == null ) 
			throw new BusinessException("分页信息不能为空");
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> pageLsit = permissionRoleReadDao.getPageList(role);
		Integer recordsTotal = pageLsit.size();
		
		map.put("draw", role.getDraw());
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}
	
	/**
	 * 查看角色
	 * @param roleID 角色ID
	 * @return 角色信息
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	public Map<String, Object> getRoleByID(Integer roleID) {
		Assert.notNull(permissionRoleReadDao, "Property 'permissionRoleReadDao' is required.");
		if( roleID == null ) throw new BusinessException("角色ID不能为空");
		
		return permissionRoleReadDao.getRoleByID(roleID);
	}

	/**
	 * 删除角色
	 * @param roleID 角色ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	public Boolean deleteRoleByID(Integer roleID) {
		Assert.notNull(permissionRoleWriteDao, "Property 'permissionRoleWriteDao' is required.");
		if( roleID == null ) throw new BusinessException("角色ID不能为空");
		
		Integer deleteResult = permissionRoleWriteDao.deleteRoleByID(roleID);
		if( deleteResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查角色名称是否重复
	 * @param role 角色信息
	 * @return True	重复
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	public Boolean checkExistRoleName(PermissionRoleParam role) {
		Assert.notNull(permissionRoleReadDao, "Property 'permissionRoleReadDao' is required.");
		if( role == null ) throw new BusinessException("角色不能为空");
		
		Integer result = permissionRoleReadDao.checkExistRoleName(role);
		if( result >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 新增角色
	 * @param role 角色信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	public void addRole(PermissionRoleParam role) {
		Assert.notNull(permissionRoleWriteDao, "Property 'permissionRoleWriteDao' is required.");
		if( role == null ) throw new BusinessException("角色不能为空");
		
		permissionRoleWriteDao.addRole(role);
	}

	/**
	 * 修改角色
	 * @param role 角色信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	public void updateRole(PermissionRoleParam role) {
		Assert.notNull(permissionRoleWriteDao, "Property 'permissionRoleWriteDao' is required.");
		if( role == null ) throw new BusinessException("角色不能为空");
		
		permissionRoleWriteDao.updateRole(role);
	}
}
