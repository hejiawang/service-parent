package com.wang.service.entity.user;

import java.io.Serializable;

/**
 * 用户
 * @author HeJiawang
 * @date   2016.09.20
 */
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键ID
	 */
	private Integer ID;

	/**
	 * 内容
	 */
	private String  loginName;
	
	/**
	 * 密码
	 */
	private String  passward;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}
	
}
