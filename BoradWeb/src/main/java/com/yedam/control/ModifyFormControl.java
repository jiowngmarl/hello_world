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

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// bno=? 의 파라메터가 넘어오고 그 값을 조회, 오픈할 페이지에(modifyBoard.jsp) 넘겨준다
	
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		SqlSession sqlSession = DataSource.getInstance().openSession();
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		
		BoardVo board = mapper.selectOne(Integer.parseInt(bno));
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		
		req.getRequestDispatcher("/WEB-INF/views/modifyBoard.jsp").forward(req, resp);
		
	}

}
