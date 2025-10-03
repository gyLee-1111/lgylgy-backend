package com.bmm.api.adminMenu;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AdminMenuService {
	
	@Autowired
	private AdminMenuMapper adminMenuMapper;

	
	public List<AdminMenuDTO> getAdminMenu(String roleCode)	{
		
		return adminMenuMapper.getAdminMenu(roleCode);
	}
	

	public List<AdminMenuDTO> getAdminSubMenu(String roleCode)	{
		
		return adminMenuMapper.getAdminSubMenu(roleCode);
	}
	


	public List<AdminMenuDTO> getListMenu(String menuType) {
		return adminMenuMapper.getListMenu(menuType);
	}


	public AdminMenuDTO getDetailMenu(int menuCode) {
		
		 return adminMenuMapper.getDetailMenu(menuCode);
	}


	public List<AdminMenuRoleDTO> getDetailMenuRole(int menuCode) {

		return adminMenuMapper.getDetailMenuRole(menuCode);
	}


	public List<AdminMenuTypeDTO> getListMenuType() {
		
		return adminMenuMapper.getListMenuType();
	}

	@Transactional
	public void insertMenu(AdminMenuDTO adminMenuDto, List<AdminMenuRoleDTO> adminMenuRoleDtoList) {
		
		int lastCode = generateNextMenuCode();
		
		adminMenuDto.setMenuCode(lastCode);
		
		int parentCode = adminMenuDto.getParentCode();
		
		if (parentCode !=0) {
			int parentDepth = adminMenuMapper.getDepth(parentCode);

			adminMenuDto.setDepth(parentDepth + 1);
	        
	    } else {
	        adminMenuDto.setDepth(1);
	    }
		
		int getSortNumber = adminMenuMapper.getMenuSort(adminMenuDto);
		
		adminMenuDto.setSortOrder(getSortNumber + 1);
		
		adminMenuDto.setUseYn("Y");
		
		adminMenuMapper.insertMenu(adminMenuDto);
		
		for (AdminMenuRoleDTO adminMenuRoleDto : adminMenuRoleDtoList) {
			
			adminMenuRoleDto.setMenuCode(lastCode);
			
			adminMenuMapper.insertMenuRole(adminMenuRoleDto);
		
		}
		
	}
	private int generateNextMenuCode() {
		
        int lastCode = adminMenuMapper.findLatestMenuCode();

        if (lastCode == 0) {
            return 1;
        }

        return lastCode + 1;
    }


	public int getMenuPath(String path) {
		
		return adminMenuMapper.getMenuPath(path);
	}


	public List<AdminMenuDTO> getListMenuUpper(String menuType) {
		
		return adminMenuMapper.getListMenuUpper(menuType);
	}

	@Transactional
	public void updateSortOrder(AdminMenuDTO adminMenuDto) {
		
		adminMenuMapper.updateSortOrder(adminMenuDto);
		
	}

	@Transactional
	public void deleteMenu(int menuCode) {
		
		
		AdminMenuDTO adminMenuDto = adminMenuMapper.getDetailMenu(menuCode);
		
		adminMenuMapper.contectSortOrder(adminMenuDto);
		
		
		adminMenuMapper.deleteMenurole(menuCode);
		
		adminMenuMapper.deleteMenu(menuCode);
	}


	public int getCountChildren(int menuCode) {
		
		return adminMenuMapper.getCountChildren(menuCode);
	}


	public List<AdminMenuDTO> getListParent() {
		return adminMenuMapper.getListParent();
	}

	@Transactional
	public void updateMenu(AdminMenuDTO adminMenuDto, List<AdminMenuRoleDTO> adminMenuRoleDtoList) {
		
		AdminMenuDTO originalDto = adminMenuMapper.getDetailMenu(adminMenuDto.getMenuCode());
		
		if(originalDto.getParentCode() != adminMenuDto.getParentCode()) {
			
			adminMenuMapper.contectSortOrder(originalDto);
			
			int getSortNumber = adminMenuMapper.getMenuSort(adminMenuDto);
			
			adminMenuDto.setSortOrder(getSortNumber + 1);
			
			
			if(adminMenuDto.getParentCode() !=0) {
				int parentDepth = adminMenuMapper.getDepth(adminMenuDto.getParentCode());

				adminMenuDto.setDepth(parentDepth + 1);
			}else {
				System.out.println("여기를 타야하는데");
				adminMenuDto.setDepth(1);
			}
			
		}
		int parentCode = adminMenuDto.getParentCode();

				
		adminMenuMapper.deleteMenurole(adminMenuDto.getMenuCode());
		
		adminMenuMapper.updateMenu(adminMenuDto);
		
		for(AdminMenuRoleDTO adminMenuRoleDto : adminMenuRoleDtoList) {
			
			adminMenuRoleDto.setMenuCode(adminMenuDto.getMenuCode());
			
			adminMenuMapper.insertMenuRole(adminMenuRoleDto);

		}
		
		
	}


	public List<AdminUserRoleDTO> getListRole() {
	 	return adminMenuMapper.getListRole();
	}

	

}
