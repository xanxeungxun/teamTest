package com.iei.user.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.cal.model.vo.CalCheck;
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


	


	public int updateUserCheckPoint(String userId, int userPoint, int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.selectCheck(conn, userNo);
		if(result == 0) {			
			result = dao.updateUserCheckPoint(conn, userId, userPoint);
			if(result > 0) {
				result = dao.insertCalCheck(conn, userNo);
				if(result > 0) {
					JDBCTemplate.commit(conn);
				}else {
					JDBCTemplate.rollback(conn);
				}
			}else {
				JDBCTemplate.rollback(conn);
			}
		}else {
			JDBCTemplate.close(conn);
			return -1;
		}
		JDBCTemplate.close(conn);

		return result;
	}


	public int updateAssistPoint(String loginUser, String bookWriter, int inputPoint, int userNo, int bookNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateLoginUserPoint(conn, loginUser, inputPoint);
		if(result > 0) {
			result = dao.updateWriterPoint(conn, bookWriter, inputPoint);
			if(result > 0) {
				JDBCTemplate.commit(conn);
				result = dao.insertSupportBook(conn, inputPoint, userNo, bookNo, bookWriter);
				if(result > 0) {
					JDBCTemplate.commit(conn);
				}else {
					JDBCTemplate.rollback(conn);
				}
			}else {
				JDBCTemplate.rollback(conn);
			}
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}


	public int updateUserPoint(int updatePrice, int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.updateUserPoint(conn, updatePrice, userNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}


	public User selectOneUser(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		User user = dao.selectOneUser(conn, userId);
		
		JDBCTemplate.close(conn);
		
		return user;
	}


	public String selectEmail(String inputEmail) {
		Connection conn = JDBCTemplate.getConnection();
		
		String sameEmail = dao.selectEmail(conn, inputEmail);
		
		JDBCTemplate.close(conn);
		
		return sameEmail;
	}







	


}
