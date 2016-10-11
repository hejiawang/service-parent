package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionOrgParam;

/**
 * 
 * 机构read dao
 * 
 * @author HeJiawang
 * @date   2016.10.10
 *
 */
@MyBatisRepository
public interface PermissionOrgReadDao {

	/**
	 * 获取分页机构
	 * @param org  机构参数
	 * @return     机构集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.10
	 */
	List<Map<String, Object>> getPageList(PermissionOrgParam org);
	
	/**
	 * 根据机构ID获取机构信息
	 * @param orgID 机构ID
	 * @return 机构信息
	 * @author HeJiawang
	 * @date   2016.10.10
	 */
	Map<String, Object> getOrgByID(@Param("orgID") Integer orgID);
	
	/**
	 * 检查是否被当做父机构引用
	 * @param orgID 机构ID
	 * @return 引用条数
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	Integer checkOrgFromParentOrg(@Param("orgID") Integer orgID);

	/**
	 * 在同一父机构下，检查机构名称是否重复
	 * @param orgI		机构
	 * @return 机构名称是否重复——true:重复
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	Integer checkExistOrgName(PermissionOrgParam org);
	
	/**
	 * 在同一父机构下，检查机构编码是否重复
	 * @param org		机构
	 * @return 机构编码是否重复——true:重复
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	Integer checkExistOrgCode(PermissionOrgParam org);

}
