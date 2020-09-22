package com.kh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.kh.model.vo.User;

/**
 * Servlet implementation class JqAjaxServlet4
 */
@WebServlet("/jqAjax4.do")
public class JqAjaxServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ArrayList<User> list = new UserService().selectList(); 
		
		// 조회된 데이터가 다음과 같다는 가정하에 
		ArrayList<User> list = new ArrayList<>();
		list.add(new User(1,"박철수", 30, '남'));
		list.add(new User(2,"홍길동", 23, '남'));
		list.add(new User(3,"김철순", 54, '여'));
		list.add(new User(4,"박순", 10, '여'));
		list.add(new User(5,"김희", 21, '남'));

		//System.out.println(list);
		
		//response.getWriter().print(list); // ArrayList의 toString한 문자열이 응답 
		
		JSONArray jArr = new JSONArray(); // []
		
		for(User u : list) {
			JSONObject jsonUser = new JSONObject(); 
			jsonUser.put("userNo",u.getUserNo()); // {userNo : 1}
			jsonUser.put("userName", u.getUserName());
			jsonUser.put("age", u.getAge());
			jsonUser.put("age", u.getGender()+""); 
			
			jArr.add(jsonUser); 
		}
		// jArr == [{}, {}, {}, {}, {}]
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(jArr);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
