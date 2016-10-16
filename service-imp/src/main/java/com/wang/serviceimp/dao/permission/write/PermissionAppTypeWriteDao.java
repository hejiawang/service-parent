package com.wang.serviceimp.dao.permission.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionAppTypeParam;

/**
 * 
 * 系统类型writer dao
 * 
 * @author HeJiawang
 * @date   2016.10.16
 *
 */
@MyBatisRepository
public interface PermissionAppTypeWriteDao {

	/**
	 * 删除系统类型
	 * @param appType 系统类型ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	Integer deleteAppTypeByID(@Param("appTypeID")Integer appTypeID);

	/**
	 * 新增系统类型
	 * @param appType 系统类型信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	void addAppType(PermissionAppTypeParam appType);

	/**
	 * 修改系统类型
	 * @param appType 系统类型信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	void updateAppType(PermissionAppTypeParam appType);

}
