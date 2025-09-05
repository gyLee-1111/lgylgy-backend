package com.bmm.api.commonBoard;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bmm.api.commonBoard.commonBoardDTO.BoardFileDTO;
import com.bmm.api.commonBoard.commonBoardDTO.CommonBoardDTO;
import com.bmm.api.commonBoard.commonBoardDTO.CommonCommentDTO;
import com.bmm.api.commonBoard.commonBoardDTO.CommonPostDTO;
import com.bmm.api.commonBoard.commonBoardDTO.CommonPostEntity;
import com.bmm.api.commonBoard.commonBoardDTO.FileDownloadDTO;
import com.bmm.api.commonUtil.DropzoneFileUpload;

@Service
public class CommonBoardService {
	
	@Autowired
	private CommonBoardMapper commonBoardMapper;
	
	
	public CommonBoardDTO getDetailBoard(String boardCode) {
		return commonBoardMapper.getDetailBoard(boardCode);
	}
	
	public List<CommonPostDTO> getListPost(CommonPostDTO commonPostDto) {
		return commonBoardMapper.getListPost(commonPostDto);
	}
	/*
	@Transactional
	public void insertPost(CommonPostDTO commonPostDto, List<MultipartFile> files) {

		
		int nextPostCode = findpostCode();
		commonPostDto.setDethp(1);
		commonPostDto.setPostCode(nextPostCode);
		
		CommonPostEntity commonPostEntity = commonPostDto.toEntity();
		
		
		commonBoardMapper.insertPost(commonPostEntity);
		
		if (files != null && !files.isEmpty()) {
			for (MultipartFile file : files) {
				if (!file.isEmpty()) {
					try {
                        saveFile(file, nextPostCode, commonPostDto.getInsertUserId());
                    } catch (IOException e) {
                        e.printStackTrace();
                        // 파일 저장 실패 시 로깅만 하고 넘어감 (실제 운영에서는 DB 롤백 등 고려)
                    }
				}
			}
			
			
		}
		
		
	}
	
	private void saveFile(MultipartFile file, int postCode, String userId) throws IOException {
		
		String basePath = System.getProperty("user.dir") + "/src/main/resources/static/upload/board";
		
		String savedName = DropzoneFileUpload.saveFile(file, basePath);
		
		String saveFileNm = basePath + File.separator + savedName;
		
		int nextFileNo = findFileNo();
		BoardFileDTO boardFileDto = new BoardFileDTO();
		boardFileDto.setFileNm(file.getOriginalFilename());
		boardFileDto.setFileNo(nextFileNo);
		boardFileDto.setSaveFileNm(saveFileNm);
		boardFileDto.setFileSize(file.getSize());
		boardFileDto.setPostCode(postCode);
		boardFileDto.setUserId(userId);

		// DB에 파일 정보 저장 (Mapper 메서드 필요)
		commonBoardMapper.insertFile(boardFileDto);
	}
	*/
	public int insertPost(CommonPostDTO commonPostDto) {
			
			int nextPostCode = findpostCode();
			commonPostDto.setDethp(1);
			commonPostDto.setPostCode(nextPostCode);
			CommonPostEntity commonPostEntity = commonPostDto.toEntity();
			
			
			commonBoardMapper.insertPost(commonPostEntity);
			return nextPostCode;
		
	}
	public void insertFile(MultipartFile file, int postCode) throws IOException {
		
			if (!file.isEmpty()) {
		//		int currentMaxFileNo = findFileNo();
		//		int nextFileNo = currentMaxFileNo + 1;
				String uploadFolder = "upload/board";
				String basePath = System.getProperty("user.dir") + "/src/main/resources/static/" + uploadFolder;
				String savedName = DropzoneFileUpload.saveFile(file, basePath);
				
				String saveFileNm = savedName;

				
				BoardFileDTO boardFileDto = new BoardFileDTO();
				boardFileDto.setFileNm(file.getOriginalFilename());
		//		boardFileDto.setFileNo(nextFileNo++);
				boardFileDto.setSaveFileNm(saveFileNm);
				boardFileDto.setFileSize(file.getSize());
				boardFileDto.setPostCode(postCode);
			
				// DB에 파일 정보 저장 (Mapper 메서드 필요)
				commonBoardMapper.insertFile(boardFileDto);
			}
	}
	public int insertAnswerPost(CommonPostDTO commonPostDto) {
		
		int nextPostCode = findpostCode();
		
		commonPostDto.setDethp((commonPostDto.getDethp())+1);
		commonPostDto.setPostCode(nextPostCode);
		CommonPostEntity commonPostEntity = commonPostDto.toEntity();
		
		commonBoardMapper.insertPost(commonPostEntity);
		return nextPostCode;
	
}
	
	private int findpostCode() {
	    Integer lastCode = commonBoardMapper.findpostCode(); // 예: 3
	    return (lastCode != 0) ? lastCode + 1 : 1;
	}
//	private int findFileNo() {
//	    Integer lastNo = commonBoardMapper.findFileNo(); // 예: 3
//	    return lastNo;
//	}
	public CommonPostDTO getDetailPost(int postCode) {
		return commonBoardMapper.getDetailPost(postCode);
	}
	
	public List<BoardFileDTO> getDetailFile(int postCode) {
		return commonBoardMapper.getDetailFile(postCode);
	}

	public FileDownloadDTO fileDownload(int fileNo) {
		return commonBoardMapper.fileDownload(fileNo);
	}

	public List<CommonCommentDTO> getListComment(int postCode) {
		
		return commonBoardMapper.getListComment(postCode);
	}

	public void insertComment(CommonCommentDTO commonCommentDto) {
		commonCommentDto.setDethp(1);
		commonBoardMapper.insertComment(commonCommentDto);
	}

	public void insertReComment(CommonCommentDTO commonCommentDto) {
		
		commonCommentDto.setDethp((commonCommentDto.getDethp())+1);
		commonBoardMapper.insertComment(commonCommentDto);
	}
	public CommonCommentDTO getComment(int commentCode) {
		return commonBoardMapper.getComment(commentCode);
	}

	public int getCountPost(CommonPostDTO commonPostDto) {

		return commonBoardMapper.getCountPost(commonPostDto);
	}

	public List<CommonPostDTO> getListNoticePost(String boardCode) {
		
		return commonBoardMapper.getListNoticePost(boardCode);
	}
	
	
	

}
