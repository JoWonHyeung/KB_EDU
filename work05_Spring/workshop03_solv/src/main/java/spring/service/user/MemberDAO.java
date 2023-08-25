package spring.service.user;

import java.util.List;

import spring.service.domain.MemberVO;

/*
 * ~mapping.xml 에서 쿼리문 id값이 해당 인터페이스의 기능의 이름이 된다.
 */
public interface MemberDAO {
	int registerMember(MemberVO VO) throws Exception;
	int deleteMember(String id) throws Exception;
	int updateMember(MemberVO vo) throws Exception;
	List<MemberVO> showAllMember() throws Exception;
	MemberVO getMember(String id) throws Exception;
	String idExist(String id) throws Exception;
}
