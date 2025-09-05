package com.bmm.api.reviewPop;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("reviewPop")
public class ReviewPopController {
	
	@Autowired
	private ReviewPopService reviewPopService;
	
	@GetMapping("/getListReview")
	public ResponseEntity<List<ReviewPopDTO>> getListReview(@RequestParam String productCode) throws Exception {
		
	//	System.out.println("#####QQQQQ#### " + productCode);
		
		ReviewPopDTO reviewPopDto = new ReviewPopDTO();
		
		reviewPopDto.setProductCode(productCode);
		
		List<ReviewPopDTO> list = reviewPopService.getListReview(reviewPopDto);
		
		return ResponseEntity.ok(list);
	}
	
	
	@GetMapping("/downloadExcelReview")
	public ResponseEntity<byte[]> downloadExcelReview(@RequestParam String productCode) {
	    try {
	    	byte[] excelData = reviewPopService.createReviewExcel(productCode); // 엑셀 생성 로직
	    	
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	        headers.setContentDisposition(ContentDisposition.attachment()
	                .filename("keyword_list.xlsx", StandardCharsets.UTF_8)
	                .build());

	        return new ResponseEntity<>(excelData, headers, HttpStatus.OK);

	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	@GetMapping("/getTotalPriceReview")
    public ResponseEntity<Long> getTotalPriceReview(@RequestParam String productCode) {
		
		System.out.println("###########" + productCode);
		Long totalPrice = reviewPopService.getTotalPriceReview(productCode);
        
		return ResponseEntity.ok(totalPrice);
        
    }
	/*
	@GetMapping("/downloadExcel")
	public ResponseEntity<String> example2() {
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    
	    if (authentication == null) {
	        System.out.println("❌ Authentication is null");
	        return ResponseEntity.status(401).body("인증 정보 없음");
	    }
	    
	    System.out.println("✅ Authentication 객체: " + authentication);
	    System.out.println("▶ Principal: " + authentication.getPrincipal());

	    if ("anonymousUser".equals(authentication.getPrincipal())) {
	        return ResponseEntity.status(403).body("익명 사용자입니다.");
	    }
	    
	    String userId = (String) authentication.getPrincipal(); // principal이 userId일 경우

	    System.out.println("현재 로그인한 userId: " + userId);

	    return ResponseEntity.ok("userId: " + userId);
	}
	
	*/
	
	
}
