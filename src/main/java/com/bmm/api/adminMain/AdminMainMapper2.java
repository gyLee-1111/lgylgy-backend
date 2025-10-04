//package com.bmm.api.adminMain;
//
//import java.util.List;
//
//import org.apache.ibatis.annotations.Mapper;
//import org.springframework.data.repository.query.Param;
//
//
//
//@Mapper
//public interface AdminMainMapper2 {
//	
//	public List<AdminMenuDTO> getAdminMenu(String roleCode);
//	
//	public List<AdminMenuDTO> getAdminSubMenu(String roleCode);
//	
//	public List<AdminBoardDTO> getListBoard();
//	
//	public void insertBoard(AdminBoardDTO AdminBoardDto);
//	
//	public String findLatestBoardCode(@Param("prefix") String prefix);
//	
//	public AdminBoardDTO getDetailBoard(String boardCode);
//	
//	public List<AdminBoardRoleDTO> getDetailBoardrole(String boardCode);
//	
//	public void updateBoard(AdminBoardDTO AdminBoardDto);
//	
//	public void deleteBoard(String boardCode);
//	
//	public void deleteBoardrole(String boardCode);
//	
//	public List<AdminUserRoleDTO> getListRole();
//	
//	public void insertBoardrole(AdminBoardRoleDTO adminBoardRoleDto);
//
//	public List<AdminMenuDTO> getListMenu(String menuType);
//
//	public AdminMenuDTO getDetailMenu(int menuCode);
//
//	public List<AdminMenuRoleDTO> getDetailMenuRole(int menuCode);
//
//	public List<AdminMenuTypeDTO> getListMenuType();
//
//	public int findLatestMenuCode();
//
//	public void insertMenu(AdminMenuDTO adminMenuDto);
//
//	public void insertMenuRole(AdminMenuRoleDTO adminMenuRoleDto);
//
//	public int getDepth(int parentCode);
//
//	public int getMenuPath(String path);
//
//	public List<AdminMenuDTO> getListMenuUpper(String menuType);
//
//	public int getMenuSort(AdminMenuDTO adminMenuDto);
//
//	public Object getListMenuUpper(int menuCode, int sortOrder);
//
//	public void updateSortOrder(AdminMenuDTO adminMenuDto);
//
//	public void deleteMenurole(int menuCode);
//
//	public void deleteMenu(int menuCode);
//
//	public void contectSortOrder(AdminMenuDTO adminMenuDto);
//
//	public int getCountChildren(int menuCode);
//
//	public List<AdminMenuDTO> getListParent();
//
//	public void updateMenu(AdminMenuDTO adminMenuDto);
//
//	public List<AdminUserDTO> getListUser();
//
//	public AdminUserDTO getDetailUser(String userId);
//
//	public List<AdminUserMappingDTO> getDetailUserRole(String userId);
//
//	public List<AdminUserMembershipDTO> getUserMembershipList();
//
//	public List<AdminUserGenderDTO> getUserGenderList();
//
//	public void deleteUserRole(String userId);
//
//	public void updateUser(AdminUserDTO adminUserDto);
//
//	public void insertUserRole(AdminUserMappingDTO adminUserMappingDto);
//
//	public void changeLockYn(AdminUserDTO adminUserDto);
//
//	public void changeDormantYn(AdminUserDTO adminUserDto);
//
//	public int checkUserId(String userId);
//
//	public void insertUser(AdminUserDTO adminUserDto);
//
//	public void deleteUser(String userId);
//
//	public int getCountUser(AdminUserDTO adminUserDto);
//
//	public List<AdminUserDTO> getListUserResponse(AdminUserDTO adminUserDto);
//
//	public List<AdminRoleGroupDTO> getListRoleGroup();
//
//	public void insertRole(AdminRoleInfoDTO adminRoleInfoDto);
//
//	public int checkRoleCode(String roleCode);
//
//	public AdminRoleInfoDTO getDetailRole(String roleCode);
//
//	public void updateRole(AdminRoleInfoDTO request);
//
//	public void deleteRole(String roleCode);
//
//	public void changeUseYn(AdminUserRoleDTO adminUserRoleDto);
//
//	public int checkRoleGroupCode(String roleGroup);
//
//	public void insertRoleGroup(AdminRoleGroupDTO adminRoleGroupDto);
//
//	public AdminRoleGroupDTO getDetailRoleGroup(String roleGroup);
//
//	public void updateRoleGroup(AdminRoleGroupDTO request);
//
//	public void deleteRoleGroup(String roleGroup);
//
//	public void changeUseYnGroup(AdminRoleGroupDTO adminRoleGroupDto);
//
//	public List<AdminCommonGroupCodeDTO> getListCommonGroupCode();
//
//	public int getCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto);
//
//	public void insertUpperCommonCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto);
//
//	public AdminCommonGroupCodeDTO getDetailUpperCode(String commonGroupCode);
//
//	public List<AdminCommonGroupCodeDTO> getListCommonSubCode(String commonGroupCode);
//
//	public AdminCommonGroupCodeDTO getDetailSubCode(String commonCode);
//
//	public int getSubCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto);
//
//	public void insertSubCommonCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto);
//
//	public void updateUpperCommonCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto);
//
//	public void updateSubCommonCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto);
//
//	public int getSubCodeList(String commonGroupCode);
//
//	public void deleteUpperCommonCode(String commonGroupCode);
//
//	public void deleteSubCommonCode(String commonCode);
//
//}
