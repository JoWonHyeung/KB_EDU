package spring.service.member.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.service.domain.MemberVO;
import spring.service.member.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;
	public static final String MAPPER_NAME = "MemberMapper.";

	@Override
	public int registerMember(MemberVO memberVO) {
		return sqlSession.insert(MAPPER_NAME + "registerMember", memberVO);
	}

	@Override
	public int deleteMember(String id) {
		return sqlSession.delete(MAPPER_NAME + "deleteMember", id);
	}

	@Override
	public int updateMember(MemberVO memberVO) {
		return sqlSession.update(MAPPER_NAME + "updateMember", memberVO);
	}

	@Override
	public List<MemberVO> showAllMember() {
		return sqlSession.selectList(MAPPER_NAME + "showAllMember");
	}

	@Override
	public MemberVO getMember(String id) {
		return sqlSession.selectOne(MAPPER_NAME + "getMember",id);
	}

	@Override
	public MemberVO login(MemberVO memberVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int idExist(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
