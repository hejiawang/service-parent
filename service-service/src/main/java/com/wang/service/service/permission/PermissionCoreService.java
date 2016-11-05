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

	/**
	 * 初始化当前登录者所在系统的菜单列表
	 * @param currentUserID 当前登陆者ID
	 * @param changeApp 所选择的APP信息
	 * @return 菜单列表HTML
	 * @author HeJiawang
	 * @date   2016.11.05
	 */
	ServiceResult<String> changeMenu(PermissionUserInfoEntity userCurrent, PermissionAppParam changeApp);

	/**
	 * 根据当前登录者所选择的菜单获取有使用权限的页面元素
	 * @param currentUserID 当前登陆者ID
	 * @param menuID 菜单ID
	 * @return 菜单列表HTML
	 * @author HeJiawang
	 * @date   2016.11.05
	 */
	ServiceResult<String> getElementFromMenuByUserID(Integer currentUserID, Integer menuID);

}
