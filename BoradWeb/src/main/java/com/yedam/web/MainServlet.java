package com.yedam.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.common.DataSource;
import com.yedam.dao.BoardDAO;
import com.yedam.vo.BoardVo;

/*
 * tomcat(WAS) (톰캣이 정해놓은 규칙에 따라서 작성해야한다)
 * 1. url 패턴이 필요함 (ex.  http://localhost/BoardWeb/welcome)
 * 2. 서블릿 클래스가 필요 (이 클래스가 서블릿 클래스를 제작하는것) (init() -> service() -> destroy() 순으로 메서드를 생성해야함)
 */

public class MainServlet extends HttpServlet  {

	//생성자
	public MainServlet() {
		System.out.println("mainServlet() 호출");
	}
	
	//서블릿의 생명주기 (init)
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("최초호출 한번만 실행되는 init() 메서드입니다.");
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		System.out.println("호출될때마다 실행되는 service() 메서드입니다.");
//		BoardDAO dao = new BoardDAO();
//		List<BoardVo> list = dao.boardList();
		
		SqlSessionFactory sqlSessionFactory = DataSource.getInstance();
		
		try (SqlSession session = sqlSessionFactory.openSession()) {
			  List<BoardVo> list = session.selectList("com.yedam.mapper.BoardMapper.selectBoard");
			
		
		PrintWriter out = resp.getWriter();
		String html = "<h3>게시글목록</h3>";
		html += "<table border = '2'>";
		html += "<thead><tr><th>글번호</th><th>제목</th><th>작성자</th><th>작성일시</th></tr></thead>";
		html += "<tbody>";
		for(BoardVo board : list) {
			html += "<tr>";
			html += "<td>" + board.getBoardNo() + "</td>";
			html += "<td>" + board.getTitle() + "</td>";
			html += "<td>" + board.getWriter() + "</td>";
			html += "<td>" + board.getWriteDate() + "</td>";
			html += "</tr>";
		}
		
		html += "</tbody></table>";
		out.print(html);
		} // end of try
	} // end of service
	
	@Override
	public void destroy() {
		System.out.println("서버종료시 실행되는 destroy() 메서드입니다.");
	}
}
