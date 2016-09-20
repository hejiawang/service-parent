package com.wang.service.entity.test;

import java.io.Serializable;
import java.util.Date;

/**
 * 测试
 * @author HeJiawang
 * @date   2016.09.13
 */
public class TestEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键ID
	 */
	private Integer ID;

	/**
	 * 内容
	 */
	private String  context;

	/**
	 * 修改时间
	 */
	private Date    updateTime;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
}
