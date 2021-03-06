package com.wang.serviceimp.dao.permission.read;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.entity.permission.PermissionResourceEntity;
import com.wang.service.param.permission.PermissionResourceParam;

/**
 * 
 * 资源read dao
 * 
 * @author HeJiawang
 * @date   2016.10.17
 *
 */
@MyBatisRepository
public interface PermissionResourceReadDao {

	/**
	 * 根据应用系统ID获取对对应的资源
	 * @param selfID 应用系统ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	PermissionResourceEntity getResourceByAppID(@Param("selfID")Integer selfID);

	/**
	 * 根据菜单ID获取对对应的资源
	 * @param menuID 菜单ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	PermissionResourceEntity getResourceByMenuID(@Param("selfID")Integer selfID);

	/**
	 * 根据页面元素ID获取对对应的资源
	 * @param elementID 页面元素ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	PermissionResourceEntity getResourceByElementID(@Param("selfID")Integer elementID);

	/**
	 * 根据资源ID获取资源信息
	 * @param resourceID 资源ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	PermissionResourceParam getResourceByID( @Param("resourceID") Integer resourceID);

	/**
	 * 获取所有应用系统对应的资源信息
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	List<PermissionResourceParam> getResourceForApp();

	/**
	 * 根据父ID(资源父ID)获取菜单资源信息
	 * @param parentID 资源父ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	List<PermissionResourceParam> getResourceForMenu( @Param("parentID") Integer parentID);

	/**
	 * 根据父ID(资源父ID)获取页面元素资源信息
	 * @param parentID 资源父ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.26
	 */
	List<PermissionResourceParam> getResourceForElement( @Param("parentID") Integer parentID);

	/**
	 * 根据父ID(资源父ID)获取菜单资源信息<br>
	 * 菜单下有页面元素信息时，为父资源
	 * @param parentID 资源父ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.26
	 */
	List<PermissionResourceParam> getResourceForMenuElement( @Param("parentID") Integer parentID);

	/**
	 * 根据登陆者的角色,列出该角色权限允许授权的APP信息
	 * @param userID 登陆者ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	List<PermissionResourceParam> getResourceForAppByUserID(@Param("userID")Integer userID);

	/**
	 * 根据登陆者的角色列出该角色权限允许授权的菜单信息
	 * @param userID 登陆者ID
	 * @param parentID 资源父ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	List<PermissionResourceParam> getResourceForMenuElementByUserID(@Param("userID")Integer userID,
			@Param("parentID") Integer parentID);

	/**
	 * 根据登陆者的角色列出该角色权限允许授权的页面元素信息
	 * @param userID 登陆者ID
	 * @param parentID 资源父ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	List<PermissionResourceParam> getResourceForElementByUserID(@Param("userID")Integer userID,
			@Param("parentID") Integer parentID);
	
}
