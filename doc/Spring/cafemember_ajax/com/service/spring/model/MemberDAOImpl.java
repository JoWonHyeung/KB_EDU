package com.service.spring.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	public static final String NS ="MemberMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int registerMember(MemberVO vo) throws Exception {
		int result = sqlSession.insert(NS+"registerMember",vo);
		return result;
	}

	@Override
	public int deleteMember(String id) throws Exception {
		int result = sqlSession.delete(NS+"deleteMember",id);
		return result;
	}

	@Override
	public int updateMember(MemberVO vo) throws Exception {
		int result = sqlSession.update(NS+"updateMember",vo);
		return result;
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return sqlSession.selectOne(NS+"getMember",id);
	}

	@Override
	public List<MemberVO> showAllMember() throws Exception {
		return sqlSession.selectList(NS+"showAllMember");
	}

	@Override
	public MemberVO login(MemberVO vo) throws Exception {
		return sqlSession.selectOne(NS+"login",vo);
	}

	@Override
	public String idExist(String id) throws Exception {
		return sqlSession.selectOne(NS+"idExist",id);
	}
}
