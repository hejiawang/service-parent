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

}
