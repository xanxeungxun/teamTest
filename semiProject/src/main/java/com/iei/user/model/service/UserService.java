package com.iei.user.model.service;

import java.sql.Connection;

import com.iei.user.model.dao.UserDao;

import common.JDBCTemplate;

public class UserService {
	
	private UserDao dao;

	public UserService() {
		super();
		dao = new UserDao();
	}

	public String selectUserId(String inputEmail) {
		Connection conn = JDBCTemplate.getConnection();
		
		String searchId = dao.selectUserId(conn, inputEmail);
		
		JDBCTemplate.close(conn);
		
		return searchId;
	}

}
