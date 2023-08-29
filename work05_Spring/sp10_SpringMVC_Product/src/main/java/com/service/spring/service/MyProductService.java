package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.MyProduct;

public interface MyProductService {
	int addProduct(MyProduct vo) throws Exception;
	
	List<MyProduct> findProductByName(String name)throws Exception;
	List<MyProduct> findProductByMaker(String maker)throws Exception;
	List<MyProduct> findProducts(String str)throws Exception;
}
