package com.iei.question.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.question.model.dao.QuestionDao;
import com.iei.question.model.vo.QuestionVo;

import common.JDBCTemplate;

public class QuestionService {
	private QuestionDao dao;

	public QuestionService() {
		super();
		dao = new QuestionDao();
	}
	
	
	// 문의 전체 목록 확인
	public ArrayList<QuestionVo> selectAllQuestionList(){
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<QuestionVo> list = dao.selectAllQuestionList(conn);
		JDBCTemplate.close(conn);
		
		return list;
	}
	
	
	// 문의 상세 보기
	public QuestionVo selectOneQuestion(String questionNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		QuestionVo result = dao.selectOneQuestion(conn, questionNo);
		JDBCTemplate.close(conn);

		return result;
	}
	
	// 답변 등록, 수정
	public int updateQuestion(QuestionVo paramVo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateAnswer(conn, paramVo);
		if(result >0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		
		return result;
	}

}
