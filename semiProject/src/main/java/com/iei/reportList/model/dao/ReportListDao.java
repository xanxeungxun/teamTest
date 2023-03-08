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
			
			private int reportNo; //신고번호
			private String reporterId; //신고자
			private String reportTitle; //신고제목
			private String reportContent;  //신고내용
			private int reportType;  //신고 종류
			private String reportDate; //신고 일자
			private String bookNo;  // 신고 게시물 (소설게시판) - (게시물신고)
			private String boardNo; // 신고 게시물 (자유게시판) - (게시물신고)
			private String fileName; //보여질 파일 이름
			private String filePatch; //저장될 파일 이름
			
			
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
