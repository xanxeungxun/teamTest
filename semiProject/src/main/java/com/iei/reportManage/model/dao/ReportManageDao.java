package com.iei.reportManage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.reportManage.model.vo.ReportManageVo;

import common.JDBCTemplate;

public class ReportManageDao {
	
	
	// 전체 목록 조회
	public ArrayList<ReportManageVo> selectAllReportManageList(Connection conn,int start,int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ReportManageVo> list = new ArrayList<ReportManageVo>();
		String query = "select * from(select rownum as rnum, n.* from(select report_no,reporter_no,sus_no,report_content,report_file,report_style,report_date,story_comment_no,book_no,board_comment_no,board_no,file_name,file_patch from report order by 1 desc)n)where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ReportManageVo n = new ReportManageVo();
				n.setReportNo(rset.getInt("report_no"));
				n.setReporterNo(rset.getInt("reporter_no"));
				n.setSusNo(rset.getInt("sus_no"));
				n.setReportContent(rset.getString("report_content"));
				n.setReportFile(rset.getString("report_file"));
				n.setReportStyle(rset.getInt("report_file"));
				n.setReportDate(rset.getString("report_date"));
				n.setStoryCommentNo(rset.getInt("story_comment_no"));
				n.setBookNo(rset.getInt("book_no"));
				n.setBoardCommentNo(rset.getInt("board_comment_no"));
				n.setBoardNo(rset.getInt("board_no"));
				n.setFilename(rset.getString("file_name"));
				n.setFilepatch(rset.getString("filepatch"));
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
	
	
	// 문의 상세 조회
	public ReportManageVo selectOneReportManage(Connection conn, String reportManageNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ReportManageVo result = new ReportManageVo();
		String query = "SELECT * FROM QUESTION WHERE QUESTION_NO = ?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(questionNo));
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result.setQuestionNo(rset.getInt("QUESTION_NO"));
				result.setQuestionUserId(rset.getString("QUESTION_USER_ID"));
				result.setQuestionName(rset.getString("QUESTION_NAME"));
				result.setQuestionTitle(rset.getString("QUESTION_TITLE"));
				result.setQuestionType(rset.getInt("QUESTION_TYPE"));
				result.setQuestionContent(rset.getString("QUESTION_CONTENT"));
				result.setEnrollDate(rset.getString("ENROLL_DATE"));
				result.setAnswerYn(rset.getString("ANSWER_YN"));
				result.setAnswerUserName(rset.getString("ANSWER_USER_NAME"));
				result.setAnswerUserId(rset.getString("ANSWER_USER_ID"));
				result.setAnswerTitle(rset.getString("ANSWER_TITLE"));
				result.setAnswerContent(rset.getString("ANSWER_CONTENT"));
				result.setAnswerDate(rset.getString("ANSWER_DATE"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return result;
	}
	
	// 답변 수정 등록
	public int updateAnswer(Connection conn, ReportManageVo paramVo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE QUESTION SET ANSWER_YN = ? , ANSWER_TITLE = ? , ANSWER_CONTENT = ? , ANSWER_USER_NAME = ? , ANSWER_USER_ID = ? , ANSWER_DATE = SYSDATE WHERE QUESTION_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "y");
			pstmt.setString(2, paramVo.getAnswerTitle());
			pstmt.setString(3, paramVo.getAnswerContent());
			pstmt.setString(4, paramVo.getAnswerUserName());
			pstmt.setString(5, paramVo.getAnswerUserId());
			pstmt.setInt(6, paramVo.getQuestionNo());
			
			System.out.println(pstmt.toString());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	//신고 게시물 작성
	public int insertReportManage(Connection conn, ReportManageVo q) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into report values(report_seq.nextval,?,?,?,?,?,to_char(sysdate,'yy/mm/dd'),?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, q.getQuestionUserId());//1 신고인(int)
			pstmt.setString(2, q.getQuestionName());//2 피신고인(int)
			pstmt.setString(3, q.getQuestionTitle());//3 신고내용(Str)
			pstmt.setString(3, q.getQuestionTitle());//4 파일첨부(Str)
			pstmt.setInt(4, q.getQuestionType());//5 신고종류(int)
			pstmt.setString(5, q.getQuestionContent());//6 댓글번호(소설게시판)-(댓글신고용)-(int)
			pstmt.setString(6, "n");//7 신고게시물(소설게시판)-(게시물신고용)-(int)
			pstmt.setString(7, "n");//8 댓글번호(자유게시판)-(댓글신고용)-(int)
			pstmt.setString(8, "n");//9 신고게시물(자유게시판)-(게시물신고용)-(int)
			System.out.println(pstmt);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
// 게시물수가 몇개인지 세어주는 dao
	public int selectReportManageCount(Connection conn) {
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
