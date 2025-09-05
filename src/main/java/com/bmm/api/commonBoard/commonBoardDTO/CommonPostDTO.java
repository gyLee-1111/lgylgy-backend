package com.bmm.api.commonBoard.commonBoardDTO;

import java.time.LocalDateTime;

public class CommonPostDTO {
	
	private int postCode;
	
	private String boardCode;
	
	private String postNm;
	
	private String postInfo;
	
	private String noticeCheck;
	
	private int upperCode;
	
	private int dethp;
	
	private int viewCount;
	
	private String secretCheck;
	
	private String insertUserId;
	
	private LocalDateTime insertDt;
	
	private String commentCheck;
	
	private String answerCheck;
	
	private int commentCnt;
	
	private String searchType;
	
	private String searchValue;
	
	private int listView;
	
	private int page;
	
	private int totalCount;
	
	private int rseq;

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getBoardCode() {
		return boardCode;
	}

	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}

	public String getPostNm() {
		return postNm;
	}

	public void setPostNm(String postNm) {
		this.postNm = postNm;
	}

	public String getPostInfo() {
		return postInfo;
	}

	public void setPostInfo(String postInfo) {
		this.postInfo = postInfo;
	}

	public String getNoticeCheck() {
		return noticeCheck;
	}

	public void setNoticeCheck(String noticeCheck) {
		this.noticeCheck = noticeCheck;
	}

	public int getUpperCode() {
		return upperCode;
	}

	public void setUpperCode(int upperCode) {
		this.upperCode = upperCode;
	}

	public int getDethp() {
		return dethp;
	}

	public void setDethp(int dethp) {
		this.dethp = dethp;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public String getSecretCheck() {
		return secretCheck;
	}

	public void setSecretCheck(String secretCheck) {
		this.secretCheck = secretCheck;
	}

	public String getInsertUserId() {
		return insertUserId;
	}

	public void setInsertUserId(String insertUserId) {
		this.insertUserId = insertUserId;
	}

	public LocalDateTime getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(LocalDateTime insertDt) {
		this.insertDt = insertDt;
	}
	
	public String getCommentCheck() {
		return commentCheck;
	}

	public void setCommentCheck(String commentCheck) {
		this.commentCheck = commentCheck;
	}

	public String getAnswerCheck() {
		return answerCheck;
	}

	public void setAnswerCheck(String answerCheck) {
		this.answerCheck = answerCheck;
	}
	
	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	
	

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchValue() {
		return searchValue;
	}

	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
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

	public CommonPostEntity toEntity() {
		CommonPostEntity commonPostEntity = new CommonPostEntity();
		commonPostEntity.setPostCode(this.postCode);
		commonPostEntity.setPostNm(this.postNm);
		commonPostEntity.setPostInfo(this.postInfo);
		commonPostEntity.setNoticeCheck(this.noticeCheck);
		commonPostEntity.setSecretCheck(this.secretCheck);
		commonPostEntity.setBoardCode(this.boardCode);
		commonPostEntity.setInsertUserId(this.insertUserId);
		commonPostEntity.setUpperCode(this.upperCode);
		commonPostEntity.setDethp(this.dethp);
		commonPostEntity.setViewCount(this.viewCount);
		commonPostEntity.setCommentCheck(this.commentCheck);
		commonPostEntity.setAnswerCheck(this.answerCheck);
	    return commonPostEntity;
	}
	


}
