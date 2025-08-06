package com.bmm.api.keyword;

import java.nio.charset.StandardCharsets;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmm.api.keyword.ReviewStatsDTO;

@RestController
@RequestMapping("/user/keyword")
public class KeywordController {
	
	@Autowired
	private KeywordService keywordService;
	

	
	@PostMapping("/getListKeyword")
	public ResponseEntity<List<KeywordDTO>> getListKeyword(@RequestBody SearchKeywordDTO searchKeywordDto,Authentication authentication) throws Exception {
		
		System.out.println("categoryCode = " + searchKeywordDto.getCategoryCode());
		System.out.println("키워드명: " + searchKeywordDto.getKeywordNm());
		
		/*
		 * KeywordDTO keywordDto = new KeywordDTO();
		 * 
		 * keywordDto.setCategoryCode(searchKeywordDto.getCategoryCode());
		 */
		
		if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
	        String userId = (String) authentication.getPrincipal(); 
	        searchKeywordDto.setUserId(userId);
//	        KeywordDTO keywordDTO = new KeywordDTO();
//			keywordDTO.setUserId(userId);
	        System.out.println("유저ID: " + userId);
	    } else {
	        System.out.println("익명 사용자 요청");
	    }
	    
	  //  System.out.println("유저ID:뭘까!!!! " + searchKeywordDto.getUserId());
		
