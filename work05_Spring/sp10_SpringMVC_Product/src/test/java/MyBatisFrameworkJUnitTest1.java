
//JUnit 사용한 단위테스트..
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
		
		//3. 쿼리문 실행
		/*
		System.out.println("========1. addProduct ==============");
		MyProduct vo =new MyProduct("공기방울 세탁기", "대우", 600000); 
		//id 없음, insert into 할 때 id에 값이 sequence로 들어간다
		//insert할 때는 id에 값이 없어서 pvo와 rvo가 동기화가 안된다. >> controller component에서 rvo 시퀀스를 받아서 꽂아넣는 일을 해야한다.
		//화면에서 값을 받아서 DB에 보통 넣는데, 컨테이너 차원에서 끌어당기는것도 있지만 그건 제외
		//DB에서 자동증가하는 값이 있음(sequence, sysdate 등), 그게 하필 column의 PK인 경우엔 vo 간 동기화가 되지 않으면 문제가 발생한다.
		//PK일 때만 문제가 생긴다.
		
		
		
		//
		ssession.insert("ns.sql.MyProductMapper.addProduct", vo); 
		ssession.commit();
		//
		*/
		
		System.out.println("\n========2. findProducts ==============");
		List<MyProduct> list = ssession.selectList("ns.sql.MyProductMapper.findProducts");
		for(MyProduct prduct : list)
			System.out.println(prduct);
		
		MyProduct vo =new MyProduct("선풍기", null, 0); 
		System.out.println("\n========3. findProductByName ==============");
		List<MyProduct> list2 = ssession.selectList("ns.sql.MyProductMapper.findProducts",vo);
		for(MyProduct prduct : list2)
			System.out.println(prduct);
//		
		MyProduct vo2 =new MyProduct(null, "대우", 0); 
		System.out.println("\n========3. findProductByMaker ==============");
		List<MyProduct> list3 = ssession.selectList("ns.sql.MyProductMapper.findProducts",vo2);
		for(MyProduct prduct : list3)
			System.out.println(prduct);
//			
	}
}











