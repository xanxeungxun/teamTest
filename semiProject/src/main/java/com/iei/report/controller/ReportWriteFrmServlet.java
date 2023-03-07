package com.iei.report.controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iei.user.model.vo.User;


@WebServlet(name = "ReportWriteFrm", urlPatterns = { "/report/reportWriteFrm.do" })
public class ReportWriteFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReportWriteFrmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1인코딩
		request.setCharacterEncoding("utf-8");
		//2값추출
		//3비즈니스 로직
		HttpSession session = request.getSession();  
		User loginUser = (User)session.getAttribute("loginUser");
		//4결과처리
		
		if(loginUser!=null&&loginUser.getUserLevel()==1) {
		RequestDispatcher view =
				request.getRequestDispatcher("/WEB-INF/views/report/reportWriteFrm.jsp");
		view.forward(request, response);
		}
		RequestDispatcher view =
				request.getRequestDispatcher("/");
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
