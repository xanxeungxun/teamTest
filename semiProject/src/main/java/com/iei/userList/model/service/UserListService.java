package com.iei.userList.model.service;

import java.sql.Connection;

import com.iei.userList.model.dao.UserListDao;

public class UserListService {

	private UserListDao dao;

	public UserListService(UserListDao dao) {
		super();
		dao = new UserListDao();
	}
	
	

}
