package com.bmm.api.keyword;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeywordService {
	
	@Autowired
	private KeywordMapper keywordMapper;
	
	public List<KeywordDTO> getListKeyword(SearchKeywordDTO searchKeywordDto) {
		
		
		return keywordMapper.getListKeyword(searchKeywordDto);
	}
	
	public byte[] downloadKeywordExcel(SearchKeywordDTO searchKeywordDto) throws IOException {
	    List<KeywordExcelDTO> list = keywordMapper.downloadKeywordExcel(searchKeywordDto); // 기존 키워드 조회 재활용

	    XSSFWorkbook workbook = new XSSFWorkbook();
	    XSSFSheet sheet = workbook.createSheet("키워드 목록");

	    // Header
	    Row headerRow = sheet.createRow(0);
	    headerRow.createCell(0).setCellValue("번호");
	    headerRow.createCell(1).setCellValue("키워드명");
	    headerRow.createCell(2).setCellValue("키워드 분류");
	    headerRow.createCell(3).setCellValue("총 검색량");
	    headerRow.createCell(4).setCellValue("PC 검색량");
	    headerRow.createCell(5).setCellValue("모바일 검색량");
	    headerRow.createCell(6).setCellValue("평균 광고 수");

	    // Data
	    int rowNum = 1;
	    for (KeywordExcelDTO keywordExcelDto : list) {
	        Row row = sheet.createRow(rowNum++);
	        row.createCell(0).setCellValue(keywordExcelDto.getRseq());
	        row.createCell(1).setCellValue(keywordExcelDto.getKeywordNm());
	        row.createCell(2).setCellValue(keywordExcelDto.getKeywordTypeNm());
	        row.createCell(3).setCellValue(keywordExcelDto.getSearchPc() + keywordExcelDto.getSearchMobile());
	        row.createCell(4).setCellValue(keywordExcelDto.getSearchPc());
	        row.createCell(5).setCellValue(keywordExcelDto.getSearchMobile());
	        Long averageAdv = keywordExcelDto.getAverageAdv();
	        row.createCell(6).setCellValue(averageAdv != null ? averageAdv.doubleValue() : 0);
	    }

	    // Excel to byte[]
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    workbook.write(out);
	    workbook.close();
	    out.flush();

	    return out.toByteArray();
	}
	
    public KeywordDTO getDetailKeyword(int keywordCode) {
		 
        return keywordMapper.getDetailKeyword(keywordCode);
        
    }
    
    public KeywordChartDTO getKeywordChart(int keywordCode) {
		 
        return keywordMapper.getKeywordChart(keywordCode);
        
    }
    public List<KeywordHistoryChartDTO> getKeywordHistoryChart(int keywordCode) {
    	
    	return keywordMapper.getKeywordHistoryChart(keywordCode);
    			
    }
    public List<KeywordCategoryDTO> getKeywordCategory(int keywordCode) {
    	
    	return keywordMapper.getKeywordCategory(keywordCode);
    			
    }

	public String checkFavorite(SearchKeywordDTO searchKeywordDto) {
	    boolean exists = keywordMapper.checkFavoriteExists(searchKeywordDto.getUserId(), searchKeywordDto.getKeywordCode());

	    if (exists) {
	        keywordMapper.removeFavorite(searchKeywordDto.getUserId(), searchKeywordDto.getKeywordCode());
	        return "removed";
	    } else {
	        keywordMapper.addFavorite(searchKeywordDto.getUserId(), searchKeywordDto.getKeywordCode());
	        return "added";
	    }
	}
	public String getKeywordNm(int keywordCode) {
		
		return keywordMapper.getKeywordNm(keywordCode);
	}
	
	public ReviewStatsDTO getCountReview(int keywordCode) {
		
		return keywordMapper.getCountReview(keywordCode);
	}
	
	public ReviewStatsDTO getShoppingDetail(int keywordCode) {
		
		return keywordMapper.getShoppingDetail(keywordCode);
	}
	
	public String getScore(double score) {
		
		return keywordMapper.getScore(score);
	}

}
