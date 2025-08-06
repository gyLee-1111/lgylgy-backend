package com.bmm.api.category;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface CategoryMapper {
	
	public List<CategoryDTO> getTopCategory();
	
	public List<CategoryDTO> getSubCategory(String parentCode);
}