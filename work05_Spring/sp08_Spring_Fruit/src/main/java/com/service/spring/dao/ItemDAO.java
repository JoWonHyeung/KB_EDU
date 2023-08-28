package com.service.spring.dao;

import java.util.List;

import com.service.spring.domain.Item;

public interface ItemDAO {
	List<Item> getItemList() throws Exception;
	Item getItem(Integer itemId) throws Exception;	
}
