package com.wang.service.param.permission;

import java.io.Serializable;

/**
 * 权限--操作  Param
 * @author HeJiawang
 * @date   2016.10.28
 */
public class PermissionPermissionOperationParam implements Serializable {
	
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
	
	/**
	 * 类型编码
	 */
	private String 	typeCode;
	
	/**
	 * 操作名称
	 */
	private String  operationName;
	
	/**
	 * 方法名称
	 */
	private String  fun;

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

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}

	public String getFun() {
		return fun;
	}

	public void setFun(String fun) {
		this.fun = fun;
	}
	
}
