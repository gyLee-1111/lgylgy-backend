package com.bmm.api.adminMain;

import java.util.List;

public class MenuInsertRequestDTO {
	
	private AdminMenuDTO adminMenuDto;
	
	private List<AdminMenuRoleDTO> adminMenuRoleDto;
	
	private String message;

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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

}
