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
import com.wang.service.param.permission.PermissionElementParam;
import com.wang.service.param.permission.PermissionMenuParam;
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
			if(key == Integer.valueOf(typeID)){
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
					apps.append("<li><a href=\"/pageGoto"+roleApp.getUrl()+"?param_app_id="+roleApp.getAppID()+"\">");
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
		//apps.append("<li><a href=\"main/personal.jsp\"><i class=\"ace-icon fa fa-user\"></i>个人信息</a></li>");
		//apps.append("<li class=\"divider\"></li>");
		apps.append("<li><a href=\"logout\"><i class=\"ace-icon fa fa-power-off\"></i>退出</a></li>");
		apps.append("</ul></li>");			
		apps.append("</ul>");
		
		return apps.toString();
	}

	/**
	 * 初始化当前登录者所在系统的菜单列表
	 * @param currentUserID 当前登陆者ID
	 * @param changeApp 所选择的APP信息
	 * @return 菜单列表HTML
	 * @author HeJiawang
	 * @date   2016.11.05
	 */
	public String changeMenu(PermissionUserInfoEntity userCurrent, PermissionAppParam changeApp) {
		Assert.notNull(permissionUserInfoReadDao, "Property 'permissionUserInfoReadDao' is required.");
		if( userCurrent == null ) throw new BusinessException("当前登录者不能为空");
		if( changeApp == null ) throw new BusinessException("所选APP信息不能为空");
		
		/**
		 * 获取该用户有权限访问的所在APP的菜单集合
		 */
		List<PermissionMenuParam> menuList = permissionUserInfoReadDao.getMenuByUserIDAndParentID(userCurrent.getUserID(), changeApp.getAppID());
		
		StringBuffer menuStr = new StringBuffer("");
		for(PermissionMenuParam menu : menuList){
			menuStr.append("<li id=\"menu_"+menu.getMenuID()+"\">");
			menuStr.append("<a href=\"/pageGoto"+menu.getUrl()+"?pid="+changeApp.getAppID()+"&sid="+menu.getMenuID()+"\"><i class=\"menu-icon fa fa-tachometer\"></i><span class=\"menu-text\" style=\"font-family: 微软雅黑\">"+menu.getMenuName()+"</span></a><b class=\"arrow\"></b>");
			menuStr.append("</li>");
		}
		 
		/*StringBuffer menuStr = new StringBuffer("<li id=\"menu_root\" class=\"active\">");
		menuStr.append("<a href=\"main/index.jsp\"><i class=\"menu-icon fa fa-tachometer\"></i><span class=\"menu-text\">我的工作台</span></a><b class=\"arrow\"></b>");
		this.createViewMenu(userCurrent.getUserID(), changeApp.getAppID(), menuStr);
		menuStr.append("</li>");*/
		
		return menuStr.toString();
	}
	
	/**
	 * 递归拼接菜单HTML
	 * @param userID 用户ID
	 * @param parentID 上级菜单
	 * @param menuStr 拼接字符串 
	 * @return List:PermissionMenuParam
	 * @author HeJiawang
	 * @date   2016.11.05
	 */
	private List<PermissionMenuParam> createViewMenu( Integer userID, Integer parentID, StringBuffer menuStr ){
		/**
		 * 获取该用户有权限访问的所在APP的菜单集合
		 */
		List<PermissionMenuParam> menuList = permissionUserInfoReadDao.getMenuByUserIDAndParentID(userID, parentID);
		
		for (PermissionMenuParam menu : menuList) {
			menuStr.append("<li id=\"menu_"+menu.getMenuID()+"\">");
			if(menu.getIsParent() > 0){
				menuStr.append("<a href=\""+menu.getUrl()+"?pid="+parentID+"&sid="+menu.getMenuID()+"\" class=\"dropdown-toggle\">");
				menuStr.append("<i class=\"menu-icon fa fa-list\"></i><span class=\"menu-text\">"+menu.getMenuName()+"</span><b class=\"arrow fa fa-angle-down\"></b>");
				menuStr.append("</a><b class=\"arrow\"></b>");
				menuStr.append("<ul class=\"submenu\">");
				createViewMenu(userID, menu.getMenuID(), menuStr);
				menuStr.append("</ul>");
			}else{
				menuStr.append("<a href=\""+menu.getUrl()+"?pid="+parentID+"&sid="+menu.getMenuID()+"\"><i class=\"menu-icon fa fa-caret-right\"></i>"+menu.getMenuName()+"</a><b class=\"arrow\"></b>");
			}
			menuStr.append("</li>");
		}
		return menuList;
	}

	/**
	 * 根据当前登录者所选择的菜单获取有使用权限的页面元素
	 * @param currentUserID 当前登陆者ID
	 * @param menuID 菜单ID
	 * @return 菜单列表HTML
	 * @author HeJiawang
	 * @date   2016.11.05
	 */
	public String getElementFromMenuByUserID(Integer currentUserID, Integer menuID) {
		Assert.notNull(permissionUserInfoReadDao, "Property 'permissionUserInfoReadDao' is required.");
		if( currentUserID == null ) throw new BusinessException("当前登录者ID不能为空");
		if( menuID == null ) throw new BusinessException("menuID不能为空");
		
		List<PermissionElementParam> elementList = permissionUserInfoReadDao.getElementFromMenuByUserID(currentUserID, menuID);
		StringBuffer elementStr = new StringBuffer("");
		for (PermissionElementParam element : elementList) {
			elementStr.append("<button id=\""+element.getElementID()+"\"");
			elementStr.append(" class=\""+element.getElementStyle()+"\"");
			elementStr.append(" data-last=\"Finish\" style=\"margin-left:5px;\" onclick=\"javascript:");
			elementStr.append(element.getElementFunction());
			elementStr.append(";\">"+element.getElementName()+"</button>");
		}
		elementStr.append("");
		return elementStr.toString();
	}
	
}
