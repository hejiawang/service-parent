package com.wang.serviceimp.model.permission;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wang.core.exception.BusinessException;
import com.wang.service.entity.permission.PermissionUserInfoEntity;
import com.wang.service.param.permission.PermissionAppParam;
import com.wang.serviceimp.dao.permission.read.PermissionUserInfoReadDao;

/**
 * 菜单、页面元素权限 model
 * 
 * @author HeJiawang
 * @date   2016.11.04
 */
@Service
public class PermissionCoreModel {

	/**
	 * log
	 */
	private final Logger logger = LoggerFactory.getLogger(PermissionCoreModel.class);

	/**
	 * permissionUserInfoReadDao
	 */
	@Autowired
	private PermissionUserInfoReadDao permissionUserInfoReadDao;
	
	/**
	 * 初始化当前登录者的APP列表
	 * @param currentUserID 当前登陆者ID
	 * @param changeApp 所选择的APP信息
	 * @return APP列表HTML
	 * @author HeJiawang
	 * @date   2016.11.04
	 */
	public String changeApp(PermissionUserInfoEntity userCurrent, PermissionAppParam changeApp) {
		Assert.notNull(permissionUserInfoReadDao, "Property 'permissionUserInfoReadDao' is required.");
		if( userCurrent == null ) throw new BusinessException("当前登录者不能为空");
		if( changeApp == null ) throw new BusinessException("所选APP信息不能为空");
		
		/**
		 * 获取该用户有权限访问的的APP集合
		 */
		List<PermissionAppParam> appList = permissionUserInfoReadDao.getAppByUserID(userCurrent.getUserID());
		/**
		 * 根据AppTypeID分类,key--appTypeID  value--PermissionAppParam集合
		 */
		Map<Integer,List<PermissionAppParam>> appMap = new LinkedHashMap<Integer,List<PermissionAppParam>>();
		List<PermissionAppParam> appListTemp = null;
		for( PermissionAppParam appParam : appList ){
			Integer appTypeID = appParam.getAppTypeID(); 
			if(appMap.containsKey(appTypeID)){
				appListTemp = appMap.get(appTypeID);
			}else{
				appListTemp = new ArrayList<PermissionAppParam>();
				appMap.put(appTypeID, appListTemp);
			}
			appListTemp.add(appParam);
		}
		
		
		/**
		 * 拼接HTML
		 */
		String typeID = String.valueOf(changeApp.getAppTypeID());
		String appID = String.valueOf(changeApp.getAppID());
		StringBuffer apps = new StringBuffer("<ul class=\"nav ace-nav\">");
		for (Map.Entry<Integer,List<PermissionAppParam>> entry : appMap.entrySet()) {
			Integer key = entry.getKey();
			List<PermissionAppParam> value = entry.getValue();
			if(key.equals(typeID)){
				apps.append("<li class=\"green\">");
				apps.append("<a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\">");
				apps.append("<i class=\"ace-icon fa fa-tasks\"></i>");
				apps.append("<span class=\"badge badge-success\">"+value.size()+"</span></a>");
			}else{
				apps.append("<li class=\"grey\">");
				apps.append("<a data-toggle=\"dropdown\" class=\"dropdown-toggle\" href=\"#\">");
				apps.append("<i class=\"ace-icon fa fa-tasks\"></i>");
				apps.append("<span class=\"badge badge-grey\">"+value.size()+"</span></a>");
			}
			apps.append("<ul class=\"dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close\">");
			
			apps.append("<li class=\"dropdown-header\"><i class=\"ace-icon fa fa-check\"></i>");
			apps.append(value.get(0).getAppTypeName());
			apps.append("</li>");
			for (PermissionAppParam roleApp : value) {
				if(roleApp.getUrl() == null || roleApp.getUrl().equals("#") || roleApp.getUrl().equals("")){
					apps.append("<li><a href=\"javascript:changeApp("+roleApp.getAppID()+","+key+");\">");
					apps.append("<div class=\"clearfix\">");
				}else{
					apps.append("<li><a href=\""+roleApp.getUrl()+"\">");
					apps.append("<div class=\"clearfix\">");
				}
				apps.append("<span class=\"pull-left\">"+roleApp.getAppName()+"</span>");
				if(String.valueOf(roleApp.getAppID()).equals(appID)){
					apps.append("<span class=\"pull-right badge badge-success\"> √ </span>");
				}
				apps.append("</div>");
				apps.append("</a></li>");
			}
			apps.append("</ul>");
			apps.append("</li>");
		}
		apps.append("<li class=\"light-blue\">");
		apps.append("<a data-toggle=\"dropdown\" href=\"#\" class=\"dropdown-toggle\">");
		apps.append("<img class=\"nav-user-photo\" src=\""+userCurrent.getUserPhotoFile()+"\" alt=\""+userCurrent.getUserName()+"\" />");
		apps.append("<span class=\"user-info\"><small>欢迎您,</small>"+userCurrent.getUserName()+"</span>");
		apps.append("<i class=\"ace-icon fa fa-caret-down\"></i></a>");
		apps.append("<ul class=\"user-menu dropdown-menu-right dropdown-menu dropdown-menus dropdown-yellow dropdown-caret dropdown-close\">");
		apps.append("<li><a href=\"main/personal.jsp\"><i class=\"ace-icon fa fa-user\"></i>个人信息</a></li>");
		apps.append("<li class=\"divider\"></li>");
		apps.append("<li onclick=\"javascript:logout();\"><a href=\"#\"><i class=\"ace-icon fa fa-power-off\"></i>退出</a></li>");
		apps.append("</ul></li>");			
		apps.append("</ul>");
		
		return apps.toString();
	}

}
