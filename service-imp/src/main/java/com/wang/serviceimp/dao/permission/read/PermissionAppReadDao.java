package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionAppParam;

/**
 * 
 * 应用系统read dao
 * 
 * @author HeJiawang
 * @date   2016.10.17
 *
 */
@MyBatisRepository
public interface PermissionAppReadDao {

	/**
	 * 获取分页应用系统
	 * @param app 应用系统参数
	 * @return 应用系统集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	List<Map<String, Object>> getPageList(PermissionAppParam app);

	/**
	 * 检查系统名称是否重复
	 * @param app 应用系统信息
	 * @return True	重复
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	Integer checkExistAppName(PermissionAppParam app);

	/**
	 * 获取应用信息基本信息
	 * @param appID 应用系统ID
	 * @return 应用系统信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	PermissionAppParam getApp( @Param("appID") Integer appID);

}
