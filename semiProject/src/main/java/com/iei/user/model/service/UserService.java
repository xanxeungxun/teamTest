package com.iei.user.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.mypage.vo.FavoriteBook;
import com.iei.user.model.dao.UserDao;
import com.iei.user.model.vo.User;


import common.JDBCTemplate;

public class UserService {
	
	private UserDao dao;

	public UserService() {
		super();
		dao = new UserDao();
	}

	
	public User selectOneUser(User u) {
		Connection conn = JDBCTemplate.getConnection();
		
		User user = dao.selectOneUser(conn, u);
		
		JDBCTemplate.close(conn);
		
		return user;
	}


	public String selectUserId(String inputEmail) {
		Connection conn = JDBCTemplate.getConnection();
		
		String searchId = dao.selectUserId(conn, inputEmail);
		
		JDBCTemplate.close(conn);
		
		return searchId;
	}


	public int inserUser(User u) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.insertUser(conn, u);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}


	public int updateUser(User u) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.updateUser(conn, u);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.close(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}


	public int deleteUser(String userId, String checkPw) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.deleteUser(conn, userId, checkPw);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.close(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}


	public String selectUserPw(String inputId, String inputEmail) {
		Connection conn = JDBCTemplate.getConnection();
		
		String searchPw = dao.selectUserPw(conn, inputId, inputEmail);
		
		JDBCTemplate.close(conn);
		
		return searchPw;
	}


	


	public int updateUserPoint(String userId, int userPoint) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.updateUserPoint(conn, userId, userPoint);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}


	public int updateAssistPoint(String loginUser, String bookWriter, int inputPoint, int userPoint) {
		Connection conn = JDBCTemplate.getConnection();
		int writerPoint = dao.selectWriterPoint(conn, bookWriter);
		int result = dao.updateLoginUserPoint(conn, loginUser, inputPoint, userPoint);
		if(result > 0) {
			int result2 = dao.updateWriterPoint(conn, bookWriter, inputPoint, writerPoint);
			if(result2 > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}







	


}
