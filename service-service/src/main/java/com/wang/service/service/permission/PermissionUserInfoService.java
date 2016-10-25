package com.wang.service.service.permission;

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

}
