package com.bmm.api.commonBoard.commonBoardDTO;

import java.time.LocalDateTime;

public class CommonCommentResponseDTO {
	
	private int commentCode;
	
	private int postCode;
	
	private String commentContent;
	
	private int upperCode;
	
	private int dethp;
	
	private String userId;
	
	private String insertUserId;
	
	private LocalDateTime insertDt;

	public int getCommentCode() {
		return commentCode;
	}

	public void setCommentCode(int commentCode) {
		this.commentCode = commentCode;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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



}
