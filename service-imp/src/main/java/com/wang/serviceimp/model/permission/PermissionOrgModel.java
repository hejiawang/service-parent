package com.wang.serviceimp.model.permission;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
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
		if( org.getPageSize() == null || org.getPageNumber() == null || org.getDraw() == null ){
			throw new BusinessException("分页信息不能为空");
		}
		
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

}
