package com.bmm.api.authLogIn;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

@Mapper
public interface AuthLogInMapper {
	
	public String getKakaoUser(String id);
	
	public int insertUserKakao(KakaoUserInfoDTO kakaoUserInfoDto);

	public void insertUserRole(@Param("userId") String userId, @Param("roleCode") String roleCode);
}
