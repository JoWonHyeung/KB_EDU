package com.service.spring.model;

import java.util.List;

import com.service.spring.domain.MemberVO;

public interface MemberService {
	
	MemberVO getMember(String id) throws Exception;
	List<MemberVO> showAllMember()  throws Exception;
	MemberVO login(MemberVO vo) throws Exception;
}
