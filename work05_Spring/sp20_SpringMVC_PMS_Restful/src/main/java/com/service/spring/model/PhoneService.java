package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;

public interface PhoneService {
	
	int insert(Phone phone);
	int delete(List<String> list);
	Phone select(Phone phone);
	List<Phone> select();
	UserInfo select(UserInfo user);
	
	int update(Phone phone);
}
