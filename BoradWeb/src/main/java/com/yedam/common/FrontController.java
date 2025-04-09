package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddEventControl;
import com.yedam.control.AdddReplyControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.DeleteBoardControl;
import com.yedam.control.DeleteFormControl;
import com.yedam.control.EventControl;
import com.yedam.control.EventFormControl;
import com.yedam.control.JSControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MainControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.ModifyFormControl;
import com.yedam.control.RLDatatable;
import com.yedam.control.RemoveEventControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyCountControl;
import com.yedam.control.ReplyListControl;
import com.yedam.control.SignUpcontrol;

// *.do의 요청에 실행
public class FrontController extends HttpServlet{

	// 요청한 url 값을 실행컨트롤에 바로
	Map<String, Control> map;
	
	// 생성자
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	
	// init
	@Override
	public void init(ServletConfig config) throws ServletException {
		map.put("/board.do", new BoardControl()); // 상세화면
		map.put("/boardList.do", new BoardListControl()); // 목록
		map.put("/addBoard.do", new AddBoardControl()); // 글등록 
		map.put("/modifyForm.do", new ModifyFormControl()); // 수정화면
		map.put("/modifyBoard.do", new ModifyBoardControl()); // 수정기능
		map.put("/deleteForm.do", new DeleteFormControl()); // 삭제화면
		map.put("/deleteBoard.do", new DeleteBoardControl()); // 삭제처리
		map.put("/loginForm.do", new LoginFormControl()); // 로그인
		map.put("/login.do", new LoginControl()); // 로그인처리
		map.put("/logout.do", new LogoutControl()); // 로그아웃처리
		map.put("/main.do", new MainControl());
		map.put("/signForm.do", new SignUpcontrol()); // 회원가입화면
		map.put("/signUp.do", new SignUpcontrol()); // 회원등록처리
		map.put("/javascript.do", new JSControl()); // js연습
		map.put("/replyList.do", new ReplyListControl()); // 댓글데이터
		map.put("/removeReply.do", new RemoveReplyControl()); // 댓글삭제
		map.put("/addReply.do", new AdddReplyControl()); // 댓글추가
		map.put("/replyCount.do", new ReplyCountControl()); // 댓글수
		//Datatable 연습용
		map.put("/replyListDatatable.do", new RLDatatable()); //댓글목록
		// fullcalendar관련
		map.put("/eventForm.do", new EventFormControl());
		map.put("/eventList.do", new EventControl());
		map.put("/addEvent.do",  new AddEventControl());
		map.put("/removeEvent.do",  new RemoveEventControl());
	}
	
	// service
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		System.out.println("service메소드 실행");
		String uri = req.getRequestURI();
//		System.out.println("요청 URI : " + uri); //  /BoardWeb/board.do
		String context = req.getContextPath();
		String page = uri.substring(context.length()); // /board.do
		System.out.println(page);
		
		Control sub = map.get(page); // 키(url) => control 반환
		sub.exec(req, resp);
	}
}
