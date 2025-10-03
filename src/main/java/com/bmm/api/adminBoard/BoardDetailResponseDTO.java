package com.bmm.api.adminBoard;

import java.util.List;

import com.bmm.api.adminMenu.AdminUserRoleDTO;

public class BoardDetailResponseDTO {
	
	private AdminBoardDTO adminBoardDto;
	
	private List<AdminBoardRoleDTO> adminBoardRoleDto;
	
	private List<AdminUserRoleDTO> allBoardRoleDto;

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

	public List<AdminUserRoleDTO> getAllBoardRoleDto() {
		return allBoardRoleDto;
	}

	public void setAllBoardRoleDto(List<AdminUserRoleDTO> allBoardRoleDto) {
		this.allBoardRoleDto = allBoardRoleDto;
	}
	
	
	

}
