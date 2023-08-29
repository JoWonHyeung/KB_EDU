package com.service.spring.test;
//JUnit ?��?��?�� ?��?��?��?��?��..
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.service.spring.domain.MyProduct;


public class MyBatisFrameworkJUnitTest1 {	
	@Test
	public void unit() throws Exception{
		Reader r=Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//1. SqlSessionFactory -- SqlSessionFactoryBean
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//2. SqlSession -- SqlSessionTemplate
		SqlSession ssession=factory.openSession();
		
		
		
		
		System.out.println("\n========2. findProducts ==============");
		List<MyProduct> list = ssession.selectList("ns.sql.MyProductMapper.findProducts");
		for(MyProduct prduct : list)
			System.out.println(prduct);
		
		System.out.println("\n========3. findProductByName ==============");
		List<MyProduct> list2 = ssession.selectList("ns.sql.MyProductMapper.findProductByName","?��?���?");
		for(MyProduct prduct : list2)
			System.out.println(prduct);
		
		System.out.println("\n========3. findProductByMaker ==============");
		List<MyProduct> list3 = ssession.selectList("ns.sql.MyProductMapper.findProductByMaker","???��");
		for(MyProduct prduct : list3)
			System.out.println(prduct);
	}
}











