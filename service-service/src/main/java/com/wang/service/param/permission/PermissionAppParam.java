package com.wang.service.param.permission;

import java.io.Serializable;

/**
 * 应用系统Entity
 * @author HeJiawang
 * @date   2016.10.17
 */
public class PermissionAppParam implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 应用系统ID
	 */
	private Integer appID;
	
	/**
	 * 所属系统类型ID
	 */
	private Integer appTypeID;
	
	/**
	 * 应用系统名称
	 */
	private String appName;
	
	/**
	 * 应用系统连接
	 */
	private String url;
	
	/**
	 * 图标风格
	 */
	private String iconStyle;
	
	/**
	 * 顺序
	 */
	private Integer sortNum;
	
	/**
	 * 0：未启动 1：启用
	 */
	private Integer isCurrent;
	
	/**
	 * 是否删除,默认1 未删除  0 删除
	 */
	private Integer isDelete;
	
	/**
	 * 备注
	 */
	private String theNote;
	
	/**
	 * 系统类型名称
	 */
	private String appTypeName;
	
	/**
	 * 操作ID集合
	 */
	private String operationIDs;
	
	/**
	 * 操作ID集合名称
	 */
	private String operationNames;
	
	/**
	 * 分页信息
	 */
	private Integer pageStart; 
	
	/**
	 * 分页信息
	 */
	private Integer pageEnd;
	
	/**
	 * 分页信息
	 */
	private Integer draw;

	public String getAppTypeName() {
		return appTypeName;
	}

	public void setAppTypeName(String appTypeName) {
		this.appTypeName = appTypeName;
	}

	public String getOperationNames() {
		return operationNames;
	}

	public void setOperationNames(String operationNames) {
		this.operationNames = operationNames;
	}

	public String getOperationIDs() {
		return operationIDs;
	}

	public void setOperationIDs(String operationIDs) {
		this.operationIDs = operationIDs;
	}

	public Integer getAppID() {
		return appID;
	}

	public void setAppID(Integer appID) {
		this.appID = appID;
	}

	public Integer getAppTypeID() {
		return appTypeID;
	}

	public void setAppTypeID(Integer appTypeID) {
		this.appTypeID = appTypeID;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIconStyle() {
		return iconStyle;
	}

	public void setIconStyle(String iconStyle) {
		this.iconStyle = iconStyle;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public Integer getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(Integer isCurrent) {
		this.isCurrent = isCurrent;
	}

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getTheNote() {
		return theNote;
	}

	public void setTheNote(String theNote) {
		this.theNote = theNote;
	}

	public Integer getPageStart() {
		return pageStart;
	}

	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}

	public Integer getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(Integer pageEnd) {
		this.pageEnd = pageEnd;
	}

	public Integer getDraw() {
		return draw;
	}

	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	
}
