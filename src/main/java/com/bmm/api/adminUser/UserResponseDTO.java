package com.bmm.api.adminUser;

import java.util.List;

public class UserResponseDTO {
	
	private int totalCount;
	
	private List<AdminUserDTO> adminUserDto;

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public List<AdminUserDTO> getAdminUserDto() {
		return adminUserDto;
	}

	public void setAdminUserDto(List<AdminUserDTO> adminUserDto) {
		this.adminUserDto = adminUserDto;
	}

	
	

}
