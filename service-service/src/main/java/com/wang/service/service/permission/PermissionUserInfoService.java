package com.wang.service.service.permission;

import java.util.List;

import com.wang.core.ServiceResult;
import com.wang.service.param.permission.PermissionUserInfoParam;

/**
 * 用户信息service
 * @author HeJiawang
 * @date   2016.10.25
 */
public interface PermissionUserInfoService {

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

}
