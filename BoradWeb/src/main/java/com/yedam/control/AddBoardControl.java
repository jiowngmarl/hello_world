package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVo;

public class AddBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8"); // 요청정보의 몸체에 있는 값에 대한 인코딩방식 지정
		
		if(req.getMethod().equals("GET")) {
			// get 방식은 url에 직접 입력하거나 링크를 클리하여 넘어가는 것을 말한다
			req.getRequestDispatcher("common/addForm.tiles").forward(req, resp); // 요청재지정
		} else if(req.getMethod().equals("POST")) {
			// post 방식이면 등록하도록 지정
			
			String title = req.getParameter("title");
			String writer = req.getParameter("writer");
			String content = req.getParameter("content");
			
			BoardVo board = new BoardVo();
			board.setTitle(title);
			board.setWriter(writer);
			board.setContent(content);
			
			// mybatis를 활용해서 jdbc 처리
			SqlSession sqlSession = DataSource.getInstance().openSession(true);
			BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
			int r = mapper.insertBoard(board);
			// 등록성공
			if(r > 0) {
				resp.sendRedirect("boardList.do"); // 요청재지정
			} else {
				System.out.println("등록실패");
			}
			
		}
		
		
	}
}
