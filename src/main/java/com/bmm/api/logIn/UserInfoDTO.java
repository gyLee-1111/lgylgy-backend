package com.bmm.api.logIn;

import java.time.LocalDate;

public class UserInfoDTO {
	
	private String userId;
	
	private String userPassword;
	
	private String normalPassword;
	
	private String userNm;
	
	private String phoneNumber;
	
	private LocalDate userBirth;
	
	private String userGender;
	
	private String membership;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getNormalPassword() {
		return normalPassword;
	}

	public void setNormalPassword(String normalPassword) {
		this.normalPassword = normalPassword;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(LocalDate userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}
    

}
