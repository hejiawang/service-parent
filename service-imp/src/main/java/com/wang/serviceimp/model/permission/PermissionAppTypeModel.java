package com.wang.serviceimp.model.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.service.param.permission.PermissionAppTypeParam;
import com.wang.serviceimp.dao.permission.read.PermissionAppTypeReadDao;
import com.wang.serviceimp.dao.permission.write.PermissionAppTypeWriteDao;

/**
 * 系统类型 model
 * 
 * @author HeJiawang
 * @date   2016.10.16
 */
@Service
public class PermissionAppTypeModel {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionAppTypeModel.class);
	
	/**
	 * permissionAppTypeReadDao
	 */
	@Autowired
	private PermissionAppTypeReadDao permissionAppTypeReadDao;
	
	/**
	 * permissionAppTypeWriteDao
	 */
	@Autowired
	private PermissionAppTypeWriteDao permissionAppTypeWriteDao;

	/**
	 * 获取分页系统类型
	 * @param appType  系统类型参数
	 * @return     系统类型集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	public Map<String, Object> pageAppType(PermissionAppTypeParam appType) {
		Assert.notNull(permissionAppTypeReadDao, "Property 'permissionAppTypeReadDao' is required.");
		if( appType.getPageSize() == null || appType.getPageNumber() == null || appType.getDraw() == null ) 
			throw new BusinessException("分页信息不能为空");
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> pageLsit = permissionAppTypeReadDao.getPageList(appType);
		Integer recordsTotal = pageLsit.size();
		
		map.put("draw", appType.getDraw());
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}
	
	/**
	 * 查看系统类型
	 * @param appTypeID 系统类型ID
	 * @return 系统类型信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	public Map<String, Object> getAppTypeByID(Integer appTypeID) {
		Assert.notNull(permissionAppTypeReadDao, "Property 'permissionAppTypeReadDao' is required.");
		if( appTypeID == null ) throw new BusinessException("系统类型ID不能为空");
		
		return permissionAppTypeReadDao.getAppTypeByID(appTypeID);
	}

	/**
	 * 删除系统类型
	 * @param appTypeID 系统类型ID
	 * @return 返回信息
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	public Boolean deleteAppTypeByID(Integer appTypeID) {
		Assert.notNull(permissionAppTypeWriteDao, "Property 'permissionAppTypeWriteDao' is required.");
		if( appTypeID == null ) throw new BusinessException("系统类型ID不能为空");
		
		Integer deleteResult = permissionAppTypeWriteDao.deleteAppTypeByID(appTypeID);
		if( deleteResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 检查系统类型名称是否重复
	 * @param appType 系统类型信息
	 * @return True	重复
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	public Boolean checkExistAppTypeName(PermissionAppTypeParam appType) {
		Assert.notNull(permissionAppTypeReadDao, "Property 'permissionAppTypeReadDao' is required.");
		if( appType == null ) throw new BusinessException("系统类型不能为空");
		
		Integer result = permissionAppTypeReadDao.checkExistAppTypeName(appType);
		if( result >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 新增系统类型
	 * @param appType 系统类型信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	public void addPost(PermissionAppTypeParam appType) {
		Assert.notNull(permissionAppTypeWriteDao, "Property 'permissionAppTypeWriteDao' is required.");
		if( appType == null ) throw new BusinessException("系统类型不能为空");
		
		permissionAppTypeWriteDao.addAppType(appType);
	}

	/**
	 * 修改系统类型
	 * @param appType 系统类型信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.16
	 */
	public void updateAppType(PermissionAppTypeParam appType) {
		Assert.notNull(permissionAppTypeWriteDao, "Property 'permissionAppTypeWriteDao' is required.");
		if( appType == null ) throw new BusinessException("系统类型不能为空");
		
		permissionAppTypeWriteDao.updateAppType(appType);
	}
	
}
