package com.wang.serviceimp.dao.permission.read;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.wang.core.repository.myBatis.MyBatisRepository;
import com.wang.service.entity.permission.PermissionAreaEntity;
import com.wang.service.param.permission.PermissionAreaParam;

/**
 * 地区——读
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@MyBatisRepository
public interface PermissionAreaReadDao {

	/**
	 * 根据父级地址获取子地址集合
	 * 
	 * @param parentID 地址父ID
	 * @return 地址信息集合
	 */
	List<PermissionAreaEntity> getAreaListByParentID(@Param("parentID")Integer parentID);

	/**
	 * 分页获取地区信息
	 * 
	 * @param paramMap 参数map
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	List<Map<String, Object>> pageAera(Map<String, Object> paramMap);

	/**
	 * 分页总条数
	 * 
	 * @param param 查询参数
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	Integer pageAreaTotal(PermissionAreaParam param);

	/**
	 * 获取地区树
	 * 
	 * @param id 父地区ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	List<PermissionAreaParam> getAreaTreeData(@Param("parentID")Integer parentID);

	/**
	 * 根据地区ID获取地区信息
	 * @param areaID 地区ID
	 * @return 地区信息
	 */
	PermissionAreaParam getAreaByID(@Param("areaID")Integer areaID);

}
