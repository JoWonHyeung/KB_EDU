package aop.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.aop.prob.MemberService;
import spring.aop.prob.ProductService;

public class AopAppTest1 {

	public static void main(String[] args) {
		ApplicationContext factory = 
				new ClassPathXmlApplicationContext("beans/prob.xml");
		
		System.out.println("===prob.xml을 읽어서 빈을 생성했습니다.====");
		
		MemberService member = (MemberService)factory.getBean("member");
		ProductService product = (ProductService)factory.getBean("product");
		member.register("kbstar");
		member.findMember("kbstar");
		
		System.out.println("\n****************************\n");
		product.deleteProduct("aaa");
		
		

	}

}
