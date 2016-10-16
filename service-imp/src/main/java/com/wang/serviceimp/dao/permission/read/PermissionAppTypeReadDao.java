package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionAppTypeParam;

/**
 * 
 * 系统类型read dao
 * 
 * @author HeJiawang
 * @date   2016.10.16
 *
 */
@MyBatisRepository
public interface PermissionAppTypeReadDao {

	/**
	 * 获取分页系统类型
	 * @param appType  系统类型参数
	 * @return      系统类型集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	List<Map<String, Object>> getPageList(PermissionAppTypeParam appType);

	/**
	 * 查看系统类型
	 * @param appTypeID 系统类型ID
	 * @return 系统类型信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	Map<String, Object> getAppTypeByID(@Param("appTypeID") Integer appTypeID);

	/**
	 * 检查系统类型名称是否重复
	 * @param appType 系统类型信息
	 * @return True	重复
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	Integer checkExistAppTypeName(PermissionAppTypeParam appType);

}
