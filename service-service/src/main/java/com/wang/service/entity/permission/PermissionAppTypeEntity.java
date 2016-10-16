package com.wang.service.entity.permission;

import java.io.Serializable;

/**
 * 系统类型Entity
 * @author HeJiawang
 * @date   2016.10.16
 */
public class PermissionAppTypeEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 系统类型ID
	 */
	private Integer appTypeID;
	
	
	/**
	 * 系统类型名称
	 */
	private String appTypeName;
	
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

	public Integer getAppTypeID() {
		return appTypeID;
	}

	public void setAppTypeID(Integer appTypeID) {
		this.appTypeID = appTypeID;
	}

	public String getAppTypeName() {
		return appTypeName;
	}

	public void setAppTypeName(String appTypeName) {
		this.appTypeName = appTypeName;
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

}
