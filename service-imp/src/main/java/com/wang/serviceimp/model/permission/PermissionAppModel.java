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
import com.wang.service.param.permission.PermissionResourceParam;
import com.wang.serviceimp.dao.permission.read.PermissionAppReadDao;
import com.wang.serviceimp.dao.permission.read.PermissionOperationReadDao;
import com.wang.serviceimp.dao.permission.read.PermissionResourceReadDao;
import com.wang.serviceimp.dao.permission.write.PermissionAppWriteDao;
import com.wang.serviceimp.dao.permission.write.PermissionPermissionWriteDao;
import com.wang.serviceimp.dao.permission.write.PermissionResourceWriteDao;

/**
 * 应用系统 model
 * 
 * @author HeJiawang
 * @date   2016.10.17
 */
@Service
public class PermissionAppModel {

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
	 * permissionAppReadDao
	 */
	@Autowired
	private PermissionAppReadDao permissionAppReadDao;
	
	/**
	 * permissionAppWriteDao
	 */
	@Autowired
	private PermissionAppWriteDao permissionAppWriteDao;
	
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
	 * 获取分页应用系统
	 * @param app 应用系统参数
	 * @return 应用系统集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	public Map<String, Object> pageApp(PermissionAppParam app) {
		Assert.notNull(permissionAppReadDao, "Property 'permissionAppReadDao' is required.");
		if( app.getPageStart() == null || app.getPageEnd() == null || app.getDraw() == null ) 
			throw new BusinessException("分页信息不能为空");
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> pageLsit = permissionAppReadDao.getPageList(app);
		Integer recordsTotal = permissionAppReadDao.getPageTotal(app);
		
		map.put("draw", app.getDraw());
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}

	/**
	 * 检查系统名称是否重复
	 * @param app 应用系统信息
	 * @return True	重复
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	public Boolean checkExistAppName(PermissionAppParam app) {
		Assert.notNull(permissionAppReadDao, "Property 'permissionAppReadDao' is required.");
		if( app == null ) throw new BusinessException("系统不能为空");
		
		Integer result = permissionAppReadDao.checkExistAppName(app);
		if( result >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 新增应用系统
	 * 
	 * @param app 应用系统信息
	 * @return ServiceResult
	 * 
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	public void addApp(PermissionAppParam app) {
		Assert.notNull(permissionAppReadDao, "Property 'permissionAppReadDao' is required.");
		Assert.notNull(permissionAppWriteDao, "Property 'permissionAppWriteDao' is required.");
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		Assert.notNull(permissionPermissionWriteDao, "Property 'permissionPermissionWriteDao' is required.");
		Assert.notNull(transactionManagerMember, "Property 'transactionManagerMember' is required.");
		if( app == null ) throw new BusinessException("系统不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			/**
			 * 存储新增的应用系统,并返回该应用系统ID
			 */
			permissionAppWriteDao.addApp(app);
			
			/**
			 * 存储该应用系统资源,并返回该资源ID
			 */
			PermissionResourceParam resource = new PermissionResourceParam();
			resource.setSelfID(app.getAppID());
			resource.setSelfType("SYS_APP");
			resource.setParentID(0);
			resource.setParentType("SYS_APP");
			permissionResourceWriteDao.addResource(resource);
			
			String[] operationIDs = app.getOperationIDs().split(",");
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
			logger.error("异常发生在"+this.getClass().getName()+"类的addApp方法，异常原因是："+e.getMessage(), e.fillInStackTrace());
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("新增应用系统失败!");
		}
		
	}

	/**
	 * 修改应用系统
	 * @param app 应用系统信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	public void updateApp(PermissionAppParam app) {
		Assert.notNull(permissionAppReadDao, "Property 'permissionAppReadDao' is required.");
		Assert.notNull(permissionAppWriteDao, "Property 'permissionAppWriteDao' is required.");
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		Assert.notNull(permissionPermissionWriteDao, "Property 'permissionPermissionWriteDao' is required.");
		Assert.notNull(transactionManagerMember, "Property 'transactionManagerMember' is required.");
		if( app == null ) throw new BusinessException("系统不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			/**
			 * 根据应用系统ID获取该应用系统资源
			 */
			PermissionResourceEntity resource = permissionResourceReadDao.getResourceByAppID(app.getAppID());
			
			/**
			 * 删除所有该资源绑定的操作权限
			 */
			permissionPermissionWriteDao.deletePermissionByResourceID(resource.getResourceID());
			
			/**
			 * 根据新的操作权限，重新新增
			 */
			String[] operationIDs = app.getOperationIDs().split(",");
			for( String operationID : operationIDs ){
				/**
				 * 存储可用的操作
				 */
				permissionPermissionWriteDao.addPermission(operationID, resource.getResourceID());
			}
			
			/**
			 * 更新应用系统基本信息
			 */
			permissionAppWriteDao.updateApp(app);
			
			/**
			 * 事务提交
			 */
			transactionManagerMember.commit(status);
		}catch( Exception e ){
			logger.error("异常发生在"+this.getClass().getName()+"类的updateApp方法，异常原因是："+e.getMessage(), e.fillInStackTrace());
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("修改应用系统失败!");
		}
	}

	/**
	 * 删除应用系统
	 * @param appID 应用系统ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	public Boolean deleteAppByID(Integer appID) {
		Assert.notNull(permissionAppWriteDao, "Property 'permissionAppWriteDao' is required.");
		if( appID == null ) throw new BusinessException("应用系统ID不能为空");
		
		Integer deleteResult = permissionAppWriteDao.deleteAppByID(appID);
		if( deleteResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 应用系统查看
	 * @param appID 应用系统ID
	 * @return 应用系统信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	public PermissionAppParam getApp(Integer appID) {
		Assert.notNull(permissionAppReadDao, "Property 'permissionAppReadDao' is required.");
		if( appID == null ) throw new BusinessException("应用系统ID不能为空");
		
		PermissionAppParam app = permissionAppReadDao.getApp(appID);
		
		PermissionResourceEntity resource = permissionResourceReadDao.getResourceByAppID(appID);
		Map<String, String> map = permissionOperationReadDao.getOperationStringArgsByResourceID(resource.getResourceID());
		if( ! map.isEmpty() ){
			String operationIDs = map.get("operationIDs");
			String operationNames = map.get("operationNames");
			app.setOperationIDs(operationIDs);
			app.setOperationNames(operationNames);
		}
		
		return app;
	}
	
}
