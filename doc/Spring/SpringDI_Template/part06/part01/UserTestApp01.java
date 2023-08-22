package spring.service.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import spring.service.domain.User;

public class UserTestApp01 {
	public static void main(String[] args) {
		/*
		 * BeanFactory�� ��ü�� getBean() �ϴ� ������ ������...
		 * �ؿ����� ���ؼ� ���캸��!!! ȣ��Ǵ� ����!!!
		 * �� �κп��� BeanFactory�� ApplicationContext�� ���ؼ� �� �����ϰ� �Ѿ��
		 * (Ư��, PreLoading �ϴ°� �� �� ������..was Servlet�� �츮�� �̹� �ô�. ���� ������ ������ �̸� �ε��Ǿ� �־���)
		 */
		BeanFactory factory = 
				new XmlBeanFactory(new FileSystemResource("./src/main/resources/config/userservice01.xml"));
		/*
		 * ��Ÿ����Ÿ�� �о�Ë� �̸� �ν��Ͻ� �����ؼ� �о�´�...
		 * �ٽ� ���ؼ� PreLoading�ϴµ�..�̰� �� ���� ���.(���������� BeanFactory �Ⱦ���)
		 * Was �� ��쿡�� ó��, ���� �����Ҷ� DD ���� �о �ѹ��� ������ �� �̸� ����� ���´�...�װͰ� ���� ����̴�.
		 * ��ó�� ApplicationContext�� BeanFactory�� �ڽ����� �� ���� ��ɵ��� �ִµ�...�ϳ��� ���� ���Եɰ��̴�.
		 * Ư���� ���� �ý����� �ƴ϶� �ٷ� Ŭ���� �н� ������ ������ ������ �����⿡ �ٷ� �ҽ� �غ��� ã���� �ȴ�..�ڹ��� �⺻ ���.
		 */
		//ApplicationContext factory = new ClassPathXmlApplicationContext("/config/userservice.xml");
		
		System.out.println("\n=============================================================================");
		User user01 = (User)factory.getBean("user01");
		System.out.println(user01);
		
		System.out.println("\n=============================================================================");
		User user02 = (User)factory.getBean("user02");
		System.out.println(user02);
		
		System.out.println("\n=============================================================================");
		User user03 = (User)factory.getBean("user03");
		System.out.println(user03);
		
		System.out.println("\n=============================================================================");
		User user04 = (User)factory.getBean("user04");
		System.out.println(user04);
		
		System.out.println("\n=============================================================================");
		User user05 = (User)factory.getBean("user05");
		System.out.println(user05);
		
	

	}

}
