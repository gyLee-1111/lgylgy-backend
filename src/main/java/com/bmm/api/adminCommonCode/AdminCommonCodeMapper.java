package com.bmm.api.adminCommonCode;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;



@Mapper
public interface AdminCommonCodeMapper {
	

	public List<AdminCommonCodeDTO> getListCommonUpperCode(AdminCommonCodeDTO adminCommonCodeDto);
	
	public int getCode(AdminCommonCodeDTO adminCommonCodeDto);

	public void insertUpperCommonCode(AdminCommonCodeDTO adminCommonCodeDto);

	public AdminCommonCodeDTO getDetailUpperCode(String commonCode);

	public void updateUpperCommonCode(AdminCommonCodeDTO adminCommonCodeDto);

	public int getSubCodeList(String upperCode);

	public void deleteUpperCommonCode(String upperCode);

	public List<AdminCommonCodeDTO> getListCommonSubCode(String commonCode);

	public int getSubCode(AdminCommonCodeDTO adminCommonCodeDto);

	public void insertSubCommonCode(AdminCommonCodeDTO adminCommonCodeDto);

	public AdminCommonCodeDTO getDetailSubCode(String commonCode);
	
	public void updateSubCommonCode(AdminCommonCodeDTO adminCommonCodeDto);

	public void deleteSubCommonCode(String commonCode);

	public List<AdminCommonGroupCodeDTO> getListCommonGroup();

	public void updateSubGroupCode(AdminCommonCodeDTO adminCommonCodeDto);

	public int getCountCommonCode(AdminCommonCodeDTO adminCommonCodeDto);

	public int getGroupCode(AdminCommonGroupCodeDTO adminCommonGroupCodeDto);

	public void insertCommonGroup(AdminCommonGroupCodeDTO adminCommonGroupCodeDto);

	public void updateCommonGroup(AdminCommonGroupCodeDTO adminCommonGroupCodeDto);

	public int getMappingList(String commonGroupCode);

	public void deleteCommonGroup(String commonGroupCode);
	
}
	
