package com.wang.serviceimp.dao.permission.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionOrgParam;

/**
 * 
 * 机构writer dao
 * 
 * @author HeJiawang
 * @date   2016.10.10
 *
 */
@MyBatisRepository
public interface PermissionOrgWriteDao {

	/**
	 * 删除机构</br>
	 * @param orgID 机构ID
	 * @return 删除条数
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	Integer deleteOrgByID(@Param("orgID") Integer orgID);
	
	/**
	 * 新增机构
	 * @param org 机构信息
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	void addOrg(PermissionOrgParam org);

	/**
	 * 修改机构
	 * @param org 机构信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	Integer updateOrg(PermissionOrgParam org);

}
