package com.iei.question.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.question.model.dao.QuestionDao;
import com.iei.question.model.vo.QuestionPageData;
import com.iei.question.model.vo.QuestionVo;

import common.JDBCTemplate;

public class QuestionService {
	private QuestionDao dao;

	public QuestionService() {
		super();
		dao = new QuestionDao();
	}
	
	
	// 문의 전체 목록 확인
	public QuestionPageData selectAllQuestionList(int reqPage){
		
		Connection conn = JDBCTemplate.getConnection();
		
		int numPerPage = 10;
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		
		ArrayList<QuestionVo> list = dao.selectAllQuestionList(conn,start,end);
		int totalCount = dao.selectNoticeCount(conn);
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage + 1;
		}
		int pageNaviSize = 5;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize +1;
		String pageNavi = "<ul class='pagination circle-style'>";
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/questionList.do?reqPage="+(pageNo-1)+"'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/question/questionList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/question/questionList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		if(pageNo <= totalPage) {
			pageNavi += "<hr>";
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/question/questionList.do?reqPage="+(pageNo)+"'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		JDBCTemplate.close(conn);
		QuestionPageData npd = new QuestionPageData(list, pageNavi, start);
		return npd;
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

	// 문의 게시물 작성
	public int insertQuestion(QuestionVo q) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertQuestion(conn, q);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		
		return result;
	}



		// 문의 목록 검색
	public QuestionPageData selectSearchedQuestion(int reqPage, QuestionPageData paramVo) {
			
			Connection conn = JDBCTemplate.getConnection();
			
			int numPerPage = 10;
			int end = numPerPage*reqPage;
			int start = end - numPerPage + 1;
			String searchValue = paramVo.getSearchValue();
			String searchType = paramVo.getSearchType();
			System.out.println(searchType +" : "+searchValue);
			ArrayList<QuestionVo> list = dao.selectSearchedQuestion(conn,start,end, searchValue, searchType);
			int totalCount = dao.selectQuestionCount(conn);
			int totalPage = 0;
			if(totalCount%numPerPage == 0) {
				totalPage = totalCount/numPerPage;
			}else {
				totalPage = totalCount/numPerPage + 1;
			}
			int pageNaviSize = 5;
			int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize +1;
			String pageNavi = "<ul class='pagination circle-style'>";
			if(pageNo != 1) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/questionList.do?reqPage="+(pageNo-1)+"'>";
				pageNavi += "<span class='material-icons'>chevron_left</span>";
				pageNavi += "</a></li>";
			}
			for(int i=0;i<pageNaviSize;i++) {
				if(pageNo == reqPage) {
					pageNavi += "<li>";
					pageNavi += "<a class='page-item active-page' href='/question/questionList.do?reqPage="+(pageNo)+"'>";
					pageNavi += pageNo;
					pageNavi += "</a></li>";
				}else {
					pageNavi += "<li>";
					pageNavi += "<a class='page-item' href='/question/questionList.do?reqPage="+(pageNo)+"'>";
					pageNavi += pageNo;
					pageNavi += "</a></li>";
				}
				pageNo++;
				if(pageNo>totalPage) {
					break;
				}
			}
			if(pageNo <= totalPage) {
				pageNavi += "<hr>";
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/question/questionList.do?reqPage="+(pageNo)+"'>";
				pageNavi += "<span class='material-icons'>chevron_right</span>";
				pageNavi += "</a></li>";
			}
			pageNavi += "</ul>";
			JDBCTemplate.close(conn);
			QuestionPageData npd = new QuestionPageData(list, pageNavi, start);
			return npd;
		
	}



}
