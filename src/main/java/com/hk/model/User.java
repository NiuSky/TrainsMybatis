package com.hk.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户表
 */
public class User implements Serializable {
	private static final long serialVersionUID = -328602757171077630L;
	/**
	 * 用户ID
	 */
	private Long ID;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 密码
	 */
	private String userPassword;
	/**
	 * 邮箱
	 */
	private String userEmail;
	/**
	 * 简介
	 */
	private String userInfo;
	/**
	 * 头像
	 */
	private String headImg;
	/**
	 * 创建时间
	 */
	private Date createTime;
	
	/**
	 * 用户角色
	 */
	private Role role;
	
	/**
	 * 用户的角色集合
	 */
	private List<Role> roleList;

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}


	@Override
	public String toString() {
		return "User{" +
				"ID=" + ID +
				", userName='" + userName + '\'' +
				", userPassword='" + userPassword + '\'' +
				", userEmail='" + userEmail + '\'' +
				", userInfo='" + userInfo + '\'' +
				", headImg='" + headImg + '\'' +
				", createTime=" + createTime +
				", role=" + role +
				", roleList=" + roleList +
				'}';
	}
}
