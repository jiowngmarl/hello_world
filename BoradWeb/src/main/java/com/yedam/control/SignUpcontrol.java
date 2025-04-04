package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVo;

public class SignUpcontrol implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getMethod().equals("GET")) {			
			// 1. 회원가입 화면 (get방식이 들어오면 회원가입 화면) WEB-INF/views/signForm.jsp
			req.getRequestDispatcher("member/signForm.tiles").forward(req, resp);
		} else {
			// 2. 회원가입 처리 (post방식이 들어오면 회원가입 처리), (파일업로드:images, db등록)
			
			// multipart에 매개값으로 들어가야하는 정보 5가지
			// 1)요청정보 2)경로 3)파일의 최대크기 4)파일이름을 처리하는 인코딩(영어,한국어 등) 5)리네임정책 (동일한 이름의 파일이 있으면 바꾸는 것)
			
			String saveDir = req.getServletContext().getRealPath("images");
			int maxSize = 1024 * 1024 * 5;
			String enc = "UTF-8";
			
			MultipartRequest mr = new MultipartRequest(req, saveDir, maxSize, enc, new DefaultFileRenamePolicy());
			
			String uid = mr.getParameter("userId");
			String upw = mr.getParameter("userPw");
			String unm = mr.getParameter("userName");
			String img = mr.getFilesystemName("userImg");
			
			MemberVo mvo = new MemberVo();
			mvo.setUserId(uid);
			mvo.setUserName(unm);
			mvo.setPassword(upw);
			mvo.setImages(img);
			
			MemberService svc = new MemberServiceImpl();
			if(svc.addMember(mvo)) {
				resp.sendRedirect("loginForm.do");
			} else {
				System.out.println("처리오류");
			}
		}
		
	}

}
