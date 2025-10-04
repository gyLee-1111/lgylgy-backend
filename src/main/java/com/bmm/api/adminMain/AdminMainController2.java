//package com.bmm.api.adminMain;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.bmm.api.commonBoard.commonBoardDTO.CommonCommentDTO;
//import com.bmm.api.logIn.LogInResponseDTO;
//import com.bmm.api.logIn.UserDTO;
//
//import jakarta.servlet.http.HttpServletRequest;
//
//@RestController
//@RequestMapping("admin")
//public class AdminMainController2 {
//	
//	@Autowired
//	private AdminMainService adminMainService;
//
//	
//	@GetMapping("/getAdminMenu")
//	public ResponseEntity<List<AdminMenuDTO>> getAdminMenu(@RequestParam String roleCode) throws Exception {
//		System.out.println("#################"+roleCode);
//		List<AdminMenuDTO> list = adminMainService.getAdminMenu(roleCode);
//		System.out.println("상위 메뉴 수: " + list.size());
//		List<AdminMenuDTO> sublist = adminMainService.getAdminSubMenu(roleCode);
//		System.out.println("하위 메뉴 수: " + sublist.size());
//		for(AdminMenuDTO parent : list) {
//			parent.setChildren(new ArrayList<>());
//			for (AdminMenuDTO child : sublist) {
//				if(parent.getMenuCode() == child.getParentCode()) {
//				parent.getChildren().add(child);
//				}
//			}
//		}
//		
//		return ResponseEntity.ok(list);
//	}
//	
//	
//	@GetMapping("/getListBoard")
//	public ResponseEntity<List<AdminBoardDTO>> getListBoard(HttpServletRequest request) throws Exception {
//		
//		List<AdminBoardDTO> list = adminMainService.getListBoard();
//		
//		return ResponseEntity.ok(list);
//	}
//	
///*	@PostMapping("/insertBoard")
//	public ResponseEntity<String> insertBoard(@RequestBody AdminBoardDTO adminBoardDto) {
//		try {
//			System.out.println("asd");
//	    	adminMainService.insertBoard(adminBoardDto);
//			return ResponseEntity.ok("등록완료");
//		 } catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("게시판 등록 실패입니다.");
//		 }
//    	
//	}
//	*/
//	
//	@GetMapping("/getListMenu")
//	public ResponseEntity<List<AdminMenuDTO>> getListMenu(@RequestParam String menuType) throws Exception {
//		
//		List<AdminMenuDTO> list = adminMainService.getListMenu(menuType);
//		
//		return ResponseEntity.ok(list);
//	}
//	
//	@PostMapping("/insertBoard")
//	public ResponseEntity<String> insertBoard(@RequestBody BoardInsertRequestDTO request) {
//		try {
//			System.out.println("asd");
//	    	adminMainService.insertBoard(request.getAdminBoardDto(), request.getAdminBoardRoleDto() );
//			return ResponseEntity.ok("등록완료");
//		 } catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("게시판 등록 실패입니다.");
//		 }
//    	
//	}
//	
//	@GetMapping("/getDetailBoard")
//	public ResponseEntity<BoardDetailResponseDTO> getDetailBoard(@RequestParam String boardCode) throws Exception {
//		
//		AdminBoardDTO result = adminMainService.getDetailBoard(boardCode);
//		List<AdminBoardRoleDTO> roleResult = adminMainService.getDetailBoardrole(boardCode);
//		
//		BoardDetailResponseDTO response = new BoardDetailResponseDTO();
//		
//		response.setAdminBoardDto(result);
//		response.setAdminBoardRoleDto(roleResult);
//		return ResponseEntity.ok(response);
//	    	
//	}
//	/*
//	@PostMapping("/updateBoard")
//	public ResponseEntity<String> updateBoard(@RequestBody AdminBoardDTO adminBoardDto) {
//		try {
//			System.out.println("asd");
//	    	adminMainService.updateBoard(adminBoardDto);
//			return ResponseEntity.ok("수정완료");
//		 } catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("게시판 수정 실패입니다.");
//		 }
//    	
//	}
//	*/
//	@PostMapping("/updateBoard")
//	public ResponseEntity<String> updateBoard(@RequestBody BoardInsertRequestDTO request) {
//		try {
//			System.out.println("asd");
//	    	adminMainService.updateBoard(request.getAdminBoardDto(), request.getAdminBoardRoleDto());
//			return ResponseEntity.ok("수정완료");
//		 } catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("게시판 수정 실패입니다.");
//		 }
//    	
//	}
//	@PostMapping("/deleteBoard")
//	public ResponseEntity<String> deleteBoard(@RequestParam String boardCode) throws Exception {
//		
//		adminMainService.deleteBoard(boardCode);
//		return ResponseEntity.ok("삭제완료");
//	}
//	
//	@GetMapping("/getListRole")
//	public ResponseEntity<List<AdminUserRoleDTO>> getListRole(HttpServletRequest request) throws Exception {
//		
//		List<AdminUserRoleDTO> list = adminMainService.getListRole();
//		
//		return ResponseEntity.ok(list);
//	}
//	@GetMapping("/getDetailMenu")
//	public ResponseEntity<MenuDetailResponseDTO> getDetailMenu(@RequestParam int menuCode) throws Exception {
//		
//		AdminMenuDTO result = adminMainService.getDetailMenu(menuCode);
//		
//		//String parentNm = adminMainService.getParentNm(result.getParentCode());
//		
//	//	result.setParentNm(parentNm);
//		
//		List<AdminMenuRoleDTO> roleResult = adminMainService.getDetailMenuRole(menuCode);
//		
//		List<AdminUserRoleDTO> roleAllResult = adminMainService.getListRole();
//		
//		MenuDetailResponseDTO response = new MenuDetailResponseDTO();
//		
//		response.setAdminMenuDto(result);
//		response.setAdminMenuRoleDto(roleResult);
//		response.setAllMenuRoleDto(roleAllResult);
//		
//		return ResponseEntity.ok(response);
//	    	
//	}
//	
//	@GetMapping("/getListMenuUpper")
//	public ResponseEntity<List<AdminMenuDTO>> getListMenuUpper(@RequestParam String menuType) throws Exception {
//		
//		List<AdminMenuDTO> list = adminMainService.getListMenuUpper(menuType);
//		
//		return ResponseEntity.ok(list);
//	}
//	
//	@GetMapping("/getListMenuType")
//	public ResponseEntity<List<AdminMenuTypeDTO>> getListMenuType(HttpServletRequest request) throws Exception {
//		
//		List<AdminMenuTypeDTO> list = adminMainService.getListMenuType();
//		
//		return ResponseEntity.ok(list);
//	
//	}
//	@GetMapping("/getListParent")
//	public ResponseEntity<List<AdminMenuDTO>> getListParent(HttpServletRequest request) throws Exception {
//		
//		List<AdminMenuDTO> list = adminMainService.getListParent();
//		
//		return ResponseEntity.ok(list);
//	
//	}
//	@PostMapping("/insertMenu")
//	public ResponseEntity<?> insertMenu(@RequestBody MenuInsertRequestDTO request) {
//		
//		int parentCode = request.getAdminMenuDto().getParentCode();
//		
//		if (parentCode != 0) {
//		
//			String path = request.getAdminMenuDto().getPath();
//			
//			int menuPath = adminMainService.getMenuPath(path);
//			
//			if(menuPath != 0) {
//				MenuInsertRequestDTO errorMessage = new MenuInsertRequestDTO();
//				errorMessage.setMessage("이미 등록된 URL 입니다.");
//				System.out.println("이미 등록된 URL 입니다.");
//				return ResponseEntity.status(405).body(errorMessage);
//			}
//			
//		}
//			try {
//				System.out.println("asd");
//				
//		    	adminMainService.insertMenu(request.getAdminMenuDto(), request.getAdminMenuRoleDto() );
//				return ResponseEntity.ok("메뉴 등록완료");
//			 } catch(Exception e) {
//				 e.printStackTrace();
//				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                     .body("메뉴 등록 실패입니다.");
//			 }
//		
//		
//	}
//	@PostMapping("/updateSortOrder")
//	public ResponseEntity<?> updateSortOrder(@RequestBody MenuSortOrderUpdateDTO request) {
//        
//        try {
//        	List<AdminMenuDTO> list = request.getMenus();
//        	
//        	for(AdminMenuDTO adminMenuDto : list) {
//        		adminMainService.updateSortOrder(adminMenuDto);
//        		System.out.println("업데이트할 메뉴: " + adminMenuDto.getMenuCode() + " → 순서: " + adminMenuDto.getSortOrder());
//        	}
//        	
//        	return ResponseEntity.ok("메뉴 수정 완료");
//        } catch(Exception e) {
//        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//            .body("메뉴 수정 실패입니다.");
//        }
//	
//	}
//	@PostMapping("/deleteMenu")
//	public ResponseEntity<String> deleteMenu(@RequestParam int menuCode) throws Exception {
//		int children = adminMainService.getCountChildren(menuCode);
//		if(children !=0) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//		            .body("하위 메뉴를 먼저 삭제 하세요.");
//		}
//		
//		System.out.println(menuCode+"adasdsadsadas");
//		adminMainService.deleteMenu(menuCode);
//		return ResponseEntity.ok("삭제완료");
//	}
//	
//	@PostMapping("/updateMenu")
//	public ResponseEntity<?> updateMenu(@RequestBody MenuInsertRequestDTO request) {
//		
//		AdminMenuDTO adminMenuDto = request.getAdminMenuDto();
//		int parentCode = request.getAdminMenuDto().getParentCode();
//		
//		AdminMenuDTO originalDto = adminMainService.getDetailMenu(adminMenuDto.getMenuCode());
//		
//		if (parentCode != 0) {
//			
//			if (!adminMenuDto.getPath().equals(originalDto.getPath())) {
//		
//				String path = request.getAdminMenuDto().getPath();
//				
//				int menuPath = adminMainService.getMenuPath(path);
//				
//				if(menuPath != 0) {
//					MenuInsertRequestDTO errorMessage = new MenuInsertRequestDTO();
//					errorMessage.setMessage("이미 등록된 URL 입니다.");
//					System.out.println("이미 등록된 URL 입니다.");
//					return ResponseEntity.status(405).body(errorMessage);
//				}
//			}
//			
//		}
//		
//		try {
//			System.out.println("asd");
//	    	adminMainService.updateMenu(request.getAdminMenuDto(), request.getAdminMenuRoleDto());
//			return ResponseEntity.ok("수정완료");
//		} catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("매뉴 수정 실패입니다.");
//		}
//	
//	}
//
////	@PostMapping("/deleteMenu")
////	public ResponseEntity<String> deleteMenu(@RequestBody AdminMenuDTO adminMenuDto) throws Exception {
////		
////		
////		System.out.println(adminMenuDto+"adasdsadsadas");
////		adminMainService.deleteMenu(adminMenuDto);
////		return ResponseEntity.ok("삭제완료");
////	}
//	
//	@GetMapping("/getListUser")
//	public ResponseEntity<List<AdminUserDTO>> getListUser(HttpServletRequest request) throws Exception {
//		
//	//	System.out.println("이것은");
//		List<AdminUserDTO> list = adminMainService.getListUser();
//		
//		return ResponseEntity.ok(list);
//	}
//	
//	@PostMapping("/getListUserResponse")
//	public ResponseEntity<UserResponseDTO> getListUserResponse(@RequestBody AdminUserDTO adminUserDto) throws Exception {
//		
//		UserResponseDTO userResponseDto = new UserResponseDTO();
//		
//		userResponseDto.setTotalCount(adminMainService.getCountUser(adminUserDto));
//		System.out.println("토탈 숫자" + userResponseDto.getTotalCount());
//		List<AdminUserDTO> list = adminMainService.getListUserResponse(adminUserDto);
//		
//		userResponseDto.setAdminUserDto(list);
//		
//		return ResponseEntity.ok(userResponseDto);
//	}
//	
//	@GetMapping("/getDetailUser")
//	public ResponseEntity<UserDetailResponseDTO> getDetailUser(@RequestParam String userId) throws Exception {
//		System.out.println("이것은");
//		AdminUserDTO result = adminMainService.getDetailUser(userId);
//		
//		List<AdminUserMappingDTO> roleResult = adminMainService.getDetailUserRole(userId);
//		
//		List<AdminUserRoleDTO> roleAllResult = adminMainService.getListRole();
//		
//		UserDetailResponseDTO response = new UserDetailResponseDTO();
//		
//		response.setAdminUserDto(result);
//		response.setAdminUserMappingDto(roleResult);
//		response.setAllUserRoleDto(roleAllResult);
//		
//		return ResponseEntity.ok(response);
//	    	
//	}
//	@GetMapping("/getInfoList")
//	public ResponseEntity<InfoListResponseDTO> getInfoList(HttpServletRequest request) {
//		
//		List<AdminUserGenderDTO> genderList = adminMainService.getUserGenderList();
//		
//		List<AdminUserMembershipDTO> membershipList = adminMainService.getUserMembershipList();
//		
//		InfoListResponseDTO response = new InfoListResponseDTO();
//		
//		response.setAdminUserGenderDto(genderList);
//	    response.setAdminUserMembershipDto(membershipList);
//		
//		return ResponseEntity.ok(response);
//		
//	}
//	
//	@PostMapping("/updateUser")
//	public ResponseEntity<?> updateUser(@RequestBody UserInsertRequestDTO request) {
//		
//		try {
//			System.out.println("asd");
//	    	adminMainService.updateUser(request.getAdminUserDto(), request.getAdminUserMappingDto());
//			return ResponseEntity.ok("수정완료");
//		} catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("정보 수정 실패입니다.");
//		}
//	
//	}
//	@PostMapping("/changeLockYn")
//	public ResponseEntity<?> changeLockYn(@RequestBody AdminUserDTO adminUserDto) {
//		try {
//	    	adminMainService.changeLockYn(adminUserDto);
//			return ResponseEntity.ok("수정완료");
//		} catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("정보 수정 실패입니다.");
//		}
//	}
//	@PostMapping("/changeDormantYn")
//	public ResponseEntity<?> changeDormantYn(@RequestBody AdminUserDTO adminUserDto) {
//		try {
//	    	adminMainService.changeDormantYn(adminUserDto);
//			return ResponseEntity.ok("수정완료");
//		} catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("정보 수정 실패입니다.");
//		}
//	}
//	@GetMapping("/checkUserId")
//	public ResponseEntity<String> checkUserId(@RequestParam String userId) throws Exception {
//		
//		int checkedId = adminMainService.checkUserId(userId);
//		
//		if(checkedId != 0) {
//			System.out.println("이미 등록된 ID 입니다.");
//			return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 등록된 ID 입니다.");
//		}
//		
//		return ResponseEntity.ok("유효한 ID입니다");
//	}
//	
//	@PostMapping("/insertUser")
//	public ResponseEntity<?> insertUser(@RequestBody UserInsertRequestDTO request) {
//		
//		try {
//			System.out.println("asd");
//			
//			adminMainService.insertUser(request.getAdminUserDto(), request.getAdminUserMappingDto() );
//			return ResponseEntity.ok("회원가입 완료");
//		 } catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("회원가입 실패입니다.");
//		 }
//	}
//	@PostMapping("/deleteUser")
//	public ResponseEntity<String> deleteUser(@RequestParam String userId) throws Exception {
//		
//		adminMainService.deleteUser(userId);
//		return ResponseEntity.ok("삭제완료");
//	}
//	
//	@GetMapping("/getListRoleGroup")
//	public ResponseEntity<List<AdminRoleGroupDTO>> getListRoleGroup(HttpServletRequest request) throws Exception {
//		
//		List<AdminRoleGroupDTO> list = adminMainService.getListRoleGroup();
//		
//		return ResponseEntity.ok(list);
//	}
//	
//	@PostMapping("/insertRole")
//	public ResponseEntity<String> insertRole(@RequestBody AdminRoleInfoDTO adminRoleInfoDto) {
//		try {
//	    	adminMainService.insertRole(adminRoleInfoDto);
//			return ResponseEntity.ok("등록완료");
//		 } catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("게시판 등록 실패입니다.");
//		 }
//    	
//	}
//	@GetMapping("/checkRoleCode")
//	public ResponseEntity<String> checkRoleCode(@RequestParam String roleCode) throws Exception {
//		
//		int checkedCode = adminMainService.checkRoleCode(roleCode);
//		
//		if(checkedCode != 0) {
//			System.out.println("이미 등록된 코드 입니다.");
//			return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 등록된 코드 입니다.");
//		}
//		
//		return ResponseEntity.ok("유효한 코드입니다");
//	}
//	
//	@GetMapping("/getDetailRole")
//	public ResponseEntity<AdminRoleInfoDTO> getDetailRole(@RequestParam String roleCode) throws Exception {
//		
//		AdminRoleInfoDTO result = adminMainService.getDetailRole(roleCode);
//		
//		return ResponseEntity.ok(result);
//	    	
//	}
//	@PostMapping("/updateRole")
//	public ResponseEntity<?> updateRole(@RequestBody AdminRoleInfoDTO request) {
//		
//		try {
//			System.out.println("asd");
//	    	adminMainService.updateRole(request);
//			return ResponseEntity.ok("수정완료");
//		} catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("권한 수정 실패입니다.");
//		}
//	
//	}
//	@PostMapping("/deleteRole")
//	public ResponseEntity<String> deleteRole(@RequestParam String roleCode) throws Exception {
//		
//		adminMainService.deleteRole(roleCode);
//		return ResponseEntity.ok("삭제완료");
//	}
//	
//	@PostMapping("/changeUseYn")
//	public ResponseEntity<?> changeUseYn(@RequestBody AdminUserRoleDTO adminUserRoleDto) {
//		try {
//	    	adminMainService.changeUseYn(adminUserRoleDto);
//			return ResponseEntity.ok("수정완료");
//		} catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("정보 수정 실패입니다.");
//		}
//	}
//	@GetMapping("/checkRoleGroupCode")
//	public ResponseEntity<String> checkRoleGroupCode(@RequestParam String roleGroup) throws Exception {
//		
//		int checkedGroupCode = adminMainService.checkRoleGroupCode(roleGroup);
//		
//		if(checkedGroupCode != 0) {
//			System.out.println("이미 등록된 코드 입니다.");
//			return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 등록된 코드 입니다.");
//		}
//		
//		return ResponseEntity.ok("유효한 코드입니다");
//	}
//	@PostMapping("/insertRoleGroup")
//	public ResponseEntity<String> insertRoleGroup(@RequestBody AdminRoleGroupDTO adminRoleGroupDto) {
//		try {
//	    	adminMainService.insertRoleGroup(adminRoleGroupDto);
//			return ResponseEntity.ok("등록완료");
//		 } catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("등록 실패입니다.");
//		 }
//    	
//	}
//	@GetMapping("/getDetailRoleGroup")
//	public ResponseEntity<AdminRoleGroupDTO> getDetailRoleGroup(@RequestParam String roleGroup) throws Exception {
//		
//		AdminRoleGroupDTO result = adminMainService.getDetailRoleGroup(roleGroup);
//		
//		return ResponseEntity.ok(result);
//	    	
//	}
//	
//	@PostMapping("/updateRoleGroup")
//	public ResponseEntity<?> updateRoleGroup(@RequestBody AdminRoleGroupDTO request) {
//		
//		try {
//			System.out.println("asd");
//	    	adminMainService.updateRoleGroup(request);
//			return ResponseEntity.ok("수정완료");
//		} catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("권한 수정 실패입니다.");
//		}
//	
//	}
//	@PostMapping("/deleteRoleGroup")
//	public ResponseEntity<String> deleteRoleGroup(@RequestParam String roleGroup) throws Exception {
//		
//		adminMainService.deleteRoleGroup(roleGroup);
//		return ResponseEntity.ok("삭제완료");
//	}
//	
//	@PostMapping("/changeUseYnGroup")
//	public ResponseEntity<?> changeUseYnGroup(@RequestBody AdminRoleGroupDTO adminRoleGroupDto) {
//		try {
//	    	adminMainService.changeUseYnGroup(adminRoleGroupDto);
//			return ResponseEntity.ok("수정완료");
//		} catch(Exception e) {
//			 e.printStackTrace();
//			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                     .body("정보 수정 실패입니다.");
//		}
//	}
//	@GetMapping("/getListCommonGroupCode")
//	public ResponseEntity<List<AdminCommonGroupCodeDTO>> getListCommonGroupCode(HttpServletRequest request) {
//		
//		List<AdminCommonGroupCodeDTO> commonGroupList = adminMainService.getListCommonGroupCode();
//		
//		
//		return ResponseEntity.ok(commonGroupList);
//		
//	}
//	
//	@PostMapping("/insertUpperCommonCode")
//	public ResponseEntity<String> insertUpperCommonCode(@RequestBody AdminCommonGroupCodeDTO adminCommonGroupCodeDto ,Authentication authentication) {
//		int getCode = adminMainService.getCode(adminCommonGroupCodeDto);
//		
//		if(getCode != 0) {
//			return ResponseEntity.status(405).body(null);
//		}
//		else {
//			try {
//				String userId = (String)authentication.getName();
//				adminCommonGroupCodeDto.setUserId(userId);
//		    	adminMainService.insertUpperCommonCode(adminCommonGroupCodeDto);
//				return ResponseEntity.ok("등록완료");
//			 } catch(Exception e) {
//				 e.printStackTrace();
//				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                     .body("게시판 등록 실패입니다.");
//			 }
//		}
//	}
//	@GetMapping("/getDetailUpperCode")
//	public ResponseEntity<AdminCommonGroupCodeDTO> getDetailUpperCode(@RequestParam String commonGroupCode) throws Exception {
//		
//		AdminCommonGroupCodeDTO result = adminMainService.getDetailUpperCode(commonGroupCode);
//		
//		
//		return ResponseEntity.ok(result);
//	    	
//	}
//	@GetMapping("/getListCommonSubCode")
//	public ResponseEntity<List<AdminCommonGroupCodeDTO>> getListCommonSubCode(@RequestParam String commonGroupCode) {
//		
//		List<AdminCommonGroupCodeDTO> commonSubList = adminMainService.getListCommonSubCode(commonGroupCode);
//		
//		
//		return ResponseEntity.ok(commonSubList);
//		
//	}
//	@GetMapping("/getDetailSubCode")
//	public ResponseEntity<AdminCommonGroupCodeDTO> getDetailSubCode(@RequestParam String commonCode) throws Exception {
//		
//		AdminCommonGroupCodeDTO result = adminMainService.getDetailSubCode(commonCode);
//		
//		
//		return ResponseEntity.ok(result);
//	    	
//	}
//	@PostMapping("/insertSubCommonCode")
//	public ResponseEntity<String> insertSubCommonCode(@RequestBody AdminCommonGroupCodeDTO adminCommonGroupCodeDto ,Authentication authentication) {
//		int getSubCode = adminMainService.getSubCode(adminCommonGroupCodeDto);
//		
//		if(getSubCode != 0) {
//			return ResponseEntity.status(405).body(null);
//		}
//		else {
//			try {
//				String userId = (String)authentication.getName();
//				adminCommonGroupCodeDto.setUserId(userId);
//		    	adminMainService.insertSubCommonCode(adminCommonGroupCodeDto);
//				return ResponseEntity.ok("등록완료");
//			 } catch(Exception e) {
//				 e.printStackTrace();
//				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                     .body("게시판 등록 실패입니다.");
//			 }
//		}
//	}
//	@PostMapping("/updateUpperCommonCode")
//	public ResponseEntity<String> updateUpperCommonCode(@RequestBody AdminCommonGroupCodeDTO adminCommonGroupCodeDto) {
//		
//			try {
////				String userId = (String)authentication.getName();
////				adminCommonGroupCodeDto.setUserId(userId);
//		    	adminMainService.updateUpperCommonCode(adminCommonGroupCodeDto);
//				return ResponseEntity.ok("수정완료");
//			 } catch(Exception e) {
//				 e.printStackTrace();
//				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                     .body("게시판 등록 실패입니다.");
//			 }
//		
//	}
//	@PostMapping("/updateSubCommonCode")
//	public ResponseEntity<String> updateSubCommonCode(@RequestBody AdminCommonGroupCodeDTO adminCommonGroupCodeDto) {
//		
//			try {
//		    	adminMainService.updateSubCommonCode(adminCommonGroupCodeDto);
//				return ResponseEntity.ok("수정완료");
//			 } catch(Exception e) {
//				 e.printStackTrace();
//				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//	                     .body("게시판 등록 실패입니다.");
//			 }
//		
//	}
//	@PostMapping("/deleteUpperCommonCode")
//	public ResponseEntity<String> deleteUpperCommonCode(@RequestBody AdminCommonGroupCodeDTO adminCommonGroupCodeDto) throws Exception {
//		String commonGroupCode = adminCommonGroupCodeDto.getCommonGroupCode();
//		
//		int getSubCodeList = adminMainService.getSubCodeList(commonGroupCode);
//		
//		if(getSubCodeList != 0) {
//			return ResponseEntity.status(405).body(null);
//		}
//		else {
//			adminMainService.deleteUpperCommonCode(commonGroupCode);
//			return ResponseEntity.ok("삭제완료");
//		}
//	}
//	@PostMapping("/deleteSubCommonCode")
//	public ResponseEntity<String> deleteSubCommonCode(@RequestBody AdminCommonGroupCodeDTO adminCommonGroupCodeDto) throws Exception {
//		String commonCode = adminCommonGroupCodeDto.getCommonCode();
//			
//		adminMainService.deleteSubCommonCode(commonCode);
//		return ResponseEntity.ok("삭제완료");
//		
//	}
//	
//}