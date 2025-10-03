package com.bmm.api.adminCommonCode;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AdminCommonCodeService {
	
	@Autowired
	private AdminCommonCodeMapper adminCommonCodeMapper;


	public List<AdminCommonCodeDTO> getListCommonUpperCode(AdminCommonCodeDTO adminCommonCodeDto) {
		
		return adminCommonCodeMapper.getListCommonUpperCode(adminCommonCodeDto);
	}


	public int getCode(AdminCommonCodeDTO adminCommonCodeDto) {
		return adminCommonCodeMapper.getCode(adminCommonCodeDto);
	}


	public void insertUpperCommonCode(AdminCommonCodeDTO adminCommonCodeDto) {
		adminCommonCodeDto.setUseYn("Y");
		adminCommonCodeMapper.insertUpperCommonCode(adminCommonCodeDto);
	}

	public AdminCommonCodeDTO getDetailUpperCode(String commonCode) {
		return adminCommonCodeMapper.getDetailUpperCode(commonCode);
	}
	@Transactional
	public void updateUpperCommonCode(AdminCommonCodeDTO adminCommonCodeDto) {
		
		adminCommonCodeMapper.updateUpperCommonCode(adminCommonCodeDto);
		
		adminCommonCodeMapper.updateSubGroupCode(adminCommonCodeDto);
	}

	public int getSubCodeList(String upperCode) {
		return adminCommonCodeMapper.getSubCodeList(upperCode);
	}

	public void deleteUpperCommonCode(String upperCode) {
		adminCommonCodeMapper.deleteUpperCommonCode(upperCode);
	}

	public List<AdminCommonCodeDTO> getListCommonSubCode(String commonCode) {
		return adminCommonCodeMapper.getListCommonSubCode(commonCode);
	}

	public int getSubCode(AdminCommonCodeDTO adminCommonCodeDto) {
		return adminCommonCodeMapper.getSubCode(adminCommonCodeDto);
	}

	public void insertSubCommonCode(AdminCommonCodeDTO adminCommonCodeDto) {
		adminCommonCodeDto.setUseYn("Y");
		
		adminCommonCodeMapper.insertSubCommonCode(adminCommonCodeDto);
	}

	public AdminCommonCodeDTO getDetailSubCode(String commonCode) {
		return adminCommonCodeMapper.getDetailSubCode(commonCode);
	}
	
	public void updateSubCommonCode(AdminCommonCodeDTO adminCommonCodeDto) {
		adminCommonCodeMapper.updateSubCommonCode(adminCommonCodeDto);
	}

	public void deleteSubCommonCode(String commonCode) {
		adminCommonCodeMapper.deleteSubCommonCode(commonCode);
	}

	public List<AdminCommonGroupCodeDTO> getListCommonGroup() {
		
		return adminCommonCodeMapper.getListCommonGroup();
	}


	public int getCountCommonCode(AdminCommonCodeDTO adminCommonCodeDto) {
		return adminCommonCodeMapper.getCountCommonCode(adminCommonCodeDto);
	}


	public int getGroupCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto) {
		
		return adminCommonCodeMapper.getGroupCode(adminCommonGroupCodeDto);
	}


	public void insertCommonGroup(AdminCommonGroupCodeDTO adminCommonGroupCodeDto) {
		adminCommonGroupCodeDto.setUseYn("Y");
		adminCommonCodeMapper.insertCommonGroup(adminCommonGroupCodeDto);
	}


	public void updateCommonGroup(AdminCommonGroupCodeDTO adminCommonGroupCodeDto) {
		adminCommonCodeMapper.updateCommonGroup(adminCommonGroupCodeDto);
		
	}


	public int getMappingList(String commonGroupCode) {
		
		return adminCommonCodeMapper.getMappingList(commonGroupCode);
	}


	public void deleteCommonGroup(String commonGroupCode) {
		adminCommonCodeMapper.deleteCommonGroup(commonGroupCode);
	}

}
