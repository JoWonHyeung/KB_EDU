package spring.service.member;

import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberDAO {
	int registerMember(MemberVO memberVO);
	int deleteMember(String id);
	int updateMember(MemberVO memberVO);
	List<MemberVO> showAllMember();
	MemberVO getMember(String id);
	MemberVO login(MemberVO memberVO);
	int idExist(String id);
	void deleteAllMember();
} 
