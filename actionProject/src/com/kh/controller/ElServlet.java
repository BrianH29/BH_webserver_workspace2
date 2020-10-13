package com.kh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.model.vo.Person;

/**
 * Servlet implementation class ElServlet
 */
@WebServlet("/el.do")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ElServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 테이터들을 담을 수 있는 JSP내장 객체 종류
		 * 
		 * 1.application : 한 애플리케이션 당 단 1개 존재하는 객체
		 * 				    여기에 담으면 에플리케이션 전역에서 사용 가능(공유범위가 가장 큼) 
		 * 				  /jsp/servlet/java
		 * 				  ServletContext 타입
		 * 2.session : 한 브라우저당 1개씩 존재하는 객체 
		 * 			     여기에 담으면 jsp/servlet 단에서 사용 가능 (공유범위가 그 다음으로 큼)
		 *             HttpSession 타입
		 * 3.request : 사용자가 요청할때마다 생성되는 객체
		 *             여기에 담으면 해당 request객체를 포워딩 받는 응답페이지에서만 사용 가능 (공유범위가 다소 제한적) 
		 *             HttpServletRequest 타입
		 * 4.page : 현재 해당 그 페이지에서만 사용 가능 (공유범위가 가장 작음) 
		 * 
		 * 위의 객체들에 
		 * 데이터를 담을 떄는 .setAttribute("key", 담고자하는 value)
		 *       꺼낼 떄는 .getAttribute("key")
		 *       삭제할때는 .removeAttribute("key")
		 */
		
		// requestScope(영역)에 담기
		request.setAttribute("classRoom", "I강의장");
		request.setAttribute("student", new Person("홍길동",23,'남'));
		
		//sessionScope
		HttpSession session = request.getSession();
		session.setAttribute("academy", "KH정보교육원");
		session.setAttribute("teacher", new Person("황학천",20,'남'));
		
		// applicationScope
		ServletContext application = request.getServletContext();
		application.setAttribute("scope", "application");
		
		// requestScope와 sessionScope에 동일한 키값으로 담아보기
		request.setAttribute("scope", "request");
		session.setAttribute("scope", "session");
		
		// 응답페이지를 만드는 역할을 JSP에게 위임(제어권 넘김)할 떄 필요한 객체(클래스) : RequestDispatcher
		RequestDispatcher view = request.getRequestDispatcher("views/1_EL/01_el.jsp");
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
