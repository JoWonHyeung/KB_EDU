package spring.service.user;

import java.util.List;

import spring.service.domain.MemberVO;

//데이터 가공과 관련된 레이저...
//게시판 페이징 처리로직, 통계관련 로직, 알고리즘 연결로직
public interface MemberService {
	
	List<MemberVO> showAllMember() throws Exception;
	MemberVO getMember(String id) throws Exception;
	
	String idExist(String id) throws Exception;
}
