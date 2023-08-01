package jdbc.client;

import config.ServerInfo;
import jdbc.dao.impl.MemberDAOImpl;
import jdbc.dto.Member;

public class MemberDAOImplTest {

	public static void main(String[] args) throws Exception {
		MemberDAOImpl dao = MemberDAOImpl.getInstance();
		
//		System.out.println("===================== [멤버 추가] ====================");
//		dao.insertMember(new Member("1","a","a")); 
//		dao.insertMember(new Member("2","b","b")); 
//		dao.insertMember(new Member("3","c","c")); 
//		dao.insertMember(new Member("4","d","d")); 
//		
//		System.out.println("===================== [멤버 삭제] ====================");
//		dao.deleteMember(133);
//		
//		System.out.println("===================== [멤버 업데이트] ====================");
//		dao.updateMember(new Member(8,"5","c","ccc"));
//		
//		System.out.println("===================== [멤버 출력 - 1] ====================");
//		for(Member m : dao.getMember()) {
//			System.out.println(m);
//		}
		
		System.out.println("===================== [멤버 출력 - 2] ====================");
		System.out.println(dao.getMember(141));
		
	}

	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success....");
			
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail....");
		}
	}
}
