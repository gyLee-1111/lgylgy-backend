package com.bmm.api.adminMain;

import java.util.List;

public class UserInsertRequestDTO {
	
	private AdminUserDTO adminUserDto;
	
	private List<AdminUserMappingDTO> adminUserMappingDto;

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

	
	

}
