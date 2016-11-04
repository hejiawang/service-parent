package com.wang.serviceimp.model.permission;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
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
	 * 事务
	 */
	@Autowired
	private DataSourceTransactionManager transactionManagerMember;

	/**
	 * 获取分页角色
	 * @param role  角色参数
	 * @return     角色集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.14
	 */
	public Map<String, Object> pageRole(PermissionRoleParam role) {
		Assert.notNull(permissionRoleReadDao, "Property 'permissionRoleReadDao' is required.");
		if( role.getPageStart() == null || role.getPageEnd() == null || role.getDraw() == null ) 
			throw new BusinessException("分页信息不能为空");
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> pageLsit = permissionRoleReadDao.getPageList(role);
		Integer recordsTotal = permissionRoleReadDao.getPageTotal(role);
		
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

	/**
	 * 为角色分配权限
	 * @param role 角色信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.28
	 */
	public Boolean raisePermission(PermissionRoleParam role) {
		Assert.notNull(permissionRoleWriteDao, "Property 'permissionRoleWriteDao' is required.");
		if( role == null ) throw new BusinessException("角色不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			List<String> permissionIDList = Arrays.asList(role.getPermissionIDs().split(","));
			
			/**
			 * 删除该角色的所有权限
			 */
			permissionRoleWriteDao.deleteRolePermissionByReaourceID(role.getRoleID(), role.getResourceID());
			
			/**
			 * 为该角色增加新的权限
			 */
			for( String permissionID : permissionIDList ){
				
				permissionRoleWriteDao.addRolePermissionByReaourceID(role.getRoleID() ,permissionID);
			}
			
			transactionManagerMember.commit(status);
		} catch ( Exception e ){
			logger.error("异常发生在"+this.getClass().getName()+"类的addUserInfo方法，异常原因是："+e.getMessage(), e.fillInStackTrace());
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("授权失败!");
		}
		
		return true;
	}

	/**
	 * 获取角色树</br>
	 * 即、全部角色
	 * @return 角色树
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	public List<PermissionRoleParam> queryRoleForTree() {
		Assert.notNull(permissionRoleReadDao, "Property 'permissionRoleReadDao' is required.");
		
		return permissionRoleReadDao.queryRoleForTree();
	}

	/**
	 * 检查角色信息是否被应用
	 * @param roleID 角色ID
	 * @return true  被引用
	 * @author HeJiawang
	 * @date   2016.11.04
	 */
	public Boolean checkRoleByID(Integer roleID) {
		Assert.notNull(permissionRoleReadDao, "Property 'permissionRoleReadDao' is required.");
		if( roleID == null ) throw new BusinessException("角色ID不能为空");
		
		Integer checkUserResult = permissionRoleReadDao.checkRoleFromUserRole(roleID);	//检查在用户角色关联表中是否被引用
		if( checkUserResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}
}
