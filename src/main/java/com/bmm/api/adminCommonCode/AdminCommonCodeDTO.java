package com.bmm.api.adminCommonCode;

import java.time.LocalDate;

public class AdminCommonCodeDTO {
	
	private String upperCode;
	
	private String upperCodeNm;
	
	private String commonCode;
	
	private String commonCodeNm;
	
	private String commonGroupCode;
	
	private String description;
	
	private String useYn;
	
	private String userId;
	
	private LocalDate insertDt;
	
	//
	private String searchValue;
	
	private String searchType;
	
	private int listView;
	
	private int page;
	
	private int totalCount;
	
	private int rseq;
	//

	public String getUpperCode() {
		return upperCode;
	}

	public void setUpperCode(String upperCode) {
		this.upperCode = upperCode;
	}

	public String getUpperCodeNm() {
		return upperCodeNm;
	}

	public void setUpperCodeNm(String upperCodeNm) {
		this.upperCodeNm = upperCodeNm;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDate getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(LocalDate insertDt) {
		this.insertDt = insertDt;
	}

	public String getCommonCode() {
		return commonCode;
	}

	public void setCommonCode(String commonCode) {
		this.commonCode = commonCode;
	}

	public String getCommonCodeNm() {
		return commonCodeNm;
	}

	public void setCommonCodeNm(String commonCodeNm) {
		this.commonCodeNm = commonCodeNm;
	}

	public String getCommonGroupCode() {
		return commonGroupCode;
	}

	public void setCommonGroupCode(String commonGroupCode) {
		this.commonGroupCode = commonGroupCode;
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
