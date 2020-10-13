package com.kh.member.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.kh.common.JDBCTemplate;
import com.kh.member.model.vo.Member;

public class MemberDao {

	private Properties prop = new Properties();	//  private-전역변수로 설정
		
		
		public MemberDao() {
			
//			String fileName = MemberDao.class.getResource("/sql/member/member-mapper.properties").getPath(); 
			String fileName = MemberDao.class.getResource("/sql/member/member-mapper.xml").getPath();
			try {
//				prop.load(new FileInputStream(fileName));
				prop.loadFromXML(new FileInputStream(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//e.MemberDao
		
		public Member loginMember(Connection conn, String userId, String userPwd) {
			//select문 => 한 행 => Member
			
			//필요한 변수들 셋팅
			Member m = null; 
			
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			
			String sql = prop.getProperty("loginMember");	// 미완성된 sql
			
			try {
				pstmt = conn.prepareStatement(sql);	// 미완성sql => 완성형태로 만들고 => 실행(execute)
				
				pstmt.setString(1, userId);
				pstmt.setString(2, userPwd);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					m = new Member(rset.getInt("USER_NO"),
								   rset.getString("USER_ID"),
								   rset.getString("user_pwd"),
								   rset.getString("USER_NAME"),
								   rset.getString("phone"),
								   rset.getString("email"),
								   rset.getString("address"),
								   rset.getString("interest"),
								   rset.getDate("enroll_date"),
								   rset.getDate("modify_date"),
								   rset.getString("status"));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return m; 
		}//e.loginMember
		
		public int insertMember(Connection conn, Member m) {
			// insert문 -> 처리된 행 수 
			int result = 0; 
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("insertMember");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, m.getUserId());
				pstmt.setString(2, m.getUserPwd());
				pstmt.setString(3, m.getUserName());
				pstmt.setString(4, m.getPhone());
				pstmt.setString(5, m.getEmail());
				pstmt.setString(6, m.getAddress());
				pstmt.setString(7, m.getInterest());
				
				result = pstmt.executeUpdate(); 
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result; 
			
		}//e.insertMember
		
		public int updateMember(Connection conn, Member m) {
			int result = 0;
			
			PreparedStatement pstmt = null;

			String sql = prop.getProperty("updateMember"); 
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, m.getUserName());
				pstmt.setString(2, m.getPhone());
				pstmt.setString(3, m.getEmail());
				pstmt.setString(4, m.getAddress());
				pstmt.setString(5, m.getInterest());
				pstmt.setString(6, m.getUserId());
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result; 
			
			
		}//e.updateMember
		
		public Member selectMember(Connection conn, String userId) {
			// select문 --> 한행 --> Member
			
			Member m = null;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null; 
			
			String sql = prop.getProperty("selectMember");
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, userId);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					m = new Member(rset.getInt("USER_NO"),
								   rset.getString("USER_ID"),
								   rset.getString("user_pwd"),
								   rset.getString("USER_NAME"),
								   rset.getString("phone"),
								   rset.getString("email"),
								   rset.getString("address"),
								   rset.getString("interest"),
								   rset.getDate("enroll_date"),
								   rset.getDate("modify_date"),
								   rset.getString("status"));
				}
								
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return m; 
			
		}//e.selectMember
		
		public int updatePwdMember(Connection conn, String userId, String userPwd, String updatePwd) {
			int result = 0;
			
			PreparedStatement pstmt = null;
			
			String sql = prop.getProperty("updatePwdMember");
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, updatePwd);
				pstmt.setString(2, userId);
				pstmt.setString(3, userPwd);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result; 
			
		}//e.updatePwdMember
	
		public int deleteMember(Connection conn, String userId, String userPwd) {
			int result = 0; 
			
			PreparedStatement pstmt = null; 
			
			String sql = prop.getProperty("deleteMember");
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, userId);
				pstmt.setString(2, userPwd);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(pstmt);
			}
			return result; 
			
		}//e.deleteMember
		
		public int idCheck(Connection conn, String checkId) {
			int count = 0;
			
			PreparedStatement pstmt = null;
			ResultSet rset = null; 
			String sql = prop.getProperty("idCheck");
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, checkId);
				
				rset = pstmt.executeQuery();
				
				if(rset.next()) {
					count = rset.getInt(1); //첫번쨰에 해당하는 값 SQL문 COUNT(*) 혹은 별칭을 부여해서 넣어도 됨. 
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rset);
				JDBCTemplate.close(pstmt);
			}
			return count; 
			
		}
}
