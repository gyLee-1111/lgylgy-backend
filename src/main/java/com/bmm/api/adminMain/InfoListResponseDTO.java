package com.bmm.api.adminMain;

import java.util.List;

public class InfoListResponseDTO {
	
	private List<AdminUserGenderDTO> adminUserGenderDto;
	
	private List<AdminUserMembershipDTO> adminUserMembershipDto;

	public List<AdminUserGenderDTO> getAdminUserGenderDto() {
		return adminUserGenderDto;
	}

	public void setAdminUserGenderDto(List<AdminUserGenderDTO> adminUserGenderDto) {
		this.adminUserGenderDto = adminUserGenderDto;
	}

	public List<AdminUserMembershipDTO> getAdminUserMembershipDto() {
		return adminUserMembershipDto;
	}

	public void setAdminUserMembershipDto(List<AdminUserMembershipDTO> adminUserMembershipDto) {
		this.adminUserMembershipDto = adminUserMembershipDto;
	}

	

	
}
