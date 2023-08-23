package com.service.mybatis.test;

import com.service.mybatis.vo.MySawon;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySawonAppTest01 {

	public static void main(String[] args) throws Exception {
		//1. 폼으로부터 가입하려는 사원의 정보를 받는다...
		MySawon pvo = new MySawon();
		pvo.setId("hahash");
		pvo.setPwd("9006");
		pvo.setName("김연아");
		pvo.setAge(33);
		
		//2. SqlMapConfig.xml 파일을 읽어들인다
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");

		//3. SqlSessionFactory 생성
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//4. SqlSession 생성
		SqlSession session = factory.openSession();
		System.out.println("SqlSession이 드디어 만들어졌습니다...");
		
		/*
		 * SqlSession 쿼리문을 수행하는 모든 기능을 다 가지고 있다.
		 * int insert()
		 * int delete()
		 * int update()
		 * 
		 * List selectList()
		 * Object selectOne()
		 */
		
		//sawonAdd 쿼리문을 단위테스트... insert() 실행
		session.insert("SawonMapper.sawonAdd", pvo); //디비 업데이트
		System.out.println(pvo.getName() + " 님이 회원 등록 성공 ^^");
		
		//반드시!!
		session.commit();
		session.close();
		
		
	}

}
