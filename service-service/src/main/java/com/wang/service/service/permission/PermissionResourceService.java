package com.wang.service.service.permission;

import java.util.List;

import com.wang.core.ServiceResult;
import com.wang.service.entity.permission.PermissionResourceEntity;
import com.wang.service.param.permission.PermissionResourceParam;

/**
 * 资源service
 * @author HeJiawang
 * @date   2016.10.17
 */
public interface PermissionResourceService {

	/**
	 * 根据应用系统ID获取对对应的资源
	 * @param appID 应用系统ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	ServiceResult<PermissionResourceEntity> getResourceByAppID(Integer appID);

	/**
	 * 根据菜单ID获取对对应的资源
	 * @param menuID 菜单ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	ServiceResult<PermissionResourceEntity> getResourceByMenuID(Integer menuID);
	
	/**
	 * 根据资源ID获取资源信息
	 * @param resourceID 资源ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	ServiceResult<PermissionResourceParam> getResourceByID(Integer resourceID);

	/**
	 * 获取所有应用系统对应的资源信息
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	ServiceResult<List<PermissionResourceParam>> getResourceForApp();

	/**
	 * 根据父ID(资源父ID)获取菜单资源信息
	 * @param parentID 资源父ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	ServiceResult<List<PermissionResourceParam>> getResourceForMenu(Integer parentID);
	
	/**
	 * 根据父ID(资源父ID)获取页面元素资源信息
	 * @param parentID 资源父ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.26
	 */
	ServiceResult<List<PermissionResourceParam>> getResourceForElement(Integer parentID);

}
