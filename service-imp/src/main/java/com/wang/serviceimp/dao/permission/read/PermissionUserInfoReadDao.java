package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
	 * 获取分页用户信息
	 * @param userInfo 用户信息
	 * @return 分页数据
	 */
	List<Map<String, Object>> getPageList(PermissionUserInfoParam userInfo);

	/**
	 * 获取用户信息条数
	 * @param userInfo 用户信息
	 * @return 用户信息条数
	 */
	Integer getPageTotal(PermissionUserInfoParam userInfo);
	
	/**
	 * 检查用户登录名时候重复
	 * @param userInfo 用户信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	Integer checkExistUserLoginName(PermissionUserInfoParam userInfo);

	/**
	 * 根据用户ID获取该用户角色ID集合
	 * @param userID 用户ID
	 * @return 角色ID集合
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	List<Integer> getRoleIDListByUserID(@Param("userID")Integer userID);

}
