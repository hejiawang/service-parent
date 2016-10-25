package com.wang.service.param.permission;

import java.io.Serializable;

/**
 * 用户parameter
 * @author HeJiawang
 * @date   2016.10.25
 */
public class PermissionUserInfoParam implements Serializable {

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
	private String userBirthday;
	
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
	private String createDT;
	
	/**
	 * 备注
	 */
	private String theNote;

	/**
	 * 组织ID</br>
	 * 关系：一对一
	 */
	private String orgID;
	
	/**
	 * 组织Name
	 */
	private String orgName;
	
	/**
	 * 职级ID</br>
	 * 关系：一对多
	 */
	private String rankIDs;
	
	/**
	 * 职级Name
	 */
	private String rankNames;
	
	/**
	 * 岗位ID</br>
	 * 关系：一对多
	 */
	private String postIDs;
	
	/**
	 * 岗位Name
	 */
	private String postNames;
	
	/**
	 * 角色ID</br>
	 * 关系：一对多
	 */
	private String roleIDs;
	
	/**
	 * 角色Name
	 */
	private String roleNames;
	
	/**
	 * 用户登录后默认app
	 */
	private String appID;
	
	/**
	 * appTypeID
	 */
	private String appTypeID;
	
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

	public String getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(String userBirthday) {
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

	public String getCreateDT() {
		return createDT;
	}

	public void setCreateDT(String createDT) {
		this.createDT = createDT;
	}

	public String getTheNote() {
		return theNote;
	}

	public void setTheNote(String theNote) {
		this.theNote = theNote;
	}

	public String getOrgID() {
		return orgID;
	}

	public void setOrgID(String orgID) {
		this.orgID = orgID;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getRankIDs() {
		return rankIDs;
	}

	public void setRankIDs(String rankIDs) {
		this.rankIDs = rankIDs;
	}

	public String getRankNames() {
		return rankNames;
	}

	public void setRankNames(String rankNames) {
		this.rankNames = rankNames;
	}

	public String getPostIDs() {
		return postIDs;
	}

	public void setPostIDs(String postIDs) {
		this.postIDs = postIDs;
	}

	public String getPostNames() {
		return postNames;
	}

	public void setPostNames(String postNames) {
		this.postNames = postNames;
	}

	public String getRoleIDs() {
		return roleIDs;
	}

	public void setRoleIDs(String roleIDs) {
		this.roleIDs = roleIDs;
	}

	public String getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}

	public String getAppID() {
		return appID;
	}

	public void setAppID(String appID) {
		this.appID = appID;
	}

	public String getAppTypeID() {
		return appTypeID;
	}

	public void setAppTypeID(String appTypeID) {
		this.appTypeID = appTypeID;
	}
	
}
