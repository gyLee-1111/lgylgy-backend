package com.bmm.api.adminMenu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmm.api.commonBoard.commonBoardDTO.CommonCommentDTO;
import com.bmm.api.logIn.LogInResponseDTO;
import com.bmm.api.logIn.UserDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class AdminMenuController {
	
	@Autowired
	private AdminMenuService adminMenuService;

	
	@GetMapping("/getAdminMenu")
	public ResponseEntity<List<AdminMenuDTO>> getAdminMenu(@RequestParam String roleCode) throws Exception {
		System.out.println("#################"+roleCode);
		List<AdminMenuDTO> list = adminMenuService.getAdminMenu(roleCode);
		System.out.println("상위 메뉴 수: " + list.size());
		List<AdminMenuDTO> sublist = adminMenuService.getAdminSubMenu(roleCode);
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
	
	
	
	@GetMapping("/getListMenu")
	public ResponseEntity<List<AdminMenuDTO>> getListMenu(@RequestParam String menuType) throws Exception {
		
		List<AdminMenuDTO> list = adminMenuService.getListMenu(menuType);
		
		return ResponseEntity.ok(list);
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

	@GetMapping("/getDetailMenu")
	public ResponseEntity<MenuDetailResponseDTO> getDetailMenu(@RequestParam int menuCode) throws Exception {
		
		AdminMenuDTO result = adminMenuService.getDetailMenu(menuCode);
		
		//String parentNm = adminMainService.getParentNm(result.getParentCode());
		
	//	result.setParentNm(parentNm);
		
		List<AdminMenuRoleDTO> roleResult = adminMenuService.getDetailMenuRole(menuCode);
		
		List<AdminUserRoleDTO> roleAllResult = adminMenuService.getListRole();
		
		MenuDetailResponseDTO response = new MenuDetailResponseDTO();
		
		response.setAdminMenuDto(result);
		response.setAdminMenuRoleDto(roleResult);
		response.setAllMenuRoleDto(roleAllResult);
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/getListMenuUpper")
	public ResponseEntity<List<AdminMenuDTO>> getListMenuUpper(@RequestParam String menuType) throws Exception {
		
		List<AdminMenuDTO> list = adminMenuService.getListMenuUpper(menuType);
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/getListMenuType")
	public ResponseEntity<List<AdminMenuTypeDTO>> getListMenuType(HttpServletRequest request) throws Exception {
		
		List<AdminMenuTypeDTO> list = adminMenuService.getListMenuType();
		
		return ResponseEntity.ok(list);
	
	}
	@GetMapping("/getListParent")
	public ResponseEntity<List<AdminMenuDTO>> getListParent(HttpServletRequest request) throws Exception {
		
		List<AdminMenuDTO> list = adminMenuService.getListParent();
		
		return ResponseEntity.ok(list);
	
	}
	@PostMapping("/insertMenu")
	public ResponseEntity<?> insertMenu(@RequestBody MenuInsertRequestDTO request) {
		
		int parentCode = request.getAdminMenuDto().getParentCode();
		
		if (parentCode != 0) {
		
			String path = request.getAdminMenuDto().getPath();
			
			int menuPath = adminMenuService.getMenuPath(path);
			
			if(menuPath != 0) {
				MenuInsertRequestDTO errorMessage = new MenuInsertRequestDTO();
				errorMessage.setMessage("이미 등록된 URL 입니다.");
				System.out.println("이미 등록된 URL 입니다.");
				return ResponseEntity.status(405).body(errorMessage);
			}
			
		}
			try {
				System.out.println("asd");
				
				adminMenuService.insertMenu(request.getAdminMenuDto(), request.getAdminMenuRoleDto() );
				return ResponseEntity.ok("메뉴 등록완료");
			 } catch(Exception e) {
				 e.printStackTrace();
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                     .body("메뉴 등록 실패입니다.");
			 }
		
		
	}
	@PostMapping("/updateSortOrder")
	public ResponseEntity<?> updateSortOrder(@RequestBody MenuSortOrderUpdateDTO request) {
        
        try {
        	List<AdminMenuDTO> list = request.getMenus();
        	
        	for(AdminMenuDTO adminMenuDto : list) {
        		adminMenuService.updateSortOrder(adminMenuDto);
        		System.out.println("업데이트할 메뉴: " + adminMenuDto.getMenuCode() + " → 순서: " + adminMenuDto.getSortOrder());
        	}
        	
        	return ResponseEntity.ok("메뉴 수정 완료");
        } catch(Exception e) {
        	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body("메뉴 수정 실패입니다.");
        }
	}
	@PostMapping("/deleteMenu")
	public ResponseEntity<String> deleteMenu(@RequestParam int menuCode) throws Exception {
		int children = adminMenuService.getCountChildren(menuCode);
		if(children !=0) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		            .body("하위 메뉴를 먼저 삭제 하세요.");
		}
		
		System.out.println(menuCode+"adasdsadsadas");
		adminMenuService.deleteMenu(menuCode);
		return ResponseEntity.ok("삭제완료");
	}
	
	@PostMapping("/updateMenu")
	public ResponseEntity<?> updateMenu(@RequestBody MenuInsertRequestDTO request) {
		
		AdminMenuDTO adminMenuDto = request.getAdminMenuDto();
		int parentCode = request.getAdminMenuDto().getParentCode();
		
		AdminMenuDTO originalDto = adminMenuService.getDetailMenu(adminMenuDto.getMenuCode());
		
		if (parentCode != 0) {
			
			if (!adminMenuDto.getPath().equals(originalDto.getPath())) {
		
				String path = request.getAdminMenuDto().getPath();
				
				int menuPath = adminMenuService.getMenuPath(path);
				
				if(menuPath != 0) {
					MenuInsertRequestDTO errorMessage = new MenuInsertRequestDTO();
					errorMessage.setMessage("이미 등록된 URL 입니다.");
					System.out.println("이미 등록된 URL 입니다.");
					return ResponseEntity.status(405).body(errorMessage);
				}
			}
			
		}
		
		try {
			System.out.println("asd");
			adminMenuService.updateMenu(request.getAdminMenuDto(), request.getAdminMenuRoleDto());
			return ResponseEntity.ok("수정완료");
		} catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("매뉴 수정 실패입니다.");
		}
	
	}

//	@PostMapping("/deleteMenu")
//	public ResponseEntity<String> deleteMenu(@RequestBody AdminMenuDTO adminMenuDto) throws Exception {
//		
//		
//		System.out.println(adminMenuDto+"adasdsadsadas");
//		adminMainService.deleteMenu(adminMenuDto);
//		return ResponseEntity.ok("삭제완료");
//	}
	
	
}