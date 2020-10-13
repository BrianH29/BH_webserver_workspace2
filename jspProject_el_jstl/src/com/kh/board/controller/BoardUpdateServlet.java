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
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/update.bo")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		// 우선 enctype이 multipart/form-data로 잘 전송되었을 때만 전반적인 내용이 수행되게끔
		if(ServletFileUpload.isMultipartContent(request)) {
			
			//1-1. 전송되는 파일 용량 제한(int maxSize) => 10mbyte
			int maxSize = 10 * 1024 * 1024; 
			
			//1-2. 전달된 파일을 저장시킬 서버의 폴더 물리적인 경로 알아내기(String savePath)
			String savePath = request.getSession().getServletContext().getRealPath("/resources/board_upfiles/");
			
			
			
			//HttpServletRequest request --> MultipartRequest multiRequest 
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			// 위의 이 코드한줄이 실행됨가 동시에 뭔가 문제가 있든 없든간에 무조건 전달된 파일이 폴도에 업로드 됨!!
			
			// 본격적으로 sql문 실행하기 위한 값 뽑기 
			// 공통적으로 수행 => Board테이블 Update 
			int bno = Integer.parseInt(multiRequest.getParameter("bno")); 
			String category = multiRequest.getParameter("category"); 
			String boardTitle = multiRequest.getParameter("title"); 
			String boardContent = multiRequest.getParameter("content"); 
			
			Board b  = new Board();
			b.setBoardNo(bno);
			b.setCategory(category);
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boardContent);
			
			//새로이 전달된 첨부파일과 관련된 값 뽑기
			Attachment at = null;
			
			if(multiRequest.getOriginalFileName("reUpfile") != null) {
				
				at = new Attachment();
				at.setOriginName(multiRequest.getOriginalFileName("reUpfile"));
				at.setChangeName(multiRequest.getFilesystemName("reUpfile"));
				at.setFilePath("resources/board_upfiles/");
				//위의 3개의 정보는 기존의 첨부파일이 있든 없든 간에 새로전달된 파일이 있었기 떄문에 무조건 기록할 값
				
				// 기존의 첨부파일이 있었을 경우  
				if(multiRequest.getParameter("originFileNo") != null) {
					// 새로운 첨부파일이있고, 기존의 파일이 있었을 경우
					// => Attachment Update
					// + 기존의 첨부파일 고유번호 
					
					at.setFileNo(Integer.parseInt(multiRequest.getParameter("originFileNo")));
					
					// 기존의 파일 삭제 
					File deleteFile = new File(savePath + multiRequest.getParameter("originFileName"));
					deleteFile.delete(); // 서버에 업로드 되어있던 기존 파일 삭제 
					
				} else {
					// 새로운 첨부파일이 들어왔지만, 기존의 파일이 없었을 경우 
					// => Attachment Insert 
					// + 게시글 번호 
					
					at.setRefBoardNo(bno);
				}
				
			}
			
			int result = new BoardService().updateBoard(b, at);
			
			//case1: 새로운 첨부파일 X  => updateBoard(b, null); => Board 테이블에만 Update
			//case2: 새로운 첨부파일 O  기존의 첨부파일 O => updateBoard(b, fileNo 담긴 at) => Board update, Attachment Update
			//case3: 새로운 첨부파일 O, 기존의 첨부파일 X => updateBoard(b, refBoardNo 담긴 at) => Board Update, Attachment Insert 
			
			if(result > 0){ // 성공 => 상세조회 재요청(detail.bo?bno=xx)
				
				request.getSession().setAttribute("alertMsg", "게시글 수정 성공했습니다");
				response.sendRedirect(request.getContextPath() + "/detail.bo?bno=" + bno);
				
			} else {
				
				request.setAttribute("errorMsg", "게시글 수정 실패");
				request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
			}
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
