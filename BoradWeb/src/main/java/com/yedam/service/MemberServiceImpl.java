package com.yedam.service;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVo;

// 업무 서비스 로직을 구현하는 객체 
public class MemberServiceImpl implements MemberService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	MemberMapper mapper = sqlSession.getMapper(MemberMapper.class);
	
	@Override
	public MemberVo login(String id, String pw) {
		return mapper.selectMember(id, pw);
	}
}
