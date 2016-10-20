package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionMenuParam;

/**
 * 
 * menu read dao
 * 
 * @author HeJiawang
 * @date   2016.10.18
 *
 */
@MyBatisRepository
public interface PermissionMenuReadDao {

	/**
	 * 获取分页菜单
	 * @param menu 菜单参数
	 * @return 菜单集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	List<Map<String, Object>> getPageList(PermissionMenuParam menu);

	/**
	 * 获取分页条数
	 * @param menu 菜单参数
	 * @return 菜单集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	Integer getPageTotal(PermissionMenuParam menu);

}
