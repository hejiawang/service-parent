package com.wang.service.param.permission;

import java.io.Serializable;

/**
 * 角色Param
 * @author HeJiawang
 * @date   2016.10.14
 */
public class PermissionRoleParam implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 角色ID
	 */
	private Integer roleID;
	
	/**
	 * 角色名称
	 */
	private String roleName;
	
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

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

}
