package com.iei.userManage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.userManage.model.vo.UserManageVo;

import common.JDBCTemplate;

public class UserManageDao {
	
	
	// 전체 목록 조회
	public ArrayList<UserManageVo> selectAllUserManageList(Connection conn,int start,int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<UserManageVo> list = new ArrayList<UserManageVo>();
		String query = "select * from(select rownum as rnum, n.* from(select user_no,user_id,user_name,user_nick,user_phone,user_level,user_enroll,user_email from user_tbl order by 1 desc)n)where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				UserManageVo n = new UserManageVo();
				n.setUserNo(rset.getInt("user_no"));
				n.setUserId(rset.getString("user_id"));
				n.setUserName(rset.getString("user_name"));
				n.setUserNick(rset.getString("user_nick"));
				n.setUserPhone(rset.getString("user_phone"));
				n.setUserLevel(rset.getInt("user_level"));
				n.setUserEnroll(rset.getString("user_enroll"));
				n.setUserEmail(rset.getString("user_email"));
				list.add(n);
				System.out.println(list.toString());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}
	
	
	// 문의 상세 조회
	public UserManageVo selectOneUserManage(Connection conn, String userManageNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		UserManageVo result = new UserManageVo();
		String query = "SELECT * FROM QUESTION WHERE QUESTION_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(userManageNo));
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
//				result.setQuestionNo(rset.getInt("QUESTION_NO"));
//				result.setQuestionUserId(rset.getString("QUESTION_USER_ID"));
//				result.setQuestionName(rset.getString("QUESTION_USER_ID"));
//				result.setQuestionTitle(rset.getString("QUESTION_TITLE"));
//				result.setQuestionType(rset.getString("QUESTION_TYPE"));
//				result.setQuestionContent(rset.getString("QUESTION_CONTENT"));
//				result.setEnrollDate(rset.getString("ENROLL_DATE"));
//				result.setAnswerYn(rset.getString("ANSWER_YN"));
//				result.setAnswerUserName(rset.getString("ANSWER_USER_NAME"));
//				result.setAnswerUserId(rset.getString("ANSWER_USER_ID"));
//				result.setAnswerTitle(rset.getString("ANSWER_TITLE"));
//				result.setAnswerContent(rset.getString("ANSWER_CONTENT"));
//				result.setAnswerDate(rset.getString("ANSWER_DATE"));
				
				System.out.println("========= OUTPUT VALUES =========");
				System.out.println(result.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return result;
	}
	

	public int selectUserManageCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from user_tbl";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt"); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalCount;
	}


	public int blockUser(Connection conn, String blockUser) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update user_tbl set user_level='3' where user_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, blockUser);
			result = pstmt.executeUpdate();
			System.out.println(blockUser);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}





	public int changeUserLevel(Connection conn, int no, int level) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update user_tbl set user_level=? where user_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, level);
			pstmt.setInt(2, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}


	

}
