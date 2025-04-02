package com.yedam.service;

import com.yedam.vo.MemberVo;

//MemberService(인터페이스)는 규칙을 정할때 사용
//MemberServiceDAO는 jdbc 기능을 구현하기 위해서 만듬
//MemberServiceImpl은 mybatis 기능을 활용해 기능을 구현
//MemberService(인터페이스)로 만든 규칙 없이 만들면 클래스에서 이름을 변경할 경우 DAO 또한 변경해야한다

public class MemberServiceDAO implements MemberService {

	@Override
	public MemberVo login(String id, String pw) {
		// TODO Auto-generated method stub
		return null;
	}
}
