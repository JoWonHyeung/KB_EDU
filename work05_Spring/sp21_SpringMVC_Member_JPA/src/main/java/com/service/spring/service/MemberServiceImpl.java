package com.service.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.domain.Member;
import com.service.spring.model.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository; 
	
	@Override
	public void registerMember(Member member) {
		memberRepository.save(member);
	}

	@Override
	public List<Member> showAllMember() {
		return memberRepository.findAll();
	}

	@Override
	public Member findByIdMember(String id) {
		return memberRepository.findByIdMember(id);
	}

	@Override
	public Member login(Member member) {
		return memberRepository.login(member);
	}

	@Override
	public void updateMember(Member member) {
		memberRepository.save(member);
	}

	@Override
	public String idExist(String id) {
		return memberRepository.idExist(id);
	}

}
