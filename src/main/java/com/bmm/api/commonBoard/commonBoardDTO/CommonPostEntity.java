package com.bmm.api.commonBoard.commonBoardDTO;

import java.time.LocalDateTime;
import java.util.List;

public class CommonPostEntity {

	
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
	
	private List<BoardFileDTO> boardFileDto;
	
	private String commentCheck;
	
	private String answerCheck;

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

	public List<BoardFileDTO> getBoardFileDto() {
		return boardFileDto;
	}

	public void setBoardFileDto(List<BoardFileDTO> boardFileDto) {
		this.boardFileDto = boardFileDto;
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




	
}
