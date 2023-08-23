package spring.service.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;

public class MyBatisMemberTestApp {

	public static void main(String[] args) throws Exception {
		
		Reader reader=Resources.getResourceAsReader("config/SqlMapConfig.xml");		
		
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
		
		SqlSession session=factory.openSession();
		
		//Test를 위한 MemberVO 생성
		MemberVO m1 = new MemberVO("mykb","1234","조원형","구의");
		MemberVO m2 = new MemberVO("meshjo","1111","김무식","서울");
		MemberVO m3 = new MemberVO("aa11aass","4444","조인성","상암");
		
		try {
			/* [registerMember Test]*/
			session.insert("registerMember",m1);
			session.insert("registerMember",m2);
			session.insert("registerMember",m3);
			session.commit();

			/* [deleteMember Test] */
			//'Name = 조원형'이 없으면 delete 테스트 완료 
			session.delete("deleteMember",m1.getId());
			session.commit();
			
			/* [updateMember Test ]*/
			//'김무식 -> 차무식'으로 변경 
			MemberVO newMember = new MemberVO("meshjo","1111","차무식","서울");
			session.update("updateMember", newMember);
			
			/* [showAllMmeber Test] */
			System.out.println("=== showAllMember Test ===");
			List<MemberVO> list = session.selectList("showAllMember");
			
			for(MemberVO m : list) {
				System.out.println(m);
			}
			
			System.out.println();
			
			/* [getMember Test] */
			//'차무식'정보 가져오기
			System.out.println("=== getMember Test ===");
			System.out.println(session.selectOne("getMember", "meshjo").toString());
			
			System.out.println();
			
			/* [idExist Test]*/
			System.out.println("=== idExist Test ===");
			if((Integer)session.selectOne("idExist","aa11aass") == 1) {
				System.out.println("'aa11aass' 아이디가 존재합니다...");
			}
			
			System.out.println();
			
			/* [Login Test] */
			System.out.println("=== login Test ===");
			MemberVO loginMember1 = new MemberVO("aa11aass","4444","조인성","상암");
			MemberVO loginMember2 = new MemberVO("a","4","윤석열","용산");
			MemberVO loginSuccessMember = session.selectOne("login",loginMember1);
			MemberVO loginFailMember = session.selectOne("login",loginMember2);
			
			if(loginSuccessMember != null)
				System.out.println("로그인 성공 테스트 완료");
			if(loginFailMember == null)
				System.out.println("로그인 실패 테스트 완료 ");
			
		}finally {
			/* Test를 위해서 모든 코드 실행 후에 임의로 넣은 데이터 값을 삭제해준다.*/
			afterEach(session);
		}
		
	}
	
	public static void afterEach(SqlSession session) {
		session.delete("deleteAllMember");
		session.commit();
		session.close();
	}
	

}
