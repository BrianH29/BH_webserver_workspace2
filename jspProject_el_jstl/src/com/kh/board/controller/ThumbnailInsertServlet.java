package com.kh.board.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class ThumbnailInsertServlet
 */
@WebServlet("/insert.th")
public class ThumbnailInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThumbnailInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		
		if(ServletFileUpload.isMultipartContent(request)) {
			
			// 1_1. 용량제한
			int maxSize = 10 * 1024 * 1024; 
			
			//1-2. 저장할 폴던의 물리적인 경로
			String savePath = request.getSession().getServletContext().getRealPath("/resources/thumbnail_upfiles/");
			
			//2. 전달된 파일 서버에 업로드
			// HttpServletRequest -> MultipartRequest
			MultipartRequest multiRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyFileRenamePolicy());
			
			//3. DB에 전달할 값 뽑기
			
			// Board객체에 담을 작성자 번호, 제목, 내용 뽑아서 Board 객체에 담아놓기 
			String userNo = multiRequest.getParameter("userNo");
			String boardTitle = multiRequest.getParameter("title"); 
			String boardContent = multiRequest.getParameter("content");
			
			Board b = new Board();
			b.setBoardWriter(userNo);
			b.setBoardTitle(boardTitle);
			b.setBoardContent(boardContent); 
			
			//Attachment 테이블에 insert 할 원본명, 수정명, 폴더경로를 Attachment 객체에 담기
			//단, 여러개의 첨부파일이 있을 거기 때문에 Attachment들을 ArrayList에 담아내기
			
			ArrayList<Attachment> list = new ArrayList<>(); 
			
			for(int i=1; i<=4; i++) {	
				String key = "file" + i;
				if(multiRequest.getOriginalFileName("file" + i) != null) {
					//Attachment 객체 생성 + 원본명,수정명,폴더경로 담아서 
					//list 추가
					Attachment at = new Attachment(); 
					at.setOriginName(multiRequest.getOriginalFileName(key));
					at.setChangeName(multiRequest.getFilesystemName(key));
					at.setFilePath("resources/thumbnail_upfiles/");
					
					//System.out.println(multiRequest.getFilesystemName(key));
					if(i == 1) {//대표이미지일 경우
						at.setFileLevel(1);
					}else {//그게 아닐경우 
						at.setFileLevel(2); 
					}
					
					list.add(at); 
				}
				
			}//e.for문
			int result = new BoardService().insertThumbnailBoard(b, list);
		
			if(result > 0) {//성공
				request.getSession().setAttribute("alertMsg", "사진게시판 등록 성공!!");
				response.sendRedirect(request.getContextPath() + "/list.th");
				
			}else {//실패
				//서버에 업로드된 파일 삭제
				for(int i=0; i<list.size(); i++) {
					//삭제할 파일 찾아서 File객체 생성
					File failedFile = new File(savePath + list.get(i).getChangeName()); 
					//delete()실행
					failedFile.delete(); 
				}
				request.setAttribute("errorMsg", "사진 게시판 등록 실패!");
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
