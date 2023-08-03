package broker.twotier.vo;

/*
 * Shares 테이블의 정보를 담는 클래스...
 * 누가...ssn
 * 어떤주식을...symbol
 * 얼만큼 ...quantity
 * 보유하는 지에 대한 정보를 담고 있다.
 */
public class SharesRec {
	private String ssn;
	private String symbol;
	private int quantity;
	public SharesRec(String ssn, String symbol, int quantity) {
		super();
		this.ssn = ssn;
		this.symbol = symbol;
		this.quantity = quantity;
	}
	public SharesRec() {	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "SharesRec [ssn=" + ssn + ", symbol=" + symbol + ", quantity=" + quantity + "]";
	}
	
}






