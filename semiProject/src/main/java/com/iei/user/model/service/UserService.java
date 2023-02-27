package com.iei.user.model.service;

import com.iei.user.model.dao.UserDao;

public class UserService {
	
	private UserDao dao;

	public UserService() {
		super();
		dao = new UserDao();
	}

}
