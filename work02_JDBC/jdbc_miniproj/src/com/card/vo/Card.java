package com.card.vo;

public class Card {
	private String cardId;
	private String companyName;
	private String expire;
	
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
	
	
	
}
