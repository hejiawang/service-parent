package com.wang.service.service.permission;

import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.service.param.permission.PermissionAppParam;

/**
 * 应用系统service
 * @author HeJiawang
 * @date   2016.10.17
 */
public interface PermissionAppService {

	/**
	 * 获取分页应用系统
	 * @param app 应用系统参数
	 * @return 应用系统集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	ServiceResult<Map<String, Object>> pageApp(PermissionAppParam app);

	/**
	 * 新增应用系统
	 * @param app 应用系统信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	ServiceResult<Void> addApp(PermissionAppParam app);

}
