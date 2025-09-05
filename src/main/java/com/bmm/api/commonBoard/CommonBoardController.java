package com.bmm.api.commonBoard;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriUtils;

import com.bmm.api.commonBoard.commonBoardDTO.BoardFileDTO;
import com.bmm.api.commonBoard.commonBoardDTO.CommonBoardDTO;
import com.bmm.api.commonBoard.commonBoardDTO.CommonCommentDTO;
import com.bmm.api.commonBoard.commonBoardDTO.CommonCommentResponseDTO;
import com.bmm.api.commonBoard.commonBoardDTO.CommonPostDTO;
import com.bmm.api.commonBoard.commonBoardDTO.FileDownloadDTO;
import com.bmm.api.commonBoard.commonBoardDTO.PostDetailResponseDTO;
import com.bmm.api.commonBoard.commonBoardDTO.PostResponseDTO;

@RestController
@RequestMapping("user/board")
public class CommonBoardController {

	@Autowired
	private CommonBoardService commonBoardService;
	
	@GetMapping("/getDetailBoard")
	public ResponseEntity<CommonBoardDTO> getDetailBoard(@RequestParam String boardCode) throws Exception {
		
		System.out.println("게시판코드"+boardCode);
		
		CommonBoardDTO result = commonBoardService.getDetailBoard(boardCode);
		
		return ResponseEntity.ok(result);
	    	
	}
	@PostMapping("/getListPost")
	public ResponseEntity<PostResponseDTO> getListPost(@RequestBody CommonPostDTO commonPostDto) throws Exception {
		
		System.out.println("받은 boardCode: " + commonPostDto.getBoardCode());
		PostResponseDTO postResponseDto = new PostResponseDTO();
		
		postResponseDto.setTotalCount(commonBoardService.getCountPost(commonPostDto));
		System.out.println("토탈 숫자" + commonPostDto.getTotalCount());
	//	System.out.println(System.getProperty("user.dir"));
		List<CommonPostDTO> list = commonBoardService.getListPost(commonPostDto);
		
		
		postResponseDto.setCommonPostDto(list);
		
		
		return ResponseEntity.ok(postResponseDto);
	}
	/*
	@GetMapping("/getListPost")
	public ResponseEntity<List<CommonPostDTO>> getListPost(@RequestParam String boardCode) throws Exception {
		
	
	//	System.out.println(System.getProperty("user.dir"));
		List<CommonPostDTO> list = commonBoardService.getListPost(boardCode);
		
		return ResponseEntity.ok(list);
	}
	*/
	/*
	@PostMapping("/insertPost")
	public ResponseEntity<?> insertPost(@RequestPart("post") CommonPostDTO commonPostDto,
		    @RequestPart(value = "files", required = false) List<MultipartFile> files) {
		
		try {
			commonBoardService.insertPost(commonPostDto,files);
			return ResponseEntity.ok("등록완료");
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("게시판 등록 실패입니다.");
		}
	}
	*/
	@PostMapping("/insertPost")
	public ResponseEntity<?> insertPost(@RequestBody CommonPostDTO commonPostDto ,Authentication authentication) {
		try {
			CommonBoardDTO commonBoardDto = new CommonBoardDTO();
			commonBoardDto = commonBoardService.getDetailBoard(commonPostDto.getBoardCode());
			commonPostDto.setAnswerCheck(commonBoardDto.getUseAnswer());
			commonPostDto.setCommentCheck(commonBoardDto.getUseComment());
			String userId = (String)authentication.getPrincipal();
			System.out.println("12321312312312312" + userId);
			commonPostDto.setInsertUserId(userId);
			commonBoardService.insertPost(commonPostDto);
			return ResponseEntity.ok(commonPostDto.getPostCode());
			
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("게시판 등록 실패입니다.");
		}
	}
	@PostMapping("/insertFile")
	public ResponseEntity<?> insertFile(@RequestParam("file") MultipartFile file,
			 @RequestParam("postCode") int postCode) throws IOException {
		System.out.println("게시물코드"+postCode);
		commonBoardService.insertFile(file,postCode);
	    return ResponseEntity.ok("업로드 성공");
	}
	
	@PostMapping("/insertAnswerPost")
	public ResponseEntity<?> insertAnswerPost(@RequestBody CommonPostDTO commonPostDto ,Authentication authentication) {
		try {
			System.out.println("###########" + commonPostDto.getUpperCode());
			CommonBoardDTO commonBoardDto = new CommonBoardDTO();
			commonBoardDto = commonBoardService.getDetailBoard(commonPostDto.getBoardCode());
			commonPostDto.setAnswerCheck(commonBoardDto.getUseAnswer());
			commonPostDto.setCommentCheck(commonBoardDto.getUseComment());
			String userId = (String)authentication.getPrincipal();
			System.out.println("12321312312312312" + userId);
			commonPostDto.setInsertUserId(userId);
			commonBoardService.insertAnswerPost(commonPostDto);
			return ResponseEntity.ok(commonPostDto.getPostCode());
			
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("게시판 등록 실패입니다.");
		}
	}
	
