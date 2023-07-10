package com.edu.service;

import com.edu.vo.Customer;
import com.edu.vo.Product;

/*
 * 아울렛에서 상품을 구매하는 고객에 대한 기능을 다루는
 * 서비스 클래스...
 * 기능들만 정의되어져 있다.
 * 하나의 기능은 독자적인 완벽한 서비스로 이해하자.. 중요!!!!!!!!!!!!!!!!!!!!!!!!!!!
 */
public class CustomerService {
	//1. 특정 고객이 구입한 상품을 리턴하는 기능...
	public Product[] getProducts(Customer c) {
		return c.getProducts();
	}
	
	//2. 특정 고객이 구입한 상품들의 maker들을 리턴
	public String[] getAllProductMakers(Customer cust) {
		String[] temp = new String[cust.getProducts().length];
		int idx = 0;
		for(Product pro : cust.getProducts()) {
			temp[idx++] = pro.getMaker();
		}
		return temp;
	}
	
	//3. 모든 고객중에서 특정한 고객을 검색...
	//find, search... 검색관련 기능은 왼쪽의 접두어들을 사용한다. 어떤 수단으로 ..by???..
	public Customer findCustomer(Customer[] custs, int ssn) { // findCustomerBySsn 이것도 괜춘... 강사님은 이것도 오버로딩이라고 생각하신다.
		Customer customer = null; // 리턴타입이 있으면 바로 선언할 것
		for(Customer cust : custs) {
			if(cust.getSsn() == ssn)
				customer = cust;
		}
		return customer;
	}
	
	//4. 모든 고객중에서 특정한 동네한 사는 고객을 검색...
	//method overloading : 하나의 클래스에서 하는 일은 같지만, 처리하는 데이터를 달리하는 기법
	//소스코드의 가독력을 높인다.
	//<메소드 오버로딩 조건>
	//1. 메소드 이름을 같게 한다.
	//2. 인자 값을 달라야 한0다. 순서, 타입 하나라도
	//3. 리턴타입은 상관없다.
	public Customer[] findCustomer(Customer[] custs, String address) { // findCustomerByAddr
		Customer[] temp = new Customer[custs.length]; // 리턴타입이 있으면 바로 선언할 것
		int idx = 0;
		for(Customer cust : custs) {
			if(cust.getAddress().equals(address)) {
				temp[idx++] = cust;
			}
		}
		return temp;
	}
	
	//5. .........
}
