package com.wang.service.service.permission;

import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.service.param.permission.PermissionMenuParam;

/**
 * 菜单service
 * @author HeJiawang
 * @date   2016.10.18
 */
public interface PermissionMenuService {

	/**
	 * 获取分页菜单
	 * @param menu 菜单参数
	 * @return 菜单集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	ServiceResult<Map<String,Object>> pageMenu(PermissionMenuParam menu);

	/**
	 * 新增菜单
	 * @param  menu 菜单信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	ServiceResult<Void> addMenu(PermissionMenuParam menu);

	/**
	 * 根据菜单ID获取菜单信息
	 * @param menuID menuID
	 * @return 应用系统信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	ServiceResult<PermissionMenuParam> getMenuByID(Integer menuID);

	/**
	 * 删除menu
	 * @param menuID menuID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	ServiceResult<Void> deleteMenuByID(Integer menuID);

	/**
	 * 通过资源ID获取菜单信息
	 * @param menuID menuID
	 * @return 应用系统信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	ServiceResult<PermissionMenuParam> getMenuByResourceID(Integer resourceID);

}
