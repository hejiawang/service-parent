package com.wang.service.param.permission;

import java.io.Serializable;

/**
 * 机构Param
 * @author HeJiawang
 * @date   2016.10.10
 */
public class PermissionOrgParam implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 机构ID
	 */
	private Integer orgID;
	
	/**
	 * 机构编码
	 */
	private String orgCode;
	
	/**
	 * 机构名称
	 */
	private String orgName;
	
	/**
	 * 机构简称
	 */
	private String orgShortName;
	
	/**
	 * 机构等级
	 */
	private Integer orgLevel;
	
	/**
	 * 上级机构ID
	 */
	private Integer parentOrgID;
	
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
	 * 创建时间
	 */
	private String createDT;
	
	/**
	 * 备注
	 */
	private String theNote;
	
	/**
	 * 上级机构名称
	 */
	private String parentOrgName;
	
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
	
	/**
	 * 是否为父机构</br>
	 * 在生成机构树时用来判断是否为父机构</br>
	 * Integer类型——0：不是父机构
	 */
	private Integer isParent;
	
	public Integer getIsParent() {
		return isParent;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
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

	public Integer getOrgID() {
		return orgID;
	}

	public void setOrgID(Integer orgID) {
		this.orgID = orgID;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getOrgShortName() {
		return orgShortName;
	}

	public void setOrgShortName(String orgShortName) {
		this.orgShortName = orgShortName;
	}

	public Integer getOrgLevel() {
		return orgLevel;
	}

	public void setOrgLevel(Integer orgLevel) {
		this.orgLevel = orgLevel;
	}

	public Integer getParentOrgID() {
		return parentOrgID;
	}

	public void setParentOrgID(Integer parentOrgID) {
		this.parentOrgID = parentOrgID;
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

	public String getCreateDT() {
		return createDT;
	}

	public void setCreateDT(String createDT) {
		this.createDT = createDT;
	}

	public String getParentOrgName() {
		return parentOrgName;
	}

	public void setParentOrgName(String parentOrgName) {
		this.parentOrgName = parentOrgName;
	}
	
}
