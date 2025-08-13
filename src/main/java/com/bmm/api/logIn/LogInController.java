package com.bmm.api.logIn;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmm.api.logIn.security.JwtUtil;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("login")
public class LogInController {
	
	@Autowired
	private LogInService logInService;
	
	
	private final JwtUtil jwtUtil;
	
	public LogInController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

	@PostMapping(value = "/logInApi")
	public ResponseEntity<LogInResponseDTO> logInApi(@RequestParam String userId,
														@RequestParam String userPassword,
														HttpServletResponse servletResponse) throws Exception {
	
	//	System.out.println("#####################");
		
		UserDTO userDto = logInService.getOngoingUser(userId);
		
	//	System.out.println("#####################");
		
		if(userDto == null) {
			LogInResponseDTO errorMessage = new LogInResponseDTO();
			errorMessage.setMessage("등록되지 않은 아이디 입니다.");
			return ResponseEntity.status(404).body(errorMessage);
		}
		
		if (!BCrypt.checkpw(userPassword, userDto.getUserPassword())) {
			LogInResponseDTO errorMessage = new LogInResponseDTO();
			errorMessage.setMessage("비밀번호가 일치하지 않습니다.");
			return ResponseEntity.status(404).body(errorMessage);
		}
		
		List<UserRoleDTO> userRoleList = logInService.getListUserRole(userId);
		
	//	System.out.println("###유저롤##@#" + userRoleList.getRoleCode());
		
		String token = jwtUtil.generateAccessToken(userId, userRoleList.get(0));
		
		
		LogInResponseDTO response = new LogInResponseDTO();
		response.setUserId(userId);
		response.setToken(token);
		//첫번째 로우 자동 선택
		response.setCurrentRole(userRoleList.get(0));
		//전체 권한 목록
	    response.setUserRoleList(userRoleList);
	    
	    System.out.println("###################@#" + userRoleList.get(0));
		//리프레쉬 토큰 
		String refreshToken = jwtUtil.generateRefreshToken(userId);
		
		ResponseCookie httpOnlyCookie = ResponseCookie.from("refreshToken",refreshToken)
				.httpOnly(true)
				.secure(false)
				.path("/")
				.maxAge(Duration.ofDays(1))
		//		.maxAge(Duration.ofSeconds(15))
				.sameSite("Lax")
				.build();
		
		servletResponse.addHeader("Set-Cookie", httpOnlyCookie.toString());
		
		return ResponseEntity.ok(response);
		
		}
		
	@PostMapping("/refreshToken")
	public ResponseEntity<?> refreshToken(HttpServletRequest request, HttpServletResponse response){
		
		String refreshToken = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			System.out.println("쿠키존재");
			for (Cookie cookie : cookies) {
				if("refreshToken".equals(cookie.getName())) {
					refreshToken = cookie.getValue();
					break;
				}
			}
		}
		
		if (refreshToken == null) {
			return ResponseEntity.status(401).body("리프레시 토큰 없음");
		}
		
		if(!jwtUtil.validateToken(refreshToken)) {
			return ResponseEntity.status(401).body("유효하지 않은 토큰");
		}
		
		String userId = jwtUtil.getUserIdFromToken(refreshToken);
		
		try {
			List<UserRoleDTO> userRoles = logInService.getListUserRole(userId);
			
			String newAccessToken = jwtUtil.generateAccessToken(userId, userRoles.get(0));
			
			LogInResponseDTO responseDto = new LogInResponseDTO();
			
			responseDto.setUserId(userId);
			responseDto.setToken(newAccessToken);
			
			return ResponseEntity.ok(responseDto);
			
		} catch(Exception e){
			return ResponseEntity.status(500).body("권한 조회 실패");
		}
	}
	
    @PostMapping("/logOut")
    public ResponseEntity<?> logOut(HttpServletResponse response) {
    	System.out.println("logout");
        ResponseCookie deleteCookie = ResponseCookie.from("refreshToken", "")
                .path("/")
                .httpOnly(true)
                .secure(false)
                .maxAge(0) // 쿠키 삭제
                .sameSite("Lax")
                .build();
        response.addHeader("Set-Cookie", deleteCookie.toString());
        return ResponseEntity.ok("로그아웃 성공");
    }
    
    @PostMapping(value = "/changeRole")
	public ResponseEntity<?> changeRole(@RequestParam String roleCode,
														HttpServletResponse servletResponse, Authentication authentication) throws Exception {
    
    	System.out.println("enter change");
    	String userId = (String)authentication.getPrincipal();
    	
    	System.out.println("###################@#" + userId);
    	
		List<UserRoleDTO> userRoleList = logInService.getListUserRole(userId);
		
		System.out.println("###################@#" + userRoleList);
		
		UserRoleDTO currentRole = null;
		
		for (UserRoleDTO role : userRoleList) {
			  if (role.getRoleCode().equals(roleCode)) {
			   currentRole = role;
			   }
		}
		
		if(currentRole == null) {
			return ResponseEntity.status(401).body("잘못된 권한 접근");
		}
		try {
			
			String newtoken = jwtUtil.generateAccessToken(userId, currentRole);
			
			LogInResponseDTO response = new LogInResponseDTO();
			response.setUserId(userId);
			response.setToken(newtoken);
			//첫번째 로우 자동 선택
			response.setCurrentRole(currentRole);
			//전체 권한 목록
		    response.setUserRoleList(userRoleList);
		    
			//리프레쉬 토큰 
			String refreshToken = jwtUtil.generateRefreshToken(userId);
			
			ResponseCookie httpOnlyCookie = ResponseCookie.from("refreshToken",refreshToken)
					.httpOnly(true)
					.secure(false)
					.path("/")
			//		.maxAge(Duration.ofDays(1))
					.maxAge(Duration.ofSeconds(15))
					.sameSite("Lax")
					.build();
			
			servletResponse.addHeader("Set-Cookie", httpOnlyCookie.toString());
			
			System.out.println("userRoleList###################@#" + userRoleList);
			System.out.println("현재권한###################@#" + currentRole);
			
			System.out.println("refreshToken###################@#" + refreshToken);
			return ResponseEntity.ok(response);
			
		} catch (Exception e) {
			return ResponseEntity.status(500).body("권한 조회 실패");
		}
		
	}
    
	@GetMapping("/getUserMenu")
	public ResponseEntity<List<UserMenuDTO>> getUserMenu(@RequestParam String roleCode) throws Exception {
		System.out.println("#################"+roleCode);
		List<UserMenuDTO> list = logInService.getUserMenu(roleCode);
		System.out.println("상위 메뉴 수: " + list.size());
		List<UserMenuDTO> sublist = logInService.getUserSubMenu(roleCode);
		System.out.println("하위 메뉴 수: " + sublist.size());
		for (UserMenuDTO parent : list) {
			System.out.println("asdsad#################@#" + parent);
		    parent.setChildren(new ArrayList<>());
		    for (UserMenuDTO child : sublist) {
		    	System.out.println(" - 자식 후보: " + child.getMenuNm() + " → 부모코드: " + child.getParentCode());
		    	System.out.println("child###############@#" + child);
		        if (parent.getMenuCode() == child.getParentCode()) {
		            parent.getChildren().add(child);
		            System.out.println("childchild###############@#");

		         //   System.out.println("childchild###############@#" + child.getParentCode());
		        }
		    }
		}
		
		return ResponseEntity.ok(list);
	}
	
    

}
