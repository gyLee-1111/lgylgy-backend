package com.bmm.api.joinMembership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("join/membership")
public class JoinController {
	
	@Autowired
	private JoinService joinService;

	
	@PostMapping("/verification")
	public ResponseEntity<?> verification(@RequestParam String email) throws Exception {
		
		String result = joinService.sendVerificationCode(email);
		System.out.println("email#" + email);
		
		if("failed" == result) {
			System.out.println("result#" + result);
			return ResponseEntity.badRequest().body(result);
		}
		
		return ResponseEntity.ok().build();
	}
	@PostMapping("/checkVerification")
    public ResponseEntity<?> checkVerification(@RequestBody VerificationDTO verificationDto) {
		boolean result = joinService.checkVerification(verificationDto.getEmail(), verificationDto.getCode());
		
		 if (result) {
	            return ResponseEntity.ok("인증 성공");
	        } else {
	            return ResponseEntity.badRequest().body("인증 실패 또는 만료된 코드입니다.");
	        }
	}
	@PostMapping("/insertUser")
    public ResponseEntity<?> insertUser(@RequestBody JoinMembershipDTO joinMembershipDto) {
		/*
		joinMembershipDto.setLockYn("N");
		
		joinMembershipDto.setDormantYn("N");
		
		joinMembershipDto.setMembership("MEMBERSHIP_01");
		*/
		joinService.insertUser(joinMembershipDto);
		
		return ResponseEntity.ok("가입완료");
	}
}
