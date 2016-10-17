package com.wang.service.service.permission;

import com.wang.core.ServiceResult;
import com.wang.service.entity.permission.PermissionResourceEntity;

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

}
