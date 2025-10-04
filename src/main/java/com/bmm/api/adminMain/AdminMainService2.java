//package com.bmm.api.adminMain;
//
//import java.util.List;
//
//import org.mindrot.jbcrypt.BCrypt;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import jakarta.transaction.Transactional;
//
//@Service
//public class AdminMainService2 {
//	
//	@Autowired
//	private AdminMainMapper adminMainMapper;
//
//	
//	public List<AdminMenuDTO> getAdminMenu(String roleCode)	{
//		
//		return adminMainMapper.getAdminMenu(roleCode);
//	}
//	
//
//	public List<AdminMenuDTO> getAdminSubMenu(String roleCode)	{
//		
//		return adminMainMapper.getAdminSubMenu(roleCode);
//	}
//	
//	public List<AdminBoardDTO> getListBoard() {
//    	
//    	return adminMainMapper.getListBoard();
//    			
//    }
//	@Transactional
//	public void insertBoard(AdminBoardDTO adminBoardDto, List<AdminBoardRoleDTO> adminBoardRoleDtoList) {
//		
//		String newBoardCode = generateNextBoardCode("BOARD_");
//		
//		adminBoardDto.setBoardCode(newBoardCode);
//		
//		adminMainMapper.insertBoard(adminBoardDto);
//		
//		for (AdminBoardRoleDTO adminBoardRoleDto : adminBoardRoleDtoList) {
//			
//			adminBoardRoleDto.setBoardCode(newBoardCode);
//			
//			adminMainMapper.insertBoardrole(adminBoardRoleDto);
//		
//		}
//		
//	}
//	
//	private String generateNextBoardCode(String prefix) {
//        String lastCode = adminMainMapper.findLatestBoardCode(prefix);
//        int nextNumber = 1;
//
//        if (lastCode != null && lastCode.startsWith(prefix)) {
//            String numberPart = lastCode.substring(prefix.length());
//            try {
//                nextNumber = Integer.parseInt(numberPart) + 1;
//            } catch (NumberFormatException e) {
//                // fallback
//            }
//        }
//
//        return String.format("%s%02d", prefix, nextNumber); // ex: BOARD_004
//    }
//	
//	public AdminBoardDTO getDetailBoard(String boardCode) {
//		 
//        return adminMainMapper.getDetailBoard(boardCode);
//        
//    }
//	
//	public List<AdminBoardRoleDTO> getDetailBoardrole(String boardCode) {
//		 
//        return adminMainMapper.getDetailBoardrole(boardCode);
//        
//    }
//	@Transactional
//	public void updateBoard(AdminBoardDTO adminBoardDto, List<AdminBoardRoleDTO> adminBoardRoleDtoList) {
//		
//		adminMainMapper.deleteBoardrole(adminBoardDto.getBoardCode());
//		
//		adminMainMapper.updateBoard(adminBoardDto);
//		
//		for (AdminBoardRoleDTO adminBoardRoleDto : adminBoardRoleDtoList) {
//			
//			adminBoardRoleDto.setBoardCode(adminBoardDto.getBoardCode());
//			
//			adminMainMapper.insertBoardrole(adminBoardRoleDto);
//		
//		}
//	}
//	@Transactional
//	public void deleteBoard(String boardCode) {
//		
//		adminMainMapper.deleteBoardrole(boardCode);
//		
//		adminMainMapper.deleteBoard(boardCode);
//	}
//	
//	public List<AdminUserRoleDTO> getListRole() {
//    	
//    	return adminMainMapper.getListRole();
//    			
//    }
//
//
//	public List<AdminMenuDTO> getListMenu(String menuType) {
//		return adminMainMapper.getListMenu(menuType);
//	}
//
//
//	public AdminMenuDTO getDetailMenu(int menuCode) {
//		
//		 return adminMainMapper.getDetailMenu(menuCode);
//	}
//
//
//	public List<AdminMenuRoleDTO> getDetailMenuRole(int menuCode) {
//
//		return adminMainMapper.getDetailMenuRole(menuCode);
//	}
//
//
//	public List<AdminMenuTypeDTO> getListMenuType() {
//		
//		return adminMainMapper.getListMenuType();
//	}
//
//	@Transactional
//	public void insertMenu(AdminMenuDTO adminMenuDto, List<AdminMenuRoleDTO> adminMenuRoleDtoList) {
//		
//		int lastCode = generateNextMenuCode();
//		
//		adminMenuDto.setMenuCode(lastCode);
//		
//		int parentCode = adminMenuDto.getParentCode();
//		
//		if (parentCode !=0) {
//			int parentDepth = adminMainMapper.getDepth(parentCode);
//
//			adminMenuDto.setDepth(parentDepth + 1);
//	        
//	    } else {
//	        adminMenuDto.setDepth(1);
//	    }
//		
//		int getSortNumber = adminMainMapper.getMenuSort(adminMenuDto);
//		
//		adminMenuDto.setSortOrder(getSortNumber + 1);
//		
//		adminMenuDto.setUseYn("Y");
//		
//		adminMainMapper.insertMenu(adminMenuDto);
//		
//		for (AdminMenuRoleDTO adminMenuRoleDto : adminMenuRoleDtoList) {
//			
//			adminMenuRoleDto.setMenuCode(lastCode);
//			
//			adminMainMapper.insertMenuRole(adminMenuRoleDto);
//		
//		}
//		
//	}
//	private int generateNextMenuCode() {
//		
//        int lastCode = adminMainMapper.findLatestMenuCode();
//
//        if (lastCode == 0) {
//            return 1;
//        }
//
//        return lastCode + 1;
//    }
//
//
//	public int getMenuPath(String path) {
//		
//		return adminMainMapper.getMenuPath(path);
//	}
//
//
//	public List<AdminMenuDTO> getListMenuUpper(String menuType) {
//		
//		return adminMainMapper.getListMenuUpper(menuType);
//	}
//
//	@Transactional
//	public void updateSortOrder(AdminMenuDTO adminMenuDto) {
//		
//		adminMainMapper.updateSortOrder(adminMenuDto);
//		
//	}
//
//	@Transactional
//	public void deleteMenu(int menuCode) {
//		
//		
//		AdminMenuDTO adminMenuDto = adminMainMapper.getDetailMenu(menuCode);
//		
//		adminMainMapper.contectSortOrder(adminMenuDto);
//		
//		
//		adminMainMapper.deleteMenurole(menuCode);
//		
//		adminMainMapper.deleteMenu(menuCode);
//	}
//
//
//	public int getCountChildren(int menuCode) {
//		
//		return adminMainMapper.getCountChildren(menuCode);
//	}
//
//
//	public List<AdminMenuDTO> getListParent() {
//		return adminMainMapper.getListParent();
//	}
//
//	@Transactional
//	public void updateMenu(AdminMenuDTO adminMenuDto, List<AdminMenuRoleDTO> adminMenuRoleDtoList) {
//		
//		AdminMenuDTO originalDto = adminMainMapper.getDetailMenu(adminMenuDto.getMenuCode());
//		
//		if(originalDto.getParentCode() != adminMenuDto.getParentCode()) {
//			
//			adminMainMapper.contectSortOrder(originalDto);
//			
//			int getSortNumber = adminMainMapper.getMenuSort(adminMenuDto);
//			
//			adminMenuDto.setSortOrder(getSortNumber + 1);
//			
//			
//			if(adminMenuDto.getParentCode() !=0) {
//				int parentDepth = adminMainMapper.getDepth(adminMenuDto.getParentCode());
//
//				adminMenuDto.setDepth(parentDepth + 1);
//			}else {
//				System.out.println("여기를 타야하는데");
//				adminMenuDto.setDepth(1);
//			}
//			
//		}
//		int parentCode = adminMenuDto.getParentCode();
//				
////		if (parentCode !=0) {
////			int parentDepth = adminMainMapper.getDepth(parentCode);
////
////			adminMenuDto.setDepth(parentDepth + 1);
////	        
////	    } else {
////	    	
////	        adminMenuDto.setDepth(1);
////	    }
//				
//		adminMainMapper.deleteMenurole(adminMenuDto.getMenuCode());
//		
//		adminMainMapper.updateMenu(adminMenuDto);
//		
//		for(AdminMenuRoleDTO adminMenuRoleDto : adminMenuRoleDtoList) {
//			
//			adminMenuRoleDto.setMenuCode(adminMenuDto.getMenuCode());
//			
//			adminMainMapper.insertMenuRole(adminMenuRoleDto);
//
//		}
//		
//		
//	}
//
//	public List<AdminUserDTO> getListUser() {
//		
//		return adminMainMapper.getListUser();
//	}
//
//
//	public AdminUserDTO getDetailUser(String userId) {
//		return adminMainMapper.getDetailUser(userId);
//	}
//
//
//	public List<AdminUserMappingDTO> getDetailUserRole(String userId) {
//		return adminMainMapper.getDetailUserRole(userId);
//
//	}
//
//
//	public List<AdminUserGenderDTO> getUserGenderList() {
//		return adminMainMapper.getUserGenderList();
//	}
//
//
//	public List<AdminUserMembershipDTO> getUserMembershipList() {
//		return adminMainMapper.getUserMembershipList();
//	}
//
//	@Transactional
//	public void updateUser(AdminUserDTO adminUserDto, List<AdminUserMappingDTO> adminUserMappingDtoList) {
//		
//		adminMainMapper.deleteUserRole(adminUserDto.getUserId());
//		
//		adminMainMapper.updateUser(adminUserDto);
//		
//		for (AdminUserMappingDTO adminUserMappingDto : adminUserMappingDtoList) {
//			
//			adminUserMappingDto.setUserId(adminUserDto.getUserId());
//			
//			adminMainMapper.insertUserRole(adminUserMappingDto);
//		
//		}
//		
//	}
//
//
//	public void changeLockYn(AdminUserDTO adminUserDto) {
//		
//		adminMainMapper.changeLockYn(adminUserDto);
//	}
//
//
//	public void changeDormantYn(AdminUserDTO adminUserDto) {
//		
//		adminMainMapper.changeDormantYn(adminUserDto);
//	}
//
//
//	public int checkUserId(String userId) {
//		
//		return adminMainMapper.checkUserId(userId);
//	}
//
//
//	public void insertUser(AdminUserDTO adminUserDto, List<AdminUserMappingDTO> adminUserMappingDtoList) {
//
//		String password = adminUserDto.getNormalPassword();
//		
//		String userPassword = BCrypt.hashpw(password, BCrypt.gensalt());
//		
//		adminUserDto.setUserPassword(userPassword);
//		
//		adminUserDto.setLockYn("N");
//		
//		adminUserDto.setDormantYn("N");
//		
//		adminUserDto.setMembership("MEMBERSHIP_03");
//		
//		adminMainMapper.insertUser(adminUserDto);
//		
//		for (AdminUserMappingDTO adminUserMappingDto : adminUserMappingDtoList) {
//			
//			adminUserMappingDto.setUserId(adminUserDto.getUserId());
//			
//			adminMainMapper.insertUserRole(adminUserMappingDto);
//		}
//	}
//
//	public void deleteUser(String userId) {
//		
//		adminMainMapper.deleteUserRole(userId);
//		
//		adminMainMapper.deleteUser(userId);
//		
//	}
//
//
//	public int getCountUser(AdminUserDTO adminUserDto) {
//		return adminMainMapper.getCountUser(adminUserDto);
//	}
//
//
//	public List<AdminUserDTO> getListUserResponse(AdminUserDTO adminUserDto) {
//		return adminMainMapper.getListUserResponse(adminUserDto);
//	}
//
//
//	public List<AdminRoleGroupDTO> getListRoleGroup() {
//		
//		return adminMainMapper.getListRoleGroup();
//	}
//
//
//	public void insertRole(AdminRoleGroupDTO adminRoleGroupDto) {
//
//		
//	}
//
//
//	public void insertRole(AdminRoleInfoDTO adminRoleInfoDto) {
//		
//		adminRoleInfoDto.setUseYn("Y");
//		
//		adminMainMapper.insertRole(adminRoleInfoDto);
//		
//	}
//
//
//	public int checkRoleCode(String roleCode) {
//	
//		return adminMainMapper.checkRoleCode(roleCode);
//	}
//
//
//	public AdminRoleInfoDTO getDetailRole(String roleCode) {
//		return adminMainMapper.getDetailRole(roleCode);
//	}
//
//
//	public void updateRole(AdminRoleInfoDTO request) {
//		adminMainMapper.updateRole(request);
//	}
//
//
//	public void deleteRole(String roleCode) {
//		adminMainMapper.deleteRole(roleCode);
//	}
//
//
//	public void changeUseYn(AdminUserRoleDTO adminUserRoleDto) {
//		adminMainMapper.changeUseYn(adminUserRoleDto);
//	}
//
//
//	public int checkRoleGroupCode(String roleGroup) {
//		
//		return adminMainMapper.checkRoleGroupCode(roleGroup);
//	}
//	
//	public void insertRoleGroup(AdminRoleGroupDTO adminRoleGroupDto) {
//		adminRoleGroupDto.setUseYn("Y");
//		
//		adminMainMapper.insertRoleGroup(adminRoleGroupDto);
//	}
//
//
//	public AdminRoleGroupDTO getDetailRoleGroup(String roleGroup) {
//		return adminMainMapper.getDetailRoleGroup(roleGroup);
//	}
//
//
//	public void updateRoleGroup(AdminRoleGroupDTO request) {
//		adminMainMapper.updateRoleGroup(request);
//	}
//
//
//	public void deleteRoleGroup(String roleGroup) {
//		adminMainMapper.deleteRoleGroup(roleGroup);
//		
//	}
//
//
//	public void changeUseYnGroup(AdminRoleGroupDTO adminRoleGroupDto) {
//		adminMainMapper.changeUseYnGroup(adminRoleGroupDto);
//		
//	}
//
//
//	public List<AdminCommonGroupCodeDTO> getListCommonGroupCode() {
//		
//		return adminMainMapper.getListCommonGroupCode();
//	}
//
//
//	public int getCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto) {
//		return adminMainMapper.getCode(adminCommonGroupCodeDto);
//	}
//
//
//	public void insertUpperCommonCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto) {
//		adminCommonGroupCodeDto.setUseYn("Y");
//		
//		adminMainMapper.insertUpperCommonCode(adminCommonGroupCodeDto);
//	}
//
//
//	public AdminCommonGroupCodeDTO getDetailUpperCode(String commonGroupCode) {
//		return adminMainMapper.getDetailUpperCode(commonGroupCode);
//	}
//
//
//	public List<AdminCommonGroupCodeDTO> getListCommonSubCode(String commonGroupCode) {
//		return adminMainMapper.getListCommonSubCode(commonGroupCode);
//	}
//
//
//	public AdminCommonGroupCodeDTO getDetailSubCode(String commonCode) {
//		return adminMainMapper.getDetailSubCode(commonCode);
//	}
//
//
//	public int getSubCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto) {
//		return adminMainMapper.getSubCode(adminCommonGroupCodeDto);
//	}
//
//
//	public void insertSubCommonCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto) {
//		adminCommonGroupCodeDto.setUseYn("Y");
//		
//		adminMainMapper.insertSubCommonCode(adminCommonGroupCodeDto);
//	}
//
//
//	public void updateUpperCommonCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto) {
//		adminMainMapper.updateUpperCommonCode(adminCommonGroupCodeDto);
//		
//	}
//
//
//	public void updateSubCommonCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto) {
//		adminMainMapper.updateSubCommonCode(adminCommonGroupCodeDto);
//	}
//
//
//	public int getSubCodeList(String commonGroupCode) {
//		return adminMainMapper.getSubCodeList(commonGroupCode);
//	}
//
//
//	public void deleteUpperCommonCode(String commonGroupCode) {
//		adminMainMapper.deleteUpperCommonCode(commonGroupCode);
//	}
//
//
//	public void deleteSubCommonCode(String commonCode) {
//		adminMainMapper.deleteSubCommonCode(commonCode);
//	}
//
//
//
//	
//}
