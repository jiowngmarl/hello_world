package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVo;

@WebServlet("/getBoard")
public class GetBoardServ extends HttpServlet {

	// http://localhost/BoardWeb/getBoard?board_no=3 -> board_no가 13인 상세조회 기능

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		String boardNo=req.getParameter("boardNo");
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		BoardVo board = mapper.selectOne(Integer.parseInt(boardNo));
		
		PrintWriter out = resp.getWriter();
		String html = "<h3>상세조회</h>";
		html += "글번호 : " + board.getBoardNo();
		
		html += "<p><a href='mainsevlet'>목록으로</a></p>";
		
		out.print(html);
	}
}
