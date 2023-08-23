package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//SqlSessionfactory만 받아오는 기능을 가지고 있음
public class FactoryService {
	
	private static SqlSessionFactory factory = null;

	static {
		try {
			Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
		}catch(IOException e) {
			
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
	
}
