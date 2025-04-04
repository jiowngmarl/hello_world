package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVo;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 파라미터 : uname, psw 를 읽고 있으면 글목록으로 이동, 없으면 로그인실패로 로그인페이지로 다시 이동

		String id = req.getParameter("uname");
		String pw = req.getParameter("psw");
		
		// 서비스객체를 통해서 값을 처리
		MemberService svc = new MemberServiceImpl();
		MemberVo mvo = svc.login(id, pw);
		
		if(mvo == null) {
			req.setAttribute("msg", "아이디와 비밀번호를 확인하세요");
			req.getRequestDispatcher("member/loginForm.tiles").forward(req, resp);
		} else {
			
			// 로그인성공 => 세션객체에 로그인 정보 저장
			HttpSession session = req.getSession();
			session.setAttribute("logId", id); // 세선객체의 Attribute에 저장
			session.setAttribute("img", mvo.getImages());
			
			if(mvo.getResponsibility().equals("User")) {
//				resp.sendRedirect("boardList.do");
				req.getRequestDispatcher("etc/main.tiles").forward(req, resp);
			} else if(mvo.getResponsibility().equals("Admin")) {
				req.getRequestDispatcher("admin/main.tiles").forward(req, resp);
			}
			
		}
	}
}
