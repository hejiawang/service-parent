package com.wang.service.entity.permission;

import java.io.Serializable;

/**
 * 资源--操作  Entity
 * @author HeJiawang
 * @date   2016.10.17
 */
public class PermissionPermissionEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 权限ID
	 */
	private Integer permissionID;
	
	/**
	 * 资源ID
	 */
	private Integer resourceID;
	
	/**
	 * 操作ID
	 */
	private Integer operationID;

	public Integer getPermissionID() {
		return permissionID;
	}

	public void setPermissionID(Integer permissionID) {
		this.permissionID = permissionID;
	}

	public Integer getResourceID() {
		return resourceID;
	}

	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}

	public Integer getOperationID() {
		return operationID;
	}

	public void setOperationID(Integer operationID) {
		this.operationID = operationID;
	}
	
}
