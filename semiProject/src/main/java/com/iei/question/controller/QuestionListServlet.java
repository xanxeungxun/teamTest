package com.iei.question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iei.question.model.service.QuestionService;
import com.iei.question.model.vo.QuestionPageData;
import com.iei.question.model.vo.QuestionVo;
import com.iei.user.model.vo.User;

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
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		
		//4 결과처리
		if (loginUser != null && loginUser.getUserLevel() == 2||loginUser != null && loginUser.getUserLevel() == 1) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/question/questionList.jsp");
			request.setAttribute("list", qpd.getList());
			request.setAttribute("pageNavi", qpd.getPageNavi());
			request.setAttribute("start", qpd.getStart());
			view.forward(request, response);
		} else if (loginUser == null) {

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "로그인이 필요한 서비스입니다");
			request.setAttribute("msg", "로그인 후 이용해주세요");
			request.setAttribute("icon", "warning");
			request.setAttribute("loc", "/loginFrm.do");
			view.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
