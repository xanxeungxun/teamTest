package com.iei.user.model.service;

import java.sql.Connection;

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


}
