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

@WebServlet(name = "QuestionWrite", urlPatterns = { "/questionWrite.do" })
public class QuestionWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QuestionWriteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1 인코딩
		request.setCharacterEncoding("utf-8");
		//2 값 추출
		String questionTitle = request.getParameter("questionTitle");
		String questionContent = request.getParameter("questionContent");
		QuestionVo q = new QuestionVo();
		q.setQuestionTitle(questionTitle);
		q.setQuestionContent(questionContent);
		//3 비즈니스 로직
		QuestionService service = new QuestionService();
		int result = service.insertQuestion(q);
		System.out.println("q :"+q);
		//4 결과 처리
		RequestDispatcher view =
				request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "게시글 작성 완료");
			request.setAttribute("msg", "게시글이 작성되었습니다.");
			request.setAttribute("icon", "success");
		}
		request.setAttribute("loc", "/question/questionList.do?reqPage=1");
		view.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
