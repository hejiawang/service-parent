package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

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

}
