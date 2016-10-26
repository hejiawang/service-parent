package com.wang.serviceimp.model.permission;

import java.util.List;

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
import com.wang.core.util.MD5;
import com.wang.service.param.permission.PermissionAppParam;
import com.wang.service.param.permission.PermissionUserInfoParam;
import com.wang.serviceimp.dao.permission.read.PermissionAppReadDao;
import com.wang.serviceimp.dao.permission.read.PermissionUserInfoReadDao;
import com.wang.serviceimp.dao.permission.write.PermissionUserInfoWriteDao;

/**
 * 用户信息 model
 * 
 * @author HeJiawang
 * @date   2016.10.25
 */
@Service
public class PermissionUserInfoModel {
	
	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionUserInfoModel.class);
	
	/**
	 * permissionUserInfoReadDao
	 */
	@Autowired
	private PermissionUserInfoReadDao permissionUserInfoReadDao;
	
	/**
	 * permissionUserInfoWriteDao
	 */
	@Autowired
	private PermissionUserInfoWriteDao permissionUserInfoWriteDao;
	
	/**
	 * permissionAppReadDao
	 */
	@Autowired
	private PermissionAppReadDao permissionAppReadDao;
	
	/**
	 * 事务
	 */
	@Autowired
	private DataSourceTransactionManager transactionManagerMember;
	
	/**
	 * 检查用户登录名时候重复
	 * @param userInfo 用户信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	public Boolean checkExistUserLoginName(PermissionUserInfoParam userInfo) {
		Assert.notNull(permissionUserInfoReadDao, "Property 'permissionUserInfoReadDao' is required.");
		if( userInfo == null ) throw new BusinessException("用户信息不能为空");
		
		Integer result = permissionUserInfoReadDao.checkExistUserLoginName(userInfo);
		if( result >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 新增用户信息
	 * @param userInfo 用户信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	public void addUserInfo(PermissionUserInfoParam userInfo) {
		Assert.notNull(permissionUserInfoWriteDao, "Property 'permissionUserInfoWriteDao' is required.");
		if( userInfo == null ) throw new BusinessException("用户信息不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			/**
			 * 存储用户基本信息,并在实体中返回用户ID
			 */
			userInfo.setPassWord(MD5.getInstrance().getMD5String4(userInfo.getPassWord()));
			permissionUserInfoWriteDao.addUserInfo(userInfo);
			Integer userID = userInfo.getUserID();
			
			/**
			 * 向用户机构关联表中插入数据
			 */
			permissionUserInfoWriteDao.addUserOrg(userID, userInfo.getOrgID());
			
			/**
			 * 向用户岗位关联表中插入数据
			 */
			String postIDs[] = userInfo.getPostIDs().split(",");
			for( String postID : postIDs ){
				permissionUserInfoWriteDao.addUserPost(userID, postID);
			}
			
			/**
			 * 向用户职级关联表中插入数据
			 */
			String rankIDs[] = userInfo.getRankIDs().split(",");
			for( String rankID : rankIDs ){
				permissionUserInfoWriteDao.addUserRank(userID, rankID);
			}
			
			/**
			 * 向用户角色关联表中插入数据
			 */
			String roleIDs[] = userInfo.getRoleIDs().split(",");
			for( String roleID : roleIDs ){
				permissionUserInfoWriteDao.addUserRole(userID, roleID);
			}
			
			//给用户设置默认的访问系统
			/**
			 * 根据角色ID集合，获取这些角色有哪些app的权限
			 */
			List<PermissionAppParam> appList = permissionAppReadDao.getAppByRoleIDs(userInfo.getRoleIDs());
			if( appList.size() > 0 )
				permissionUserInfoWriteDao.addUserApp(userID, appList.get(0).getAppID(), appList.get(0).getAppTypeID());
			
			/**
			 * 事务提交
			 */
			transactionManagerMember.commit(status);
		} catch ( Exception e ){
			logger.error("异常发生在"+this.getClass().getName()+"类的addUserInfo方法，异常原因是："+e.getMessage(), e.fillInStackTrace());
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("新增用户失败!");
		}
	}

	/**
	 * 根据用户ID获取该用户角色ID集合
	 * @param userID 用户ID
	 * @return 角色ID集合
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	public List<Integer> getRoleIDListByUserID(Integer userID) {
		Assert.notNull(permissionUserInfoReadDao, "Property 'permissionUserInfoReadDao' is required.");
		if( userID == null ) throw new BusinessException("用户ID不能为空");
		return permissionUserInfoReadDao.getRoleIDListByUserID(userID);
	}

}
