package com.bmm.api.adminMenu;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;



@Mapper
public interface AdminMenuMapper {
	
	public List<AdminMenuDTO> getAdminMenu(String roleCode);
	
	public List<AdminMenuDTO> getAdminSubMenu(String roleCode);
	
	public List<AdminMenuDTO> getListMenu(String menuType);

	public AdminMenuDTO getDetailMenu(int menuCode);

	public List<AdminMenuRoleDTO> getDetailMenuRole(int menuCode);

	public List<AdminMenuTypeDTO> getListMenuType();

	public int findLatestMenuCode();

	public void insertMenu(AdminMenuDTO adminMenuDto);

	public void insertMenuRole(AdminMenuRoleDTO adminMenuRoleDto);

	public int getDepth(int parentCode);

	public int getMenuPath(String path);

	public List<AdminMenuDTO> getListMenuUpper(String menuType);

	public int getMenuSort(AdminMenuDTO adminMenuDto);

	public Object getListMenuUpper(int menuCode, int sortOrder);

	public void updateSortOrder(AdminMenuDTO adminMenuDto);

	public void deleteMenurole(int menuCode);

	public void deleteMenu(int menuCode);

	public void contectSortOrder(AdminMenuDTO adminMenuDto);

	public int getCountChildren(int menuCode);

	public List<AdminMenuDTO> getListParent();

	public void updateMenu(AdminMenuDTO adminMenuDto);

	public List<AdminUserRoleDTO> getListRole();


}
	
