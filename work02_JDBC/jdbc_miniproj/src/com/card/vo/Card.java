package com.card.vo;

public class Card {
	private String cardId; 		/* card_id */
	private String companyName; /* company_name */
	private String expire; 		/* expire_date */
	private String grade; 		/* grade */
	
	public Card(String cardId,  String expire, String companyName) {
		super();
		this.cardId = cardId;
		this.expire = expire;
		this.companyName = companyName;
	}
	
	public String getCardId() {
		return cardId;
	}
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getExpire() {
		return expire;
	}
	public void setExpire(String expire) {
		this.expire = expire;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
