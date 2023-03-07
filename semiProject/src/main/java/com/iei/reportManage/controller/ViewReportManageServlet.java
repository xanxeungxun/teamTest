package com.iei.reportManage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.reportManage.model.service.ReportManageService;
import com.iei.reportManage.model.vo.ReportManageVo;


// 신고 상세 조회
@WebServlet(name = "viewReportManage", urlPatterns = { "/reportManage/viewReportManage.do" })
public class ViewReportManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewReportManageServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ReportManageService service = new ReportManageService();
		
		String reportManageNo = request.getParameter("reportManageNo");
		
		ReportManageVo result = service.selectOneReportManage(reportManageNo);
		
		request.setAttribute("reportManageResult", result);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/reportManage/viewReportManage.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
