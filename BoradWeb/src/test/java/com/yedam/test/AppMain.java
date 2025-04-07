package com.yedam.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.MemberMapper;
import com.yedam.mapper.ReplyMapper;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVo;
import com.yedam.vo.ReplyVo;

public class AppMain {

	public static void main(String[] args) {
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		ReplyVo rvo = new ReplyVo();
		rvo.setBoardNo(152);
		rvo.setReply("댓글테스트");
		rvo.setReplyer("user99");
		int cnt = mapper.insertReply(rvo);
		if(cnt>0) {
			System.out.println("성공");
		}
		List<ReplyVo> list = mapper.selectList(152);
		for(ReplyVo reply : list) {
			System.out.println(reply.toString());
		}
	}
}
