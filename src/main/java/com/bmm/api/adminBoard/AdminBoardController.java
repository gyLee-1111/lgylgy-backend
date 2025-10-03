package com.bmm.api.adminBoard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmm.api.adminMenu.AdminUserRoleDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class AdminBoardController {
	
	@Autowired
	private AdminBoardService adminBoardService;

	
	
	
	@GetMapping("/getListBoard")
	public ResponseEntity<List<AdminBoardDTO>> getListBoard(HttpServletRequest request) throws Exception {
		
		List<AdminBoardDTO> list = adminBoardService.getListBoard();
		
		return ResponseEntity.ok(list);
	}
	
/*	@PostMapping("/insertBoard")
	public ResponseEntity<String> insertBoard(@RequestBody AdminBoardDTO adminBoardDto) {
		try {
			System.out.println("asd");
	    	adminMainService.insertBoard(adminBoardDto);
			return ResponseEntity.ok("등록완료");
		 } catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("게시판 등록 실패입니다.");
		 }
    	
	}
	*/
	
	@PostMapping("/insertBoard")
	public ResponseEntity<String> insertBoard(@RequestBody BoardInsertRequestDTO request) {
		try {
			System.out.println("asd");
			adminBoardService.insertBoard(request.getAdminBoardDto(), request.getAdminBoardRoleDto() );
			return ResponseEntity.ok("등록완료");
		 } catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("게시판 등록 실패입니다.");
		 }
	}
	
	@GetMapping("/getDetailBoard")
	public ResponseEntity<BoardDetailResponseDTO> getDetailBoard(@RequestParam String boardCode) throws Exception {
		
		AdminBoardDTO result = adminBoardService.getDetailBoard(boardCode);
		List<AdminBoardRoleDTO> roleResult = adminBoardService.getDetailBoardrole(boardCode);
		List<AdminUserRoleDTO> roleAllResult = adminBoardService.getListRole();
		
		BoardDetailResponseDTO response = new BoardDetailResponseDTO();
		
		response.setAdminBoardDto(result);
		response.setAdminBoardRoleDto(roleResult);
		response.setAllBoardRoleDto(roleAllResult);
		return ResponseEntity.ok(response);
	    	
	}
	
	/*
	@PostMapping("/updateBoard")
	public ResponseEntity<String> updateBoard(@RequestBody AdminBoardDTO adminBoardDto) {
		try {
			System.out.println("asd");
	    	adminMainService.updateBoard(adminBoardDto);
			return ResponseEntity.ok("수정완료");
		 } catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("게시판 수정 실패입니다.");
		 }
	}
	*/
	@PostMapping("/updateBoard")
	public ResponseEntity<String> updateBoard(@RequestBody BoardInsertRequestDTO request) {
		try {
			System.out.println("asd");
			adminBoardService.updateBoard(request.getAdminBoardDto(), request.getAdminBoardRoleDto());
			return ResponseEntity.ok("수정완료");
		 } catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("게시판 수정 실패입니다.");
		 }
	}
	
	@PostMapping("/deleteBoard")
	public ResponseEntity<String> deleteBoard(@RequestParam String boardCode) throws Exception {
		
		adminBoardService.deleteBoard(boardCode);
		return ResponseEntity.ok("삭제완료");
	}
	
	
	
	
}