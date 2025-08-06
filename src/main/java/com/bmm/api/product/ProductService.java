package com.bmm.api.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
//	public ReviewStatsDTO getCountReview(int keywordCode) {
//		
//		return productMapper.getCountReview(keywordCode);
//	}
//	
//	public ReviewStatsDTO getShoppingDetail(int keywordCode) {
//		
//		return productMapper.getShoppingDetail(keywordCode);
//	}
	
//	public String getScore(double score) {
//		
//		return productMapper.getScore(score);
//	}

	public List<ProductDTO> getListProductNaver(int keywordCode) {
		
		return productMapper.getListProductNaver(keywordCode);
	}
	
	public List<ProductDTO> getListProductCoupang(ProductDTO productDto) {
		
		return productMapper.getListProductCoupang(productDto);
	}
	public ProductResponseDTO getTotalPriceNaver(int keywordCode) {
		
        return productMapper.getTotalPriceNaver(keywordCode);
    }

}
