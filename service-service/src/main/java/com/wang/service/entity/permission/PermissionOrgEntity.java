package com.wang.service.entity.permission;

import java.io.Serializable;
import java.util.Date;

/**
 * 机构Entity
 * @author HeJiawang
 * @date   2016.10.10
 */
public class PermissionOrgEntity implements Serializable {
	
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
	private Date createDT;
	
	/**
	 * 备注
	 */
	private String theNote;

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
	
	public Date getCreateDT() {
		return createDT;
	}

	public void setCreateDT(Date createDT) {
		this.createDT = createDT;
	}

}
