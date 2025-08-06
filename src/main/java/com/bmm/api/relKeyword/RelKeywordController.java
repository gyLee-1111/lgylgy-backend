package com.bmm.api.relKeyword;

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

@RestController
@RequestMapping("user/relkeyword")
public class RelKeywordController {
	
	@Autowired
	private RelKeywordService relKeywordService;
	

	
	@GetMapping("/getRelKeyword")
	public ResponseEntity<List<RelKeywordDTO>> getRelKeyword(@RequestParam Integer keywordCode,
            												@RequestParam(required = false) Integer limitCount) throws Exception {
		
		RelKeywordDTO relKeywordDto = new RelKeywordDTO();
	    relKeywordDto.setKeywordCode(keywordCode);
	    System.out.println("리미트: " + limitCount);
	    relKeywordDto.setLimitCount(limitCount);
		
	   
	    
		List<RelKeywordDTO> list = relKeywordService.getRelKeyword(relKeywordDto);
		
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/downloadRelKeywordExcel")
	public ResponseEntity<byte[]> downloadRelKeywordExcel(@RequestParam int keywordCode) {
	    try {
	        byte[] excelData = relKeywordService.createRelKeywordExcel(keywordCode); // 엑셀 생성 로직

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
	
	
}
