package com.yedam.test;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVo;

public class AppMain {

	public static void main(String[] args) {
		MemberService svc = new MemberServiceImpl();
		MemberVo member = svc.login("user01", "1111");
		
		System.out.println(member.toString());
	}
	
}
