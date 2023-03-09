package com.iei.report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.report.model.service.ReportService;
import com.iei.report.model.vo.ReportVo;


// 신고 상세 조회
@WebServlet(name = "viewReport", urlPatterns = { "/report/viewReport.do" })
public class ViewReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewReportServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ReportService service = new ReportService();
		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		ReportVo result = service.selectOneReport(reportNo);
		request.setAttribute("reportResult", result);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/report/viewReport.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
