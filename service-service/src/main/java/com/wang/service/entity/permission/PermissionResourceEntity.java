package com.wang.service.entity.permission;

import java.io.Serializable;

/**
 *                   _ooOoo_ 
 *                  o8888888o 
 *                  88" . "88 
 *                  (| -_- |) 
 *                  O\  =  /O 
 *               ____/`---'\____ 
 *             .'  \\|     |//  `. 
 *           /  \\|||  :  |||//  \ 
 *           /  _||||| -:- |||||-  \ 
 *           |   | \\\  -  /// |   | 
 *           | \_|  ''\---/''  |   | 
 *           \  .-\__  `-`  ___/-. / 
 *         ___`. .'  /--.--\  `. . __ 
 *      ."" '<  `.___\_<|>_/___.'  >'"". 
 *     | | :  `- \`.;`\ _ /`;.`/ - ` : | | 
 *     \  \ `-.   \_ __\ /__ _/   .-` /  / 
 *======`-.____`-.___\_____/___.-`____.-'====== 
 *                   `=---=' 
 *
 * 资源  Entity</br>
 * <li>使关联该实体的实体能够构成树信息</li>
 * <li>使两个及两个以上的实体相互之间也能构成树信息，比如应用系统、菜单、菜单元素</li>
 * 
 * @author HeJiawang
 * @date   2016.10.17
 */
public class PermissionResourceEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 资源ID
	 */
	private Integer resourceID;
	
	/**
	 * 本身ID
	 */
	private Integer selfID;
	
	/**
	 * 本身类型
	 */
	private String selfType;
	
	/**
	 * 上级ID
	 */
	private Integer parentID;
	
	/**
	 * 上类型
	 */
	private String parentType;

	public Integer getResourceID() {
		return resourceID;
	}

	public void setResourceID(Integer resourceID) {
		this.resourceID = resourceID;
	}

	public Integer getSelfID() {
		return selfID;
	}

	public void setSelfID(Integer selfID) {
		this.selfID = selfID;
	}

	public String getSelfType() {
		return selfType;
	}

	public void setSelfType(String selfType) {
		this.selfType = selfType;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	public String getParentType() {
		return parentType;
	}

	public void setParentType(String parentType) {
		this.parentType = parentType;
	}
	
}
