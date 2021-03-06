package com.kh.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.notice.model.service.NoticeService;
import com.kh.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeInsertServlet
 */
@WebServlet("/insert.no")
public class NoticeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		//int userNo = Integer.parseInt(request.getParameter("userNo"));
		String userNo = request.getParameter("userNo"); // "1"
		String noticeTitle = request.getParameter("title");
		String noticeContent = request.getParameter("content");
		
		//매개변수 방식
		//Notice n = new Notice(userNo, noticeTitle, noticeContent)
		
		//setter method 방식
		Notice n = new Notice();
		n.setNoticeWriter(userNo);
		n.setNoticeTitle(noticeTitle);
		n.setNoticeContent(noticeContent);
		
		int result = new NoticeService().insertNotice(n); 
		
		if(result>0) {	// 성공==> 게시판 보여지게
			
			//forwarding  방식으로 응답시 => NullPointerException 발생
			//request.getRequestDispatcher("views/common/errorPage.jsp").forward(request,response);
			
			request.getSession().setAttribute("alertMsg", "성공적으로 등록되었습니다"); //menubar에 이미 기입 되어져있고 모든페이지에 메뉴바가 보이기 때문에
			
			//list.no 라는 url 재용청 방식
			response.sendRedirect(request.getContextPath()+ "/list.no");
			
		}else {	//실패 ==> errorPage
			
			request.setAttribute("errorMsg", "공지사항 등록 실패");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request,response);
			
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
