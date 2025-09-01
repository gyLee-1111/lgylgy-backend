package com.bmm.api.adminMain;

import java.util.List;

public class AdminMenuDTO {

	private int menuCode;

	private String menuNm;
	
	private int depth;

	private String roleCode;
	
	private String roleNm;

	private String roleGroup;
	
	private int parentCode;
	
	private String path;
	
	private List<AdminMenuDTO> children;

	public int getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(int menuCode) {
		this.menuCode = menuCode;
	}

	public String getMenuNm() {
		return menuNm;
	}

	public void setMenuNm(String menuNm) {
		this.menuNm = menuNm;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleNm() {
		return roleNm;
	}

	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}

	public String getRoleGroup() {
		return roleGroup;
	}

	public void setRoleGroup(String roleGroup) {
		this.roleGroup = roleGroup;
	}

	public int getParentCode() {
		return parentCode;
	}

	public void setParentCode(int parentCode) {
		this.parentCode = parentCode;
	}

	public List<AdminMenuDTO> getChildren() {
		return children;
	}

	public void setChildren(List<AdminMenuDTO> children) {
		this.children = children;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	
	
}
