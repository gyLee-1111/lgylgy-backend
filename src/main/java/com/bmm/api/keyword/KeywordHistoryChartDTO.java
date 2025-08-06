package com.bmm.api.keyword;

import java.util.Date;

public class KeywordHistoryChartDTO {
	
	private int keywordCode;

	public int getKeywordCode() {
		return keywordCode;
	}

	public void setKeywordCode(int keywordCode) {
		this.keywordCode = keywordCode;
	}

	private Date date;
	
	private int totalCnt;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	
}
