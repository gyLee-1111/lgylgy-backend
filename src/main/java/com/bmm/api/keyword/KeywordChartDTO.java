package com.bmm.api.keyword;

import java.util.List;

public class KeywordChartDTO {
	
	private int keywordCode;

	public int getKeywordCode() {
		return keywordCode;
	}

	public void setKeywordCode(int keywordCode) {
		this.keywordCode = keywordCode;
	}

	private int age10;
	
	private int age20;
	
	private int age30;
	
	private int age40;
	
	private int age50;
	
	private int age60;
	
	private int devicePc;
	
	private int deviceMobile;
	
	private int genderMan;
	
	private int genderWoman;

	public int getAge10() {
		return age10;
	}

	public void setAge10(int age10) {
		this.age10 = age10;
	}

	public int getAge20() {
		return age20;
	}

	public void setAge20(int age20) {
		this.age20 = age20;
	}

	public int getAge30() {
		return age30;
	}

	public void setAge30(int age30) {
		this.age30 = age30;
	}

	public int getAge40() {
		return age40;
	}

	public void setAge40(int age40) {
		this.age40 = age40;
	}

	public int getAge50() {
		return age50;
	}

	public void setAge50(int age50) {
		this.age50 = age50;
	}

	public int getAge60() {
		return age60;
	}

	public void setAge60(int age60) {
		this.age60 = age60;
	}

	public int getDevicePc() {
		return devicePc;
	}

	public void setDevicePc(int devicePc) {
		this.devicePc = devicePc;
	}

	public int getDeviceMobile() {
		return deviceMobile;
	}

	public void setDeviceMobile(int deviceMobile) {
		this.deviceMobile = deviceMobile;
	}

	public int getGenderMan() {
		return genderMan;
	}

	public void setGenderMan(int genderMan) {
		this.genderMan = genderMan;
	}

	public int getGenderWoman() {
		return genderWoman;
	}

	public void setGenderWoman(int genderWoman) {
		this.genderWoman = genderWoman;
	}
	private List<KeywordHistoryChartDTO> historyChart ;

	public List<KeywordHistoryChartDTO> getHistoryChart() {
		return historyChart;
	}

	public void setHistoryChart(List<KeywordHistoryChartDTO> historyChart) {
		this.historyChart = historyChart;
	}

	
}
