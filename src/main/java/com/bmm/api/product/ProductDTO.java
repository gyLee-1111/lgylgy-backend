package com.bmm.api.product;

import java.util.Date;

public class ProductDTO {
	
	 	private int keywordCode;
	    
	    private String productNm;
	   
		private String productCode;
		
		private long sales;
		
		private long amount;
		
		private String platForm;
		
		private String productImg;
		
		private Date registrationDt;
		
		private int reviewCnt;
		
		private double avgScore;
		
		private int coupangCode;
		
		private String rocketdeli;
		
		private int deliveryDate;
		
		public int getKeywordCode() {
			return keywordCode;
		}

		public void setKeywordCode(int keywordCode) {
			this.keywordCode = keywordCode;
		}

		public String getProductNm() {
			return productNm;
		}

		public void setProductNm(String productNm) {
			this.productNm = productNm;
		}

		public String getProductCode() {
			return productCode;
		}

		public void setProductCode(String productCode) {
			this.productCode = productCode;
		}

		public long getSales() {
			return sales;
		}

		public void setSales(long sales) {
			this.sales = sales;
		}

		public long getAmount() {
			return amount;
		}

		public void setAmount(long amount) {
			this.amount = amount;
		}

		public String getPlatForm() {
			return platForm;
		}

		public void setPlatForm(String platForm) {
			this.platForm = platForm;
		}

		public String getProductImg() {
			return productImg;
		}

		public void setProductImg(String productImg) {
			this.productImg = productImg;
		}

		public Date getRegistrationDt() {
			return registrationDt;
		}

		public void setRegistrationDt(Date registrationDt) {
			this.registrationDt = registrationDt;
		}

		public int getReviewCnt() {
			return reviewCnt;
		}

		public void setReviewCnt(int reviewCnt) {
			this.reviewCnt = reviewCnt;
		}

		public double getAvgScore() {
			return avgScore;
		}

		public void setAvgScore(double avgScore) {
			this.avgScore = avgScore;
		}

		public int getCoupangCode() {
			return coupangCode;
		}

		public void setCoupangCode(int coupangCode) {
			this.coupangCode = coupangCode;
		}

		public String getRocketdeli() {
			return rocketdeli;
		}

		public void setRocketdeli(String rocketdeli) {
			this.rocketdeli = rocketdeli;
		}

		public int getDeliveryDate() {
			return deliveryDate;
		}

		public void setDeliveryDate(int deliveryDate) {
			this.deliveryDate = deliveryDate;
		}
		
		

	

}
