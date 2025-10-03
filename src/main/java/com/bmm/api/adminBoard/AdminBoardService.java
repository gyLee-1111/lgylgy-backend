package com.bmm.api.adminBoard;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmm.api.adminMenu.AdminUserRoleDTO;

import jakarta.transaction.Transactional;

@Service
public class AdminBoardService {
	
	@Autowired
	private AdminBoardMapper adminBoardMapper;

	
	@Transactional
	public void insertBoard(AdminBoardDTO adminBoardDto, List<AdminBoardRoleDTO> adminBoardRoleDtoList) {
		
		String newBoardCode = generateNextBoardCode("BOARD_");
		
		adminBoardDto.setBoardCode(newBoardCode);
		
		adminBoardMapper.insertBoard(adminBoardDto);
		
		for (AdminBoardRoleDTO adminBoardRoleDto : adminBoardRoleDtoList) {
			
			adminBoardRoleDto.setBoardCode(newBoardCode);
			
			adminBoardMapper.insertBoardrole(adminBoardRoleDto);
		
		}
		
	}
	
	private String generateNextBoardCode(String prefix) {
        String lastCode = adminBoardMapper.findLatestBoardCode(prefix);
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
		 
        return adminBoardMapper.getDetailBoard(boardCode);
        
    }
	
	public List<AdminBoardRoleDTO> getDetailBoardrole(String boardCode) {
		 
        return adminBoardMapper.getDetailBoardrole(boardCode);
        
    }
	@Transactional
	public void updateBoard(AdminBoardDTO adminBoardDto, List<AdminBoardRoleDTO> adminBoardRoleDtoList) {
		
		adminBoardMapper.deleteBoardrole(adminBoardDto.getBoardCode());
		
		adminBoardMapper.updateBoard(adminBoardDto);
		
		for (AdminBoardRoleDTO adminBoardRoleDto : adminBoardRoleDtoList) {
			
			adminBoardRoleDto.setBoardCode(adminBoardDto.getBoardCode());
			
			adminBoardMapper.insertBoardrole(adminBoardRoleDto);
		
		}
	}
	@Transactional
	public void deleteBoard(String boardCode) {
		
		adminBoardMapper.deleteBoardrole(boardCode);
		
		adminBoardMapper.deleteBoard(boardCode);
	}

	public List<AdminBoardDTO> getListBoard() {
		return adminBoardMapper.getListBoard();
	}

	public List<AdminUserRoleDTO> getListRole() {
		return adminBoardMapper.getListRole();
	}
	
	

}
