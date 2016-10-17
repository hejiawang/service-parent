package com.wang.serviceimp.dao.permission.write;

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
	 * @return 应用系统ID
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	Integer addApp(PermissionAppParam app);

}
