package com.bmm.api.adminRole;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AdminRoleService {
	
	@Autowired
	private AdminRoleMapper adminMainMapper;

	


	public List<AdminRoleGroupDTO> getListRoleGroup() {
		
		return adminMainMapper.getListRoleGroup();
	}


	public void insertRole(AdminRoleGroupDTO adminRoleGroupDto) {

		
	}


	public void insertRole(AdminRoleInfoDTO adminRoleInfoDto) {
		
		adminRoleInfoDto.setUseYn("Y");
		
		adminMainMapper.insertRole(adminRoleInfoDto);
		
	}


	public int checkRoleCode(String roleCode) {
	
		return adminMainMapper.checkRoleCode(roleCode);
	}


	public AdminRoleInfoDTO getDetailRole(String roleCode) {
		return adminMainMapper.getDetailRole(roleCode);
	}


	public void updateRole(AdminRoleInfoDTO request) {
		adminMainMapper.updateRole(request);
	}


	public void deleteRole(String roleCode) {
		adminMainMapper.deleteRole(roleCode);
	}


	public void changeUseYn(AdminUserRoleDTO adminUserRoleDto) {
		adminMainMapper.changeUseYn(adminUserRoleDto);
	}


	public int checkRoleGroupCode(String roleGroup) {
		
		return adminMainMapper.checkRoleGroupCode(roleGroup);
	}
	
	public void insertRoleGroup(AdminRoleGroupDTO adminRoleGroupDto) {
		adminRoleGroupDto.setUseYn("Y");
		
		adminMainMapper.insertRoleGroup(adminRoleGroupDto);
	}


	public AdminRoleGroupDTO getDetailRoleGroup(String roleGroup) {
		return adminMainMapper.getDetailRoleGroup(roleGroup);
	}


	public void updateRoleGroup(AdminRoleGroupDTO request) {
		adminMainMapper.updateRoleGroup(request);
	}


	public void deleteRoleGroup(String roleGroup) {
		adminMainMapper.deleteRoleGroup(roleGroup);
	}


	public void changeUseYnGroup(AdminRoleGroupDTO adminRoleGroupDto) {
		adminMainMapper.changeUseYnGroup(adminRoleGroupDto);
	}


}
