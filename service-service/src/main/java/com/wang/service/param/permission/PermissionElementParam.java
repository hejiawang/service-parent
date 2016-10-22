package com.wang.service.param.permission;

import java.io.Serializable;

/**
 * 页面元素Param
 * @author HeJiawang
 * @date   2016.10.22
 */
public class PermissionElementParam implements Serializable {

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
	
	/**
	 * 所属菜单ID
	 */
	private Integer parentID;
	
	/**
	 * 所属菜单名称 
	 */
	private String parentName;
	
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
	private Integer pageStart; 
	
	/**
	 * 分页信息
	 */
	private Integer pageEnd;
	
	/**
	 * 分页信息
	 */
	private Integer draw;

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

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
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

	public Integer getResourceID() {
		return resourceID;
	}

	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
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
