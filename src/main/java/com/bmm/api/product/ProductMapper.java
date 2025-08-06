package com.bmm.api.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;



@Mapper
public interface ProductMapper {
	
//	public ReviewStatsDTO getCountReview(@Param("keywordCode") int keywordCode);
//	
//	public ReviewStatsDTO getShoppingDetail(@Param("keywordCode") int keywordCode);
	
//	public String getScore(@Param("score") double score);
	

	
	public List<ProductDTO> getListProductNaver(int keywordCode);
	
	public List<ProductDTO> getListProductCoupang(ProductDTO productDto);
	
	public ProductResponseDTO getTotalPriceNaver(@Param("keywordCode") int keywordCode);
	
}
