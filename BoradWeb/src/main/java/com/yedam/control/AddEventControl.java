package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.Control;
import com.yedam.common.DataSource;
import com.yedam.mapper.EventMapper;
import com.yedam.vo.EventVo;

public class AddEventControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String title = req.getParameter("title");
		String startDate = req.getParameter("startDate");
		String end = req.getParameter("end");
		
		EventVo event = new EventVo();
		event.setTitle(title);
		event.setStartDate(startDate);
		event.setEnd(end);
		
		SqlSession sqlSession = DataSource.getInstance().openSession(true);
		EventMapper mapper = sqlSession.getMapper(EventMapper.class);
		int r = mapper.insertEvent(event);
		
		if(r > 0) {
			resp.getWriter().print("{\"retCode\":\"Success\"}");
		} else {
			resp.getWriter().print("{\"retCode\":\"Fail\"}");
		}
	}

}
