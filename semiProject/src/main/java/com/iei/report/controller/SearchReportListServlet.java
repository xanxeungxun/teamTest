package com.iei.report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.report.model.service.ReportService;
import com.iei.report.model.vo.ReportPageData;


// 질문 목록 조회
@WebServlet(name = "SearchReportList", urlPatterns = { "/report/searchReportList.do" })
public class SearchReportListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SearchReportListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1인코딩
		request.setCharacterEncoding("utf-8");
		//2값추출
		int reqPage = 1;
		
		ReportPageData paramVo = new ReportPageData();

		String searchType = request.getParameter("searchType");
		paramVo.setSearchType(searchType);
		
		String searchValue = request.getParameter("searchValue");
		paramVo.setSearchValue(searchValue);
		
		System.out.println("VO : " + paramVo.toString());

		//3비즈니스 로직
		ReportService service = new ReportService();
//		ReportPageData qpd = service.selectAllReportList(reqPage);
		ReportPageData qpd = service.selectSearchedReportList(reqPage,paramVo);
		//4 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/report/reportList.jsp");
		request.setAttribute("list", qpd.getList());
		request.setAttribute("pageNavi", qpd.getPageNavi());
		request.setAttribute("start", qpd.getStart());
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
