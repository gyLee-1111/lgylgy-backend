package com.bmm.api.relKeyword;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.vue3.api.product.ProductDTO;



@Mapper
public interface RelKeywordMapper {
	
	public List<RelKeywordDTO> getRelKeyword(RelKeywordDTO relKeywordDto);

}
