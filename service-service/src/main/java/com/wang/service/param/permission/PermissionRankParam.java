package com.wang.service.param.permission;

import java.io.Serializable;

/**
 * 职级Param
 * @author HeJiawang
 * @date   2016.10.13
 */
public class PermissionRankParam implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 职级ID
	 */
	private Integer rankID;
	
	/**
	 * 职级名称
	 */
	private String rankName;
	
	/**
	 * 职级等级
	 */
	private Integer rankLevel;
	
	/**
	 * 上级职级ID
	 */
	private Integer parentRankID;
	
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
	 * 上级机构名称
	 */
	private String parentRankName;
	
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
	
	/**
	 * 是否为父职级</br>
	 * 在生成职级树时用来判断是否为父职级</br>
	 * Integer类型——0：不是父职级
	 */
	private Integer isParent;

	public Integer getRankID() {
		return rankID;
	}

	public void setRankID(Integer rankID) {
		this.rankID = rankID;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public Integer getRankLevel() {
		return rankLevel;
	}

	public void setRankLevel(Integer rankLevel) {
		this.rankLevel = rankLevel;
	}

	public Integer getParentRankID() {
		return parentRankID;
	}

	public void setParentRankID(Integer parentRankID) {
		this.parentRankID = parentRankID;
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

	public String getParentRankName() {
		return parentRankName;
	}

	public void setParentRankName(String parentRankName) {
		this.parentRankName = parentRankName;
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

	public Integer getIsParent() {
		return isParent;
	}

	public void setIsParent(Integer isParent) {
		this.isParent = isParent;
	}

}
