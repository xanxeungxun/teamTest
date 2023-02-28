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
}
