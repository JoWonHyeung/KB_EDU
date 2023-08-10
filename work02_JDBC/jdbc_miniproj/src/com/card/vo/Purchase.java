package com.card.vo;


public class Purchase {
	private int id;
	private int price;
	private String ssn;
	private String cardId;
	private String day;
	private String category;
	private String companyName;
	
	
	public Purchase(int id, int price, String ssn, String cardId, String day, String category, String companyName) {
		this.id = id;
		this.price = price;
		this.ssn = ssn;
		this.cardId = cardId;
		this.day = day;
		this.category = category;
		this.companyName = companyName;
	}


	public Purchase(int price, String ssn, String cardId, String day, String category, String companyName) {
		this.price = price;
		this.ssn = ssn;
		this.cardId = cardId;
		this.day = day;
		this.category = category;
		this.companyName = companyName;
	}

	public Purchase(String day, String category, String companyName) {
        this.day = day;
        this.category = category;
        this.companyName = companyName;
    }
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getSsn() {
		return ssn;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}


	public String getCardId() {
		return cardId;
	}


	public void setCardId(String cardId) {
		this.cardId = cardId;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Override
	public String toString() {
		return "Purchase [price=" + price + ", ssn=" + ssn + ", cardId=" + cardId + ", day=" + day
				+ ", category=" + category + ", companyName=" + companyName + "]";
	}

	
}
