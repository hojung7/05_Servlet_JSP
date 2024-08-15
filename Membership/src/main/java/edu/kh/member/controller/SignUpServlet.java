package edu.kh.member.controller;

import java.io.IOException;

import edu.kh.member.service.MemberService;
import edu.kh.member.service.MemberServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

	// 회원 가입 페이지 응답
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String path = "/WEB-INF/views/signUp.jsp";
		// WEB-INF 폴더는 클라이언트 직접 접근 불가
		req.getRequestDispatcher(path).forward(req, resp);
		// -> 지정된 경로의 jsp에서 응답을 대신하라고 위임
					//  이때, 기존 req/resp가 유지됨
					// 응답화면의 주소 : /search
					//  (현재 Servlet 매핑 주소)
	}
	// 회원 가입 결과에 따라 redirect 페이지 결정
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("name");
			String phone = req.getParameter("phone");
		
		try {
			
			// 객체를 생성한다.
			// memberservice에 있는 메서드나 필드값을 쓸 수 있다.
			MemberService service = new MemberServiceImpl();
	
			boolean result = service.addMember(name, phone);
			
			String url = null;
			String message = null;
			
			if(result) {
				url = "/";
				message = name + "님이 가입되었습니다";
			}else {
				url = "/signUp";
				message = "중복된 휴대폰 번호가 존재합니다";
				
			}
			
			// Session scope 객체 얻어오기
			HttpSession session = req.getSession();
			
			// HttpServletSession 객체에 "message"라는 이름으로 message 값을 저장 
			session.setAttribute("message", message);
			
			resp.sendRedirect(url);
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
	
		
		
		}
}
