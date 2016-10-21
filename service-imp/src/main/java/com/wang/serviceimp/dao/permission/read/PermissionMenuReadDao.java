package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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

	/**
	 * 在同一父菜单下，检查菜单名称是否重复
	 * @param menu 菜单信息
	 * @return True——重复
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	Integer checkExistMenuName(PermissionMenuParam menu);

	/**
	 * 根据菜单ID获取菜单信息
	 * @param menuID menuID
	 * @return 应用系统信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	PermissionMenuParam getMenu(@Param("menuID")Integer menuID);

}
