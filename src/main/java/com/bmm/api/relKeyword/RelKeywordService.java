package com.bmm.api.relKeyword;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bmm.api.keyword.SearchKeywordDTO;

@Service
public class RelKeywordService {
	
	@Autowired
	private RelKeywordMapper relKeywordMapper;
	
	
    public List<RelKeywordDTO> getRelKeyword(RelKeywordDTO relKeywordDto) {
    	
    	return relKeywordMapper.getRelKeyword(relKeywordDto);
    			
    }
	public byte[] createRelKeywordExcel(int keywordCode) throws IOException {
	    List<RelKeywordDTO> list = getRelKeyword(new RelKeywordDTO(keywordCode)); // 기존 키워드 조회 재활용

	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("키워드 목록");

	    // Header
	    Row headerRow = sheet.createRow(0);
	    headerRow.createCell(0).setCellValue("순위");
	    headerRow.createCell(1).setCellValue("키워드명");
	    headerRow.createCell(2).setCellValue("월 검색량");
	    headerRow.createCell(3).setCellValue("PC 검색량");
	    headerRow.createCell(4).setCellValue("모바일 검색량");
	    headerRow.createCell(5).setCellValue("PC 평균 클릭수");
	    headerRow.createCell(6).setCellValue("모바일 평균 클릭수");
	    headerRow.createCell(7).setCellValue("PC 클릭률");
	    headerRow.createCell(8).setCellValue("모바일 클릭률");
	    headerRow.createCell(9).setCellValue("평균 광고 수");
	    headerRow.createCell(10).setCellValue("경쟁 정도");
	    // Data
	    int rowNum = 1;
	    for (RelKeywordDTO relKeywordDto : list) {
	        Row row = sheet.createRow(rowNum++);
	        row.createCell(0).setCellValue(relKeywordDto.getRseq());
	        row.createCell(1).setCellValue(relKeywordDto.getRelKeywordNm());
	        row.createCell(2).setCellValue(relKeywordDto.getSearchMon());
	        row.createCell(3).setCellValue(relKeywordDto.getSearchPc());
	        row.createCell(4).setCellValue(relKeywordDto.getSearchMobile());
	        row.createCell(5).setCellValue(relKeywordDto.getClickPc());
	        row.createCell(6).setCellValue(relKeywordDto.getClickMobile());
	        row.createCell(7).setCellValue(relKeywordDto.getClickPersentPc() + "%");
	        row.createCell(8).setCellValue(relKeywordDto.getClickPersentMobile() + "%");
	        row.createCell(9).setCellValue(relKeywordDto.getAverageAdv());
	        row.createCell(10).setCellValue(relKeywordDto.getCompetitionNm());
	    
	    }

	    // Excel to byte[]
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    workbook.write(out);
	    workbook.close();

	    return out.toByteArray();
	}
	
	
	

}
