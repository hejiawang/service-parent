package com.wang.service.service.permission;

import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.service.param.permission.PermissionMenuParam;

/**
 * 菜单service
 * @author HeJiawang
 * @date   2016.10.18
 */
public interface PermissionMenuService {

	/**
	 * 获取分页菜单
	 * @param menu 菜单参数
	 * @return 菜单集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	ServiceResult<Map<String,Object>> pageMenu(PermissionMenuParam menu);

}
