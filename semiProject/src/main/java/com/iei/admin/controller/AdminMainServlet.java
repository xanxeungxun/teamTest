package com.iei.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "AdminMain", urlPatterns = { "/adminMain.do" })
public class AdminMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminMainServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1인코딩
		request.setCharacterEncoding("utf-8");
		//2값 추출
		int userLevel = Integer.parseInt(request.getParameter("userLevel"));
		//3비즈니스로직
		//4결과처리
		if(userLevel == 1) {
		RequestDispatcher view
		= request.getRequestDispatcher("/WEB-INF/views/admin/admin.jsp");
		view.forward(request, response);
		}
		RequestDispatcher view
		= request.getRequestDispatcher("index.jsp");
		view.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
