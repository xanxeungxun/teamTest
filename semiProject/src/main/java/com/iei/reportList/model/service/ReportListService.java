package com.iei.reportList.model.service;

import java.sql.Connection;

import com.iei.report.model.vo.ReportVo;
import com.iei.reportList.model.dao.ReportListDao;

import common.JDBCTemplate;

public class ReportListService {
	private ReportListDao dao;

	public ReportListService() {
		super();
		dao = new ReportListDao();
	}

	public int insertReport(ReportVo r) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertReport(conn, r);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	
	
	
	
	

}
