package com.bmm.api.adminUser;

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

import com.bmm.api.adminUser.AdminUserRoleDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class AdminUserController {
	
	@Autowired
	private AdminUserService adminUserService;

	
	
	@GetMapping("/getListUser")
	public ResponseEntity<List<AdminUserDTO>> getListUser(HttpServletRequest request) throws Exception {
		
	//	System.out.println("이것은");
		List<AdminUserDTO> list = adminUserService.getListUser();
		
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/getListUserResponse")
	public ResponseEntity<UserResponseDTO> getListUserResponse(@RequestBody AdminUserDTO adminUserDto) throws Exception {
		
		UserResponseDTO userResponseDto = new UserResponseDTO();
		
		userResponseDto.setTotalCount(adminUserService.getCountUser(adminUserDto));
		System.out.println("토탈 숫자" + userResponseDto.getTotalCount());
		List<AdminUserDTO> list = adminUserService.getListUserResponse(adminUserDto);
		
		userResponseDto.setAdminUserDto(list);
		
		return ResponseEntity.ok(userResponseDto);
	}
	
	@GetMapping("/getDetailUser")
	public ResponseEntity<UserDetailResponseDTO> getDetailUser(@RequestParam String userId) throws Exception {
		System.out.println("이것은");
		AdminUserDTO result = adminUserService.getDetailUser(userId);
		
		List<AdminUserMappingDTO> roleResult = adminUserService.getDetailUserRole(userId);
		
		List<AdminUserRoleDTO> roleAllResult = adminUserService.getListRole();
		
		UserDetailResponseDTO response = new UserDetailResponseDTO();
		
		response.setAdminUserDto(result);
		response.setAdminUserMappingDto(roleResult);
		response.setAllUserRoleDto(roleAllResult);
		
		return ResponseEntity.ok(response);
	    	
	}
	@GetMapping("/getInfoList")
	public ResponseEntity<InfoListResponseDTO> getInfoList(HttpServletRequest request) {
		
		List<AdminUserGenderDTO> genderList = adminUserService.getUserGenderList();
		
		List<AdminUserMembershipDTO> membershipList = adminUserService.getUserMembershipList();
		
		InfoListResponseDTO response = new InfoListResponseDTO();
		
		response.setAdminUserGenderDto(genderList);
	    response.setAdminUserMembershipDto(membershipList);
		
		return ResponseEntity.ok(response);
		
	}
	
	@PostMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody UserInsertRequestDTO request) {
		
		try {
			System.out.println("asd");
			adminUserService.updateUser(request.getAdminUserDto(), request.getAdminUserMappingDto());
			return ResponseEntity.ok("수정완료");
		} catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("정보 수정 실패입니다.");
		}
	
	}
	@PostMapping("/changeLockYn")
	public ResponseEntity<?> changeLockYn(@RequestBody AdminUserDTO adminUserDto) {
		try {
			adminUserService.changeLockYn(adminUserDto);
			return ResponseEntity.ok("수정완료");
		} catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("정보 수정 실패입니다.");
		}
	}
	@PostMapping("/changeDormantYn")
	public ResponseEntity<?> changeDormantYn(@RequestBody AdminUserDTO adminUserDto) {
		try {
			adminUserService.changeDormantYn(adminUserDto);
			return ResponseEntity.ok("수정완료");
		} catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("정보 수정 실패입니다.");
		}
	}
	@GetMapping("/checkUserId")
	public ResponseEntity<String> checkUserId(@RequestParam String userId) throws Exception {
		
		int checkedId = adminUserService.checkUserId(userId);
		
		if(checkedId != 0) {
			System.out.println("이미 등록된 ID 입니다.");
			return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 등록된 ID 입니다.");
		}
		
		return ResponseEntity.ok("유효한 ID입니다");
	}
	
	@PostMapping("/insertUser")
	public ResponseEntity<?> insertUser(@RequestBody UserInsertRequestDTO request) {
		
		try {
			System.out.println("asd");
			
			adminUserService.insertUser(request.getAdminUserDto(), request.getAdminUserMappingDto() );
			return ResponseEntity.ok("회원가입 완료");
		 } catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("회원가입 실패입니다.");
		 }
	}
	@PostMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(@RequestParam String userId) throws Exception {
		
		adminUserService.deleteUser(userId);
		return ResponseEntity.ok("삭제완료");
	}
	
	@GetMapping("/getListRole")
	public ResponseEntity<List<AdminUserRoleDTO>> getListRole(HttpServletRequest request) throws Exception {
		
		List<AdminUserRoleDTO> list = adminUserService.getListRole();
		
		return ResponseEntity.ok(list);
	}
	
	
	
}