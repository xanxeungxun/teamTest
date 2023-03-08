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
		String query = "insert into report values(report_seq.nextval,?,?,?,0,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardWriter());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setString(4, b.getFileName());
			pstmt.setString(5, b.getFilePath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


}
