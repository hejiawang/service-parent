package com.wang.service.service.permission;

import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.service.param.permission.PermissionOrgParam;

/**
 * 机构service
 * @author HeJiawang
 * @date   2016.10.10
 */
public interface PermissionOrgService {

	/**
	 * 获取分页机构
	 * @param org  机构参数
	 * @return     机构集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.10
	 */
	ServiceResult<Map<String, Object>> pageOrg(PermissionOrgParam org);

}
