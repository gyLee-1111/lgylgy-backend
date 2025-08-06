package com.bmm.api.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("public/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
    @GetMapping("/getTopCategory")
    public ResponseEntity<List<CategoryDTO>> getTopCategory(HttpServletRequest request) throws Exception {
    	
    	/*
    	 
    	 --수정 text 커밋 푸시--
    	 
    	 */
    	List<CategoryDTO> list = categoryService.getTopCategory();
      	
    	return ResponseEntity.ok(list);
    }
    
    @GetMapping("/getSubCategory")
    public ResponseEntity<List<CategoryDTO>> getSubCategory(@RequestParam String parentCode) throws Exception {

    	List<CategoryDTO> list = categoryService.getSubCategory(parentCode);
      	
    	System.out.println("#####QQQQQ#### " + parentCode);
    	return ResponseEntity.ok(list);
    }
    /*
     초기 리스트 
    @PostMapping("/getListKeyword")
	public ResponseEntity<List<KeywordDTO>> getListKeyword(@RequestBody SearchKeywordDTO searchKeywordDto,Authentication authentication) throws Exception {
		
		System.out.println("categoryCode = " + searchKeywordDto.getCategoryCode());
		System.out.println("키워드명: " + searchKeywordDto.getKeywordNm());
		
		
		 // KeywordDTO keywordDto = new KeywordDTO();
		  
		//  keywordDto.setCategoryCode(searchKeywordDto.getCategoryCode());
		 
		
		if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
	        String userId = (String) authentication.getPrincipal(); // ✅ 여기가 유저 ID입니다
	        searchKeywordDto.setUserId(userId);
	        System.out.println("유저ID: " + userId);
	    } else {
	        System.out.println("익명 사용자 요청");
	    }
	    
	    System.out.println("유저ID:뭘까!!!! " + searchKeywordDto.getUserId());
		List<KeywordDTO> list = keywordService.getListKeyword(searchKeywordDto);
		
		return ResponseEntity.ok(list);
	}
	*/
    /*
     키워드 엑셀
    @GetMapping("/downloadKeywordExcel")
	public ResponseEntity<byte[]> downloadKeywordExcel(@ModelAttribute SearchKeywordDTO searchKeywordDto,Authentication authentication) {
	    try {
	        if (authentication != null && authentication.isAuthenticated() && !"anonymousUser".equals(authentication.getPrincipal())) {
		        String userId = (String) authentication.getPrincipal(); // ✅ 여기가 유저 ID입니다
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
	*/

}
