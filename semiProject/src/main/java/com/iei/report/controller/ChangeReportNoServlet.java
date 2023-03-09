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

@WebServlet(name = "ChangeReportNo", urlPatterns = { "/changeReportNo.do" })
public class ChangeReportNoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ChangeReportNoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("utf-8");
		// 값 추출
		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		
		// 비즈니스 로직
		ReportService service = new ReportService(); 
		int result = service.changeReportNo(reportNo);
		//4 결과 처리
		RequestDispatcher view =
				request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "신고 처리 완료");
			request.setAttribute("msg", "신고 처리를 완료하였습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/reportView.do?reportNo="+reportNo);
		}else {
			request.setAttribute("title", "신고 처리 실패");
			request.setAttribute("msg", "오류가 발생하였습니다.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/reportView.do?reportNo="+reportNo);
		}
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
