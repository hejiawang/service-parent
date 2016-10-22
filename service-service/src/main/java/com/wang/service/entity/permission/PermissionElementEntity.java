package com.wang.service.entity.permission;

import java.io.Serializable;

/**
 * 页面元素Entity
 * @author HeJiawang
 * @date   2016.10.22
 */
public class PermissionElementEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ID
	 */
	private Integer elementID;
	
	/**
	 * 名称
	 */
	private String elementName;
	
	/**
	 * 方法名称
	 */
	private String elementFunction;
	
	/**
	 * 元素样式
	 */
	private String elementStyle;
	
	/**
	 * 当前状态，0：未启动 1：启用
	 */
	private Integer isCurrent;
	
	/**
	 * 是否删除,默认1 未删除  0 删除
	 */
	private Integer isDelete;
	
	/**
	 * 排序
	 */
	private Integer sortNum;
	
	/**
	 * 备注
	 */
	private String theNote;

	public Integer getElementID() {
		return elementID;
	}

	public void setElementID(Integer elementID) {
		this.elementID = elementID;
	}

	public String getElementName() {
		return elementName;
	}

	public void setElementName(String elementName) {
		this.elementName = elementName;
	}

	public String getElementFunction() {
		return elementFunction;
	}

	public void setElementFunction(String elementFunction) {
		this.elementFunction = elementFunction;
	}

	public String getElementStyle() {
		return elementStyle;
	}

	public void setElementStyle(String elementStyle) {
		this.elementStyle = elementStyle;
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

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public String getTheNote() {
		return theNote;
	}

	public void setTheNote(String theNote) {
		this.theNote = theNote;
	}
	
}
