package com.kh.notice.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.notice.model.dao.NoticeDao;
import com.kh.notice.model.vo.Notice;

public class NoticeService {
	
	
	/**
	 * 1.공지사항 전체조회용 서비스
	 * @return	조회된 전체 공지사항 리스트 
	 */
	public ArrayList<Notice> selectNoticeList() {
		Connection conn = getConnection();
		
		ArrayList<Notice> list = new NoticeDao().selectNoticeList(conn);
		
		close(conn); 
		
		return list; 
	}//e.selectNoticeList
	
	/**
	 * 2.공지사항 작성 서비스
	 * @param n 	작성자번호,제목,내용
	 * @return 		처리된 행수 
	 */
	public int insertNotice(Notice n) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().insertNotice(conn, n);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn); 
		}
		
		close(conn);
		
		return result;
		
	}//e.insertNotice
	
	/**
	 * 3_1. 조회수 증가 서비스 
	 * @param noticeNo	클릭한 공지사항 글 번호
	 * @return			처리된 행수 
	 */
	public int increaseCount(int noticeNo) {
		Connection conn = getConnection(); 
		
		int result = new NoticeDao().increaseCount(conn, noticeNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn); 
		}
		
		close(conn);
		
		return result; 
		
	}//e.increaseCount
	
	/**
	 * 4.공지사항 상세조회용 서비스
	 * @param noticeNo	클릭한 공지사항 번호
	 * @return			조회된 데이터가 담겨있는 Notice객체
	 */
	public Notice selectNotice(int noticeNo) {
		
		Connection conn = getConnection();
		
		Notice n = new NoticeDao().selectNotice(conn, noticeNo);
		
		close(conn);
		
		return n; 
	}//e.selectNotice
	
	/**
	 * 5.공지사항 수정용 서비스 
	 * @param n		수정할 제목, 수정할 내용, 수정하고자하는 글번호 담겨있는 Notice 객체
	 * @return		처리된 행수
	 */
	public int updateNotice(Notice n) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().updateNotice(conn,n);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result; 
	}//e.updateNotice
	
	public int deleteNotice(int noticeNo) {
		Connection conn = getConnection();
		
		int result = new NoticeDao().deleteNotice(conn, noticeNo);
		
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result; 
	}//e.deleteNotice
}
