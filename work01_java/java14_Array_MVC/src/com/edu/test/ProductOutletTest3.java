package com.edu.test;

import com.edu.service.CustomerService;
import com.edu.vo.Customer;
import com.edu.vo.Product;

public class ProductOutletTest3 {

	public static void main(String[] args) {
		Product[] pros1 = {
				new Product("신라면", 1200, 10, "농심"),
				new Product("삼다수", 1100, 2, "농심"),
				new Product("옥시크린", 34000, 1, "엘지"),
				new Product("IPhone", 1000000, 1, "애플")
		};
		
		Product[] pros2 = {
				new Product("새우깡", 1000, 2, "농심"),
				new Product("Terra", 5000, 2, "T"),
				new Product("정수기", 304000, 1, "엘지")
		};
		
		Customer[] custs = {
				new Customer(111,"원빈","방배동"),
				new Customer(222,"이나영","방배동")	
		};
		
		CustomerService service = new CustomerService();

		custs[0].buyProducts(pros2);
		custs[1].buyProducts(pros1);
		
		//1
		System.out.println("=================== 1 ====================");
		Product[] p1 = service.getProducts(custs[0]);
		for(Product p : p1) 
			System.out.println(p);
		
		//2
		System.out.println("==================== 2 ===================");
		for(String s : service.getAllProductMakers(custs[0]))
			System.out.println(s);
		
		//3
		System.out.println("==================== 3 ===================");
		System.out.println(service.findCustomer(custs, 111));
		
		//4
		System.out.println("==================== 4 ===================");
		for(Customer cust : service.findCustomer(custs, "방배동")) 
			System.out.println(cust);
		
		
	}

}
