package com.bmm.api.reviewPop;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewPopService {

	@Autowired
	private ReviewPopMapper reviewPopMapper;
	
	public List<ReviewPopDTO> getListReview(ReviewPopDTO reviewPopDto) {
		
		return reviewPopMapper.getListReview(reviewPopDto);
	}
	
	public byte[] createReviewExcel(String productCode) throws IOException {
		
		List<ReviewPopDTO> list = getListReview(new ReviewPopDTO(productCode)); // 기존 키워드 조회 재활용
		
	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("리뷰 목록");
	    
	    var creationHelper = workbook.getCreationHelper();
	    var dateCellStyle = workbook.createCellStyle();
	    dateCellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd"));
	    
	    
	    // Header
	    Row headerRow = sheet.createRow(0);
	    headerRow.createCell(0).setCellValue("내용");
	    headerRow.createCell(1).setCellValue("점수");
	    headerRow.createCell(2).setCellValue("등록날짜");

	    // Data
	    int rowNum = 1;
	    for (ReviewPopDTO reviewPopDto : list) {
	        Row row = sheet.createRow(rowNum++);
	        row.createCell(0).setCellValue(reviewPopDto.getReviewInfo());
	        row.createCell(1).setCellValue(reviewPopDto.getReviewScore());
	        row.createCell(2).setCellValue(reviewPopDto.getInsertDt());
	        
	        if (reviewPopDto.getInsertDt() != null) {
	            Cell dateCell = row.createCell(2);
	            
	            // insertDt가 java.util.Date인 경우
	            dateCell.setCellValue(reviewPopDto.getInsertDt());
	            dateCell.setCellStyle(dateCellStyle);
	        }
	    }
	    // Excel to byte[]
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    workbook.write(out);
	    workbook.close();

	    return out.toByteArray();
	}
	public Long getTotalPriceReview(String productCode) {
		
        return reviewPopMapper.getTotalPriceReview(productCode);
    }
	
}