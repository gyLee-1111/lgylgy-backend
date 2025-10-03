package com.bmm.api.adminUser;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AdminUserDTO {
	
	private String email;
	
	private String userId;
	
	private String normalPassword;
	
	private String userPassword;
	
	private String userNm;
	
	private String phoneNumber;
	
	private LocalDate userBirth;
	
	private String userGender;
	
	private String userGenderNm;
	
	private String lockYn;
	
	private String dormantYn;
	
	private String membership;
	
	private String membershipNm;
	
	private LocalDateTime insertDt;
	
	private String searchValue;
	
	private String searchType;
	
	private int listView;
	
	private int page;
	
	private int totalCount;
	
	private int rseq;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getUserGenderNm() {
		return userGenderNm;
	}

	public void setUserGenderNm(String userGenderNm) {
		this.userGenderNm = userGenderNm;
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

	public String getMembershipNm() {
		return membershipNm;
	}

	public void setMembershipNm(String membershipNm) {
		this.membershipNm = membershipNm;
	}

	public LocalDateTime getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(LocalDateTime insertDt) {
		this.insertDt = insertDt;
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

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public int getListView() {
		return listView;
	}

	public void setListView(int listView) {
		this.listView = listView;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getRseq() {
		return rseq;
	}

	public void setRseq(int rseq) {
		this.rseq = rseq;
	}


    

}
