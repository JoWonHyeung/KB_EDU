package spring.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

public class MyBatisSpringDIAppTest3 {
	
	@Test
	public void unit() throws Exception{
		ApplicationContext context =
                new ClassPathXmlApplicationContext(
                                new String[] {    "/bean/memberservice.xml"     });

        MemberService service = (MemberService)context.getBean("memberServiceImpl");
        MemberDAO dao = (MemberDAO)context.getBean("memberDAOImpl");
        MemberVO member = new MemberVO("101", "101", "101", "101");

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");

        System.out.println(":: 1. register(INSERT)  ? ");
        dao.registerMember(member);
        
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
    
        member = service.getMember(member.getId());
        System.out.println(":: 2. get(SELECT)  ? " + member);
        
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");

        member.setName("아이유");
        System.out.println(":: 3. update(UPDATE)  ? ");
        dao.updateMember(member);

        
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");

        member = service.getMember(member.getId());
        System.out.println(":: 4. get(SELECT)  ? " + member);

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");

        System.out.println(":: 5. all User(SELECT)  ? ");
        List<MemberVO> list = service.showAllMember();
        for (int i =0 ;  i < list.size() ; i++) {
            System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
            System.out.println( list.get(i).toString() );
        }
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
     
        
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(":: 7. remove(DELETE)  ? "+dao.deleteMember(member.getId()));
        
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
	}
	
}
