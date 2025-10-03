package com.bmm.api.adminBoard;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.bmm.api.adminMenu.AdminUserRoleDTO;



@Mapper
public interface AdminBoardMapper {
	
	public List<AdminBoardDTO> getListBoard();
	
	public void insertBoard(AdminBoardDTO AdminBoardDto);
	
	public String findLatestBoardCode(@Param("prefix") String prefix);

	public void insertBoardrole(AdminBoardRoleDTO adminBoardRoleDto);

	public AdminBoardDTO getDetailBoard(String boardCode);

	public List<AdminBoardRoleDTO> getDetailBoardrole(String boardCode);

	public void updateBoard(AdminBoardDTO adminBoardDto);

	public void deleteBoardrole(String boardCode);

	public void deleteBoard(String boardCode);

	public List<AdminUserRoleDTO> getListRole();
	
}
	
