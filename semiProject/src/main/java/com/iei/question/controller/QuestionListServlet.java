package com.iei.question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.question.model.service.QuestionService;
import com.iei.question.model.vo.QuestionVo;

// 질문 목록 조회
@WebServlet(name = "QuestionList", urlPatterns = { "/question/questionList.do" })
public class QuestionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QuestionListServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		QuestionService service = new QuestionService();
		ArrayList<QuestionVo> list = service.selectAllQuestionList();
		request.setAttribute("questionList", list);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/question/questionList.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
