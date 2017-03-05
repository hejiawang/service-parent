package com.wang.serviceimp.model.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.service.entity.permission.PermissionAreaEntity;
import com.wang.service.param.permission.PermissionAreaParam;
import com.wang.serviceimp.dao.permission.read.PermissionAreaReadDao;
import com.wang.serviceimp.dao.permission.write.PermissionAreaWriteDao;

/**
 * 地区Model
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
@Service
public class PermissionAreaModel {

	/**
	 * PermissionAreaReadDao
	 */
	@Autowired
	private PermissionAreaReadDao PermissionAreaReadDao;
	
	/**
	 * PermissionAreaWriteDao
	 */
	@Autowired
	private PermissionAreaWriteDao PermissionAreaWriteDao;
	
	/**
	 * 根据父级地址获取子地址集合
	 * 
	 * @param parentID 地址父ID
	 * @return 地址信息集合
	 */
	public List<PermissionAreaEntity> getAreaListByParentID(Integer parentID) {
		Assert.notNull(PermissionAreaReadDao, "Property 'PermissionAreaReadDao' is required.");
		if( parentID == null ) throw new BusinessException("地址父ID不能为空");
		
		return PermissionAreaReadDao.getAreaListByParentID(parentID);
	}

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
	public Map<String, Object> pageAera(PermissionAreaParam param, Integer start, Integer length, Integer draw) {
		Assert.notNull(PermissionAreaReadDao, "Property 'PermissionUserInfoReadDao' is required.");
		if( start==null || length==null || draw==null ) throw new BusinessException("分页信息不能为空");
		
		/**
		 * 将参数装进map
		 */
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put( "area", param );
		paramMap.put( "start", start );
		paramMap.put( "end", start+length );
		
		/**
		 * 获取数据
		 */
		List<Map<String,Object>> pageLsit = PermissionAreaReadDao.pageAera(paramMap);
		Integer recordsTotal = PermissionAreaReadDao.pageAreaTotal(param);
		
		/**
		 * 将结果按前台js分页插件的要求装进map
		 */
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("draw", draw);
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}

	/**
	 * 删除地区
	 * @param areaID 地区ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public Boolean deleteArea(Integer areaID) {
		Assert.notNull(PermissionAreaWriteDao, "Property 'PermissionAreaWriteDao' is required.");
		if( areaID==null ) throw new BusinessException("地区ID不能为空");
		
		Integer result = PermissionAreaWriteDao.deleteArea(areaID);
		if( result > 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 新增地区
	 * 
	 * @param area 地区信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public Boolean raiseArea(PermissionAreaParam area) {
		Assert.notNull(PermissionAreaWriteDao, "Property 'PermissionAreaWriteDao' is required.");
		if( area==null ) throw new BusinessException("地区不能为空");
		
		Integer result = PermissionAreaWriteDao.addArea(area);
		if( result > 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 修改地区
	 * 
	 * @param area 地区信息
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public Boolean modifyArea(PermissionAreaParam area) {
		Assert.notNull(PermissionAreaWriteDao, "Property 'PermissionAreaWriteDao' is required.");
		if( area.getAreaID()==null ) throw new BusinessException("地区ID不能为空");
		
		Integer result = PermissionAreaWriteDao.updateArea(area);
		if( result > 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 获取地区树
	 * 
	 * @param id 父地区ID
	 * @return
	 * 
	 * @author HeJiawang
	 * @date   2016.12.29
	 */
	public List<PermissionAreaParam> getAreaTreeData(Integer parentID) {
		Assert.notNull(PermissionAreaReadDao, "Property 'PermissionAreaReadDao' is required.");
		if( parentID == null ) throw new BusinessException("地址父ID不能为空");
		
		return PermissionAreaReadDao.getAreaTreeData(parentID);
	}

	/**
	 * 根据地区ID获取地区信息
	 * @param areaID 地区ID
	 * @return 地区信息
	 */
	public PermissionAreaParam getAreaByID(Integer areaID) {
		Assert.notNull(PermissionAreaReadDao, "Property 'PermissionAreaReadDao' is required.");
		if( areaID == null ) throw new BusinessException("ID不能为空");
		
		return PermissionAreaReadDao.getAreaByID(areaID);
	}

}
