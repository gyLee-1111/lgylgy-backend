package com.bmm.api.adminMain;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;



@Mapper
public interface AdminMainMapper {
	
	public List<AdminMenuDTO> getAdminMenu(String roleCode);
	
	public List<AdminMenuDTO> getAdminSubMenu(String roleCode);
	
	public List<AdminBoardDTO> getListBoard();
	
	public void insertBoard(AdminBoardDTO AdminBoardDto);
	
	public String findLatestBoardCode(@Param("prefix") String prefix);
	
	public AdminBoardDTO getDetailBoard(String boardCode);
	
	public List<AdminBoardRoleDTO> getDetailBoardrole(String boardCode);
	
	public void updateBoard(AdminBoardDTO AdminBoardDto);
	
	public void deleteBoard(String boardCode);
	
	public void deleteBoardrole(String boardCode);
	
	public List<AdminUserRoleDTO> getListRole();
	
	public void insertBoardrole(AdminBoardRoleDTO adminBoardRoleDto);
	
	//public void updateBoardrole(AdminBoardRoleDTO adminBoardRoleDto);
}
