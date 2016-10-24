package com.wang.serviceimp.dao.permission.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionElementParam;

/**
 * element write dao
 * 
 * @author HeJiawang
 * @date   2016.10.24
 *
 */
@MyBatisRepository
public interface PermissionElementWriteDao {

	/**
	 * 删除页面元素
	 * @param elementID elementID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	Integer deleteElementByID(@Param("elementID")Integer elementID);

	/**
	 * 新增页面元素
	 * @param  element 页面元素信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	Integer addElement(PermissionElementParam element);

	/**
	 * 修改页面元素
	 * @param element 页面元素信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.24
	 */
	Integer updateElement(PermissionElementParam element);

}
