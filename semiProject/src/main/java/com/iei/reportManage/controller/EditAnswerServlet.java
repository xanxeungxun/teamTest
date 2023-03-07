package com.iei.question.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.question.model.service.QuestionService;
import com.iei.question.model.vo.QuestionVo;

// 답변 등록 및 수정
@WebServlet(name = "EditAnswer", urlPatterns = { "/question/editAnswer.do" })
public class EditAnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EditAnswerServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		QuestionService service = new QuestionService();
		
		System.out.println(request.getParameter("questionNo") + " / " + request.getParameter("answerTitle") + request.getParameter("answerContent"));
		
		QuestionVo paramVo = new QuestionVo();
		
		// 답변 등록자 아이디, 이름은 나중에 로그인 기능 완성 되면 세션에서 가져올 것
		paramVo.setAnswerUserId(request.getParameter("answerUserId"));
		paramVo.setAnswerUserName(request.getParameter("answerUserName"));
		paramVo.setQuestionNo(Integer.parseInt(request.getParameter("questionNo")));
		paramVo.setAnswerTitle(request.getParameter("answerTitle"));
		paramVo.setAnswerContent(request.getParameter("answerContent"));
		
		System.out.println("PARAM VO : " + paramVo.toString());
		
		service.updateQuestion(paramVo);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
