package com.bmm.api.keyword;

public class SearchKeywordDTO {
	
	private String categoryCode;
	
	private String keywordType;
	
	private int totalSearchMin;
	
	private int totalSearchMax;
	
	private int pcSearchMin;
	
	private int pcSearchMax;
	
	private int mobileSearchMin;
	
	private int mobileSearchMax;
	
	private Long averageAdvMin;
	
	private Long averageAdvMax;
	
	private String keywordNm;
	
	private String userId;
	
	private String checkSelect;

	private int keywordCode;
	
	private String sortKey;
	
	private String sortOrder;
	
	
	
	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getKeywordType() {
		return keywordType;
	}

	public void setKeywordType(String keywordType) {
		this.keywordType = keywordType;
	}

	public int getTotalSearchMin() {
		return totalSearchMin;
	}

	public void setTotalSearchMin(int totalSearchMin) {
		this.totalSearchMin = totalSearchMin;
	}

	public int getTotalSearchMax() {
		return totalSearchMax;
	}

	public void setTotalSearchMax(int totalSearchMax) {
		this.totalSearchMax = totalSearchMax;
	}

	public int getPcSearchMin() {
		return pcSearchMin;
	}

	public void setPcSearchMin(int pcSearchMin) {
		this.pcSearchMin = pcSearchMin;
	}

	public int getPcSearchMax() {
		return pcSearchMax;
	}

	public void setPcSearchMax(int pcSearchMax) {
		this.pcSearchMax = pcSearchMax;
	}

	public int getMobileSearchMin() {
		return mobileSearchMin;
	}

	public void setMobileSearchMin(int mobileSearchMin) {
		this.mobileSearchMin = mobileSearchMin;
	}

	public int getMobileSearchMax() {
		return mobileSearchMax;
	}

	public void setMobileSearchMax(int mobileSearchMax) {
		this.mobileSearchMax = mobileSearchMax;
	}

	public Long getAverageAdvMin() {
		return averageAdvMin;
	}

	public void setAverageAdvMin(Long averageAdvMin) {
		this.averageAdvMin = averageAdvMin;
	}

	public Long getAverageAdvMax() {
		return averageAdvMax;
	}

	public void setAverageAdvMax(Long averageAdvMax) {
		this.averageAdvMax = averageAdvMax;
	}

	public String getKeywordNm() {
		return keywordNm;
	}

	public void setKeywordNm(String keywordNm) {
		this.keywordNm = keywordNm;
	}
	
	public SearchKeywordDTO(String categoryCode) {
        this.categoryCode = categoryCode;
    }
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getCheckSelect() {
		return checkSelect;
	}

	public void setCheckSelect(String checkSelect) {
		this.checkSelect = checkSelect;
	}

	public int getKeywordCode() {
		return keywordCode;
	}

	public void setKeywordCode(int keywordCode) {
		this.keywordCode = keywordCode;
	}
	
	public String getSortKey() {
		return sortKey;
	}

	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}


	public SearchKeywordDTO() {}
	

}
