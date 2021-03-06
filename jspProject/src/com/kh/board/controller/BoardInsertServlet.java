	package com.kh.board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.common.MyFileRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/insert.bo")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardInsertServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		/*
		 * String category = request.getParameter("category"); String boardTitle =
		 * request.getParameter("title"); String boardContent =
		 * request.getParameter("content");
		 */

		// 폼 전송을 일반 방식이 아닌 multipart/form-data로 전송하는 경우 request값을 뽑을 수 없음

		// 우선 enctype이 multipart/form-data로 잘 전송되었을 경우 전반적인 내용들이 수행되게끔 검사
		if (ServletFileUpload.isMultipartContent(request)) {

			// 파일업로드를 위한 외부 라이브러리 : cos.jar (com.oreily.servlet의 약자)
			// http://www.servlets.com

			// 1. 전송되는 파일을 처리할 작업 내용(전송되는 파일의 용량제한, 전달된 파일을 저장할 폴더 경로)
			// 1-1. 전송파일 용량 제한(int maxSize => byte단위) : 10Mbyte로 제한

			/*
			 * byte => kbyte => mbyte => gbyte => tbyte ...
			 * 
			 * 1kbyte == 1024byte 1mbyte == 1024kbyte == 1024*1024byte 1gbyte == 1024mbyte
			 * == 1024*1024*1024byte
			 */

			int maxSize = 10 * 1024 * 1024;

			// 1-2. 전달된 파일을 저장할 서버의 폴더 경로 알아내기(String savePath)
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			// System.out.println(savePath);

			/*
			 * 2. 전달된 파일명 수정 및 서버에 업로드 작업
			 * 
			 * > HttpServletRequest --> MultipartRequest 변환
			 * 
			 * MultipartRequest multiReqest = new MultipartRequest(request객체, 저장할폴더경로, 용량제한,
			 * 인코딩값, 파일명수정시켜주는객체);
			 * 
			 * 위 구문 즉, 위의 MultipartRequest 객체 생성과 동시에 넘어온 첨부파일들이 해당 폴더에 무조건 업로드됨!! => 즉, 문제가
			 * 있든 없든 간에 무조건 서버에 업로드 우선시키게 됨 => 그말이 즉슨, 혹시나 문제가 생겼을 경우 업로드된 파일을 찾아서 삭제 시켜야
			 * 메모리 관리에 좋음
			 * 
			 * 그리고 사용자가 올린 파일명 그래도 해당 폴더에 업로드하지 않는게 일반적임!! - 같은 파일명이 있을 경우 덮어씌워질 수도 있고,
			 * 한글/특수문자/띄어쓰기가 포함된 파일명일 경우 서버에 따라 문제가 발생될 수 있음
			 * 
			 * 기본적인 수정명 작업을 해주는 객체 => DefaultFileRenamePolicy 객체 (cos.jar에서 제공하는 객체) =>
			 * 내부적으로 rename() 메소드가 실행되면서 파일명 수정진행됨!! => 기본에 동일한 파일명이 있을 경우 뒤에 카운팅 된 숫자를 붙여줌
			 * ex) aaa.jpg, aaa1.jpg, aaa2.jpg, .....
			 * 
			 * 하지만 우리 입맛대로 절대 안겹치게끔 rename 해볼거임 (즉, DefaultFileRenmaePolicy 클래스 사용x ==> 나만의
			 * MyFileRenamePolicy 클래스만들어서 rename메소드 재정의할꺼임)
			 */
			// MultipartRequest multiRequest = new MultipartRequest(request, savePath,
			// maxSize, "UTF-8", new DefaultFileRenamePolicy());
			// --> 위의 코드가 실행되는 순간 서버에 파일 업로드됨

			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			/*
			 * 3. DB에 기록할 데이터를 뽑아서 vo에 주섬주섬담기
			 * 	  > 우선 글제목이나 내용, 작성자번호를 뽑아서 Board 테이블 Insert
			 * 	  > 넘어온 첨부파일이 있다면 첨부파일의 원본명, 수정명, 폴더 경로를 뽑아서 Attachment 테이블에 Insert
			 */
			// 3-1. Board 테이블에 Insert할 카테고리번호, 게시판 제목, 내용, 작성자회원번호를 Board객체 담기 
			String category = multiRequest.getParameter("category"); // "1"
			String boardTitle = multiRequest.getParameter("title"); 
			String boardContent = multiRequest.getParameter("content");
			String boardWriter = multiRequest.getParameter("userNo"); // "1"
			
			Board b = new Board();
			b.setCategory(category);
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boardContent);
			b.setBoardWriter(boardWriter);
			
			// 3-2. 첨부파일이 있다면 Attachment 테이블에 insert할 원본명, 수정명, 저장폴더경로를 Attachent 객체 담기
			Attachment at = null; // 처음엔 null초기화, 첨부파일이 있다면 그때 생성
			
			//System.out.println(multiRequest.getOriginalFileName("upfile"));
			//System.out.println(multiRequest.getFilesystemName("upfile"));
			
			if(multiRequest.getOriginalFileName("upfile")!= null) {//넘오온 펌부파일이 있을 경우
				String originName = multiRequest.getOriginalFileName("upfile"); // 원본명
				String changeName = multiRequest.getFilesystemName("upfile"); // 실제서버에 업로드된 이름(수정명)
				
				at = new Attachment();
				at.setOriginName(originName);
				at.setChangeName(changeName);
				at.setFilePath("resources/board_upfiles/");
				
			}//e.if
			
			// 4. 일반게시판 작성용 서비스 요청 (Board객체, Attachment 객체)
	         int result = new BoardService().insertBoard(b, at);
	         // case1 : 첨부파일이 있었을 경우    insertBoard(생성된 Board객체, 생성된 Attachment 객체)
	         // case2 : 첨부파일이 없었을 경우    insertBoard(생성된 Board객체, null)
	         
	         if(result > 0) { // 성공 => list.bo?currentPage=1      url 재요청
	            
	            request.getSession().setAttribute("alertMsg", "게시글 등록 성공!");
	            response.sendRedirect(request.getContextPath() + "/list.bo?currentPage=1");
	            
	         }else { // 실패 => 첨부파일이 있었을 경우 업로드된 파일 찾아서 삭제시킨 후 => errorPage포워딩
	            request.setAttribute("errorMsg", "일반게시판 등록 실패!!");
	            request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
	            
	            if(at != null) {   // 넘어온 첨부파일이 있었을 경우
	               // 삭제할 파일객체 생성
	               File failedFile = new File(savePath + at.getChangeName());
	               failedFile.delete();
	            }
	         }
	      }
	   }
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
