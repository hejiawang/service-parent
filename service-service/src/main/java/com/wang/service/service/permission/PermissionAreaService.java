package com.wang.service.service.permission;

import java.util.List;
import java.util.Map;

import com.wang.core.ServiceResult;
import com.wang.service.entity.permission.PermissionAreaEntity;
import com.wang.service.param.permission.PermissionAreaParam;

/**
 * 地区接口
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
public interface PermissionAreaService {
	
	/**
	 * 根据父级地址获取子地址集合
	 * 
	 * @param parentID 地址父ID
	 * @return 地址信息集合
	 */
	public ServiceResult<List<PermissionAreaEntity>> getAreaListByParentID( Integer parentID );

	/**
	 * 分页获取地区信息
	 * 
	 * @param param 查询信息
	 * @param start 分页信息
	 * @param length 分页信息
	 * @param draw 分页信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public ServiceResult<Map<String,Object>> pageAera(PermissionAreaParam param, Integer start, Integer length, Integer draw);

	/**
	 * 删除地区
	 * @param areaID 地区ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public ServiceResult<Void> deleteArea(Integer areaID);

	/**
	 * 新增地区
	 * 
	 * @param area 地区信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public ServiceResult<Void> raiseArea(PermissionAreaParam area);

	/**
	 * 修改地区
	 * 
	 * @param area 地区信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public ServiceResult<Void> modifyArea(PermissionAreaParam area);

	/**
	 * 获取地区树
	 * 
	 * @param id 父地区ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public ServiceResult<List<PermissionAreaParam>> getAreaTreeData(Integer parentID); 
	
	/**
	 * 根据地区ID获取地区信息
	 * @param areaID 地区ID
	 * @return 地区信息
	 */
	public ServiceResult<PermissionAreaParam> getAreaByID(Integer areaID); 
}
