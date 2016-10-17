package com.wang.serviceimp.dao.permission.read;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.entity.permission.PermissionResourceEntity;

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

}
