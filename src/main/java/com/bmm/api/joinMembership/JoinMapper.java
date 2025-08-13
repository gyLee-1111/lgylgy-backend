package com.bmm.api.joinMembership;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;



@Mapper
public interface JoinMapper {
	
	public void insertVerification(VerificationDTO verificationDto);
	
	public VerificationDTO getVerification(String email);
	
	public void insertUser(JoinMembershipDTO joinMembershipDto);

	public void insertUserRole(@Param("userId") String userId, @Param("roleCode") String roleCode);
	
	public int checkUserId(String userId);
}
