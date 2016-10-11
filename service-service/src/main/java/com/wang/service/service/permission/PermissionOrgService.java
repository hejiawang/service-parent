package com.wang.service.service.permission;

import java.util.List;
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

	/**
	 * 根据机构ID获取机构信息
	 * @param orgID 机构ID
	 * @return 机构信息
	 * @author HeJiawang
	 * @date   2016.10.10
	 */
	ServiceResult<Map<String, Object>> getOrgByID(Integer orgID);

	/**
	 * 删除机构</br>
	 * 根机构不可删除——orgID:1001
	 * @param orgID 机构ID
	 * @return 返回信息: ServiceResult.success true--删除成功
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	ServiceResult<Void> deleteOrgByID(Integer orgID);
	
	/**
	 * 检查机构是否被引用
	 * @param orgID 机构ID
	 * @return 返回信息: ServiceResult.success true--引用
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	ServiceResult<Void> checkOrgByID(Integer orgID);

	/**
	 * 新增机构
	 * @param org 机构信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	ServiceResult<Void> addOrg(PermissionOrgParam org);

	/**
	 * 修改机构
	 * @param org 机构信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	ServiceResult<Void> updateOrg(PermissionOrgParam org);

	
	/**
	 * 根据父机构ID获取机构树
	 * @param id	父机构ID
	 * @return		机构树
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	ServiceResult<List<PermissionOrgParam>> findOrgForTree(Integer parentOrgID);

}
