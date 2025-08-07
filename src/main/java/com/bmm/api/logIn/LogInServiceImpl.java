package com.bmm.api.logIn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LogInServiceImpl implements LogInService {

	@Autowired
	private LogInMapper logInMapper;
	
	@Override
    public UserDTO getOngoingUser(String userId) {
		
		return logInMapper.getOngoingUser(userId);
	}
	
	@Override
	public List<UserRoleDTO> getListUserRole(String userId) throws Exception{
		
		return logInMapper.getListUserRole(userId);
	}
	@Override
	public List<UserMenuDTO> getUserMenu(String roleCode) throws Exception{
		
		return logInMapper.getUserMenu(roleCode);
	}
	
}
