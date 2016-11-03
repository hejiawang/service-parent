package com.wang.service.service.permission;

import java.util.List;
import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.service.param.permission.PermissionUserInfoParam;

/**
 * 用户信息service
 * @author HeJiawang
 * @date   2016.10.25
 */
public interface PermissionUserInfoService {

	/**
	 * 根据当前登录的用户角色,获取分页用户信息
	 * @param userInfo 用户信息
	 * @param start 分页——起始条数
	 * @param length 分页——条数
	 * @return 分页数据
	 */
	ServiceResult<Map<String, Object>> pageUserInfo(PermissionUserInfoParam userInfo, Integer currentUserID);

	/**
	 * 新增用户信息
	 * @param userInfo 用户信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	ServiceResult<Void> addUserInfo(PermissionUserInfoParam userInfo);

	/**
	 * 根据用户ID获取该用户角色ID集合
	 * @param userID 用户ID
	 * @return 角色ID集合
	 * @author HeJiawang
	 * @date   2016.10.25
	 */
	ServiceResult<List<Integer>> getRoleIDListByUserID(Integer userID);

	/**
	 * 删除用户
	 * @param userID 用户ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	ServiceResult<Void> deleteUserByID(Integer userID);

	/**
	 * 查看用户信息
	 * @param userInfoID 用户ID
	 * @return 用户信息
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	ServiceResult<PermissionUserInfoParam> getUserInfoByID(Integer userID);

	/**
	 * 修改用户信息
	 * @param userInfo 用户信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.03
	 */
	ServiceResult<Void> updateUserInfo(PermissionUserInfoParam userInfo);

}
