package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.model.service.MemberService;
import com.kh.member.model.vo.Member;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/login.me") --> 어노테이션(annotation) 방식
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 *  < HttpServletRequest 객체와 HttpServletResponse 객체 >
		 *  
		 *  -request : 서버로 요청하는 정보들이 담겨있음(요청시 전달값, 요청한 클라이언트 ip 등등)
		 *  -response :  요청에 대해 응답할 떄 필요한 객체
		 *  
		 *  <Get 방식과 Post 방식의 차이>
		 *  - Get 방식: URL의 Header에 데이터가 기록되서 전달(url노출/데이터길이제한/대신 즐겨찾기 가능)
		 *  - Post 방식 : URL의 Body에 데이터가 기록되서 전달(url노출x/데이터길이제한 없음/ 대신 TimeOut 있음/즐겨찾기 가능)
		 */
		
		//1. 전달값에 한들이 있을 경우 인코딩 처리해야됨(POST방식일 경우)
		request.setCharacterEncoding("UTF-8");
		
		//2. 요청시 전달값(request parameter영역) 꺼내서 변수 또는 객체에 기록하기
		String userId = request.getParameter("userId");		// 사용자가입력한 아이디
		String userPwd = request.getParameter("userPwd");	// 사용자가입력한 비밀번호
		
			
		//3. 해당 요청을 처리하는 서비스 클래스의 메소드 호출 및 그 처리 결과 받기 
		Member loginUser = new MemberService().loginMember(userId, userPwd); 
		
		//4. 처리결과를 가지고 사용자가 보게될 뷰 지정 후 포워딩 또는 리	다이렉트
		
		
		/*
		 * *응답페이지에 전달할 값이 있을 경우 어딘가에 담아야됨!! (담아줄 수 있는 JSP 내장 객체 4종류 그 중 하나다가 request)
		 * 
		 * 1) application : 에 담은 데이터는 웹 어플리케이션 전역(jsp, servlet, java)에서 다 꺼내 쓸 수 있다. 
		 * 2) session : 에 다음은 데이터는 모든 jsp와 servlet에서 꺼내 쓸 수 있따. 
		 * 3) request : 이 request 객체에 담은 데이터는 오로지 *응답* JSP에서만 꺼내 쓸 수 있다. 
		 * 4) page : 해당 JSP페이지에서만 꺼내 쓸 수 있다. 
		 * 
		 * Session 객체 : 웹브라우저당 하나씩 존재하는 객체
		 * 				로그인한 회원 정보를 session에 한번만 등록해 놓으면 어느 페이지에던간에 session에 담긴 회원객체에 대한 정보 뽑아 쓸 수 있음. 
		 * 
		 * .setAttribute("키", 밸류) 를 이용해서 데이터 담기
		 * 꺼낼떄는 .getAttribute("키") 이용
		 * 삭제하고자 할때는 .removeAttribute("키") 이용
		 */
		
		if(loginUser != null) {	// 로그인 성공  => index 페이지
			
			//servlet에서 JSP 내장 객체인 session에 접근하고자 한다면 우선 세션 객체를 얻어와야됨
			HttpSession session = request.getSession();
			session.setAttribute("loginUser",loginUser);
			
			//1. forwarding 방식으로 응답 뷰 출력하기 
			// 	  해당 선택된 뷰가 보여질 뿐 url에는 여전히 현재 이서블릿 매핑값이 남아있음
			/*
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
			*/
			// 로그인 성공후 메인페이지가 보여짐에도 불구하고 login.me가 남아 있던 이유!!
			
			// 2. sendRedirect 방식 (url 재 요청 방식 => 여기에 제시한 url값이 노출)
			
			//System.out.println(request.getContextPath());
			//response.sendRedirect("/jsp");
			response.sendRedirect(request.getContextPath());
			
		}else { // 로그인 실패 => 에러페이지
			//응답할 뷰에 필요한 데이터 request의 attribute에 담기
			request.setAttribute("errorMsg", "로그인에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp"); //jsp로 떠넘길떄 필요한 객체		
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
