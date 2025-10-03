package com.bmm.api.adminUser;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface AdminUserMapper {

	
	public List<AdminUserRoleDTO> getListRole();

	public List<AdminUserDTO> getListUser();

	public AdminUserDTO getDetailUser(String userId);

	public List<AdminUserMappingDTO> getDetailUserRole(String userId);

	public List<AdminUserMembershipDTO> getUserMembershipList();

	public List<AdminUserGenderDTO> getUserGenderList();

	public void deleteUserRole(String userId);

	public void updateUser(AdminUserDTO adminUserDto);

	public void insertUserRole(AdminUserMappingDTO adminUserMappingDto);

	public void changeLockYn(AdminUserDTO adminUserDto);

	public void changeDormantYn(AdminUserDTO adminUserDto);

	public int checkUserId(String userId);

	public void insertUser(AdminUserDTO adminUserDto);

	public void deleteUser(String userId);

	public int getCountUser(AdminUserDTO adminUserDto);

	public List<AdminUserDTO> getListUserResponse(AdminUserDTO adminUserDto);

	
	
}
	
