package com.bmm.api.category;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("test")
public class TestController {
	

	 @PostMapping("/getTest")
	 public void getTest() throws Exception {
	     	
	    	System.out.println("테스트입니다.");
	  }
}
