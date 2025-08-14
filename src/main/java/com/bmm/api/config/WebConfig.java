package com.bmm.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	
	  @Value("${my.vue.base-url}")
	  private String vuebaseUrl;
	
	 @Override
	 public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
		// registry.addMapping("/front/ongoing/**")
	                .allowedOrigins(vuebaseUrl)
	                .allowedMethods("*")
	                .allowedHeaders("*")
	                .allowCredentials(true);
	        System.out.println("허용된 CORS Origin: " + vuebaseUrl);
	}
	 
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 실제 이미지가 저장된 폴더 경로 (Windows 기준)
        registry.addResourceHandler("/images/**")
                .addResourceLocations(
                		"classpath:/static/images/",
                		"classpath:/static/images/product/"
                		);
        
    }
	 
}
