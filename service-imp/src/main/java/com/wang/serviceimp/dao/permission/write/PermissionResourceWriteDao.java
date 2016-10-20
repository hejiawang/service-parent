package com.wang.serviceimp.dao.permission.write;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionResourceParam;

/**
 * 
 * 资源write dao
 * 
 * @author HeJiawang
 * @date   2016.10.17
 *
 */
@MyBatisRepository
public interface PermissionResourceWriteDao {

	/**
	 * 新增系统资源
	 * @param resource 系统资源
	 * @return resource中返回资源ID
	 * 
	 * @author HeJiawang
	 * @date   2016.10.19
	 */
	Integer addResource(PermissionResourceParam resource);
	
}
