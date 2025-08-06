package com.bmm.api.relKeyword;

public class RelKeywordDTO {
	
	private int rseq;
	
	private int keywordCode;
	
	private int relKeywordCode;
	
	private String relKeywordNm;
	
	private int searchMon;
	
	private int searchPc;
	
	private int searchMobile;
	
	private int clickPc;
	
	private int clickMobile;
	
	private int clickPersentPc;
	
	private int clickPersentMobile;
	
	private int averageAdv;
	
	private String competition;

	private String competitionNm;
	
	private int limitCount;
	
	public int getKeywordCode() {
		return keywordCode;
	}

	public void setKeywordCode(int keywordCode) {
		this.keywordCode = keywordCode;
	}

	public int getRelKeywordCode() {
		return relKeywordCode;
	}

	public void setRelKeywordCode(int relKeywordCode) {
		this.relKeywordCode = relKeywordCode;
	}

	public String getRelKeywordNm() {
		return relKeywordNm;
	}

	public void setRelKeywordNm(String relKeywordNm) {
		this.relKeywordNm = relKeywordNm;
	}

	public int getSearchMon() {
		return searchMon;
	}

	public void setSearchMon(int searchMon) {
		this.searchMon = searchMon;
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

	public int getClickPc() {
		return clickPc;
	}

	public void setClickPc(int clickPc) {
		this.clickPc = clickPc;
	}

	public int getClickMobile() {
		return clickMobile;
	}

	public void setClickMobile(int clickMobile) {
		this.clickMobile = clickMobile;
	}

	public int getClickPersentPc() {
		return clickPersentPc;
	}

	public void setClickPersentPc(int clickPersentPc) {
		this.clickPersentPc = clickPersentPc;
	}

	public int getClickPersentMobile() {
		return clickPersentMobile;
	}

	public void setClickPersentMobile(int clickPersentMobile) {
		this.clickPersentMobile = clickPersentMobile;
	}

	public int getAverageAdv() {
		return averageAdv;
	}

	public void setAverageAdv(int averageAdv) {
		this.averageAdv = averageAdv;
	}

	public String getCompetition() {
		return competition;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public String getCompetitionNm() {
		return competitionNm;
	}

	public void setCompetitionNm(String competitionNm) {
		this.competitionNm = competitionNm;
	}

	public int getRseq() {
		return rseq;
	}

	public void setRseq(int rseq) {
		this.rseq = rseq;
	}
	
	public RelKeywordDTO() {}
	
    public RelKeywordDTO(int keywordCode) {
        this.keywordCode = keywordCode;
    }

	public int getLimitCount() {
		return limitCount;
	}

	public void setLimitCount(int limitCount) {
		this.limitCount = limitCount;
	}
    

}
