package com.wang.service.service.permission;

import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.service.param.permission.PermissionElementParam;

/**
 * 页面元素service
 * @author HeJiawang
 * @date   2016.10.24
 */
public interface PermissionElementService {

	/**
	 * 获取分页页面元素
	 * @param element 页面元素参数
	 * @return 页面元素集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	ServiceResult<Map<String,Object>> pageElement(PermissionElementParam element);

	/**
	 * 新增页面元素
	 * @param  element 页面元素信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	ServiceResult<Void> addElement(PermissionElementParam element);

	/**
	 * 页面元素查看
	 * @param elementID elementID
	 * @return 信息
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	ServiceResult<PermissionElementParam> getElementByID(Integer elementID);

	/**
	 * 删除页面元素
	 * @param elementID elementID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	ServiceResult<Void> deleteElementByID(Integer elementID);

	/**
	 * 修改页面元素
	 * @param element 页面元素信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	ServiceResult<Void> updateElement(PermissionElementParam element);

}
