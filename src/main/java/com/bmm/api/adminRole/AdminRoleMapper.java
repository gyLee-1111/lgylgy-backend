package com.bmm.api.adminRole;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;



@Mapper
public interface AdminRoleMapper {
	


	public List<AdminRoleGroupDTO> getListRoleGroup();

	public void insertRole(AdminRoleInfoDTO adminRoleInfoDto);

	public int checkRoleCode(String roleCode);

	public AdminRoleInfoDTO getDetailRole(String roleCode);

	public void updateRole(AdminRoleInfoDTO request);

	public void deleteRole(String roleCode);

	public void changeUseYn(AdminUserRoleDTO adminUserRoleDto);

	public int checkRoleGroupCode(String roleGroup);

	public void insertRoleGroup(AdminRoleGroupDTO adminRoleGroupDto);

	public AdminRoleGroupDTO getDetailRoleGroup(String roleGroup);

	public void updateRoleGroup(AdminRoleGroupDTO request);

	public void deleteRoleGroup(String roleGroup);

	public void changeUseYnGroup(AdminRoleGroupDTO adminRoleGroupDto);
	
	

	
}
	