	@GetMapping("/getDetailPost")
	public ResponseEntity<PostDetailResponseDTO> getDetailPost(@RequestParam int postCode) throws Exception {
		System.out.println("게시물코드"+postCode);
		
		CommonPostDTO result = commonBoardService.getDetailPost(postCode);
		List<BoardFileDTO> fileResult = commonBoardService.getDetailFile(postCode);
		
		PostDetailResponseDTO response = new PostDetailResponseDTO();
		
		//System.out.println("asdsadadsadasdasd"+((BoardFileDTO) fileResult).getPostCode());
		response.setCommonPostDto(result);
		response.setBoardFileDto(fileResult);
	//	System.out.println("asdsadadsadasdasd"+response.getBoardFileDto());
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getDetailUpperPost")
	public ResponseEntity<PostDetailResponseDTO> getDetailUpperPost(@RequestParam int postCode) throws Exception {
		System.out.println("게시물코드"+postCode);
		
		CommonPostDTO result = commonBoardService.getDetailPost(postCode);
		if (result.getUpperCode() != 0) {
		
		List<BoardFileDTO> fileResult = commonBoardService.getDetailFile(result.getUpperCode());
		result = commonBoardService.getDetailPost(result.getUpperCode());
		
		PostDetailResponseDTO response = new PostDetailResponseDTO();
		
		//System.out.println("asdsadadsadasdasd"+((BoardFileDTO) fileResult).getPostCode());
		response.setCommonPostDto(result);
		response.setBoardFileDto(fileResult);
		
		return ResponseEntity.ok(response);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@GetMapping("/fileDownload")
	public ResponseEntity<Resource> fileDownload(@RequestParam int fileNo) throws IOException {
		
		String uploadFolder = "upload/board/";
	    String basePath = System.getProperty("user.dir") + "/src/main/resources/static/" + uploadFolder;
		
		FileDownloadDTO fileDownloadDto = commonBoardService.fileDownload(fileNo);
		
		Resource resource = new FileSystemResource(basePath + fileDownloadDto.getSaveFileNm());
		String encodedFileName = UriUtils.encode(fileDownloadDto.getFileNm(), StandardCharsets.UTF_8);
		
		HttpHeaders headers = new HttpHeaders();
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + encodedFileName + "\"");
	    System.out.println("File path: " + basePath + fileDownloadDto.getSaveFileNm());
	    System.out.println("Content-Disposition: attachment; filename=\"" + encodedFileName + "\"; filename*=UTF-8''" + encodedFileName);
	    
	    String contentType = Files.probeContentType(Paths.get(basePath + fileDownloadDto.getSaveFileNm()));
	    if (contentType == null) {
	        contentType = "application/octet-stream";
	    }
	    System.out.println("Content-Type: " + contentType);
	    
	    headers.add(HttpHeaders.CONTENT_TYPE, contentType);
	    
		return ResponseEntity.ok()
				.headers(headers)
	            .body(resource);
		
	}
	
	@GetMapping("/getListComment")
	public ResponseEntity<List<CommonCommentDTO>> getListComment(@RequestParam int postCode) throws Exception {
	
	//	System.out.println(System.getProperty("user.dir"));
		List<CommonCommentDTO> list = commonBoardService.getListComment(postCode);
		
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/insertComment")
	public ResponseEntity<?> insertComment(@RequestBody CommonCommentDTO commonCommentDto ,Authentication authentication) {
		try {
			String userId = (String)authentication.getName();
			commonCommentDto.setUserId(userId);
			commonBoardService.insertComment(commonCommentDto);
			return ResponseEntity.ok(commonCommentDto);
			
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("리플 등록 실패입니다.");
		}
	}
	@PostMapping("/insertReComment")
	public ResponseEntity<?> insertReComment(@RequestBody CommonCommentResponseDTO commonCommentResponseDto ,Authentication authentication) {
		try {
			int commentCode = commonCommentResponseDto.getCommentCode();
			System.out.println("댓글코드"+commentCode);
			CommonCommentDTO commonCommentDto = new CommonCommentDTO();
			commonCommentDto = commonBoardService.getComment(commentCode);
			
			
			commonCommentDto.setCommentContent(commonCommentResponseDto.getCommentContent());
			commonCommentDto.setUpperCode(commentCode);
			
			String userId = (String)authentication.getName();
			commonCommentDto.setUserId(userId);
			commonBoardService.insertReComment(commonCommentDto);
			return ResponseEntity.ok(commonCommentDto);
			
		} catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("리플 등록 실패입니다.");
		}
	}
	@GetMapping("/getListNoticePost")
	public ResponseEntity<List<CommonPostDTO>> getListNoticePost(@RequestParam String boardCode) throws Exception {
		List<CommonPostDTO> list = commonBoardService.getListNoticePost(boardCode);
		
		return ResponseEntity.ok(list);
	}
	
}
