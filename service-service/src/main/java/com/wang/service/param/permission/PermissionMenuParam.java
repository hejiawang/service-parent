package com.wang.service.param.permission;

import java.io.Serializable;

/**
 * 菜单Param
 * @author HeJiawang
 * @date   2016.10.18
 */
public class PermissionMenuParam implements Serializable {

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
	
	/**
	 * 父菜单ID
	 */
	private Integer parentMenuID;
	
	/**
	 * 父菜单名称
	 */
	private String  parentMenuName;
	
	/**
	 * 是否为父菜单</br>
	 * 大于0--父菜单
	 */
	private Integer isParent;
	
	/**
	 * 父菜单ID集合
	 */
	private String  parentIDs;
	
	/**
	 * 父菜单名称集合
	 */
	private String  parentNames;
	
	/**
	 * 父菜单类型
	 */
	private String  parentType;
	
	/**
	 * 操作ID集合
	 */
	private String operationIDs;
	
	/**
	 * 操作ID集合名称
	 */
	private String operationNames;
	
	/**
	 * 资源ID
	 */
	private Integer resourceID;
	
	/**
	 * 分页信息
	 */
	private Integer pageSize; 
	
	/**
	 * 分页信息
	 */
	private Integer pageNumber;
	
	/**
	 * 分页信息
	 */
	private Integer draw;

	public Integer getResourceID() {
		return resourceID;
	}

	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}

	public String getOperationIDs() {
		return operationIDs;
	}

	public void setOperationIDs(String operationIDs) {
		this.operationIDs = operationIDs;
	}

	public String getOperationNames() {
		return operationNames;
	}

	public void setOperationNames(String operationNames) {
		this.operationNames = operationNames;
	}

	public Integer getParentMenuID() {
		return parentMenuID;
	}

	public void setParentMenuID(Integer parentMenuID) {
		this.parentMenuID = parentMenuID;
	}

	public String getParentMenuName() {
		return parentMenuName;
	}

	public void setParentMenuName(String parentMenuName) {
		this.parentMenuName = parentMenuName;
	}

	public Integer getIsParent() {
		return isParent;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	public String getParentIDs() {
		return parentIDs;
	}

	public void setParentIDs(String parentIDs) {
		this.parentIDs = parentIDs;
	}

	public String getParentNames() {
		return parentNames;
	}

	public void setParentNames(String parentNames) {
		this.parentNames = parentNames;
	}

	public String getParentType() {
		return parentType;
	}

	public void setParentType(String parentType) {
		this.parentType = parentType;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}

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
