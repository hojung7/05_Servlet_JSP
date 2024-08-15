package edu.kh.practice.controller;



@WebServlet("/search")
public class PracticeServlet extends HttpServlet {

	private List<String> nameList = null;
	
	public PracticeServlet() { // 기본 생성자
		nameList = new ArrayList<String>();
		
		nameList.add("짱짱이");
		nameList.add("쫑종이");
		nameList.add("꿍궁이");
		nameList.add("융유리");
		nameList.add("맹맹이");
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// 제출된 파라미터 얻어오기
		String inputName = req.getParameter("inputName");
		
		// 입력된 이름이 nameList에 있는지 없는지 확인
		
		// int List.indexOf("값") : 값과 일치하는 요소의 index 반환
		//										없으면 반환
		int index = nameList.indexOf(inputName);
		
		// 존재하는 경우
		if(index > -1) {
			String message
			= String.format("%s님은 %d 번째 인덱스에 존재 합니다", inputName, index);
			
			// HttpServletRequest 객체에 "message"라는 이름으로 message 값을 저장
			req.setAttribute("message", message);
			// JSP 파일 경로를 webapp 폴더 기준으로 작성
			String path = "/WEB-INF/views/result.jsp";
			// WEB-INF 폴더는 클라이언트 직접 접근 불가
			req.getRequestDispatcher(path).forward(req, resp);
			// -> 지정된 경로의 jsp에서 응답을 대신하라고 위임
			//  이때, 기존 req/resp가 유지됨
			// 응답화면의 주소 : /search
			//  (현재 Servlet 매핑 주소)
		}
		// 존재하지 않는 경우
		else {
			// Session scope 객체 얻어오기
			HttpSession session = req.getSession();
			
			session.setAttribute("message", inputName + "님은 존재하지 않습니다");
			
			// 왜 massage를 session scope에 세팅 했을까?
			// -> redirect(재요청) 시
			// 기존 req/resp 객체가 사라지고
			// 새 req/resp 객체가 생성되기 때문에
			
			// 기존 req에 값을 세팅해봐야 없어지기 때문에 의미 없음
			
			// 메인 페이지(/) 재요청하기
			// -> webapp 폴더를 기준으로 파일 경로 작성
			// 또는
			// 원하는 Servlet의 매핑되는 주소 작성
			resp.sendRedirect("/");
			
			// 테스트
		
	}
}
}