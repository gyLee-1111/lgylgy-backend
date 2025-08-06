package com.bmm.api.logIn.security;

import java.util.List;

import com.bmm.api.logIn.UserRoleDTO;

public class LogInTokenInfo  {
	
	private String userId;
	
	private String userNm;

	private UserRoleDTO role;
	
	private List<String> roles;
	
	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public UserRoleDTO getRole() {
		return role;
	}

	public void setRole(UserRoleDTO role) {
		this.role = role;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


}
