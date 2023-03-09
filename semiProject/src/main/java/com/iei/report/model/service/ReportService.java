package com.iei.report.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.report.model.dao.ReportDao;
import com.iei.report.model.vo.ReportPageData;
import com.iei.report.model.vo.ReportVo;

import common.JDBCTemplate;

public class ReportService {
	private ReportDao dao;

	public ReportService() {
		super();
		dao = new ReportDao();
	}
	
	
	// 신고 전체 목록 확인
	public ReportPageData selectAllReportList(int reqPage){
		
		Connection conn = JDBCTemplate.getConnection();
		
		int numPerPage = 10;
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		
		ArrayList<ReportVo> list = dao.selectAllReportList(conn,start,end);
		int totalCount = dao.selectReportCount(conn);
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
			pageNavi += "<a class='page-item' href='/reportList.do?reqPage="+(pageNo-1)+"'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/report/reportList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/report/reportList.do?reqPage="+(pageNo)+"'>";
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
			pageNavi += "<a class='page-item' href='/report/reportList.do?reqPage="+(pageNo)+"'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		JDBCTemplate.close(conn);
		ReportPageData npd = new ReportPageData(list, pageNavi, start);
		return npd;
	}
	
	
	// 신고 목록 검색
	public ReportPageData selectSearchedReportList(int reqPage, ReportPageData paramVo){
		
		Connection conn = JDBCTemplate.getConnection();
		
		int numPerPage = 10;
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		String searchValue = paramVo.getSearchValue();
		String searchType = paramVo.getSearchType();
		
		ArrayList<ReportVo> list = dao.selectSearchedReportList(conn,start,end, searchValue, searchType);
		int totalCount = dao.selectReportCount(conn);
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
			pageNavi += "<a class='page-item' href='/reportList.do?reqPage="+(pageNo-1)+"'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/report/reportList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/report/reportList.do?reqPage="+(pageNo)+"'>";
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
			pageNavi += "<a class='page-item' href='/report/reportList.do?reqPage="+(pageNo)+"'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		JDBCTemplate.close(conn);
		ReportPageData npd = new ReportPageData(list, pageNavi, start);
		return npd;
	}
	
	
	
	// 답변 등록, 수정
	public int updateReport(ReportVo paramVo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateAnswer(conn, paramVo);
		if(result >0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		
		return result;
	}


	// 신고 상세 보기
	public ReportVo selectOneReport(int reportNo) {
		Connection conn = JDBCTemplate.getConnection();
		ReportVo result = dao.selectOneReport(conn, reportNo);
		JDBCTemplate.close(conn);

		return result;
	}



}
