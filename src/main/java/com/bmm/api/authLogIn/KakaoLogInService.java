package com.bmm.api.authLogIn;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class KakaoLogInService {
	
	@Autowired
	private AuthLogInMapper authLogInMapper;
	
	private final RestTemplate restTemplate = new RestTemplate();
	
	private final String clientId = "fe59b027894ddb6206595e9c8c0f113e";
	
	private final String redirectUrl = "http://localhost:5174/categoryList";
	
	public String getAccessToken(String code) {
		String url = "https://kauth.kakao.com/oauth/token";
		
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        params.add("client_id", clientId);
        params.add("redirect_url", redirectUrl);
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);
        return (String) response.getBody().get("access_token");
	}
	
	public KakaoUserInfoDTO getUserInfo(String accessToken) {
		String url = "https://kapi.kakao.com/v2/user/me";
		

	    HttpHeaders headers = new HttpHeaders();
	    headers.setBearerAuth(accessToken);
	    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

	    HttpEntity<Void> request = new HttpEntity<>(headers);
	    ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, request, Map.class);

	    Map<String, Object> body = response.getBody();
	    Long idLong = ((Number) body.get("id")).longValue();
	    String id = String.valueOf(idLong);

	    Map<String, Object> kakaoAccount = (Map<String, Object>) body.get("kakao_account");
	    String email = (String) kakaoAccount.get("email");

	    Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");
	    String nickname = (String) profile.get("nickname");

	    // DTO에 담아서 반환
	    KakaoUserInfoDTO kakaoUserInfoDto = new KakaoUserInfoDTO();
	    kakaoUserInfoDto.setId(id);
	    kakaoUserInfoDto.setEmail(email);
	    kakaoUserInfoDto.setNickname(nickname);

	    return kakaoUserInfoDto;
		
		
	}
	// 3. 회원가입 or 로그인
    public String getKakaoUser(String id) {
    	
        return authLogInMapper.getKakaoUser(id);
	}
    @Transactional
	public void insertUserKakao(KakaoUserInfoDTO kakaoUserInfoDto) {
		 authLogInMapper.insertUserKakao(kakaoUserInfoDto);
		 
		 authLogInMapper.insertUserRole(kakaoUserInfoDto.getId(), "USER_NOMAL");
	}
	
//	public void insertUserRole(String userId) {
//		authLogInMapper.insertUserRole(userId, "USER_NOMAL");
//	}
	
}
