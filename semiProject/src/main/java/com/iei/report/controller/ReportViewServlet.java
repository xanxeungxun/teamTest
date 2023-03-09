package com.iei.report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iei.report.model.service.ReportService;
import com.iei.report.model.vo.ReportVo;
import com.iei.user.model.vo.User;
@WebServlet(name = "ReportView", urlPatterns = { "/reportView.do" })
public class ReportViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReportViewServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인코딩
		request.setCharacterEncoding("utf-8");
		// 값 추출
		int reportNo = Integer.parseInt(request.getParameter("reportNo"));
		
		ReportService service = new ReportService();
		// 비즈니스 로직
		ReportVo result = service.selectOneReport(reportNo);
		
		
		// 결과처리
		HttpSession session = request.getSession();  
		User loginUser = (User)session.getAttribute("loginUser");
		if (loginUser != null && loginUser.getUserLevel() == 2 || loginUser != null && loginUser.getUserLevel() == 1) {
			request.setAttribute("questionResult", result);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/question/viewQuestion.jsp");
			view.forward(request, response);
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "로그인이 필요한 서비스입니다");
			request.setAttribute("msg", "로그인 후 이용해주세요");
			request.setAttribute("icon", "warning");
			request.setAttribute("loc", "/loginFrm.do");
			view.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
