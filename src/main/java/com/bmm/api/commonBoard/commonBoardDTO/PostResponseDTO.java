package com.bmm.api.commonBoard.commonBoardDTO;

import java.util.List;

public class PostResponseDTO {
	
	private int totalCount;
	
	private List<CommonPostDTO> commonPostDto;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<CommonPostDTO> getCommonPostDto() {
		return commonPostDto;
	}

	public void setCommonPostDto(List<CommonPostDTO> commonPostDto) {
		this.commonPostDto = commonPostDto;
	}

	

}
