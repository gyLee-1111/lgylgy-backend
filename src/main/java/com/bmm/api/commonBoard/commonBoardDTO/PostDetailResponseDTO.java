package com.bmm.api.commonBoard.commonBoardDTO;

import java.util.List;

public class PostDetailResponseDTO {
	
	private CommonPostDTO commonPostDto;
	
	private List<BoardFileDTO> boardFileDto;

	public CommonPostDTO getCommonPostDto() {
		return commonPostDto;
	}

	public void setCommonPostDto(CommonPostDTO commonPostDto) {
		this.commonPostDto = commonPostDto;
	}

	public List<BoardFileDTO> getBoardFileDto() {
		return boardFileDto;
	}

	public void setBoardFileDto(List<BoardFileDTO> boardFileDto) {
		this.boardFileDto = boardFileDto;
	}



}
