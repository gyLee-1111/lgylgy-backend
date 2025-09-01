package com.bmm.api.commonBoard;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.bmm.api.commonBoard.commonBoardDTO.BoardFileDTO;
import com.bmm.api.commonBoard.commonBoardDTO.CommonBoardDTO;
import com.bmm.api.commonBoard.commonBoardDTO.CommonCommentDTO;
import com.bmm.api.commonBoard.commonBoardDTO.CommonPostDTO;
import com.bmm.api.commonBoard.commonBoardDTO.CommonPostEntity;
import com.bmm.api.commonBoard.commonBoardDTO.FileDownloadDTO;

@Mapper
public interface CommonBoardMapper {
	
	public CommonBoardDTO getDetailBoard(String boardCode);
	
	public List<CommonPostDTO> getListPost(String boardCode);
	
	public void insertPost(CommonPostEntity commonPostEntity);
	
	public int findpostCode();
	
	public void insertFile(BoardFileDTO boardFileDto);
	
	public CommonPostDTO getDetailPost(int postCode);
	
	public List<BoardFileDTO> getDetailFile(int postCode);
	
	public int findFileNo();

	public FileDownloadDTO fileDownload(int fileNo);

	public List<CommonCommentDTO> getListComment(int postCode);

	public void insertComment(CommonCommentDTO commonCommentDto);
	
	public void insertReComment(CommonCommentDTO commonCommentDto);

	public CommonCommentDTO getComment(int commentCode);
	
	
}
