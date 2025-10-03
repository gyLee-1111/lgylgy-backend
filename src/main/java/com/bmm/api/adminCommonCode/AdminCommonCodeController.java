package com.bmm.api.adminCommonCode;

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
public class AdminCommonCodeController {
	
	@Autowired
	private AdminCommonCodeService adminCommonCodeService;

	
	@PostMapping("/getListCommonUpperCode")
	public ResponseEntity<CommonCodeResponseDTO> getListCommonUpperCode(@RequestBody AdminCommonCodeDTO adminCommonCodeDto) {
		
		CommonCodeResponseDTO commonCodeResponseDto = new CommonCodeResponseDTO();
		
		commonCodeResponseDto.setTotalCount(adminCommonCodeService.getCountCommonCode(adminCommonCodeDto));
		
		List<AdminCommonCodeDTO> commonUpperList = adminCommonCodeService.getListCommonUpperCode(adminCommonCodeDto);
		
		commonCodeResponseDto.setAdminCommonCodeDto(commonUpperList);
		
		return ResponseEntity.ok(commonCodeResponseDto);
	}

	@PostMapping("/insertUpperCommonCode")
	public ResponseEntity<String> insertUpperCommonCode(@RequestBody AdminCommonCodeDTO adminCommonCodeDto ,Authentication authentication) {
		int getCode = adminCommonCodeService.getCode(adminCommonCodeDto);
		
		if(getCode != 0) {
			return ResponseEntity.status(405).body(null);
		}
		else {
			try {
				String userId = (String)authentication.getName();
				adminCommonCodeDto.setUserId(userId);
				adminCommonCodeService.insertUpperCommonCode(adminCommonCodeDto);
				return ResponseEntity.ok("등록완료");
			 } catch(Exception e) {
				 e.printStackTrace();
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                     .body("게시판 등록 실패입니다.");
			 }
		}
	}
	
	@GetMapping("/getDetailUpperCode")
	public ResponseEntity<AdminCommonCodeDTO> getDetailUpperCode(@RequestParam String commonCode) throws Exception {
		System.out.println("asdsadasdasda"+commonCode);
		
		AdminCommonCodeDTO result = adminCommonCodeService.getDetailUpperCode(commonCode);
		
		
		return ResponseEntity.ok(result);
	    	
	}
	
	@PostMapping("/updateUpperCommonCode")
	public ResponseEntity<String> updateUpperCommonCode(@RequestBody AdminCommonCodeDTO adminCommonCodeDto) {
		
			try {
//				String userId = (String)authentication.getName();
//				adminCommonGroupCodeDto.setUserId(userId);
				adminCommonCodeService.updateUpperCommonCode(adminCommonCodeDto);
				return ResponseEntity.ok("수정완료");
			 } catch(Exception e) {
				 e.printStackTrace();
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                     .body("코드 수정 실패입니다.");
			 }
		
	}
	
	@PostMapping("/deleteUpperCommonCode")
	public ResponseEntity<String> deleteUpperCommonCode(@RequestBody AdminCommonCodeDTO adminCommonCodeDto) throws Exception {
		String upperCode = adminCommonCodeDto.getCommonCode();
		
		int getSubCodeList = adminCommonCodeService.getSubCodeList(upperCode);
		
		if(getSubCodeList != 0) {
			return ResponseEntity.status(405).body(null);
		}
		else {
			adminCommonCodeService.deleteUpperCommonCode(upperCode);
			return ResponseEntity.ok("삭제완료");
		}
	}
	
	@GetMapping("/getListCommonSubCode")
	public ResponseEntity<List<AdminCommonCodeDTO>> getListCommonSubCode(@RequestParam String commonCode) {
		
		List<AdminCommonCodeDTO> commonSubList = adminCommonCodeService.getListCommonSubCode(commonCode);
		
		
		return ResponseEntity.ok(commonSubList);
	}
	
