package com.bmm.api.logIn;

import java.util.List;

public class LogInResponseDTO {

 
	private String userId;

	private String token;

	private UserRoleDTO currentRole;
	
	private List<UserRoleDTO> userRoleList;
	
	private String message;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}



	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public UserRoleDTO getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(UserRoleDTO currentRole) {
		this.currentRole = currentRole;
	}

	public List<UserRoleDTO> getUserRoleList() {
		return userRoleList;
	}

	public void setUserRoleList(List<UserRoleDTO> userRoleList) {
		this.userRoleList = userRoleList;
	}

	
	
}
