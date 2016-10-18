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
	
	/**
	 * 本身名称
	 */
	private String selfName;
	
	/**
	 * 是否为父资源</br>
	 * 大于0--父资源
	 */
	private Integer isParent; 
	
	public String getSelfName() {
		return selfName;
	}

	public void setSelfName(String selfName) {
		this.selfName = selfName;
	}

	public Integer getIsParent() {
		return isParent;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

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
