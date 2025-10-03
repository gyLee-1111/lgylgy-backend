package com.bmm.api.adminUser;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmm.api.adminUser.AdminUserRoleDTO;

import jakarta.transaction.Transactional;

@Service
public class AdminUserService {
	
	@Autowired
	private AdminUserMapper adminUserMapper;

	public List<AdminUserDTO> getListUser() {
		
		return adminUserMapper.getListUser();
	}


	public AdminUserDTO getDetailUser(String userId) {
		return adminUserMapper.getDetailUser(userId);
	}


	public List<AdminUserMappingDTO> getDetailUserRole(String userId) {
		return adminUserMapper.getDetailUserRole(userId);

	}


	public List<AdminUserGenderDTO> getUserGenderList() {
		return adminUserMapper.getUserGenderList();
	}


	public List<AdminUserMembershipDTO> getUserMembershipList() {
		return adminUserMapper.getUserMembershipList();
	}

	@Transactional
	public void updateUser(AdminUserDTO adminUserDto, List<AdminUserMappingDTO> adminUserMappingDtoList) {
		
		adminUserMapper.deleteUserRole(adminUserDto.getUserId());
		
		adminUserMapper.updateUser(adminUserDto);
		
		for (AdminUserMappingDTO adminUserMappingDto : adminUserMappingDtoList) {
			
			adminUserMappingDto.setUserId(adminUserDto.getUserId());
			
			adminUserMapper.insertUserRole(adminUserMappingDto);
		
		}
		
	}


	public void changeLockYn(AdminUserDTO adminUserDto) {
		
		adminUserMapper.changeLockYn(adminUserDto);
	}

	public void changeDormantYn(AdminUserDTO adminUserDto) {
		
		adminUserMapper.changeDormantYn(adminUserDto);
	}

	public int checkUserId(String userId) {
		
		return adminUserMapper.checkUserId(userId);
	}


	public void insertUser(AdminUserDTO adminUserDto, List<AdminUserMappingDTO> adminUserMappingDtoList) {

		String password = adminUserDto.getNormalPassword();
		
		String userPassword = BCrypt.hashpw(password, BCrypt.gensalt());
		
		adminUserDto.setUserPassword(userPassword);
		
		adminUserDto.setLockYn("N");
		
		adminUserDto.setDormantYn("N");
		
		adminUserDto.setMembership("MEMBERSHIP_03");
		
		adminUserMapper.insertUser(adminUserDto);
		
		for (AdminUserMappingDTO adminUserMappingDto : adminUserMappingDtoList) {
			
			adminUserMappingDto.setUserId(adminUserDto.getUserId());
			
			adminUserMapper.insertUserRole(adminUserMappingDto);
		}
	}

	public void deleteUser(String userId) {
		
		adminUserMapper.deleteUserRole(userId);
		
		adminUserMapper.deleteUser(userId);
		
	}


	public int getCountUser(AdminUserDTO adminUserDto) {
		return adminUserMapper.getCountUser(adminUserDto);
	}


	public List<AdminUserDTO> getListUserResponse(AdminUserDTO adminUserDto) {
		return adminUserMapper.getListUserResponse(adminUserDto);
	}


	public List<AdminUserRoleDTO> getListRole() {
		return adminUserMapper.getListRole();
	}



}
