package spring.service.member.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import spring.service.domain.MemberVO;
import spring.service.member.MemberDAO;
import spring.service.member.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public void registerMember(MemberVO memberVO) {
		memberDAO.registerMember(memberVO);
	}

	@Override
	public void updateMember(MemberVO memberVO) {
		memberDAO.updateMember(memberVO);
	}

	@Override
	public List<MemberVO> showAllMember() {
		return memberDAO.showAllMember();
	}

	@Override
	public MemberVO getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public MemberVO login(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
