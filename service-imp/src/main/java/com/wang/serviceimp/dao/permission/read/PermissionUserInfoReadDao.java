package com.wang.serviceimp.dao.permission.read;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionUserInfoParam;

/**
 * 
 * 用户信息read dao
 * 
 * @author HeJiawang
 * @date   2016.10.25
 *
 */
@MyBatisRepository
public interface PermissionUserInfoReadDao {

	/**
	 * 检查用户登录名时候重复
	 * @param userInfo 用户信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	Integer checkExistUserLoginName(PermissionUserInfoParam userInfo);

}
