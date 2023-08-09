package com.dungkun.model.input;

import com.dungkun.model.UserModel;

public class UserModelInput extends BasicModelInput<UserModel> {
	
	private String userName;
	private String fullName;
	private String password;
	private int status;
	private Long roleid;
	
	public UserModelInput() {
		this.userName = "";
		this.fullName = "";
		this.password = "";
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getRoleid() {
		return roleid;
	}
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
