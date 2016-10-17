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
import com.wang.service.param.permission.PermissionAppParam;
import com.wang.serviceimp.dao.permission.read.PermissionAppReadDao;
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
	 * permissionPermissionWriteDao
	 */
	@Autowired
	private PermissionPermissionWriteDao permissionPermissionWriteDao;
	
	/**
	 * 获取分页应用系统
	 * @param app 应用系统参数
	 * @return 应用系统集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	public Map<String, Object> pageApp(PermissionAppParam app) {
		Assert.notNull(permissionAppReadDao, "Property 'permissionAppReadDao' is required.");
		if( app.getPageSize() == null || app.getPageNumber() == null || app.getDraw() == null ) 
			throw new BusinessException("分页信息不能为空");
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> pageLsit = permissionAppReadDao.getPageList(app);
		Integer recordsTotal = pageLsit.size();
		
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
		if( app == null ) throw new BusinessException("系统不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			/**
			 * 存储新增的应用系统,并返回该应用系统ID
			 */
			Integer appID = permissionAppWriteDao.addApp(app);
			/**
			 * 存储该应用系统资源,并返回该资源ID
			 */
			Integer resourceID = permissionResourceWriteDao.addAppResource(appID);
			
			String[] operationIDs = app.getOperationIDs().split(",");
			for( String operationID : operationIDs ){
				/**
				 * 存储可用的操作
				 */
				permissionPermissionWriteDao.addPermission(operationID, resourceID);
			}
			
			/**
			 * 事务提交
			 */
			transactionManagerMember.commit(status);
		}catch( Exception e ){
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("新增应用系统失败!");
		}
		
	}
	
}
