package com.iei.cal.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.cal.model.dao.CalDao;
import com.iei.cal.model.vo.Cal;
import com.iei.cal.model.vo.CalCheck;

import common.JDBCTemplate;

public class CalService {
	private CalDao dao;

	public CalService() {
		super();
		dao = new CalDao();
	}

	public ArrayList<CalCheck> selectAllCalCheck(int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<CalCheck> list = dao.selectAllCalCheck(conn, userNo);
		JDBCTemplate.close(conn);
		return list;
	}
}
