package com.wang.service.entity.permission;

import java.io.Serializable;

/**
 * 操作  Entity
 * @author HeJiawang
 * @date   2016.10.17
 */
public class PermissionOperationEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
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
