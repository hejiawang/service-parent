package com.wang.service.param.permission;

import java.io.Serializable;

/**
 * 资源  Param
 * @author HeJiawang
 * @date   2016.10.17
 */
public class PermissionResourceParam implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 资源ID
	 */
	private Integer resourceID;
	
	/**
	 * 本身ID
	 */
	private Integer selfID;
	
	/**
	 * 本身类型
	 */
	private String selfType;
	
	/**
	 * 上级ID
	 */
	private Integer parentID;
	
	/**
	 * 上类型
	 */
	private String parentType;

	public Integer getResourceID() {
		return resourceID;
	}

	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}

	public Integer getSelfID() {
		return selfID;
	}

	public void setSelfID(Integer selfID) {
		this.selfID = selfID;
	}

	public String getSelfType() {
		return selfType;
	}

	public void setSelfType(String selfType) {
		this.selfType = selfType;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public String getParentType() {
		return parentType;
	}

	public void setParentType(String parentType) {
		this.parentType = parentType;
	}
	
}
