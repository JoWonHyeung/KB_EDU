package com.service.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest02 {

	public static void main(String[] args) throws Exception {
		
		//1. SqlMapConfig.xml 읽어 들인다...
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2. SqlSessionFactory 리턴받고
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3. SqlSession 리턴받고
		SqlSession session = factory.openSession();
		
		//4. selectList() 호출
		List<MySawon> list = session.selectList("SawonMapper.sawonList");
		
		for(Object m : list) 
			System.out.println(m);
		
	}

}
