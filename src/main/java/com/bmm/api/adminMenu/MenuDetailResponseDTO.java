package com.bmm.api.adminMenu;

import java.util.List;

public class MenuDetailResponseDTO {
	
	private AdminMenuDTO adminMenuDto;
	
	private List<AdminMenuRoleDTO> adminMenuRoleDto;
	
	private List<AdminUserRoleDTO> allMenuRoleDto;

	public AdminMenuDTO getAdminMenuDto() {
		return adminMenuDto;
	}

	public void setAdminMenuDto(AdminMenuDTO adminMenuDto) {
		this.adminMenuDto = adminMenuDto;
	}

	public List<AdminMenuRoleDTO> getAdminMenuRoleDto() {
		return adminMenuRoleDto;
	}

	public void setAdminMenuRoleDto(List<AdminMenuRoleDTO> adminMenuRoleDto) {
		this.adminMenuRoleDto = adminMenuRoleDto;
	}

	public List<AdminUserRoleDTO> getAllMenuRoleDto() {
		return allMenuRoleDto;
	}

	public void setAllMenuRoleDto(List<AdminUserRoleDTO> allMenuRoleDto) {
		this.allMenuRoleDto = allMenuRoleDto;
	}


	
}
