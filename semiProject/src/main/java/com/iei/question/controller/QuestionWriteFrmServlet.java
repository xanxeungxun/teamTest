package com.iei.question.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "QuestionWriteFrm", urlPatterns = { "/questionWriteFrm.do" })
public class QuestionWriteFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuestionWriteFrmServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1인코딩
		request.setCharacterEncoding("utf-8");
		//2값추출
		//3비즈니스 로직
		//4결과처리
		RequestDispatcher view =
				request.getRequestDispatcher("/WEB-INF/views/question/questionWriteFrm.jsp");
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
