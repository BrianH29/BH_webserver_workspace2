package com.kh.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.model.vo.User;

/**
 * Servlet implementation class JqAjaxServlet5
 */
@WebServlet("/jqAjax5.do")
public class JqAjaxServlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JqAjaxServlet5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Arraylist<User> list = new UserService().selectList();
		
		ArrayList<User> list = new ArrayList<>();
		list.add(new User(1,"박철수", 30, '남'));
		list.add(new User(2,"홍길동", 23, '남'));
		list.add(new User(3,"김철순", 54, '여'));
		list.add(new User(4,"박순", 10, '여'));
		list.add(new User(5,"김희", 21, '남'));
		
		//GSON : Google JSON 을 의미함
		//GSON 라이버리 가져오기 : (GSON, GsonBuilder)
		response.setContentType("application/json; charset=utf-8");
		
		Gson gson = new Gson(); 
		
		gson.toJson(list,response.getWriter());
		// Gson 객체에서 제공하는 toJson 메소드 통해서 응답
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
