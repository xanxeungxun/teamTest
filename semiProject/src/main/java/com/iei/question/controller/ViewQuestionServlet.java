package com.iei.question.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iei.question.model.service.QuestionService;
import com.iei.question.model.vo.QuestionVo;
import com.iei.user.model.vo.User;

// 질문 상세 조회
@WebServlet(name = "viewQuestion", urlPatterns = { "/question/viewQuestion.do" })
public class ViewQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewQuestionServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1인코딩
		request.setCharacterEncoding("utf-8");
		//2값추출
		
		QuestionService service = new QuestionService();
		
		String questionNo = request.getParameter("questionNo");
		//3비즈니스 로직
		QuestionVo result = service.selectOneQuestion(questionNo);
		//결과처리
		HttpSession session = request.getSession();  
		User loginUser = (User)session.getAttribute("loginUser");
		//4결과처리
		
		if(loginUser!=null&&loginUser.getUserLevel()==2) {
		request.setAttribute("questionResult", result);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/question/viewQuestion.jsp");
		view.forward(request, response);
		}
	
		RequestDispatcher view =
			request.getRequestDispatcher("/");
			view.forward(request, response);
		}
		
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
