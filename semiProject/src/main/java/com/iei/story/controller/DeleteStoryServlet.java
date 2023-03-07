package com.iei.story.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.story.model.service.StoryService;

/**
 * Servlet implementation class DeleteStoryServlet
 */
@WebServlet(name = "DeleteStory", urlPatterns = { "/deleteStory.do" })
public class DeleteStoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		//2.값추출
		String storyNo = request.getParameter("storyNo");
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		
		//3.비즈니스로직
		StoryService service = new StoryService();
		int result = service.deleteStroy(storyNo);
		
		//4.결과처리
		if(result>0) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "삭제 완료");
			request.setAttribute("msg", "삭제되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/storyList.do?bookNo="+bookNo);
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "삭제 실패");
			request.setAttribute("msg", "오류. 관리자에게 문의하세요");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/storyList.do?bookNo="+bookNo);
			view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
