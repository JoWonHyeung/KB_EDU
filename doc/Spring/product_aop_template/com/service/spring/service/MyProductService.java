package com.service.spring.service;

import java.util.List;

import com.service.spring.domain.MyProduct;

public interface MyProductService {
	int addProduct(MyProduct vo) throws Exception;
	
	public List<MyProduct> findByProductName(String name)throws Exception;
}
