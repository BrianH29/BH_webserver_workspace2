package com.kh.board.model.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.PageInfo; 

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

	
}