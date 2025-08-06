package com.bmm.api.product;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/getListProductNaver")
	public ResponseEntity<ProductResponseDTO> getListProductNaver(@RequestParam int keywordCode) throws Exception {
		
		ProductResponseDTO productResponseDto = productService.getTotalPriceNaver(keywordCode);
		List<ProductDTO> list = productService.getListProductNaver(keywordCode);
		
		productResponseDto.setProduct(list);
		
		return ResponseEntity.ok(productResponseDto);
	}
/*
	@GetMapping("/getTotalPriceNaver")
    public ResponseEntity<Long> getTotalPriceNaver(@RequestParam int keywordCode) {
		
		System.out.println("###########" + keywordCode);
		Long totalPrice = productService.getTotalPriceNaver(keywordCode);
        
		return ResponseEntity.ok(totalPrice);
        
    }
*/

	@GetMapping("/getListProductCoupang")
	public ResponseEntity<List<ProductDTO>> getListProductCoupang(@RequestParam int keywordCode) throws Exception {
		
		ProductDTO productDto = new ProductDTO();
		
		productDto.setKeywordCode(keywordCode);
		
		List<ProductDTO> list = productService.getListProductCoupang(productDto);
		
		return ResponseEntity.ok(list);
	}
	
	
	
}
