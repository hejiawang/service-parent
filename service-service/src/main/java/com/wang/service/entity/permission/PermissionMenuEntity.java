package com.wang.service.entity.permission;

import java.io.Serializable;

/**
 * 菜单Entity
 * @author HeJiawang
 * @date   2016.10.18
 */
public class PermissionMenuEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 菜单ID
	 */
	private Integer menuID;
	
	/**
	 * 菜单名称
	 */
	private String menuName;
	
	/**
	 * 菜单等级
	 */
	private Integer menuLevel;
	
	/**
	 * 菜单样式
	 */
	private String iconStyle;
	
	/**
	 * 连接
	 */
	private String url;
	
	/**
	 * 顺序
	 */
	private Integer sortNum;
	
	/**
	 * 是否删除,默认1 未删除  0 删除
	 */
	private Integer isDelete;
	
	/**
	 * 0：未启动 1：启用
	 */
	private Integer isCurrent;
	
	/**
	 * 备注
	 */
	private String theNote;

	public Integer getMenuID() {
		return menuID;
	}

	public void setMenuID(Integer menuID) {
		this.menuID = menuID;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public Integer getMenuLevel() {
		return menuLevel;
	}

	public void setMenuLevel(Integer menuLevel) {
		this.menuLevel = menuLevel;
	}

	public String getIconStyle() {
		return iconStyle;
	}

	public void setIconStyle(String iconStyle) {
		this.iconStyle = iconStyle;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(Integer isCurrent) {
		this.isCurrent = isCurrent;
	}

	public String getTheNote() {
		return theNote;
	}

	public void setTheNote(String theNote) {
		this.theNote = theNote;
	}
	
}
