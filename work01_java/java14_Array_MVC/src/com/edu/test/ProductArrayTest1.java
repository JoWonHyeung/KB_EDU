package com.edu.test;

import com.edu.vo.Product;

public class ProductArrayTest1 {

	public static void main(String[] args) {
		Product[] products = {
				new Product("신라면", 1200, 10, "농심"),
				new Product("삼다수", 1100, 2, "농심"),
				new Product("옥시크린", 34000, 1, "엘지"),
				new Product("IPhone", 1000000, 1, "애플")
		};
		
		System.out.println("=== 1. 상품들의 Maker만 출력 ===");
		for(Product p : products)
			System.out.println(p.getMaker());
		
		System.out.println("=== 2. 10만원 이상의 고가제품 정보를 출력한다. ===");
		for(Product p : products) {
			if(p.getPrice() >= 1000000)
				System.out.println(p);
		}
		
		System.out.println("=== 3. 구매한 상품의 총 합을 출력 ===");
		int total = 0;
		for(Product p : products) {
			total += p.getPrice() * p.getQuantity();
		}
		System.out.println(total);
		
	}

}
