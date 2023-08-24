package spring.service.member;

import java.util.List;

import spring.service.domain.MemberVO;

public interface MemberService {
	void registerMember(MemberVO memberVO);
	void updateMember(MemberVO memberVO);
	List<MemberVO> showAllMember();
	MemberVO getMember(String id);
	MemberVO login(MemberVO memberVO);
}
