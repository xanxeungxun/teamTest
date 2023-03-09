package com.iei.report.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.report.model.vo.ReportVo;

import common.JDBCTemplate;

public class ReportDao {
	
	
	// 전체 목록 조회
	public ArrayList<ReportVo> selectAllReportList(Connection conn,int start,int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReportVo> list = new ArrayList<ReportVo>();
		String query = "select * from(select rownum as rnum, n.* from(select report_no,reporter_id,report_title,report_content,report_type,report_date,BOOK_OR_BOARD_TYPE,BOOK_OR_BOARD_NO,BOOK_OR_BOARD_TITLE,file_name,file_patch from report order by 1 desc)n)where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ReportVo n = new ReportVo();
				n.setReportNo(rset.getInt("report_no"));
				n.setReporterId(rset.getString("reporter_id"));
				n.setReportTitle(rset.getString("report_title"));
				n.setReportContent(rset.getString("report_content"));
				n.setReportType(rset.getInt("report_type"));
				n.setReportDate(rset.getString("report_date"));
				n.setBobType(rset.getString("BOOK_OR_BOARD_TYPE"));
				n.setBobNo(rset.getInt("BOOK_OR_BOARD_NO"));
				n.setBobTitle(rset.getString("BOOK_OR_BOARD_TITLE"));
				n.setFileName(rset.getString("file_name"));
				n.setFilePatch(rset.getString("file_patch"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}
	
	// 검색 목록 조회
	public ArrayList<ReportVo> selectSearchedReportList(Connection conn,int start,int end, String searchValue, String searchType) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String type = "";
		if("1".equals(searchType)) type = "reporter_id";
		else if("2".equals(searchType)) type = "report_title";
		
		ArrayList<ReportVo> list = new ArrayList<ReportVo>();
		String query = "select * from(select rownum as rnum, n.* from(select report_no,reporter_id,report_title,report_content,report_type,report_date,BOOK_OR_BOARD_TYPE,BOOK_OR_BOARD_NO,BOOK_OR_BOARD_TITLE,file_name,file_patch from report"
				+ " where " + type + " = " + "\'" + searchValue + "\'" +  " order by 1 desc)n)where rnum between ? and ?";
		
		System.out.println("QUERY : " + query);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ReportVo n = new ReportVo();
				n.setReportNo(rset.getInt("report_no"));
				n.setReporterId(rset.getString("reporter_id"));
				n.setReportTitle(rset.getString("report_title"));
				n.setReportContent(rset.getString("report_content"));
				n.setReportType(rset.getInt("report_type"));
				n.setReportDate(rset.getString("report_date"));
				n.setBobType(rset.getString("BOOK_OR_BOARD_TYPE"));
				n.setBobNo(rset.getInt("BOOK_OR_BOARD_NO"));
				n.setBobTitle(rset.getString("BOOK_OR_BOARD_TITLE"));
				n.setFileName(rset.getString("file_name"));
				n.setFilePatch(rset.getString("file_patch"));
				list.add(n);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}
	
	
	// 신고 상세 조회
	public ReportVo selectOneReport(Connection conn, int reportNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ReportVo result = new ReportVo();
		String query = "SELECT * FROM REPORT WHERE REPORT_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reportNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result.setReportNo(rset.getInt("report_no"));
				result.setReporterId(rset.getString("report_id"));
				result.setReportTitle(rset.getString("report_title"));
				result.setReportContent(rset.getString("report_content"));
				result.setReportType(rset.getInt("report_type"));
				result.setReportDate(rset.getString("report_date"));
				result.setBobType(rset.getString("book_of_board_type"));
				result.setBobNo(rset.getInt("book_of_board_no"));
				result.setBobTitle(rset.getString("book_of_board_title"));
				result.setFileName(rset.getString("file_name"));
				result.setFilePatch(rset.getString("file_patch"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		System.out.println(result);
		return result;
	}
	
	

// 게시물수가 몇개인지 세어주는 dao
	public int selectReportCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from report";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt"); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalCount;
	}

}
