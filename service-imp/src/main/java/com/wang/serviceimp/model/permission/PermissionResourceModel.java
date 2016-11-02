package com.wang.serviceimp.model.permission;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.service.entity.permission.PermissionResourceEntity;
import com.wang.service.param.permission.PermissionResourceParam;
import com.wang.serviceimp.dao.permission.read.PermissionResourceReadDao;

/**
 * 资源 model
 * 
 * @author HeJiawang
 * @date   2016.10.17
 */
@Service
public class PermissionResourceModel {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionResourceModel.class);

	/**
	 * permissionResourceReadDao
	 */
	@Autowired
	private PermissionResourceReadDao permissionResourceReadDao;
	
	/**
	 * 根据应用系统ID获取对对应的资源
	 * @param appID 应用系统ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	public PermissionResourceEntity getResourceByAppID(Integer appID) {
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		if( appID == null ) throw new BusinessException("应用系统ID不能为空");
		
		return permissionResourceReadDao.getResourceByAppID(appID);
	}

	/**
	 * 根据菜单ID获取对对应的资源
	 * @param menuID 菜单ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	public PermissionResourceEntity getResourceByMenuID(Integer menuID) {
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		if( menuID == null ) throw new BusinessException("菜单ID不能为空");
		
		return permissionResourceReadDao.getResourceByMenuID(menuID);
	}

	/**
	 * 根据资源ID获取资源信息
	 * @param resourceID 资源ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	public PermissionResourceParam getResourceByID(Integer resourceID) {
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		if( resourceID == null ) throw new BusinessException("资源ID不能为空");
		
		return permissionResourceReadDao.getResourceByID(resourceID);
	}

	/**
	 * 获取所有应用系统对应的资源信息
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	public List<PermissionResourceParam> getResourceForApp() {
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		
		return permissionResourceReadDao.getResourceForApp();
	}

	/**
	 * 根据父ID(资源父ID)获取菜单资源信息
	 * @param parentID 资源父ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	public List<PermissionResourceParam> getResourceForMenu(Integer parentID) {
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		if( parentID == null ) throw new BusinessException("资源父ID不能为空");
		
		return permissionResourceReadDao.getResourceForMenu(parentID);
	}

	/**
	 * 根据父ID(资源父ID)获取页面元素资源信息
	 * @param parentID 资源父ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.26
	 */
	public List<PermissionResourceParam> getResourceForElement(Integer parentID) {
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		if( parentID == null ) throw new BusinessException("资源父ID不能为空");
		
		return permissionResourceReadDao.getResourceForElement(parentID);
	}

	/**
	 * 根据父ID(资源父ID)获取菜单资源信息<br>
	 * 菜单下有页面元素信息时，为父资源
	 * @param parentID 资源父ID
	 * @return 资源信息
	 * @author HeJiawang
	 * @date   2016.10.26
	 */
	public List<PermissionResourceParam> getResourceForMenuElement(Integer parentID) {
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		if( parentID == null ) throw new BusinessException("资源父ID不能为空");
		
		return permissionResourceReadDao.getResourceForMenuElement(parentID);
	}

	/**
	 * 根据登陆者的角色,列出该角色权限允许授权的APP信息
	 * @param userID 登陆者ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	public List<PermissionResourceParam> getResourceForAppByUserID(Integer userID) {
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		if( userID == null ) throw new BusinessException("userID不能为空");
		
		return permissionResourceReadDao.getResourceForAppByUserID(userID);
	}

	/**
	 * 根据登陆者的角色列出该角色权限允许授权的菜单信息
	 * @param userID 登陆者ID
	 * @param parentID 资源父ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	public List<PermissionResourceParam> getResourceForMenuElementByUserID(Integer userID, Integer parentID) {
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		if( userID == null ) throw new BusinessException("userID不能为空");
		
		return permissionResourceReadDao.getResourceForMenuElementByUserID(userID, parentID);
	}

	/**
	 * 根据登陆者的角色列出该角色权限允许授权的页面元素信息
	 * @param userID 登陆者ID
	 * @param parentID 资源父ID
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.11.02
	 */
	public List<PermissionResourceParam> getResourceForElementByUserID(Integer userID, Integer parentID) {
		Assert.notNull(permissionResourceReadDao, "Property 'permissionResourceReadDao' is required.");
		if( userID == null ) throw new BusinessException("userID不能为空");
		
		return permissionResourceReadDao.getResourceForElementByUserID(userID, parentID);
	}

}
