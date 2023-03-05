package com.iei.mypage.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.mypage.dao.MyPageDao;
import com.iei.mypage.vo.FavoriteBook;
import com.iei.user.model.vo.User;

import common.JDBCTemplate;

public class MyPageService {
	
	private MyPageDao dao;

	public MyPageService() {
		super();
		dao = new MyPageDao();
	}
	
	public ArrayList<FavoriteBook> selectFavList(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<FavoriteBook> favList = dao.selectFavList(conn, userNo);
		
		JDBCTemplate.close(conn);
		
		return favList;
	}
	
	public User selectOneUser(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		User u = dao.selectOneUser(conn, userId);
		
		JDBCTemplate.close(conn);
		
		return u;
	}

	public int deleteFavBook(int favBookNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.deleteFavBook(conn, favBookNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}



}
