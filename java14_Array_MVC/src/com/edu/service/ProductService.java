package com.edu.service;

import com.edu.vo.Product;

//Product들을 관리하는 기능만으로 구성된 서비스 클래스...
//메소드 identifier가 제일 중요! / return type, 인자값
//구현
public class ProductService {
	
	//1. 배열안에 있는 모든 상품들의 메이커를 출력하는 기능 -> All, -s, 아니면 둘다 붙인다.
	public void printAllProductMaker(Product[] pros) {
		for(Product pro : pros)
			System.out.println(pro.getMaker());
	}
	
	//2. 상품들의 총 구입액을 리턴하는 기능
	public int getTotalPrice(Product[] pros) { //private를 쓰면 코드의 명료성을 높여준다. private를 썼다? -> 그럼 다른 곳에서 썻겟네? -> 그럼 아래를 본다!
		int total = 0; //리턴타입있으면 로컬 타입 먼저 써줘!!!!!!
		//구현부
		for(Product p : pros) 
			total += p.getPrice() * p.getQuantity();
		
		return total;
	}
	
	//3. 특정 금액 이상의 상품을 리턴하는 기능
	public Product[] getMorePrice(Product[] pros, int price) {
		Product[] temp = new Product[pros.length]; //리턴타입이 컬렉션일 때 객체 생성부터 해준다.
		int idx = 0;
		for(Product p : pros) {
			if(p.getPrice() >= 10000) {
				temp[idx++] = p;
			}
		}
		return temp;
	}
	
	
	//4. 동일한 회사의 제품들만 리턴하는 기능
	public Product[] getCertainCompany(Product[] pros, String company) {
		Product[] temp = new Product[pros.length]; //리턴타입이 컬렉션일 때 객체 생성부터 해준다.
		int idx = 0;
		for(Product p : pros) {
			if(p.getCompany().equals(company)) {
				temp[idx++] = p;
			}
		}
		return temp;
	}
	
	//5. 구입한 상품들의 평균가격을 리턴하는 기능
	public int getAvgPrice(Product[] pros) {
		return getTotalPrice(pros) / pros.length;
	}
	
}

//중요!!!!!! 클래스 내부 메소드하나당 하나의 서비스