		List<KeywordDTO> list = keywordService.getListKeyword(searchKeywordDto);
		for (KeywordDTO keywordDto : list) {
			keywordDto.setUserId(searchKeywordDto.getUserId());
	    }
		if (!list.isEmpty()) {
	        System.out.println("키워드 유저ID: " + list.get(0).getUserId());
	    }
		return ResponseEntity.ok(list);
	}
	@GetMapping("/downloadKeywordExcel")
	public ResponseEntity<byte[]> downloadKeywordExcel(@ModelAttribute SearchKeywordDTO searchKeywordDto,Authentication authentication) {
	    try {
	        if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
		        String userId = (String) authentication.getPrincipal(); 
		        searchKeywordDto.setUserId(userId);
		        System.out.println("유저ID: " + userId);
		    } else {
		        System.out.println("익명 사용자 요청");
		    }
	        
	        byte[] excelData = keywordService.downloadKeywordExcel(searchKeywordDto); // 엑셀 생성 로직
	        
	        HttpHeaders headers = new HttpHeaders();
	        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
	        headers.setContentDisposition(ContentDisposition.attachment()
	                .filename("keyword_list.xlsx", StandardCharsets.UTF_8)
	                .build());

	        return new ResponseEntity<>(excelData, headers, HttpStatus.OK);

	    } catch (Exception e) {
	        e.printStackTrace();
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}

	/*
	@GetMapping("/getDetailKeyword")
	public ResponseEntity<KeywordDTO> getDetailKeyword(@RequestParam Integer keywordCode) throws Exception {
	    	
	 //   	KeywordDTO keywordDto = new KeywordDTO();
	    	
	 //   	keywordDto.setKeywordCode(keywordCode);
	    	
	    	KeywordDTO result = keywordService.getDetailKeyword(keywordCode);
	    	
	        return new ResponseEntity<>(result,HttpStatus.OK);
	    }
*/
	
	/*
	@GetMapping("/getKeywordCategory")
	public ResponseEntity<List<KeywordCategoryDTO>> getKeywordCategory(@RequestParam Integer keywordCode) throws Exception {
		
	//	KeywordCategoryDTO keywordCategoryDto = new KeywordCategoryDTO();
		
	//	keywordCategoryDto.setKeywordCode(keywordCode);
		
		List<KeywordCategoryDTO> list = keywordService.getKeywordCategory(keywordCode);
	    return ResponseEntity.ok(list);
	}
	*/
	/*
	@GetMapping("/getScore")
	public ResponseEntity<String> getScore(@RequestParam double score) throws Exception {
		
		
		String rankName = keywordService.getScore(score);
	
		
		return ResponseEntity.ok(rankName);
	}
	*/
	@GetMapping("/getDetailKeyword")
	public ResponseEntity<KeywordDTO> getDetailKeyword(@RequestParam Integer keywordCode) throws Exception {
		
			KeywordDTO result = keywordService.getDetailKeyword(keywordCode);
			
			List<KeywordCategoryDTO> list = keywordService.getKeywordCategory(keywordCode);
	    	
			result.setKeyCategory(list);
			
			String rankName = keywordService.getScore(result.getKeywordScore());
			result.setRankName(rankName);
			
	    	return ResponseEntity.ok(result);
	    	
	    	
	    }

	@GetMapping("/getCountReview")
	public ResponseEntity<ReviewStatsDTO> getCountReview(@RequestParam int keywordCode) throws Exception {
		
		ReviewStatsDTO getCountReview = keywordService.getCountReview(keywordCode);
		ReviewStatsDTO getShoppingDetail = keywordService.getShoppingDetail(keywordCode);
	
		if (getCountReview == null) {
	        getCountReview = new ReviewStatsDTO();  
	    }

	    if (getShoppingDetail == null) {
	        getShoppingDetail = new ReviewStatsDTO();  
	    }
		
		ReviewStatsDTO reviewStatsDto = new ReviewStatsDTO();
		
		reviewStatsDto.setPageAvgReview(getCountReview.getPageAvgReview());
	    reviewStatsDto.setTop3AvgReview(getCountReview.getTop3AvgReview());
	    reviewStatsDto.setMiddlePageReview(getCountReview.getMiddlePageReview());
	    
	    reviewStatsDto.setTop10AvgScore(getShoppingDetail.getTop10AvgScore());
	    reviewStatsDto.setTop10Sales(getShoppingDetail.getTop10Sales());
	    reviewStatsDto.setTop20Sales(getShoppingDetail.getTop20Sales());
	    

		
		return ResponseEntity.ok(reviewStatsDto);
	}
	/*
	@GetMapping("/getKeywordChart")
	public ResponseEntity<KeywordChartDTO> getKeywordChart(@RequestParam Integer keywordCode) throws Exception {
	    
		
		KeywordChartDTO result = keywordService.getKeywordChart(keywordCode);
		
//	    System.out.println("===== KeywordChartDTO 디버깅 =====");
//	    System.out.println("PC 검색량: " + result.getDevicePc());
//	    System.out.println("모바일 검색량: " + result.getDeviceMobile());
	    	
		return ResponseEntity.ok(result);
		
	}
	*/
	/*
	@GetMapping("/getKeywordHistoryChart")
	public ResponseEntity<List<KeywordHistoryChartDTO>> getKeywordHistoryChart(@RequestParam Integer keywordCode) throws Exception {
		
		List<KeywordHistoryChartDTO> list = keywordService.getKeywordHistoryChart(keywordCode);
		
		return ResponseEntity.ok(list);
	}
	*/
	@GetMapping("/getKeywordChart")
	public ResponseEntity<KeywordChartDTO> getKeywordChart(@RequestParam Integer keywordCode) throws Exception {
		
		KeywordChartDTO result = keywordService.getKeywordChart(keywordCode);
		
		if (result == null) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();  // 또는 new KeywordChartDTO() 리턴
	    }
		
		List<KeywordHistoryChartDTO> list = keywordService.getKeywordHistoryChart(keywordCode);
    	
		result.setHistoryChart(list);
		
		return ResponseEntity.ok(result);
		
	}

	
	@PostMapping("/checkFavorite")
	public ResponseEntity<String> checkFavorite(@RequestBody SearchKeywordDTO searchKeywordDto,Authentication authentication) throws Exception {
		
		if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
	        String userId = (String) authentication.getPrincipal(); // ✅ 여기가 유저 ID입니다
	        searchKeywordDto.setUserId(userId);
	        System.out.println("유저ID: " + userId);
	    } else {
	        System.out.println("익명 사용자 요청");
	        
	    }
		
	    String status = keywordService.checkFavorite(searchKeywordDto);
	    
	    
		
		return ResponseEntity.ok(status);
	}
	@GetMapping("/getKeywordNm")
	public ResponseEntity<String> getKeywordNm(@RequestParam Integer keywordCode) throws Exception {
		
		String keywordNm = keywordService.getKeywordNm(keywordCode);
		
		return ResponseEntity.ok(keywordNm);
	}
	

}
