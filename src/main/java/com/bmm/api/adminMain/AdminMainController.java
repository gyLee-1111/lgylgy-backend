package com.bmm.api.adminMain;

import java.util.ArrayList;
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

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class AdminMainController {
	
	@Autowired
	private AdminMainService adminMainService;

	
	@GetMapping("/getAdminMenu")
	public ResponseEntity<List<AdminMenuDTO>> getAdminMenu(@RequestParam String roleCode) throws Exception {
		System.out.println("#################"+roleCode);
		List<AdminMenuDTO> list = adminMainService.getAdminMenu(roleCode);
		System.out.println("상위 메뉴 수: " + list.size());
		List<AdminMenuDTO> sublist = adminMainService.getAdminSubMenu(roleCode);
		System.out.println("하위 메뉴 수: " + sublist.size());
		for(AdminMenuDTO parent : list) {
			parent.setChildren(new ArrayList<>());
			for (AdminMenuDTO child : sublist) {
				if(parent.getMenuCode() == child.getParentCode()) {
				parent.getChildren().add(child);
				}
			}
		}
		
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("/getListBoard")
	public ResponseEntity<List<AdminBoardDTO>> getListBoard(HttpServletRequest request) throws Exception {
		
		List<AdminBoardDTO> list = adminMainService.getListBoard();
		
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
	    	adminMainService.insertBoard(request.getAdminBoardDto(), request.getAdminBoardRoleDto() );
			return ResponseEntity.ok("등록완료");
		 } catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("게시판 등록 실패입니다.");
		 }
    	
	}
	
	@GetMapping("/getDetailBoard")
	public ResponseEntity<BoardDetailResponseDTO> getDetailKeyword(@RequestParam String boardCode) throws Exception {
		
		AdminBoardDTO result = adminMainService.getDetailBoard(boardCode);
		List<AdminBoardRoleDTO> roleResult = adminMainService.getDetailBoardrole(boardCode);
		
		BoardDetailResponseDTO response = new BoardDetailResponseDTO();
		
		response.setAdminBoardDto(result);
		response.setAdminBoardRoleDto(roleResult);
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
	    	adminMainService.updateBoard(request.getAdminBoardDto(), request.getAdminBoardRoleDto());
			return ResponseEntity.ok("수정완료");
		 } catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("게시판 수정 실패입니다.");
		 }
    	
	}
	@PostMapping("/deleteBoard")
	public ResponseEntity<String> deleteBoard(@RequestParam String boardCode) throws Exception {
		
		adminMainService.deleteBoard(boardCode);
		return ResponseEntity.ok("삭제완료");
	}
	
	@GetMapping("/getListRole")
	public ResponseEntity<List<AdminUserRoleDTO>> getListRole(HttpServletRequest request) throws Exception {
		
		List<AdminUserRoleDTO> list = adminMainService.getListRole();
		
		return ResponseEntity.ok(list);
	}
	
}