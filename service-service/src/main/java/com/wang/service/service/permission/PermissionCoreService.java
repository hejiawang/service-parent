package com.wang.service.service.permission;

import com.wang.core.ServiceResult;
import com.wang.service.entity.permission.PermissionUserInfoEntity;
import com.wang.service.param.permission.PermissionAppParam;

/**
 * 菜单、页面元素权限 service
 * 
 * @author HeJiawang
 * @date   2016.11.04
 */
public interface PermissionCoreService {

	/**
	 * 初始化当前登录者的APP列表
	 * @param currentUserID 当前登陆者ID
	 * @param changeApp 所选择的APP信息
	 * @return APP列表HTML
	 * @author HeJiawang
	 * @date   2016.11.04
	 */
	ServiceResult<String> changeApp(PermissionUserInfoEntity userCurrent, PermissionAppParam changeApp);

}
