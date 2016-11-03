package com.wang.serviceimp.model.permission;

import java.util.ArrayList;
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
import com.wang.core.util.MD5;
import com.wang.core.util.WebConstants;
import com.wang.service.param.permission.PermissionAppParam;
import com.wang.service.param.permission.PermissionOrgParam;
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
	 * permissionOrgModel
	 */
	private PermissionOrgModel permissionOrgModel;
	
	/**
	 * 根据当前登录的用户角色,获取分页用户信息
	 * @param userInfo 用户信息
	 * @param start 分页——起始条数
	 * @param length 分页——条数
	 * @return 分页数据
	 */
	public Map<String, Object> pageUserInfo(PermissionUserInfoParam userInfo, Integer currentUserID) {
		Assert.notNull(permissionUserInfoReadDao, "Property 'permissionUserInfoReadDao' is required.");
		if( userInfo.getPageStart() == null || userInfo.getPageEnd() == null || userInfo.getDraw() == null ) 
			throw new BusinessException("分页信息不能为空");
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> pageLsit = new ArrayList<Map<String,Object>>();
		Integer recordsTotal = 0;
		
		/**
		 * 获取当前登录用户角色ID集合
		 */
		List<Integer> roleIDList = permissionUserInfoReadDao.getRoleIDListByUserID(currentUserID);
		if(roleIDList.contains(WebConstants.permissionAdminID)){ //当前登录账号为系统超级管理员,列出所有用户信息
			
			pageLsit = permissionUserInfoReadDao.getPageList(userInfo);
			recordsTotal = permissionUserInfoReadDao.getPageTotal(userInfo);
		} else { //获取当前登录账号所属部门下的所有用户信息
			
			Integer orgID = permissionUserInfoReadDao.getOrgIDByUserID(currentUserID);
			List<PermissionOrgParam> orgList = permissionOrgModel.getChildrenOrgByOrgID(orgID);
			
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userInfo", userInfo);
			paramMap.put("org", orgList);
			
			pageLsit = permissionUserInfoReadDao.getPagePartList(paramMap);
			recordsTotal = permissionUserInfoReadDao.getPagePartTotal(paramMap);
		}
		
		map.put("draw", userInfo.getDraw());
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}
	
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

	/**
	 * 删除用户
	 * @param userID 用户ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	public Boolean deleteUserByID(Integer userID) {
		Assert.notNull(permissionUserInfoReadDao, "Property 'permissionUserInfoReadDao' is required.");
		if( userID == null ) throw new BusinessException("用户ID不能为空");
		
		Integer deleteResult = permissionUserInfoWriteDao.deleteUserByID(userID);
		if( deleteResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 查看用户信息
	 * @param userInfoID 用户ID
	 * @return 用户信息
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	public PermissionUserInfoParam getUserInfoByID(Integer userID) {
		Assert.notNull(permissionUserInfoReadDao, "Property 'permissionUserInfoReadDao' is required.");
		if( userID == null ) throw new BusinessException("用户ID不能为空");
		
		return permissionUserInfoReadDao.getUserInfoByID(userID);
	}

	/**
	 * 修改用户信息
	 * @param userInfo 用户信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	public void updateUserInfo(PermissionUserInfoParam userInfo) {
		Assert.notNull(permissionUserInfoWriteDao, "Property 'permissionUserInfoWriteDao' is required.");
		if( userInfo == null ) throw new BusinessException("用户信息不能为空");
		
		//开始事务
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = transactionManagerMember.getTransaction(def);
		try {
			Integer userID = userInfo.getUserID();
			
			/**
			 * 用户-机构、岗位、角色、职级关联表清空
			 */
			permissionUserInfoWriteDao.deleteUserRole(userID);
			permissionUserInfoWriteDao.deleteUserPost(userID);
			permissionUserInfoWriteDao.deleteUserRank(userID);
			permissionUserInfoWriteDao.deleteUserOrg(userID);
			
			/**
			 * 修改用户基本信息
			 */
			userInfo.setPassWord(MD5.getInstrance().getMD5String4(userInfo.getPassWord()));
			permissionUserInfoWriteDao.updateUserInfo(userInfo);
			
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
			
			/**
			 * 事务提交
			 */
			transactionManagerMember.commit(status);
		} catch ( Exception e ){
			logger.error("异常发生在"+this.getClass().getName()+"类的updateUserInfo方法，异常原因是："+e.getMessage(), e.fillInStackTrace());
			/**
			 * 事务回滚
			 */
			transactionManagerMember.rollback(status);
			throw new BusinessException("修改用户失败!");
		}
	}

}
