package com.wang.serviceimp.dao.permission.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionMenuParam;

/**
 * 
 * 菜单write dao
 * 
 * @author HeJiawang
 * @date   2016.10.17
 *
 */
@MyBatisRepository
public interface PermissionMenuWriteDao {

	/**
	 * 新增菜单
	 * @param  menu 菜单信息
	 * @return menu中包含menuID
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	Integer addMenu(PermissionMenuParam menu);

	/**
	 * 删除menu
	 * @param menuID menuID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.21
	 */
	Integer deleteMenuByID(@Param("menuID")Integer menuID);

	/**
	 * 修改菜单
	 * @param menu 菜单信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.22
	 */
	Integer updateMenu(PermissionMenuParam menu);

}
