package com.bmm.api.keyword;

import java.util.List;

public class KeywordDTO {
	
	
	private int keywordCode;
	
	private String keywordNm;
	
	private String categoryCode;
	
	private String keywordImg;
	
	private int keywordScore;
	
	private String keywordInfo;
	
	private String keywordType;
	
	private int rseq;
	
	private int searchPc;
	
	private int searchMobile;
	
	private Long averageAdv;
	
	private int productCnt;
	
	private String checkSelect;

	private Long totalSearch;
	
	private String sortKey;
	
	private String sortOther;
	
	private String keywordTypeNm;
	
	private List<KeywordCategoryDTO> keyCategory;
	
	private String RankName;
	
	private String userId;

	public int getProductCnt() {
		return productCnt;
	}

	public void setProductCnt(int productCnt) {
		this.productCnt = productCnt;
	}

	public int getKeywordCode() {
		return keywordCode;
	}

	public void setKeywordCode(int keywordCode) {
		this.keywordCode = keywordCode;
	}

	public String getKeywordNm() {
		return keywordNm;
	}

	public void setKeywordNm(String keywordNm) {
		this.keywordNm = keywordNm;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	public String getKeywordImg() {
		return keywordImg;
	}

	public void setKeywordImg(String keywordImg) {
		this.keywordImg = keywordImg;
	}

	public int getKeywordScore() {
		return keywordScore;
	}

	public void setKeywordScore(int keywordScore) {
		this.keywordScore = keywordScore;
	}

	public String getKeywordInfo() {
		return keywordInfo;
	}

	public void setKeywordInfo(String keywordInfo) {
		this.keywordInfo = keywordInfo;
	}

	public String getKeywordType() {
		return keywordType;
	}

	public void setKeywordType(String keywordType) {
		this.keywordType = keywordType;
	}

	public int getRseq() {
		return rseq;
	}

	public void setRseq(int rseq) {
		this.rseq = rseq;
	}

	public int getSearchPc() {
		return searchPc;
	}

	public void setSearchPc(int searchPc) {
		this.searchPc = searchPc;
	}

	public int getSearchMobile() {
		return searchMobile;
	}

	public void setSearchMobile(int searchMobile) {
		this.searchMobile = searchMobile;
	}

	public Long getAverageAdv() {
		return averageAdv;
	}

	public void setAverageAdv(Long averageAdv) {
		this.averageAdv = averageAdv;
	}

	public String getCheckSelect() {
		return checkSelect;
	}

	public void setCheckSelect(String checkSelect) {
		this.checkSelect = checkSelect;
	}

	public Long getTotalSearch() {
		return totalSearch;
	}

	public void setTotalSearch(Long totalSearch) {
		this.totalSearch = totalSearch;
	}

	public String getSortKey() {
		return sortKey;
	}

	public void setSortKey(String sortKey) {
		this.sortKey = sortKey;
	}

	public String getSortOther() {
		return sortOther;
	}

	public void setSortOther(String sortOther) {
		this.sortOther = sortOther;
	}

	public String getKeywordTypeNm() {
		return keywordTypeNm;
	}

	public void setKeywordTypeNm(String keywordTypeNm) {
		this.keywordTypeNm = keywordTypeNm;
	}

	public List<KeywordCategoryDTO> getKeyCategory() {
		return keyCategory;
	}

	public void setKeyCategory(List<KeywordCategoryDTO> keyCategory) {
		this.keyCategory = keyCategory;
	}

	public String getRankName() {
		return RankName;
	}

	public void setRankName(String rankName) {
		RankName = rankName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


}
