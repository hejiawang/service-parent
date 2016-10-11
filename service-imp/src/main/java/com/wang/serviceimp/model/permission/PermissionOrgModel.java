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
import com.wang.core.util.StringUtil;
import com.wang.core.util.WebConstants;
import com.wang.service.param.permission.PermissionOrgParam;
import com.wang.serviceimp.dao.permission.read.PermissionOrgReadDao;
import com.wang.serviceimp.dao.permission.write.PermissionOrgWriteDao;

/**
 * 机构 model
 * 
 * @author HeJiawang
 * @date   2016.10.10
 */
@Service
public class PermissionOrgModel {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionOrgModel.class);
	
	/**
	 * permissionOrgReadDao
	 */
	@Autowired
	private PermissionOrgReadDao permissionOrgReadDao;
	
	/**
	 * permissionOrgWriteDao
	 */
	@Autowired
	private PermissionOrgWriteDao permissionOrgWriteDao;
	
	/**
	 * 获取分页机构
	 * @param org  机构参数
	 * @return     机构集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.10
	 */
	public Map<String, Object> pageOrg(PermissionOrgParam org) {
		Assert.notNull(permissionOrgReadDao, "Property 'permissionOrgReadDao' is required.");
		if( org.getPageSize() == null || org.getPageNumber() == null || org.getDraw() == null ) 
			throw new BusinessException("分页信息不能为空");
		
		//初始页面取跟节点
		if(StringUtil.empty(org.getOrgID())){
			org.setOrgID(WebConstants.OrgRootID);
		}
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> pageLsit = permissionOrgReadDao.getPageList(org);
		Integer recordsTotal = pageLsit.size();
		
		map.put("draw", org.getDraw());
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}

	/**
	 * 根据机构ID获取机构信息
	 * @param orgID 机构ID
	 * @return 机构信息
	 * @author HeJiawang
	 * @date   2016.10.10
	 */
	public Map<String, Object> getOrgByID(Integer orgID) {
		Assert.notNull(permissionOrgReadDao, "Property 'permissionOrgReadDao' is required.");
		if( StringUtil.empty(orgID) ) throw new BusinessException("机构ID不能为空");
		
		return permissionOrgReadDao.getOrgByID(orgID);
	}

	/**
	 * 删除机构</br>
	 * 根机构不可删除——orgID:1001
	 * @param orgID 机构ID
	 * @return 是否删除成功: true--删除成功
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	public Boolean deleteOrgByID(Integer orgID) {
		Assert.notNull(permissionOrgWriteDao, "Property 'permissionOrgWriteDao' is required.");
		if( StringUtil.empty(orgID) ) throw new BusinessException("机构ID不能为空");
		if( orgID == 1001 ) throw new BusinessException("跟机构不可删除");
		
		Integer deleteResult = permissionOrgWriteDao.deleteOrgByID(orgID);
		if( deleteResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 检查机构是否被引用
	 * @param orgID 机构ID
	 * @return 是否被引用: true--引用
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	public Boolean checkOrgByID(Integer orgID) {
		Assert.notNull(permissionOrgReadDao, "Property 'permissionOrgReadDao' is required.");
		if( StringUtil.empty(orgID) ) throw new BusinessException("机构ID不能为空");
		
		Integer checkResult = permissionOrgReadDao.checkOrgFromParentOrg(orgID);	//检查是否被当做父机构引用
		if( checkResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 新增机构
	 * @param org 机构信息
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	public void addOrg(PermissionOrgParam org) {
		Assert.notNull(permissionOrgWriteDao, "Property 'permissionOrgWriteDao' is required.");
		if( StringUtil.empty(org) ) throw new BusinessException("机构不能为空");
		
		permissionOrgWriteDao.addOrg(org);
	}

	/**
	 * 修改机构
	 * @param org 机构信息
	 * @return ServiceResult
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	public Boolean updateOrg(PermissionOrgParam org) {
		Assert.notNull(permissionOrgWriteDao, "Property 'permissionOrgWriteDao' is required.");
		if( StringUtil.empty(org) ) throw new BusinessException("机构不能为空");
		
		Integer updateResult = permissionOrgWriteDao.updateOrg(org);
		if( updateResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * 在同一父机构下，检查机构名称是否重复
	 * @param org		机构
	 * @return 机构名称是否重复——true:重复
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	public Boolean checkExistOrgName(PermissionOrgParam org) {
		Assert.notNull(permissionOrgReadDao, "Property 'permissionOrgReadDao' is required.");
		if( StringUtil.empty(org) ) throw new BusinessException("机构不能为空");
		if( StringUtil.empty(org.getParentOrgID()) ) throw new BusinessException("机构父ID不能为空");
		
		Integer checkResult = permissionOrgReadDao.checkExistOrgName(org);
		if( checkResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 在同一父机构下，检查机构编码是否重复
	 * @param org		机构
	 * @return 机构编码是否重复——true:重复
	 * @author HeJiawang
	 * @date   2016.10.11
	 */
	public Boolean checkExistOrgCode(PermissionOrgParam org) {
		Assert.notNull(permissionOrgReadDao, "Property 'permissionOrgReadDao' is required.");
		if( StringUtil.empty(org) ) throw new BusinessException("机构不能为空");
		if( StringUtil.empty(org.getParentOrgID()) ) throw new BusinessException("机构父ID不能为空");
		
		Integer checkResult = permissionOrgReadDao.checkExistOrgCode(org);
		if( checkResult >= 1 ){
			return true;
		} else {
			return false;
		}
	}

}
