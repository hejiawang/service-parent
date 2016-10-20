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
import com.wang.service.param.permission.PermissionMenuParam;
import com.wang.serviceimp.dao.permission.read.PermissionMenuReadDao;

/**
 * 菜单service imp
 * @author HeJiawang
 * @date   2016.10.18
 */
@Service
public class PermissionMenuModel {
	
	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionAppModel.class);

	/**
	 * permissionMenuReadDao
	 */
	@Autowired
	private PermissionMenuReadDao permissionMenuReadDao;
	
	/**
	 * 获取分页菜单
	 * @param menu 菜单参数
	 * @return 菜单集合及分页信息
	 * @author HeJiawang
	 * @date   2016.10.18
	 */
	public Map<String, Object> pageMenu(PermissionMenuParam menu) {
		Assert.notNull(permissionMenuReadDao, "Property 'permissionMenuReadDao' is required.");
		if( menu.getPageStart() == null || menu.getPageEnd() == null || menu.getDraw() == null ) 
			throw new BusinessException("分页信息不能为空");
		
		Map<String,Object> map = new HashMap<String,Object>();
		List<Map<String,Object>> pageLsit = permissionMenuReadDao.getPageList(menu);
		Integer recordsTotal = permissionMenuReadDao.getPageTotal(menu);
		
		map.put("draw", menu.getDraw());
		map.put("data", pageLsit);
		map.put("recordsTotal", recordsTotal);
		map.put("recordsFiltered",  recordsTotal);
		
		return map;
	}

}
