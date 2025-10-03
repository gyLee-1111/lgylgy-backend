package com.bmm.api.adminMain;

import java.util.List;

public class AdminMenuDTO {

	private int menuCode;

	private String menuNm;
	
	private int depth;

	private String roleCode;
	
	private String roleNm;

	private int parentCode;
	
	private String menuType;
	
	private String menuTypeNm;
	
	private String useYn;
	
	private String path;
	
	private int sortOrder;
	
	private String parentNm;
	
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


	public int getParentCode() {
		return parentCode;
	}

	public void setParentCode(int parentCode) {
		this.parentCode = parentCode;
	}

	public String getMenuType() {
		return menuType;
	}

	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}

	public String getMenuTypeNm() {
		return menuTypeNm;
	}

	public void setMenuTypeNm(String menuTypeNm) {
		this.menuTypeNm = menuTypeNm;
	}

	public List<AdminMenuDTO> getChildren() {
		return children;
	}

	public void setChildren(List<AdminMenuDTO> children) {
		this.children = children;
	}
	

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getParentNm() {
		return parentNm;
	}

	public void setParentNm(String parentNm) {
		this.parentNm = parentNm;
	}


	
}
