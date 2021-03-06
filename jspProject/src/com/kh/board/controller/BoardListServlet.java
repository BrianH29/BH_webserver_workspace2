package com.kh.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.PageInfo;

/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/list.bo")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// ----------------------페이징처리--------------------------
		int listCount; 		// 현재 총 게시글 갯수
		int currentPage;	// 현재 페이지 (즉, 요청한 페이지)
		int pageLimit; 		// 한 페이지 한단에  보여질 페이지 최대갯수
		int boardLimit; 	// 한 페이지내에 보여질 게시글 최대갯
		
		int maxPage; 		// 전체 페이지들 중에서의 가장 마지막 페이지 
		int startPage; 		// 현재 페이지에 하단에 보여질 페이징 바의 시작 수 
		int endPage;		// 현재 페이지에 하단에 보여질 페이징 바의 끝 수
		
		//*listCount : 총 게시글 갯수
		listCount = new BoardService().selectListCount(); 
		// * currentPage : 현재 페이지(요청한페이지)
		currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//* pageLimit : 한페이지 하단에 보여질 페이지 최대 갯수(페이지 목록을 몇개 단위)
		pageLimit = 10; 
		
		//*boardLimit : 한 페이지에 보여질 게시글 최대값
		boardLimit = 10;
		
		// * maxPage : 총 페이지 수 (마지막 페이지) 
		/*
		 * listCount, boardLimit에 영향을 받음
		 * 
		 * ex) boardLimit : 10 이라는 가정 하에 
		 * 
		 * 총 갯수		boardlimit			maxpage 
		 * 100.0 / 		10	=> 10.0		  10	
		 * 101.0 / 		10  => 10.1		  11 
		 * 105.0 /		10	=> 10.5		  11
		 * 109.0 /		10  => 10.9		  11
		 * 
		 * 총 게시글 갯수(실수) / boardLimit  => 올림처리 => maxPage 
		 * 
		 */
		maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		// * startPage : 현재 페이지에 보여질 페이징 바의 시작수
		/*
		 * pageLimit, currentPage 에 영향을 받음 
		 * 
		 * ex) pageLimit : 10
		 * 	   startPage : 1, 11, 21, 31, .... => n * 10 + 1
		 * 
		 * 	   pageLimit : 5
		 * 	   startPage : 1, 6, 11, 16, 21, ....
		 * 
		 * 	   current page = 1 		=> 1	=> 0 * 10 + 1 => n=0
		 * 	   current page = 5			=> 1	=> 0 * 10+	1 => n=0
		 * 
		 *     current page = 11		=> 11	=> 1 * 10+	1 => n=1
		 *     current page = 20		=> 11	=> 1 * 10+	1 => n=1
		 *     
		 *     current page = 1~10 => n=0
		 *     current page = 11~20 => n=1
		 *     current page = 21~30 => n=2
		 *     
		 *     0~9 / 10 => 0
		 *     10~19 / 10 => 1
		 *     
		 *     
		 *     => n == (currentPage - 1) / pageLimit
		 *     
		 *     startPage => n * 10 + 1 == (currentPage - 1) / pageLimit * 10 + 1
		 */
		startPage = (currentPage -1) / pageLimit * pageLimit + 1; 
		
		/*
		 * * endPage : 현재페이지 보여지는 페이징 바의 끝 수 
		 * 
		 * ex) pageLimit : 10이라는 가정하에
		 * 
		 *  startPage : 1   => endPage : 10 
		 *  startPage : 11   => endPage : 20
		 *  startPage : 21   => endPage : 30  
		 * 
		 */
		endPage = startPage + pageLimit - 1; 
		
		// 만약 maxPage가 고작 13까지 밖에 안된다면? endPage를 다시 13로 해줘야됨!
		if(maxPage < endPage) {
			endPage = maxPage; 
		}
		
		// 페이징 정보들을 하나의 공간에 담아서 보재자!
		PageInfo pi = new PageInfo(listCount, currentPage, pageLimit, boardLimit, maxPage, startPage, endPage);
		
		//2. 현재 요청한 페이지(currentPage)에 보여질 게시글 리스트 조회해오기 
		ArrayList<Board> list = new BoardService().selectList(pi); 
		
		request.setAttribute("pi", pi);
		request.setAttribute("list", list);
		
		RequestDispatcher view = request.getRequestDispatcher("views/board/boardListView.jsp");
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
