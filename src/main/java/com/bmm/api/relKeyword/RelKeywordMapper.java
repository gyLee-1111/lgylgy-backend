package com.bmm.api.relKeyword;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface RelKeywordMapper {
	
	public List<RelKeywordDTO> getRelKeyword(RelKeywordDTO relKeywordDto);

}
