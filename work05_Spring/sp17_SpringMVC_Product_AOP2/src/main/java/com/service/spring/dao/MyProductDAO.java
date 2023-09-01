package com.service.spring.dao;

import java.util.List;

import com.service.spring.domain.MyProduct;

public interface MyProductDAO {
	int addProduct(MyProduct vo) throws Exception;
	
	public List<MyProduct> findByProductName(String name)throws Exception;
}
