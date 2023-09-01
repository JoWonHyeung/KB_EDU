package aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.solv.MemberService;
import spring.aop.solv.ProductService;


public class AopAppTest2 {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("beans/solv.xml");
		
		System.out.println("===solv.xml을 읽어서 빈을 생성했습니다.====");
		
		MemberService member = (MemberService)factory.getBean("member");
		ProductService product = (ProductService)factory.getBean("product");
		member.register("kbstar");
		member.findMember("kbstar");
		
		System.out.println("\n****************************\n");
		product.deleteProduct("aaa");
		
		

	}

}
