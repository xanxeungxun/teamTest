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
import com.iei.question.model.vo.QuestionPageData;
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
		//1인코딩
		request.setCharacterEncoding("utf-8");
		//2값추출
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		//3비즈니스 로직
		QuestionService service = new QuestionService();
		QuestionPageData qpd = service.selectAllQuestionList(reqPage);
		//4 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/question/questionList.jsp");
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
