package com.bmm.api.adminRole;

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
public class AdminRoleController {
	
	@Autowired
	private AdminRoleService adminRoleService;

	
	
	
	@GetMapping("/getListRoleGroup")
	public ResponseEntity<List<AdminRoleGroupDTO>> getListRoleGroup(HttpServletRequest request) throws Exception {
		
		List<AdminRoleGroupDTO> list = adminRoleService.getListRoleGroup();
		
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/insertRole")
	public ResponseEntity<String> insertRole(@RequestBody AdminRoleInfoDTO adminRoleInfoDto) {
		try {
			adminRoleService.insertRole(adminRoleInfoDto);
			return ResponseEntity.ok("등록완료");
		 } catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("게시판 등록 실패입니다.");
		 }
    	
	}
	@GetMapping("/checkRoleCode")
	public ResponseEntity<String> checkRoleCode(@RequestParam String roleCode) throws Exception {
		
		int checkedCode = adminRoleService.checkRoleCode(roleCode);
		
		if(checkedCode != 0) {
			System.out.println("이미 등록된 코드 입니다.");
			return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 등록된 코드 입니다.");
		}
		
		return ResponseEntity.ok("유효한 코드입니다");
	}
	
	@GetMapping("/getDetailRole")
	public ResponseEntity<AdminRoleInfoDTO> getDetailRole(@RequestParam String roleCode) throws Exception {
		
		AdminRoleInfoDTO result = adminRoleService.getDetailRole(roleCode);
		
		return ResponseEntity.ok(result);
	    	
	}
	@PostMapping("/updateRole")
	public ResponseEntity<?> updateRole(@RequestBody AdminRoleInfoDTO request) {
		
		try {
			System.out.println("asd");
			adminRoleService.updateRole(request);
			return ResponseEntity.ok("수정완료");
		} catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("권한 수정 실패입니다.");
		}
	
	}
	@PostMapping("/deleteRole")
	public ResponseEntity<String> deleteRole(@RequestParam String roleCode) throws Exception {
		
		adminRoleService.deleteRole(roleCode);
		return ResponseEntity.ok("삭제완료");
	}
	
	@PostMapping("/changeUseYn")
	public ResponseEntity<?> changeUseYn(@RequestBody AdminUserRoleDTO adminUserRoleDto) {
		try {
			adminRoleService.changeUseYn(adminUserRoleDto);
			return ResponseEntity.ok("수정완료");
		} catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("정보 수정 실패입니다.");
		}
	}
	@GetMapping("/checkRoleGroupCode")
	public ResponseEntity<String> checkRoleGroupCode(@RequestParam String roleGroup) throws Exception {
		
		int checkedGroupCode = adminRoleService.checkRoleGroupCode(roleGroup);
		
		if(checkedGroupCode != 0) {
			System.out.println("이미 등록된 코드 입니다.");
			return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 등록된 코드 입니다.");
		}
		
		return ResponseEntity.ok("유효한 코드입니다");
	}
	@PostMapping("/insertRoleGroup")
	public ResponseEntity<String> insertRoleGroup(@RequestBody AdminRoleGroupDTO adminRoleGroupDto) {
		try {
			adminRoleService.insertRoleGroup(adminRoleGroupDto);
			return ResponseEntity.ok("등록완료");
		 } catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("등록 실패입니다.");
		 }
    	
	}
	@GetMapping("/getDetailRoleGroup")
	public ResponseEntity<AdminRoleGroupDTO> getDetailRoleGroup(@RequestParam String roleGroup) throws Exception {
		
		AdminRoleGroupDTO result = adminRoleService.getDetailRoleGroup(roleGroup);
		
		return ResponseEntity.ok(result);
	    	
	}
	
	@PostMapping("/updateRoleGroup")
	public ResponseEntity<?> updateRoleGroup(@RequestBody AdminRoleGroupDTO request) {
		
		try {
			System.out.println("asd");
			adminRoleService.updateRoleGroup(request);
			return ResponseEntity.ok("수정완료");
		} catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("권한 수정 실패입니다.");
		}
	
	}
	@PostMapping("/deleteRoleGroup")
	public ResponseEntity<String> deleteRoleGroup(@RequestParam String roleGroup) throws Exception {
		
		adminRoleService.deleteRoleGroup(roleGroup);
		return ResponseEntity.ok("삭제완료");
	}
	
	@PostMapping("/changeUseYnGroup")
	public ResponseEntity<?> changeUseYnGroup(@RequestBody AdminRoleGroupDTO adminRoleGroupDto) {
		try {
			adminRoleService.changeUseYnGroup(adminRoleGroupDto);
			return ResponseEntity.ok("수정완료");
		} catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("정보 수정 실패입니다.");
		}
	}

	
}