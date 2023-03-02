package com.iei.question.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.question.model.vo.QuestionVo;

import common.JDBCTemplate;

public class QuestionDao {
	
	
	// 전체 목록 조회
	public ArrayList<QuestionVo> selectAllQuestionList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<QuestionVo> list = new ArrayList<QuestionVo>();
		String query = "SELECT * FROM QUESTION ORDER BY QUESTION_NO DESC";
		
		System.out.println("========= EXECUTED QUERY =========");
		System.out.println(query);
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			System.out.println("========= OUTPUT VALUES =========");
			while(rset.next()) {
				QuestionVo n = new QuestionVo();
				n.setQuestionNo(rset.getInt("QUESTION_NO"));
				n.setQuestionUserId(rset.getString("QUESTION_USER_ID"));
				n.setQuestionName(rset.getString("QUESTION_USER_ID"));
				n.setQuestionTitle(rset.getString("QUESTION_TITLE"));
				n.setQuestionType(rset.getString("QUESTION_TYPE"));
				n.setQuestionContent(rset.getString("QUESTION_CONTENT"));
				n.setEnrollDate(rset.getString("ENROLL_DATE"));
				n.setAnswerYn(rset.getString("ANSWER_YN"));
				n.setAnswerUserName(rset.getString("ANSWER_USER_NAME"));
				n.setAnswerUserId(rset.getString("ANSWER_USER_ID"));
				n.setAnswerTitle(rset.getString("ANSWER_TITLE"));
				n.setAnswerContent(rset.getString("ANSWER_CONTENT"));
				n.setAnswerDate(rset.getString("ANSWER_DATE"));
				list.add(n);
				System.out.println(n.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}
	
	
	// 문의 상세 조회
	public QuestionVo selectOneQuestion(Connection conn, String questionNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		QuestionVo result = new QuestionVo();
		String query = "SELECT * FROM QUESTION WHERE QUESTION_NO = ?";
		
		
		System.out.println("========= EXECUTED QUERY =========");
		System.out.println("questionNo : " + questionNo);
		System.out.println(query);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(questionNo));
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				result.setQuestionNo(rset.getInt("QUESTION_NO"));
				result.setQuestionUserId(rset.getString("QUESTION_USER_ID"));
				result.setQuestionName(rset.getString("QUESTION_USER_ID"));
				result.setQuestionTitle(rset.getString("QUESTION_TITLE"));
				result.setQuestionType(rset.getString("QUESTION_TYPE"));
				result.setQuestionContent(rset.getString("QUESTION_CONTENT"));
				result.setEnrollDate(rset.getString("ENROLL_DATE"));
				result.setAnswerYn(rset.getString("ANSWER_YN"));
				result.setAnswerUserName(rset.getString("ANSWER_USER_NAME"));
				result.setAnswerUserId(rset.getString("ANSWER_USER_ID"));
				result.setAnswerTitle(rset.getString("ANSWER_TITLE"));
				result.setAnswerContent(rset.getString("ANSWER_CONTENT"));
				result.setAnswerDate(rset.getString("ANSWER_DATE"));
				
				System.out.println("========= OUTPUT VALUES =========");
				System.out.println(result.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return result;
	}
	
	// 답변 수정 등록
	public int updateAnswer(Connection conn, QuestionVo paramVo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE QUESTION SET ANSWER_YN = ? , ANSWER_TITLE = ? , ANSWER_CONTENT = ? , ANSWER_USER_NAME = ? , ANSWER_USER_ID = ? , ANSWER_DATE = SYSDATE WHERE QUESTION_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "Y");
			pstmt.setString(2, paramVo.getAnswerTitle());
			pstmt.setString(3, paramVo.getAnswerContent());
			pstmt.setString(4, paramVo.getAnswerUserName());
			pstmt.setString(5, paramVo.getAnswerUserId());
			pstmt.setInt(6, paramVo.getQuestionNo());
			
			System.out.println(pstmt.toString());
			
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
