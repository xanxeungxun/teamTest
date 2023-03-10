package com.iei.reportList.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.iei.report.model.vo.ReportVo;

import common.JDBCTemplate;

public class ReportListDao {

	public int insertReport(Connection conn, ReportVo r) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into report values(report_seq.nextval,?,?,?,?,to_char(sysdate,'yyyy-mm-dd'),?,?,?,?,?,?)";
		
		System.out.println("ReportListDao 접근");
		System.out.println("QUERY : " + query);
		System.out.println("PARAMS : " + r.toString());
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r.getReporterId());
			pstmt.setString(2, r.getReportTitle());
			pstmt.setString(3, r.getReportContent());
			pstmt.setInt(4, r.getReportType());
			pstmt.setString(5, r.getBobType());
			pstmt.setInt(6, r.getBobNo());
			pstmt.setString(7, r.getBobTitle());
			pstmt.setString(8, r.getFileName());
			pstmt.setString(9, r.getFilePatch());
			pstmt.setInt(10, r.getReportYn());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


}