	@PostMapping("/insertSubCommonCode")
	public ResponseEntity<String> insertSubCommonCode(@RequestBody AdminCommonCodeDTO adminCommonCodeDto ,Authentication authentication) {
		int getSubCode = adminCommonCodeService.getSubCode(adminCommonCodeDto);
		
		if(getSubCode != 0) {
			return ResponseEntity.status(405).body(null);
		}
		else {
			try {
				String userId = (String)authentication.getName();
				adminCommonCodeDto.setUserId(userId);
				adminCommonCodeService.insertSubCommonCode(adminCommonCodeDto);
				return ResponseEntity.ok("등록완료");
			 } catch(Exception e) {
				 e.printStackTrace();
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                     .body("게시판 등록 실패입니다.");
			 }
		}
	}
	
	@GetMapping("/getDetailSubCode")
	public ResponseEntity<AdminCommonCodeDTO> getDetailSubCode(@RequestParam String commonCode) throws Exception {
		
		AdminCommonCodeDTO result = adminCommonCodeService.getDetailSubCode(commonCode);
		
		
		return ResponseEntity.ok(result);
	    	
	}
	
	
	@PostMapping("/updateSubCommonCode")
	public ResponseEntity<String> updateSubCommonCode(@RequestBody AdminCommonCodeDTO adminCommonCodeDto) {
		
			try {
				adminCommonCodeService.updateSubCommonCode(adminCommonCodeDto);
				return ResponseEntity.ok("수정완료");
			 } catch(Exception e) {
				 e.printStackTrace();
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                     .body("게시판 등록 실패입니다.");
			 }
		
	}
	
	@PostMapping("/deleteSubCommonCode")
	public ResponseEntity<String> deleteSubCommonCode(@RequestBody AdminCommonCodeDTO adminCommonCodeDto) throws Exception {
		String commonCode = adminCommonCodeDto.getCommonCode();
			
		adminCommonCodeService.deleteSubCommonCode(commonCode);
		return ResponseEntity.ok("삭제완료");
		
	}
	@GetMapping("/getListCommonGroup")
	public ResponseEntity<List<AdminCommonGroupCodeDTO>> getListCommonGroup(HttpServletRequest request) {
		
		List<AdminCommonGroupCodeDTO> commonGroupList = adminCommonCodeService.getListCommonGroup();
		
		return ResponseEntity.ok(commonGroupList);
		
	}
	@PostMapping("/insertCommonGroup")
	public ResponseEntity<String> insertCommonGroup(@RequestBody AdminCommonGroupCodeDTO adminCommonGroupCodeDto ,Authentication authentication) {
		int getGroupCode = adminCommonCodeService.getGroupCode(adminCommonGroupCodeDto);
		
		if(getGroupCode != 0) {
			return ResponseEntity.status(405).body(null);
		}
		else {
			try {
				String userId = (String)authentication.getName();
				adminCommonGroupCodeDto.setUserId(userId);
				adminCommonCodeService.insertCommonGroup(adminCommonGroupCodeDto);
				return ResponseEntity.ok("등록완료");
			 } catch(Exception e) {
				 e.printStackTrace();
				 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                     .body("코드 등록 실패입니다.");
			 }
		}
	}
	
	@PostMapping("/updateCommonGroup")
	public ResponseEntity<String> updateCommonGroup(@RequestBody AdminCommonGroupCodeDTO adminCommonGroupCodeDto) {
		
		try {
			adminCommonCodeService.updateCommonGroup(adminCommonGroupCodeDto);
			return ResponseEntity.ok("수정완료");
		 } catch(Exception e) {
			 e.printStackTrace();
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                     .body("코드 수정 실패입니다.");
		 }
	}
	@PostMapping("/deleteCommonGroup")
	public ResponseEntity<String> deleteCommonGroup(@RequestBody AdminCommonGroupCodeDTO adminCommonGroupCodeDto) throws Exception {
		String commonGroupCode = adminCommonGroupCodeDto.getCommonGroupCode();
		
		int getMappingList = adminCommonCodeService.getMappingList(commonGroupCode);
		
		if(getMappingList != 0) {
			return ResponseEntity.status(405).body(null);
		}
		else {
			adminCommonCodeService.deleteCommonGroup(commonGroupCode);
			return ResponseEntity.ok("삭제완료");
		}
	}
}