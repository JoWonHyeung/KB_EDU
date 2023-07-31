package com.edu.test;

import com.edu.service.ProductService;
import com.edu.vo.Product;

public class ProductServiceTest2 {

	public static void main(String[] args) {
		//1.
		Product[] products = {
				new Product("신라면", 1200, 10, "농심"),
				new Product("삼다수", 1100, 2, "농심"),
				new Product("옥시크린", 34000, 1, "엘지"),
				new Product("IPhone", 1000000, 1, "애플")
		};
		
		//2.Service 클래스 객체 생성
		// ProductService 클래스의 기능들이 메모리에 올라가고
		// 호출해서 사용..
		ProductService service = new ProductService();
		
		service.printAllProductMaker(products);

		System.out.println(service.getTotalPrice(products) + "원");
		
		Product[] pros = service.getMorePrice(products, 10000);
		
		for(Product p : pros) {
			if(p == null) continue;
			System.out.println(p);
		}
		
		System.out.println("================================");
		Product[] pros1 = service.getCertainCompany(products, "농심");
		
		for(Product p : pros1) {
			if(p == null) continue;
			System.out.println(p);
		}
	}

}
