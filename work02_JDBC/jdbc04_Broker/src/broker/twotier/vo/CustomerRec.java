package broker.twotier.vo;

import java.util.ArrayList;

/*
 * 주식을 사고파는 고객 정보를 저장하는 vo 클래스
 */
public class CustomerRec {
	private String ssn;
	private String name; //컬럼명은 cust_name
	private String address;
	
	//추가
	//private SharesRec sharesRec;
	private ArrayList<SharesRec> portfolio; //Hasing Relation... '1:다'관계

	public CustomerRec(String ssn, String name, String address, ArrayList<SharesRec> portfolio) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
		this.portfolio = portfolio;
	}
	
	public CustomerRec(String ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}
	
	public CustomerRec() {}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<SharesRec> getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(ArrayList<SharesRec> portfolio) {
		this.portfolio = portfolio;
	}

	@Override
	public String toString() {
		return "CustomerRec [ssn=" + ssn + ", name=" + name + ", address=" + address + ", portfolio=" + portfolio + "]";
	}
	
}
