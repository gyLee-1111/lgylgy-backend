package com.bmm.api.logIn.security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	private static final AntPathMatcher pathMatcher = new AntPathMatcher();

	public JwtAuthenticationFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	private static final List<String> EXCLUDE_URLS = List.of(
			// "/login/ongoing/refreshToken", // 여기에 제외할 경로 추가
			// "/login/ongoing/ongoingLogInApi",
			// "/login/ongoing/ongoingLogOut",
			"/images/**", "/user/keyword/getListKeyword", "/public/category/getTopCategory",
			"/login/logInApi",
			"/login/getUserMenu",
			// "/login/refreshToken",
			"/login/logOut",
			"/login/kakao/logInApi"
	// ,"/reviewPop/**"
//	                   "/login/**"
	);

	private boolean isExcludePath(String path) {
		return EXCLUDE_URLS.stream().anyMatch(pattern -> pathMatcher.match(pattern, path));
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request,
									HttpServletResponse response,
									FilterChain filterChain) throws ServletException, IOException {
		// CORS 응답 헤더 설정
       // response.setHeader("Access-Control-Allow-Origin", "http://localhost:5174");
	    response.setHeader("Access-Control-Allow-Origin", "https://calm-stone-09e440100.1.azurestaticapps.net");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // OPTIONS 요청이면 여기서 끝냄 (200 OK)
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
        	System.out.println("options return");
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        String path = request.getRequestURI();
        System.out.println("url : "+ path);

        
		/*
		 * if (isExcludePath(path)) { System.out.println("화이트 리스트 ");
		 * filterChain.doFilter(request, response); return; }
		 */
		 
        
        
		String authHeader = request.getHeader("Authorization"); 
		System.out.println("token : " + authHeader);
		
		
		
		if (authHeader != null && authHeader.startsWith("Bearer ") ) {
			System.out.println(111);
			String token = authHeader.substring(7);
			System.out.println("토큰검사전 1");
			if(jwtUtil.validateToken(token)) {
				try {
					System.out.println("토큰검사전 2");
					LogInTokenInfo tokenInfo = jwtUtil.tokenInfoToToken(token);
					String roleCode = tokenInfo.getRole().getRoleCode();
					///현재 권한으로 수정
					//List<GrantedAuthority> authorities = tokenInfo.getRoles().stream()
					//		.map(role -> new SimpleGrantedAuthority(role))
					//		.collect(Collectors.toList());
					GrantedAuthority authority = new SimpleGrantedAuthority(roleCode);
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(tokenInfo.getUserId(), null,  List.of(authority));
					SecurityContextHolder.getContext().setAuthentication(authentication);
					System.out.println("시큐리티 생성");
					request.setAttribute("tokenInfo", tokenInfo);
					
					//filterChain.doFilter(request, response);
	                //return;
					
				} catch(Exception e) {
					System.err.println(e.getMessage());
					response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Token");
				//	((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid Token");
					
				}
			} 
	      }
		
		filterChain.doFilter(request, response);
		return;
				
					/*
					 * if (isExcludePath(path)) { System.out.println("화이트 리스트 ");
					 * filterChain.doFilter(request, response); // 필터 건너뜀 return; }
					 * System.out.println("화이트 리스트 x");
					 */
//  Access Token이 없으면 401
	//response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Token is missing");
	
 //   return;
	}
}
