package com.bmm.api.adminMain;

import java.util.List;

public class UserDetailResponseDTO {
	
	private AdminUserDTO adminUserDto;
	
	private List<AdminUserMappingDTO> adminUserMappingDto;
	
	private List<AdminUserRoleDTO> allUserRoleDto;

	public AdminUserDTO getAdminUserDto() {
		return adminUserDto;
	}

	public void setAdminUserDto(AdminUserDTO adminUserDto) {
		this.adminUserDto = adminUserDto;
	}

	public List<AdminUserMappingDTO> getAdminUserMappingDto() {
		return adminUserMappingDto;
	}

	public void setAdminUserMappingDto(List<AdminUserMappingDTO> adminUserMappingDto) {
		this.adminUserMappingDto = adminUserMappingDto;
	}

	public List<AdminUserRoleDTO> getAllUserRoleDto() {
		return allUserRoleDto;
	}

	public void setAllUserRoleDto(List<AdminUserRoleDTO> allUserRoleDto) {
		this.allUserRoleDto = allUserRoleDto;
	}

	
	

	
}
