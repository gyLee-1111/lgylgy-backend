package com.bmm.api.reviewPop;

import java.util.Date;

public class ReviewPopDTO {
	
	private int reviewCode;
	
	private int keywordCode;
	
	private String productCode;
	
	private int reviewScore;
	
	private String reviewInfo;
	
	private Date insertDt;
	
	private String insertUserId;
	
	private Date updateDt;
	
	private String updateUpserId;

	public int getReviewCode() {
		return reviewCode;
	}

	public void setReviewCode(int reviewCode) {
		this.reviewCode = reviewCode;
	}
	
	public int getKeywordCode() {
		return keywordCode;
	}

	public void setKeywordCode(int keywordCode) {
		this.keywordCode = keywordCode;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public String getReviewInfo() {
		return reviewInfo;
	}

	public void setReviewInfo(String reviewInfo) {
		this.reviewInfo = reviewInfo;
	}

	public Date getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(Date insertDt) {
		this.insertDt = insertDt;
	}

	public String getInsertUserId() {
		return insertUserId;
	}

	public void setInsertUserId(String insertUserId) {
		this.insertUserId = insertUserId;
	}

	public Date getUpdateDt() {
		return updateDt;
	}

	public void setUpdateDt(Date updateDt) {
		this.updateDt = updateDt;
	}

	public String getUpdateUpserId() {
		return updateUpserId;
	}

	public void setUpdateUpserId(String updateUpserId) {
		this.updateUpserId = updateUpserId;
	}

	public ReviewPopDTO() {}
	
    public ReviewPopDTO(String productCode) {
        this.productCode = productCode;
    }

}
