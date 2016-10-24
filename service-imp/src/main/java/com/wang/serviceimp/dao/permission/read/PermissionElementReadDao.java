package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionElementParam;

/**
 * element read dao
 * 
 * @author HeJiawang
 * @date   2016.10.24
 *
 */
@MyBatisRepository
public interface PermissionElementReadDao {

	/**
	 * 获取分页页面元素
	 * @param element 页面元素参数
	 * @return 页面元素集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	List<Map<String, Object>> getPageList(PermissionElementParam element);

	/**
	 * 获取分页页面元素——条数
	 * @param element 页面元素参数
	 * @return 页面元素集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	Integer getPageTotal(PermissionElementParam element);

	/**
	 * 在同一父菜单下，检查名称是否重复
	 * @param  element 页面元素信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	Integer checkExistElementName(PermissionElementParam element);

	/**
	 * 获取页面元素信息
	 * @param elementID elementID
	 * @return 信息
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	PermissionElementParam getElementByID(@Param("elementID")Integer elementID);

}
