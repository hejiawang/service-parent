package com.wang.serviceimp.dao.permission.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;

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
	 * 新增应用系统资源
	 * @param selfID 应用系统ID
	 * @return 资源ID
	 * 
	 * @author HeJiawang
	 * @date   2016.10.17
	 */
	Integer addAppResource( @Param("selfID") Integer selfID );

}
