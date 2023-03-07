package com.iei.cal.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.cal.model.dao.CalDao;
import com.iei.cal.model.vo.Cal;

import common.JDBCTemplate;

public class CalService {
	private CalDao dao;

	public CalService() {
		super();
		dao = new CalDao();
	}

	public ArrayList<Cal> selectAllCalCheck() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Cal> list = dao.selectAllCalCheck(conn);
		JDBCTemplate.close(conn);
		return list;
	}
}
