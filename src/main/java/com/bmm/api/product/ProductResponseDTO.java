package com.bmm.api.product;

import java.util.List;

public class ProductResponseDTO {
	
	private List<ProductDTO> product ;

	private long totalPrice;

	public List<ProductDTO> getProduct() {
		return product;
	}

	public void setProduct(List<ProductDTO> product) {
		this.product = product;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	
}
