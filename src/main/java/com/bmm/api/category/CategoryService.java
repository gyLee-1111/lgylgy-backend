package com.bmm.api.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryMapper categoryMapper;
	

	public List<CategoryDTO> getTopCategory() {
		
		return categoryMapper.getTopCategory();
	}
	
	public List<CategoryDTO> getSubCategory(String parentCode) {
		
		return categoryMapper.getSubCategory(parentCode);
	}
	
}