package com.iei.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.iei.user.model.vo.User;

import common.JDBCTemplate;

public class UserDao {

	public User selectOneUser(Connection conn, User u) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		User user = null;
		
		String query = "select * from user_tbl where user_id=? and user_pw=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserPw());
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				user = new User();
				
				user.setUserEnroll(rset.getString("user_enroll"));
				user.setUserId(rset.getString("user_id"));
				user.setUserLevel(rset.getInt("user_level"));
				user.setUserName(rset.getString("user_name"));
				user.setUserNick(rset.getString("user_nick"));
				user.setUserNo(rset.getInt("user_no"));
				user.setUserPhone(rset.getString("user_phone"));
				user.setUserPic(rset.getString("user_pic"));
				user.setUserPoint(rset.getInt("user_point"));
				user.setUserPw(rset.getString("user_pw"));
				user.setUserEmail(rset.getString("user_email"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return user;
	}

	public String selectUserId(Connection conn, String inputEmail) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String searchId = null;
		
		String query = "select user_id from user_tbl where user_email=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputEmail);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				searchId = rset.getString("user_id");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return searchId;
	}

	public int insertUser(Connection conn, User u) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = "insert into user_tbl values(user_tbl_seq.nextval, ?, ?, ?, ?, ?, 2, null, 0, to_char(sysdate,'yyyy-mm-dd'), ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, u.getUserId());
			pstmt.setString(2, u.getUserPw());
			pstmt.setString(3, u.getUserName());
			pstmt.setString(4, u.getUserNick());
			pstmt.setString(5, u.getUserPhone());
			pstmt.setString(6, u.getUserEmail());
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public User selectOneUser(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		User u = null;
		
		String query = "select * from user_tbl where user_id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				u = new User();
				
				u.setUserEnroll(rset.getString("user_enroll"));
				u.setUserId(rset.getString("user_id"));
				u.setUserLevel(rset.getInt("user_level"));
				u.setUserName(rset.getString("user_name"));
				u.setUserNick(rset.getString("user_nick"));
				u.setUserNo(rset.getInt("user_no"));
				u.setUserPhone(rset.getString("user_phone"));
				u.setUserPic(rset.getString("user_pic"));
				u.setUserPoint(rset.getInt("user_point"));
				u.setUserPw(rset.getString("user_pw"));
				u.setUserEmail(rset.getString("user_email"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return u;
	}

	public int updateUser(Connection conn, User u) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		
		return 0;
	}

	public int deleteUser(Connection conn, String userId, String checkPw) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = "update user_tbl set user_level=4 where user_id=? and user_pw=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, checkPw);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public String selectUserPw(Connection conn, String inputId, String inputEmail) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String searchPw = null;
		
		String query = "select user_pw from user_tbl where user_id=? and user_email=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			pstmt.setString(2, inputEmail);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				searchPw = rset.getString("user_pw");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return searchPw;
	}
}
