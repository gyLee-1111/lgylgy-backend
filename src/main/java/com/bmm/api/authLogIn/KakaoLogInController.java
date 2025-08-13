package com.bmm.api.authLogIn;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmm.api.logIn.LogInResponseDTO;
import com.bmm.api.logIn.LogInService;
import com.bmm.api.logIn.UserRoleDTO;
import com.bmm.api.logIn.security.JwtUtil;

@RestController
@RequestMapping("login")
public class KakaoLogInController {
	
	@Autowired
	private KakaoLogInService kakaoLogInService;
	
	@Autowired
	private LogInService logInService;
	
	@Autowired
	private JwtUtil jwtUtil;
    
	@GetMapping("/kakao/logIn")
	public ResponseEntity<?> kakaoLogIn(@RequestParam String code) {
		try {
			String accessToken = kakaoLogInService.getAccessToken(code);
			
			System.out.println("code" + code);
			
			System.out.println("accessToken" + accessToken);
			
			KakaoUserInfoDTO kakaoUserInfoDto = kakaoLogInService.getUserInfo(accessToken);
			
			System.out.println("id" + kakaoUserInfoDto.getId());
			System.out.println("email" + kakaoUserInfoDto.getEmail());
			System.out.println("nickname" + kakaoUserInfoDto.getNickname());
			
	//		KakaoUserInfoDTO KakaoUserInfoDTO = logInService.getOngoingUser(userId);
			
			// 3. 내 서비스 로그인 처리 (회원가입 or 로그인)
			String userId = kakaoLogInService.getKakaoUser(kakaoUserInfoDto.getId());
			if(userId == null) {
				System.out.println("회원가입이 필요합니다.");
		//		kakaoUserInfoDto = kakaoLogInService.getUserInfo(accessToken);
				kakaoUserInfoDto.setMembership("MEMBERSHIP_02");
				kakaoLogInService.insertUserKakao(kakaoUserInfoDto);
	//			userId = kakaoUserInfoDto.getId();
	//			kakaoLogInService.insertUserRole(userId);
				
			}
			userId = kakaoUserInfoDto.getId();

			List<UserRoleDTO> userRoleList = logInService.getListUserRole(userId);
			
			String token = jwtUtil.generateAccessToken(userId, userRoleList.get(0));
			
			LogInResponseDTO response = new LogInResponseDTO();
			response.setUserId(userId);
			response.setToken(token);
			response.setCurrentRole(userRoleList.get(0));
			response.setUserRoleList(userRoleList);
			
			String refreshToken = jwtUtil.generateRefreshToken(userId);
			
			ResponseCookie httpOnlyCookie = ResponseCookie.from("refreshToken",refreshToken)
					.httpOnly(true)
					.secure(false)
					.path("/")
					.maxAge(Duration.ofDays(1))
			//		.maxAge(Duration.ofSeconds(15))
					.sameSite("Lax")
					.build();
			
			return ResponseEntity.ok()
				    .header("Set-Cookie", httpOnlyCookie.toString())
				    .body(response);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("카카오 로그인 실패: " + e.getMessage());
		}
	}
}
