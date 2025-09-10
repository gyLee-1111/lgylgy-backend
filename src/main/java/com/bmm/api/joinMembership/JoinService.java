package com.bmm.api.joinMembership;

import java.time.LocalDateTime;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JoinService {
	
	@Autowired
	private JoinMapper joinMapper;
	
	@Autowired
	private JavaMailSender mailSender;
	


	private static final int CODE_EXPIRATION_MINUTES = 3;
	
	// 인증코드와 만료시간을 묶어서 하나의 객체로 관리하기 위한 도우미 클래스
	// 하나로 만들지 않으면 두개의 객체로 관리하기 때문에 오류날 가능성이 올라감
	/*private static class VerificationData {
		private String code;
		private LocalDateTime expirationTime;
	    VerificationData(String code, LocalDateTime expirationTime) {
	        this.code = code;
	        this.expirationTime = expirationTime;
	    }
	}
	private final ConcurrentHashMap<String, VerificationData> verificationCodes = new ConcurrentHashMap<>();*/
	
	public String sendVerificationCode(String email) {
		
		
		int checkId = joinMapper.checkUserId(email);
		
		if(checkId == 1) {
			return "failed";
		}
		
		System.out.println("checkId#" + checkId);
		
		String code = String.valueOf((int)(Math.random() * 900000) + 100000);
		LocalDateTime expirationTime = LocalDateTime.now().plusMinutes(CODE_EXPIRATION_MINUTES);
		System.out.println("code#" + code);
		System.out.println("expirationTime#" + expirationTime);
		
		//e-mail 보내는 서비스
		SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("[회원가입 인증] 인증번호를 확인해주세요.");
        message.setText("인증번호는: " + code);
        message.setFrom("gy4171@naver.com");
        mailSender.send(message);
		//e-mail 보내는 서비스
		
		VerificationDTO verificationDto = new VerificationDTO();
		
		verificationDto.setEmail(email);
		verificationDto.setCode(code);
		verificationDto.setExpirationTime(expirationTime);
		
		joinMapper.insertVerification(verificationDto);
		
		return "success";
		
	}
	public boolean checkVerification(String email, String code) {
		VerificationDTO verificationDto = joinMapper.getVerification(email);

        if (verificationDto == null) {
        	return false;
        }

        if (verificationDto.getExpirationTime().isBefore(LocalDateTime.now())) {
           
            return false;
        }
        boolean result = code != null && code.equals(verificationDto.getCode());
        
        return  result;
    }
	@Transactional
	public void insertUser(JoinMembershipDTO joinMembershipDto) {

		String password = joinMembershipDto.getNormalPassword();
		
		String userPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		
		joinMembershipDto.setUserPassword(userPassword);
		
		joinMembershipDto.setLockYn("N");
		
		joinMembershipDto.setDormantYn("N");
		
		joinMembershipDto.setMembership("MEMBERSHIP_01");
		
	//	System.out.println(joinMembershipDto.getUserId());
		joinMapper.insertUser(joinMembershipDto);
		
		joinMapper.insertUserRole(joinMembershipDto.getEmail(),"USER_NORMAL");
	}
	public void updateUser(JoinMembershipDTO joinMembershipDto) {
		String password = joinMembershipDto.getNormalPassword();
		
		String userPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		
		joinMembershipDto.setUserPassword(userPassword);
		
		joinMapper.updateUser(joinMembershipDto);
		
	}
	public void updateUserNotPass(JoinMembershipDTO joinMembershipDto) {
		joinMapper.updateUserNotPass(joinMembershipDto);
		
	}
	

}
