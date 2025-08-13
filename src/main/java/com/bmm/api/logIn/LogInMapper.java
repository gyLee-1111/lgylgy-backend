package com.bmm.api.logIn;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LogInMapper {
	
	public UserDTO getOngoingUser(String userId);
	 
	public List<UserRoleDTO> getListUserRole(String userId);
	
	public List<UserMenuDTO> getUserMenu(String roleCode);
	
	public List<UserMenuDTO> getUserSubMenu(String roleCode);

}
