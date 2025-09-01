package com.bmm.api.adminMain;

import java.util.List;

public class BoardDetailResponseDTO {
	
	private AdminBoardDTO adminBoardDto;
	
	private List<AdminBoardRoleDTO> adminBoardRoleDto;

	public AdminBoardDTO getAdminBoardDto() {
		return adminBoardDto;
	}

	public void setAdminBoardDto(AdminBoardDTO adminBoardDto) {
		this.adminBoardDto = adminBoardDto;
	}

	public List<AdminBoardRoleDTO> getAdminBoardRoleDto() {
		return adminBoardRoleDto;
	}

	public void setAdminBoardRoleDto(List<AdminBoardRoleDTO> adminBoardRoleDto) {
		this.adminBoardRoleDto = adminBoardRoleDto;
	}

}
