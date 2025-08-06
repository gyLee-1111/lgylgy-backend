package com.bmm.api.keyword;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;



@Mapper
public interface KeywordMapper {
	
	public List<KeywordDTO> getListKeyword(SearchKeywordDTO searchKeyDto);
	
	public KeywordDTO getDetailKeyword(int keywordCode);
	
	public KeywordChartDTO getKeywordChart(int keywordCode);
	
	public List<KeywordHistoryChartDTO> getKeywordHistoryChart(int keywordCode);
	
	public List<KeywordCategoryDTO> getKeywordCategory(int keywordCode);
	

	public boolean checkFavoriteExists(@Param("userId") String userId, @Param("keywordCode") int keywordCode);

	public void addFavorite(@Param("userId") String userId, @Param("keywordCode") int keywordCode);

	public void removeFavorite(@Param("userId") String userId, @Param("keywordCode") int keywordCode);
	
	public String getKeywordNm(int keywordCode);
	
	public List<KeywordExcelDTO> downloadKeywordExcel(SearchKeywordDTO searchKeyDto);

	public ReviewStatsDTO getCountReview(int keywordCode);
	
	public ReviewStatsDTO getShoppingDetail(int keywordCode);

	public String getScore(@Param("score") double score);
	
}
