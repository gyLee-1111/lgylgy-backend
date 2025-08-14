package com.bmm.api.joinMembership;

import java.time.LocalDate;

public class JoinMembershipDTO {
	
	private String email;
	
	private String normalPassword;
	
	private String userPassword;
	
	private String userNm;
	
	private String phoneNumber;
	
	private LocalDate userBirth;
	
	private String userGender;
	
	private String lockYn;
	
	private String dormantYn;
	
	private String membership;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNormalPassword() {
		return normalPassword;
	}

	public void setNormalPassword(String normalPassword) {
		this.normalPassword = normalPassword;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public String getLockYn() {
		return lockYn;
	}

	public void setLockYn(String lockYn) {
		this.lockYn = lockYn;
	}

	public String getDormantYn() {
		return dormantYn;
	}

	public void setDormantYn(String dormantYn) {
		this.dormantYn = dormantYn;
	}

	public String getMembership() {
		return membership;
	}

	public void setMembership(String membership) {
		this.membership = membership;
	}

	
    

}
