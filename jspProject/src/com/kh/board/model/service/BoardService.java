package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.PageInfo;
import com.kh.board.model.vo.Reply; 

public class BoardService {

	/**
	 * 1-1. 총 일반게시글 갯수 조회용 서비스
	 * @return	총갯수
	 */
	public int selectListCount() {
		Connection conn = getConnection(); 
		
		int listCount = new BoardDao().selectListCount(conn); 
		
		close(conn);
		
		return listCount; 
	}//e.selecListCount
	/**
	 * 1-2. 현재요청한 페이지에 보여저야할 리스트 조회용 서비스
	 * @param pi	현재요청한페이지, 게시글 최대갯수가 담겨있는 PageInfo 객체
	 * @return		조회된 결과가 담겨있는 list
	 */
	public ArrayList<Board> selectList(PageInfo pi){
		Connection conn = getConnection();
		
		ArrayList<Board> list = new BoardDao().selectList(conn, pi);
		
		close(conn);
		
		return list; 
		
	}//e.selectList
	/**
	 * 2.일반게시판 작성용 서비스
	 * @param b		게시글 제목, 내용, 카테고리번호, 작성자회원번호가 담겨있는 Board 객체
	 * @param at	첨부파일o => 원본명, 수정명, 폴더경로가 담겨있느느 Attachment 객체 / 첨부파일x => null
	 * @return
	 */
	public int insertBoard(Board b, Attachment at) {
		
		Connection conn = getConnection(); 
		
		int result1 = new BoardDao().insertBoard(conn, b); 
		
		int result2 = 1; // 만약에 첨부파일이 없을 경우를 위해 1로 설정. 
		if(at != null) {	// 첨부파일이 있었을 경우 
			result2 = new BoardDao().insertAttachment(conn, at);
		}
		
		if(result1 >0 && result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn); 
		
		return result1 * result2; 
	}//e.insertBoard
	
	/**
	 * 3-1. 일반게시판 조회 요청시 조회수 증가용 서비스
	 * @param bno	상세조회 요청한 해당 게시글 번호
	 * @return		
	 */
	public int increaseCount(int bno) {
		Connection conn = getConnection();
		
		int result = new BoardDao().increaseCount(conn, bno); 
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result; 
		
	}//e.increaseCount
	
	/**
	 * 3_2. 일반 게시판 상세정보 조회용 서비스 
	 * @param bno	상세조회요청한 게시글 번호
	 * @return		해당 게시글 정보가 담겨있는 Board 객체 
	 */
	public Board selectBoard(int bno) {
		Connection conn = getConnection(); 
		
		Board b = new BoardDao().selectBoard(conn, bno);
		
		close(conn);
		return b; 
		
	}//e.selectBoard
	
	/**
	 * 3_3. 해당 게시글 딸려있는 첨부파일 조회용 서비스
	 * @param bno	상세조회요청한 게시글 번호 
	 * @return
	 */
	public Attachment selectAttachment(int bno) {
		Connection conn = getConnection(); 
		
		Attachment at = new BoardDao().selectAttachment(conn,bno);
		
		close(conn);
		
		return at; 
	}//e.selectAttachment
	
	/**
	    * 4. 일반게시판 수정용 서비스
	    * @param b      수정된 내용들이 담겨있는 Board 객체
	    * @param at   null / 새로이 첨부된 파일의 내용들이 담겨있는 Attachment
	    * @return
	    */
	   public int updateBoard(Board b, Attachment at) {
	      
	      Connection conn = getConnection();
	      
	      int result1 = new BoardDao().updateBoard(conn, b);
	      
	      int result2 = 1; 
	      if(at != null) {	// 새로이 첨부된 파일이 있을 경우 
	    	  
	    	  
	    	  if(at.getFileNo() != 0) {// 기존의 첨부파일이 있었을 경우 => Attachment Update
	    		  
	    		  result2 = new BoardDao().updateAttachment(conn, at); 
	    	  }else {// 기존의 첨부파일이 없었을 경우 => Attachment Insert 
	    		  result2 = new BoardDao().insertNewAttachment(conn,at);
	    		  
	    	  }
	    	  
	    	  
	    	  
	      }
	      
	      if(result1>0 && result2>0) {
	    	  commit(conn);
	      }else {
	    	  rollback(conn); 
	      }
	    	  
	      close(conn); 
	      
	      return result1*result2; 
	   }
	   
	   public int insertThumbnailBoard(Board b, ArrayList<Attachment> list) {
		   Connection conn = getConnection(); 
		   
		   int result1 = new BoardDao().insertThBoard(conn, b);
		   int result2 = new BoardDao().insertAttachmentList(conn, list); 
		   
		   if(result1 > 0 && result2 > 0) {
			   commit(conn);
		   }else {
			   rollback(conn); 
		   }
		   close(conn); 
		   
		   return result1 * result2; 
		   
	   }//e.insertThumbnailBoard
	   
	   public ArrayList<Board> selectThumbnailList(){
		   Connection conn = getConnection(); 
		   
		   ArrayList<Board> list = new BoardDao().selectThumbnailList(conn); 
		   
		   close(conn);
		   
		   return list; 
	   }//e.selectThumbnailList

	   public ArrayList<Attachment> selectAttachmentList(int bno){
		   Connection conn = getConnection();
		   
		   ArrayList<Attachment> list = new BoardDao().selectAttachmentList(conn, bno); 
		   
		   close(conn);
		   
		   return list; 
	   }//e.selectAttachmentList
	   
	   public ArrayList<Reply> selectReplyList(int bno){
		   Connection conn = getConnection();
		   
		   ArrayList<Reply> list = new BoardDao().selectReplyList(conn, bno);
		   
		   close(conn);
		   
		   return list; 
	   }//e.selecReplyList
	   
	   public int insertReply(Reply r) {
		   Connection conn = getConnection();
		   
		   int result = new BoardDao().insertReply(conn, r);
		   
		   if(result>0) {
			   commit(conn);
		   }else {
			   rollback(conn);
		   }
		   close(conn);
		   
		   return result; 
	   }
	   
	}