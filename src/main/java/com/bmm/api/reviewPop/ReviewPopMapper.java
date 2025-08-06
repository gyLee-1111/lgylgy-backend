package com.bmm.api.reviewPop;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

import com.bmm.api.product.ProductDTO;



@Mapper
public interface ReviewPopMapper {
	
	public List<ReviewPopDTO> getListReview(ReviewPopDTO reviewPopDto);
	
	public Long getTotalPriceReview(String productCode);
}
