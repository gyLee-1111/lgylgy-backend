package com.bmm.api.commonUtil;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

public class DropzoneFileUpload {
	
	
	public static String saveFile(MultipartFile file, String basePath) throws IOException {
		
		File uploadDir = new File(basePath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
		
        String savedName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        String saveFileNm = basePath + File.separator + savedName;
        
        file.transferTo(new File(saveFileNm));  // 실제 저장 수행
        
        return savedName;
        
	}
}
