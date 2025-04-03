package com.yedam.service;

import com.yedam.vo.MemberVo;

// 업무프로세스 (service), 이 인터페이스를 구현하는 이유는 규칙을 지정하기 위해서
public interface MemberService {

	//로그인 
	MemberVo login(String id, String pw);
	boolean addMember(MemberVo member);
}
