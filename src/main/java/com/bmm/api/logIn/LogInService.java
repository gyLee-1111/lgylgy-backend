package com.bmm.api.logIn;

import java.util.List;

public interface LogInService {
	
	public UserDTO getOngoingUser(String userId) throws Exception;

	public List<UserRoleDTO> getListUserRole(String userId) throws Exception;
	
	public List<UserMenuDTO> getUserMenu(String roleCode) throws Exception;
	
	public List<UserMenuDTO> getUserSubMenu(String roleCode) throws Exception;
	
	public UserInfoDTO getUserInfo(String userId) throws Exception;
	
}
