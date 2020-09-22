package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;


public class MemberService {
	
	/**
	 * 1.로그인용 서비스
	 * @param userId	사용자입력 아이디
	 * @param userPwd	사용자입력 비밀
	 * @return 해당 아이디와 비밀번호가 일치하는 조회된 회원 객체 / null
	 */
	public Member loginMember(String userId, String userPwd) {
		
		Connection conn = /*JDBCTemplate.*/getConnection(); 
		
		Member loginMember = new MemberDao().loginMember(conn, userId, userPwd);
		
		close(conn);
		
		return loginMember;
		
	}//e.loginMember
	/**
	 * 2.회원 가입용 서비스 
	 * @param m		사용자가 입력한(아이디,비밀번호,이름,전화번호,이메일,주소,취미)
	 * @return		처리된 행 수 
	 */
	public int insertMember(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().insertMember(conn, m); 
		
		//트랜잭션 처리 
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result; 
		
	}//e.insertMember
	
	/**
	 * 3.회원 정보변경용 서비스
	 * @param m	사용자가 입력한 (이름,전번,이메일,주소,취미)
	 * @return	갱신된 회원객체  
	 */
	public Member updateMember(Member m) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updateMember(conn,m);
		
		Member updateMem = null; 
		if(result > 0) {	//update 성공
			commit(conn);
			
			// 갱신된 회원 다시 조회해오기 --> 하지 않으면 이전에 있던 회원만 유지 (비즈니스 로직 하나의 로직에 하나 더 추가 select 문)
			updateMem = new MemberDao().selectMember(conn, m.getUserId());
			
			
		} else {			//update 실패
			rollback(conn);
		}
		
		close(conn);
		
		return updateMem; // 갱신된 회원객체 / null 
	}//e.updateMember
	
	/**
	 * 4. 비민번호 변경용 서비스 
	 * @param userId	변경요청한 사용자아이디
	 * @param userPwd	현재비밀번호
	 * @param updatePwd	변경할 비밀번호	
	 * @return			갱신된 회원객체
	 */
	
	public Member updatePwdMember(String userId, String userPwd, String updatePwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().updatePwdMember(conn, userId, userPwd, updatePwd);
		
		Member updateMem = null; 
		if(result>0) {
			commit(conn);
			
			updateMem = new MemberDao().selectMember(conn, userId); 
			
		} else {
			rollback(conn); 
		}
		
		close(conn); 
		
		return updateMem; 
	}//e.updatePwdMember
	
	/**
	 * 5.회원탈퇴용 서비스
	 * @param userId	탈퇴요청하는 아이디
	 * @param userPwd
	 * @return
	 */
	public int deleteMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		int result = new MemberDao().deleteMember(conn, userId, userPwd);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		
		return result; 
		
	}//e.delteMember
	
	/**
	 * 6. 아이디 중복확인용 서비스
	 * @param checkId	중복확인하고자 하는 아이디
	 * @return			해당 아이디와 일치하는 갯수 
	 */
	public int idCheck(String checkId) {
		Connection conn = getConnection(); 
		
		int count = new MemberDao().idCheck(conn, checkId);
		
		close(conn);
		
		return count; 
	}
}





