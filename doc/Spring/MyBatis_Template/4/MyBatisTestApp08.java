package mybatis.services.user.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.services.domain.User;

/*
 * FileName : MyBatisTestApp08.java
  * ㅇ SqlMapConfig01.xml / mybatis-userservice-mapping08.xml
  * ㅇ MyBATIS Framework 이용 Dynamic query ( SELECT ) TEST | sql구문의 Module화
  * ㅇ TestUtil.java 을 이용 Test . 
  * 
  * ㅇ 다음은 MyBatisTestApp101.java : MyBatis Framework 단위 테스트
  */
public class MyBatisTestApp08 {
	///Main method
	public static void main(String[] args) throws Exception{
		SqlSession session = null;
		//==> TestUtil 의 getSqlSessionFactory()을 이용 SqlSessionFactory instance GET
		SqlSessionFactory factory = TestUtil.getSqlSessionFactory();
		session=factory.openSession();
		
		//==> Test 용 User instance 생성  
		User user = new User("userMapper01","홍길동","user01",new Integer(30),1);
	
		//1. UserMapper08.getUserList01 Test 
		System.out.println(":: 1. getUserList01(SELECT)  ? ");
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList01",user) );
		
		//2. UserMapper08.getUserList01 Test 
		System.out.println(":: 2. getUserList01(SELECT)  ? ");
		user.setUserName(null);
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList01",user) );
		
		//3. UserMapper08.getUserList01 Test 
		System.out.println(":: 3. getUserList01(SELECT)  ? ");
		user.setUserName("홍길동");
		user.setAge(null);
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList01",user));
	
		//4. UserMapper08.getUserList01 Test 
		System.out.println(":: 4. getUserList01(SELECT)  ? ");
		user.setUserName(null);
		user.setAge(null);
		TestUtil.printList( (List)session.selectList("UserMapper08.getUserList01",user) );
	
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("\n==================================\n");
		//==> Test 용 User instance 생성 및 age / regData null setting
		user = new User("user04","주몽","user04",null,1);
		user.setRegDate(null);
		
		//0. UserMapper05.addUser Test  :: users table age/redDate 입력값 확인할것 : OK 
		System.out.println(":: 0. addUser(INSERT)  ? "
									+ session.insert("UserMapper05.addUser",user));
		session.commit();	
	}//end of main
}//end of class