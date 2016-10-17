package com.wang.service.service.permission;

import java.util.List;
import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.service.entity.permission.PermissionAppTypeEntity;
import com.wang.service.param.permission.PermissionAppTypeParam;

/**
 * 系统类型service
 * @author HeJiawang
 * @date   2016.10.16
 */
public interface PermissionAppTypeService {

	/**
	 * 获取分页系统类型
	 * @param appType  系统类型参数
	 * @return     系统类型集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	ServiceResult<Map<String, Object>> pageAppType(PermissionAppTypeParam appType);

	/**
	 * 查看系统类型
	 * @param appTypeID 系统类型ID
	 * @return 系统类型信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	ServiceResult<Map<String, Object>> getAppTypeByID(Integer appTypeID);

	/**
	 * 删除系统类型
	 * @param appTypeID 系统类型ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	ServiceResult<Void> deleteAppTypeByID(Integer appTypeID);

	/**
	 * 新增系统类型
	 * @param appType 系统类型信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	ServiceResult<Void> addAppType(PermissionAppTypeParam appType);

	/**
	 * 修改系统类型
	 * @param appType 系统类型信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	ServiceResult<Void> updateAppType(PermissionAppTypeParam appType);

	/**
	 * 获取系统类型树信息
	 * @return 系统类型树信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	ServiceResult<List<PermissionAppTypeEntity>> getAllAppType();

}
