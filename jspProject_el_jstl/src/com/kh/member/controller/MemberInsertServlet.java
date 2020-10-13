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
 * Servlet implementation class MemberInsertServlet
 */
@WebServlet("/insert.me")
public class MemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//2.전달값 뽑기 변수 및 객체에 기록하기 
		String userId = request.getParameter("userId");	//사용자가 입력한 아이디 required "user01"
		String userPwd = request.getParameter("userPwd"); // "pass01"
		String userName = request.getParameter("userName"); // "홍길동"
		String phone = request.getParameter("phone"); // "010-2222-0980" / " "
		String email = request.getParameter("email"); // "gildong@sk.com" / " "
		String address = request.getParameter("address");// "서울시 광진구" / " "
		String[] interests = request.getParameterValues("interest"); // ["",""] / null
		//String[] --> String
		//["운동","등산"] --> "운동,등산" 
		//** 데이터 가공 처리 --> Member 객체에 담아주고 싶은데 interest가 String으로 되어있기 때문에 배열로 못 받아서 바꾼거임
		String interest = "";
		if(interests != null) {
			interest = String.join(",", interests);
		}
		
		//기본생성자생성후 setter 메소드 이용해서 담기 / **아싸리 매개변수생성자 이용해서 담기 
		//매개변수 생성시 빨간줄이 생기는 이유는 이것을 받아줄 매개변수 생성이 안되어져 있기 떄문에 Member쪽으로 가서 이 것을 받아줄 매개변수 생성하면 됨. 
		Member m = new Member(userId,userPwd,userName,phone,email,address,interest);
		
		//3. 요청 처리(서비스 메소드 호출 및 결과 받기) 
		int result = new MemberService().insertMember(m);
		
		//4. 결과에 따른 사용자가 보게될 응답페이지 지정
		if(result > 0) {	//회원가입 성공 --> 인덱스페이지(home) 보여주기
			//session 영역에 alert 띄워줄 메세지담기
			HttpSession session = request.getSession();
			session.setAttribute("alertMsg", "성공적으로 회원가입");
			
			response.sendRedirect(request.getContextPath());
	
		}else {	// 회원가입 실패 
			
			request.setAttribute("errorMsg", "회원가입에 실패했습니다.");
			
			RequestDispatcher view = request.getRequestDispatcher("views/common/errorPage.jsp");
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
