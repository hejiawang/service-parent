package com.wang.serviceimp.model.permission;

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
import com.wang.service.entity.permission.PermissionResourceEntity;
import com.wang.service.param.permission.PermissionAppParam;
import com.wang.service.param.permission.PermissionMenuParam;
import com.wang.service.param.permission.PermissionResourceParam;
import com.wang.serviceimp.dao.permission.read.PermissionAppReadDao;
import com.wang.serviceimp.dao.permission.read.PermissionMenuReadDao;
import com.wang.serviceimp.dao.permission.read.PermissionOperationReadDao;
import com.wang.serviceimp.dao.permission.read.PermissionResourceReadDao;
import com.wang.serviceimp.dao.permission.write.PermissionMenuWriteDao;
import com.wang.serviceimp.dao.permission.write.PermissionPermissionWriteDao;
import com.wang.serviceimp.dao.permission.write.PermissionResourceWriteDao;

/**
 * 菜单service imp
 * @author HeJiawang
 * @date   2016.10.18
 */
@Service
public class PermissionMenuModel {
	
	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionAppModel.class);

	/**
	 * 事务
	 */
	@Autowired
	private DataSourceTransactionManager transactionManagerMember;
	
	/**
	 * permissionMenuReadDao
	 */
	@Autowired
	private PermissionMenuReadDao permissionMenuReadDao;
	
	/**
	 * permissionMenuWriteDao
	 */
	@Autowired
	private PermissionMenuWriteDao permissionMenuWriteDao;
	
	/**
	 * permissionResourceWriteDao
	 */
	@Autowired
	private PermissionResourceWriteDao permissionResourceWriteDao;
	
	/**
	 * permissionResourceReadDao
	 */
	@Autowired
	private PermissionResourceReadDao permissionResourceReadDao;
	
	/**
	 * permissionPermissionWriteDao
	 */
	@Autowired
	private PermissionPermissionWriteDao permissionPermissionWriteDao;
	
	/**
	 * permissionOperationReadDao
	 */
	@Autowired
	private PermissionOperationReadDao permissionOperationReadDao;
	
	/**
	 * permissionAppReadDao
	 */
	@Autowired
	private PermissionAppReadDao permissionAppReadDao;
	
	
	/**
	 * 获取分页菜单
	 * @param menu 菜单参数
	 * @return 菜单集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	public Map<String, Object> pageMenu(PermissionMenuParam menu) {
		Assert.notNull(permissionMenuReadDao, "Property 'permissionMenuReadDao' is required.");
		if( menu.getPageStart() == null || menu.getPageEnd() == null || menu.getDraw() == null ) 
			throw new BusinessException("分页信息不能为空");
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> pageLsit = permissionMenuReadDao.getPageList(menu);
		Integer recordsTotal = permissionMenuReadDao.getPageTotal(menu);
		
		map.put("draw", menu.getDraw());
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}

	/**
	 * 在同一父菜单下，检查菜单名称是否重复
	 * @param menu 菜单信息
	 * @return True——重复
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	public Boolean checkExistMenuName(PermissionMenuParam menu) {
		Assert.notNull(permissionMenuReadDao, "Property 'permissionMenuReadDao' is required.");
		if( menu == null ) throw new BusinessException("菜单信息不能为空");
		
		Integer result = permissionMenuReadDao.checkExistMenuName(menu);
		if( result >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 新增菜单
	 * @param  menu 菜单信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	public void addMenu(PermissionMenuParam menu) {
		Assert.notNull(permissionMenuReadDao, "Property 'permissionMenuReadDao' is required.");
		Assert.notNull(permissionMenuWriteDao, "Property 'permissionMenuWriteDao' is required.");
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		Assert.notNull(permissionPermissionWriteDao, "Property 'permissionPermissionWriteDao' is required.");
		Assert.notNull(transactionManagerMember, "Property 'transactionManagerMember' is required.");
		if( menu == null ) throw new BusinessException("菜单信息不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			/**
			 * 存储新增的菜单,并返回该应用系统ID
			 */
			permissionMenuWriteDao.addMenu(menu);
			
			/**
			 * 存储该菜单资源,并返回该资源ID
			 */
			PermissionResourceParam resource = new PermissionResourceParam();
			resource.setSelfID(menu.getMenuID());
			resource.setSelfType("SYS_MENU");
			resource.setParentID(menu.getParentID());
			resource.setParentType(menu.getParentType());
			permissionResourceWriteDao.addResource(resource);
			
			String[] operationIDs = menu.getOperationIDs().split(",");
			for( String operationID : operationIDs ){
				/**
				 * 存储可用的操作
				 */
				permissionPermissionWriteDao.addPermission(operationID, resource.getResourceID());
			}
			
			/**
			 * 事务提交
			 */
			transactionManagerMember.commit(status);
		}catch( Exception e ){
			logger.error("异常发生在"+this.getClass().getName()+"类的addMenu方法，异常原因是："+e.getMessage(), e.fillInStackTrace());
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("新增菜单失败!");
		}
		
	}

	/**
	 * 根据菜单ID获取菜单信息
	 * @param menuID menuID
	 * @return 应用系统信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	public PermissionMenuParam getMenuByID(Integer menuID) {
		Assert.notNull(permissionMenuReadDao, "Property 'permissionMenuReadDao' is required.");
		if( menuID == null ) throw new BusinessException("应用系统ID不能为空");
		
		/**
		 * 获取自己的信息
		 */
		PermissionMenuParam menu = permissionMenuReadDao.getMenu(menuID);
		
		/**
		 * 获取父资源信息
		 */
		PermissionResourceEntity resource = permissionResourceReadDao.getResourceByMenuID(menuID);

		/**
		 * 获取上级信息
		 */
		if( resource.getParentType().equals("SYS_MENU") ){	//上级是菜单
			PermissionResourceParam resourceParent = permissionResourceReadDao.getResourceByID(resource.getParentID());
			PermissionMenuParam menuParent = permissionMenuReadDao.getMenu(resourceParent.getSelfID());
			menu.setParentName(menuParent.getMenuName());
		} else {	//上级是应用系统
			PermissionAppParam menuParent = permissionAppReadDao.getApp(resource.getParentID());
			menu.setParentName(menuParent.getAppName());
		}
		menu.setParentID(resource.getParentID());
		menu.setParentType(resource.getParentType());
		menu.setResourceID(resource.getResourceID());
		
		/**
		 * 获取可操作信息
		 */
		Map<String, String> map = permissionOperationReadDao.getOperationStringArgsByResourceID(resource.getResourceID());
		if( ! map.isEmpty() ){
			String operationIDs = map.get("operationIDs");
			String operationNames = map.get("operationNames");
			menu.setOperationIDs(operationIDs);
			menu.setOperationNames(operationNames);
		}
		
		return menu;
	}

	/**
	 * 删除menu
	 * @param menuID menuID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	public Boolean deleteMenuByID(Integer menuID) {
		Assert.notNull(permissionMenuWriteDao, "Property 'permissionMenuWriteDao' is required.");
		if( menuID == null ) throw new BusinessException("menuID不能为空");
		
		Integer deleteResult = permissionMenuWriteDao.deleteMenuByID(menuID);
		if( deleteResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 通过资源ID获取菜单信息
	 * @param menuID menuID
	 * @return 应用系统信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	public PermissionMenuParam getMenuByResourceID(Integer resourceID) {
		Assert.notNull(permissionMenuReadDao, "Property 'permissionMenuReadDao' is required.");
		if( resourceID == null ) throw new BusinessException("resourceID不能为空");
		
		PermissionResourceParam resourceParent = permissionResourceReadDao.getResourceByID(resourceID);
		PermissionMenuParam menuParent = permissionMenuReadDao.getMenu(resourceParent.getSelfID());
		return menuParent;
	}

	/**
	 * 修改菜单
	 * @param menu 菜单信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.22
	 */
	public void updateMenu(PermissionMenuParam menu) {
		Assert.notNull(permissionMenuReadDao, "Property 'permissionMenuReadDao' is required.");
		Assert.notNull(permissionMenuWriteDao, "Property 'permissionMenuWriteDao' is required.");
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		Assert.notNull(permissionPermissionWriteDao, "Property 'permissionPermissionWriteDao' is required.");
		Assert.notNull(transactionManagerMember, "Property 'transactionManagerMember' is required.");
		if( menu == null ) throw new BusinessException("菜单信息不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			/**
			 * 根据menuID获取该菜单资源
			 */
			PermissionResourceEntity resource = permissionResourceReadDao.getResourceByMenuID(menu.getMenuID());
			
			/**
			 * 删除所有该资源绑定的操作权限
			 */
			permissionPermissionWriteDao.deletePermissionByResourceID(resource.getResourceID());
			
			/**
			 * 根据新的操作权限，重新新增
			 */
			String[] operationIDs = menu.getOperationIDs().split(",");
			for( String operationID : operationIDs ){
				/**
				 * 存储可用的操作
				 */
				permissionPermissionWriteDao.addPermission(operationID, resource.getResourceID());
			}
			
			/**
			 * 更新菜单基本信息
			 */
			permissionMenuWriteDao.updateMenu(menu);
			
			/**
			 * 事务提交
			 */
			transactionManagerMember.commit(status);
		}catch( Exception e ){
			logger.error("异常发生在"+this.getClass().getName()+"类的updateMenu方法，异常原因是："+e.getMessage(), e.fillInStackTrace());
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("修改菜单失败!");
		}
	}

}
