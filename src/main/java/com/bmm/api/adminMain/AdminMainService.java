package com.bmm.api.adminMain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AdminMainService {
	
	@Autowired
	private AdminMainMapper adminMainMapper;

	
	public List<AdminMenuDTO> getAdminMenu(String roleCode)	{
		
		return adminMainMapper.getAdminMenu(roleCode);
	}
	

	public List<AdminMenuDTO> getAdminSubMenu(String roleCode)	{
		
		return adminMainMapper.getAdminSubMenu(roleCode);
	}
	
	public List<AdminBoardDTO> getListBoard() {
    	
    	return adminMainMapper.getListBoard();
    			
    }
	@Transactional
	public void insertBoard(AdminBoardDTO adminBoardDto, List<AdminBoardRoleDTO> adminBoardRoleDtoList) {
		
		String newBoardCode = generateNextBoardCode("BOARD_");
		
		adminBoardDto.setBoardCode(newBoardCode);
		
		adminMainMapper.insertBoard(adminBoardDto);
		
		for (AdminBoardRoleDTO adminBoardRoleDto : adminBoardRoleDtoList) {
			
			adminBoardRoleDto.setBoardCode(newBoardCode);
			
			adminMainMapper.insertBoardrole(adminBoardRoleDto);
		
		}
		
	}
	
	private String generateNextBoardCode(String prefix) {
        String lastCode = adminMainMapper.findLatestBoardCode(prefix);
        int nextNumber = 1;

        if (lastCode != null && lastCode.startsWith(prefix)) {
            String numberPart = lastCode.substring(prefix.length());
            try {
                nextNumber = Integer.parseInt(numberPart) + 1;
            } catch (NumberFormatException e) {
                // fallback
            }
        }

        return String.format("%s%02d", prefix, nextNumber); // ex: BOARD_004
    }
	
	public AdminBoardDTO getDetailBoard(String boardCode) {
		 
        return adminMainMapper.getDetailBoard(boardCode);
        
    }
	
	public List<AdminBoardRoleDTO> getDetailBoardrole(String boardCode) {
		 
        return adminMainMapper.getDetailBoardrole(boardCode);
        
    }
	@Transactional
	public void updateBoard(AdminBoardDTO adminBoardDto, List<AdminBoardRoleDTO> adminBoardRoleDtoList) {
		
		adminMainMapper.deleteBoardrole(adminBoardDto.getBoardCode());
		
		adminMainMapper.updateBoard(adminBoardDto);
		
		for (AdminBoardRoleDTO adminBoardRoleDto : adminBoardRoleDtoList) {
			
			adminBoardRoleDto.setBoardCode(adminBoardDto.getBoardCode());
			
			adminMainMapper.insertBoardrole(adminBoardRoleDto);
		
		}
	}
	@Transactional
	public void deleteBoard(String boardCode) {
		
		adminMainMapper.deleteBoardrole(boardCode);
		
		adminMainMapper.deleteBoard(boardCode);
	}
	
	public List<AdminUserRoleDTO> getListRole() {
    	
    	return adminMainMapper.getListRole();
    			
    }
	
}
