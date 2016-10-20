package com.wang.serviceimp.dao.permission.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionAppParam;

/**
 * 
 * 应用系统write dao
 * 
 * @author HeJiawang
 * @date   2016.10.17
 *
 */
@MyBatisRepository
public interface PermissionAppWriteDao {

	/**
	 * 新增应用系统
	 * @param app 应用系统信息
	 * @return app中返回应用系统ID
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	Integer addApp(PermissionAppParam app);

	/**
	 * 更新应用系统基本信息
	 * @param app 应用系统信息
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	Integer updateApp(PermissionAppParam app);

	/**
	 * 删除应用系统
	 * @param appID 应用系统ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	Integer deleteAppByID(@Param("appID")Integer appID);

}
