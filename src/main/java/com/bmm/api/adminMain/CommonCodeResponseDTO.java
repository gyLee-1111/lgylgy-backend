package com.bmm.api.adminMain;

import java.util.List;

public class CommonCodeResponseDTO {
	
	private int totalCount;
	
	private List<AdminCommonCodeDTO> adminCommonCodeDto;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public List<AdminCommonCodeDTO> getAdminCommonCodeDto() {
		return adminCommonCodeDto;
	}

	public void setAdminCommonCodeDto(List<AdminCommonCodeDTO> adminCommonCodeDto) {
		this.adminCommonCodeDto = adminCommonCodeDto;
	}

	
	

}
