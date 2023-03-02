package com.iei.question.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.question.model.service.QuestionService;
import com.iei.question.model.vo.QuestionVo;


// 문의 답변 보기 화면
@WebServlet(name = "EditAnswerView", urlPatterns = { "/question/editAnswerView.do" })
public class EditAnswerViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditAnswerViewServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		QuestionService service = new QuestionService();
		
		String questionNo = request.getParameter("questionNo");
		
		QuestionVo result = service.selectOneQuestion(questionNo);
		
		request.setAttribute("questionResult", result);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/question/editAnswerView.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
