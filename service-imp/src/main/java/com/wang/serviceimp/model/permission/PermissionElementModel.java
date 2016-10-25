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
import com.wang.service.param.permission.PermissionElementParam;
import com.wang.service.param.permission.PermissionMenuParam;
import com.wang.service.param.permission.PermissionResourceParam;
import com.wang.serviceimp.dao.permission.read.PermissionElementReadDao;
import com.wang.serviceimp.dao.permission.read.PermissionMenuReadDao;
import com.wang.serviceimp.dao.permission.read.PermissionOperationReadDao;
import com.wang.serviceimp.dao.permission.read.PermissionResourceReadDao;
import com.wang.serviceimp.dao.permission.write.PermissionElementWriteDao;
import com.wang.serviceimp.dao.permission.write.PermissionPermissionWriteDao;
import com.wang.serviceimp.dao.permission.write.PermissionResourceWriteDao;

/**
 * 页面元素service imp
 * @author HeJiawang
 * @date   2016.10.24
 */
@Service
public class PermissionElementModel {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionElementModel.class);

	/**
	 * 事务
	 */
	@Autowired
	private DataSourceTransactionManager transactionManagerMember;
	
	/**
	 * permissionElementReadDao
	 */
	@Autowired
	private PermissionElementReadDao permissionElementReadDao;
	
	/**
	 * permissionElementWriteDao
	 */
	@Autowired
	private PermissionElementWriteDao permissionElementWriteDao;
	
	/**
	 * permissionResourceReadDao
	 */
	@Autowired
	private PermissionResourceReadDao permissionResourceReadDao;
	
	/**
	 * permissionOperationReadDao
	 */
	@Autowired
	private PermissionOperationReadDao permissionOperationReadDao;
	
	/**
	 * permissionMenuReadDao
	 */
	@Autowired
	private PermissionMenuReadDao permissionMenuReadDao;
	
	/**
	 * permissionResourceWriteDao
	 */
	@Autowired
	private PermissionResourceWriteDao permissionResourceWriteDao;
	
	/**
	 * permissionPermissionWriteDao
	 */
	@Autowired
	private PermissionPermissionWriteDao permissionPermissionWriteDao;

	/**
	 * 获取分页页面元素
	 * @param element 页面元素参数
	 * @return 页面元素集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	public Map<String, Object> pageElement(PermissionElementParam element) {
		Assert.notNull(permissionElementReadDao, "Property 'permissionElementReadDao' is required.");
		if( element.getPageStart() == null || element.getPageEnd() == null || element.getDraw() == null ) 
			throw new BusinessException("分页信息不能为空");
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> pageLsit = permissionElementReadDao.getPageList(element);
		Integer recordsTotal = permissionElementReadDao.getPageTotal(element);
		
		map.put("draw", element.getDraw());
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}

	/**
	 * 在同一父菜单下，检查名称是否重复
	 * @param  element 页面元素信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	public Boolean checkExistElementName(PermissionElementParam element) {
		Assert.notNull(permissionElementReadDao, "Property 'permissionMenuReadDao' is required.");
		if( element == null ) throw new BusinessException("页面元素信息不能为空");
		
		Integer result = permissionElementReadDao.checkExistElementName(element);
		if( result >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 新增页面元素
	 * @param  element 页面元素信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	public void addElement(PermissionElementParam element) {
		Assert.notNull(permissionElementWriteDao, "Property 'permissionElementWriteDao' is required.");
		if( element == null ) throw new BusinessException("页面元素信息不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			/**
			 * 存储新增的页面元素信息,并返回该页面元素ID
			 */
			permissionElementWriteDao.addElement(element);
			
			/**
			 * 存储该页面元素资源,并返回该资源ID
			 */
			PermissionResourceParam resource = new PermissionResourceParam();
			resource.setSelfID(element.getElementID());
			resource.setSelfType("SYS_ELEMENT");
			resource.setParentID(element.getParentID());
			resource.setParentType("SYS_MENU");
			permissionResourceWriteDao.addResource(resource);
			
			String[] operationIDs = element.getOperationIDs().split(",");
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
			logger.error("异常发生在"+this.getClass().getName()+"类的addElement方法，异常原因是："+e.getMessage(), e.fillInStackTrace());
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("新增页面元素失败!");
		}
		
	}

	/**
	 * 获取页面元素信息
	 * @param elementID elementID
	 * @return 信息
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	public PermissionElementParam getElementByID(Integer elementID) {
		Assert.notNull(permissionElementReadDao, "Property 'permissionElementReadDao' is required.");
		if( elementID == null ) throw new BusinessException("elementID不能为空");
		
		/**
		 * 获取自己的信息
		 */
		PermissionElementParam element = permissionElementReadDao.getElementByID(elementID);
		
		/**
		 * 获取资源信息
		 */
		PermissionResourceEntity resource = permissionResourceReadDao.getResourceByElementID(elementID);
		element.setResourceID(resource.getResourceID());
		
		/**
		 * 根据资源信息获取所属菜单信息
		 */
		PermissionResourceParam resourceParent = permissionResourceReadDao.getResourceByID(resource.getParentID());
		PermissionMenuParam menuParent = permissionMenuReadDao.getMenu(resourceParent.getSelfID());
		element.setParentID(menuParent.getParentID());
		element.setParentName(menuParent.getMenuName());
		
		/**
		 * 获取可操作信息
		 */
		Map<String, String> map = permissionOperationReadDao.getOperationStringArgsByResourceID(resource.getResourceID());
		if( ! map.isEmpty() ){
			String operationIDs = map.get("operationIDs");
			String operationNames = map.get("operationNames");
			element.setOperationIDs(operationIDs);
			element.setOperationNames(operationNames);
		}
		
		return element;
	}

	/**
	 * 删除页面元素
	 * @param elementID elementID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	public Boolean deleteElementByID(Integer elementID) {
		Assert.notNull(permissionElementWriteDao, "Property 'permissionElementWriteDao' is required.");
		if( elementID == null ) throw new BusinessException("elementID不能为空");
		
		Integer deleteResult = permissionElementWriteDao.deleteElementByID(elementID);
		if( deleteResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 修改页面元素
	 * @param element 页面元素信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	public void updateElement(PermissionElementParam element) {
		Assert.notNull(permissionElementWriteDao, "Property 'permissionElementWriteDao' is required.");
		if( element == null ) throw new BusinessException("页面元素信息不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			/**
			 * 根据elementID获取该菜单资源
			 */
			PermissionResourceEntity resource = permissionResourceReadDao.getResourceByElementID(element.getElementID());
			
			/**
			 * 删除所有该资源绑定的操作权限
			 */
			permissionPermissionWriteDao.deletePermissionByResourceID(resource.getResourceID());
			
			/**
			 * 根据新的操作权限，重新新增
			 */
			String[] operationIDs = element.getOperationIDs().split(",");
			for( String operationID : operationIDs ){
				/**
				 * 存储可用的操作
				 */
				permissionPermissionWriteDao.addPermission(operationID, resource.getResourceID());
			}
			
			/**
			 * 更新菜单基本信息
			 */
			permissionElementWriteDao.updateElement(element);
			
			/**
			 * 事务提交
			 */
			transactionManagerMember.commit(status);
		}catch( Exception e ){
			logger.error("异常发生在"+this.getClass().getName()+"类的updateElement方法，异常原因是："+e.getMessage(), e.fillInStackTrace());
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("修改页面元素失败!");
		}
	}
	
}
