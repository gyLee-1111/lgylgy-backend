package com.bmm.api.commonBoard.commonBoardDTO;

import java.time.LocalDateTime;

public class BoardFileDTO {
	
	private String fileNm;
	
	private int fileNo;
	
	private String saveFileNm;
	
	private long fileSize;
	
	private int postCode;
	
	private String userId;
	
	private LocalDateTime insertDt;

	public String getFileNm() {
		return fileNm;
	}

	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}

	public int getFileNo() {
		return fileNo;
	}

	public void setFileNo(int fileNo) {
		this.fileNo = fileNo;
	}

	public String getSaveFileNm() {
		return saveFileNm;
	}

	public void setSaveFileNm(String saveFileNm) {
		this.saveFileNm = saveFileNm;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public LocalDateTime getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(LocalDateTime insertDt) {
		this.insertDt = insertDt;
	}




	

}
