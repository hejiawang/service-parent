package com.wang.service.entity.permission;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户Entity
 * @author HeJiawang
 * @date   2016.10.25
 */
public class PermissionUserInfoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 用户ID
	 */
	private Integer userID;
	
	/**
	 * 用户编码
	 */
	private String userCode;
	
	/**
	 * 用户真实姓名
	 */
	private String userName;
	
	/**
	 * 性别  0：女  1：男
	 */
	private Integer userSex;
	
	/**
	 * 手机号码
	 */
	private String userTel;
	
	/**
	 * 电子邮件
	 */
	private String userEmail;
	
	/**
	 * birthday
	 */
	private Date userBirthday;
	
	/**
	 * 民族
	 */
	private String userNation;
	
	/**
	 * 图片文件名称
	 */
	private String userPhotoFile;
	
	/**
	 * 登录名
	 */
	private String loginName;
	
	/**
	 * 密码
	 */
	private String passWord;
	
	/**
	 * 0：未启动 1：启用
	 */
	private Integer isCurrent;
	
	/**
	 * 是否删除 默认1 未删除， 0 删除
	 */
	private Integer isDelete;
	
	/**
	 * 顺序
	 */
	private Integer sortNum;
	
	/**
	 * 创建时间
	 */
	private Date createDT;
	
	/**
	 * 备注
	 */
	private String theNote;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserSex() {
		return userSex;
	}

	public void setUserSex(Integer userSex) {
		this.userSex = userSex;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserNation() {
		return userNation;
	}

	public void setUserNation(String userNation) {
		this.userNation = userNation;
	}

	public String getUserPhotoFile() {
		return userPhotoFile;
	}

	public void setUserPhotoFile(String userPhotoFile) {
		this.userPhotoFile = userPhotoFile;
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

	public Date getCreateDT() {
		return createDT;
	}

	public void setCreateDT(Date createDT) {
		this.createDT = createDT;
	}

	public String getTheNote() {
		return theNote;
	}

	public void setTheNote(String theNote) {
		this.theNote = theNote;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
}
