package com.wang.service.param.permission;

import java.io.Serializable;

/**
 * 地区
 * 
 * @author HeJiawang
 * @date 2016.12.08
 */
public class PermissionAreaParam implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 地区ID
	 */
	private Integer areaID;

	/**
	 * 地区代码
	 */
	private Integer areaCode;

	/**
	 * 地区名称
	 */
	private String areaName;

	/**
	 * 地区简写
	 */
	private String shortName;

	/**
	 * 等级
	 */
	private Integer areaLevel;

	/**
	 * 上级ID
	 */
	private Integer parentID;

	/**
	 * 是否删除, yes:已删除 no:未删除(默认)
	 */
	private String isDelete;

	/**
	 * 当前状态, normal:正常(默认) pause:暂停
	 */
	private String isCurrent;

	/**
	 * 排序
	 */
	private Integer sortNum;

	/**
	 * 备注
	 */
	private String theNote;
	
	/**
	 * 是否为父地区</br>
	 * 大于0为父地区
	 */
	private Integer isParent;

	public Integer getIsParent() {
		return isParent;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

	public Integer getAreaID() {
		return areaID;
	}

	public void setAreaID(Integer areaID) {
		this.areaID = areaID;
	}

	public Integer getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(Integer areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Integer getAreaLevel() {
		return areaLevel;
	}

	public void setAreaLevel(Integer areaLevel) {
		this.areaLevel = areaLevel;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getIsCurrent() {
		return isCurrent;
	}

	public void setIsCurrent(String isCurrent) {
		this.isCurrent = isCurrent;
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
