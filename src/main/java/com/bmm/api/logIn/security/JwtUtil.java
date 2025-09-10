package com.bmm.api.logIn.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.bmm.api.logIn.UserRoleDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtil {

	private final String secret = "ongoinglogintokensecretkeyongoinglogintokensecretkey112233"; // 반드시 32바이트 이상으로
	//private final long expirationMs = 1000 * 60 * 1; // 1분
	
	private final long accessTokenExpirationMs = 1000 * 60 * 60; // 1시간
	//리프레시 토큰
	private final long refreshTokenExpirationMs = 1000L * 60 * 60 * 3; //3시간
	
//jwt 서명에 쓸 key 객채화
	private final Key key = Keys.hmacShaKeyFor(secret.getBytes());

	public String generateAccessToken(String userId, UserRoleDTO role) {
        Claims claims = Jwts.claims().setSubject(userId);
        claims.put("userId", userId);
        claims.put("role", role);
        
        
        return Jwts.builder()
        		.setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
	
    public String generateRefreshToken(String userId) {
    	
    	System.out.println("refresh" + userId);
        Claims claims = Jwts.claims().setSubject(userId);
        claims.put("userId", userId);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }
    
	public LogInTokenInfo tokenInfoToToken(String token) throws Exception {
		/* try { */
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(key)
					.build()
					.parseClaimsJws(token)
					.getBody();
	
			LogInTokenInfo logInTokenInfo = new LogInTokenInfo();
			logInTokenInfo.setUserId((String)claims.get("userId"));
			
			Object roleObject = claims.get("role");
			if(roleObject != null) {
			UserRoleDTO role = new ObjectMapper().convertValue(roleObject, UserRoleDTO.class);
			logInTokenInfo.setRole(role);
			} else {
				System.out.println("role Null");
			}
	        return logInTokenInfo;
		/*} catch (ExpiredJwtException e) {
			System.out.println("❗ JWT 만료: " + e.getMessage());
	        return null;
		} catch (Exception e) {
	        System.out.println("❗ JWT 파싱 실패: " + e.getMessage());
	        return null;
	    }*/
	}
	  
	public boolean validateToken(String token) {
		try {
			Claims claims = Jwts.parserBuilder()
				    .setSigningKey(key)
				    .build()
				    .parseClaimsJws(token)
				    .getBody();
			return true;
		} catch (ExpiredJwtException e) {
	        System.out.println("토큰 만료" + e.getMessage());
	        return false;
		} catch (JwtException e) {
			System.out.println("잘못된 토큰" + e.getMessage());
			return false;
		}
	}
	
    public String getUserIdFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("userId", String.class);
    }
    public String getTokenExtraction(HttpServletRequest request) {
    	String bearer = request.getHeader("Authorization");
    	if (bearer != null && bearer.startsWith("Bearer")) {
    		return bearer.substring(7);
    	}
    	return null;
    }
    
    
}