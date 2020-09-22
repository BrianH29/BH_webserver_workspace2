package com.kh.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.kh.model.vo.User;

/**
 * Servlet implementation class JqAjaxServlet3
 */
@WebServlet("/jqAjax3.do")
public class JqAjaxServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		//원래는 서비스 요청으로 조회된 User객체 받아야됨
		//User findUser = new UserService().selectUser(userNo); 
		
		// 조회된 데이터가 다음과 같다는 가정하에
		User findUser = new User(1, "박철수", 30, '남');
		
		/*
		response.setCharacterEncoding("utf-8");
		response.getWriter().print(findUser); // 객체 바로 출력시 해당 객체의 .toString()한 문자열 출력
		*/
		
		//자바 vo 객체 --> 자바스크립트 상의 객체표기법{속성:속성값, 속성:속성값, ...}
		/*
		 * * JSON (JavaScript Object Notation) : 자바스크립트 객체 표기법
		 * - ajax 통신시 데이터 전송에 사용되는 포멧 형식 중 하나
		 * 
		 * {
		 * 	속성:속성값,
		 * 	속성:속성값,
		 * 	...
		 * }
		 * 	key:value
		 * -key:문자열, value=기본자료형, 문자열, 배열, 객체 (char 값안됨 => 통신에러 유발)
		 * 
		 * *JSON 관련 쓰고자 한다면 라이브러리 필요
		 * https://code.google.com/archive/p/json-simple/downloads
		 */
		
		JSONObject jsonUser = new JSONObject(); // {}
		jsonUser.put("userNo",findUser.getUserNo());//{userNo:1}
		jsonUser.put("userName",findUser.getUserName());//{userNo:1, userName:"박철수"}
		jsonUser.put("age", findUser.getAge()); //{userNo:1, userName:"박철수", age:30}
		jsonUser.put("age", findUser.getGender()+""); //{userNo:1, userName:"박철수", age:30, gender:"남"}
		// char 오류 생김 그래서 문자열로 바꿔야 함 --> 간단한 방법< + ""> 
		
		//응답데이터로 json객체 전송시 내가 응답할 데이터 json타입으로 문자셋은 utf-8이야 지정! 
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonUser);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
