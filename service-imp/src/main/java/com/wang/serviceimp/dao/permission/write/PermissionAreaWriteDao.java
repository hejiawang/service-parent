package com.wang.serviceimp.dao.permission.write;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.param.permission.PermissionAreaParam;

/**
 * 地区——写
 * 
 * @author HeJiawang
 * @date   2016.12.29
 */
@MyBatisRepository
public interface PermissionAreaWriteDao {

	/**
	 * 删除地区
	 * @param areaID 地区ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	Integer deleteArea(@Param("areaID")Integer areaID);

	/**
	 * 新增地区
	 * 
	 * @param area 地区信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	Integer addArea(PermissionAreaParam area);

	/**
	 * 修改地区
	 * 
	 * @param area 地区信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	Integer updateArea(PermissionAreaParam area);

}
