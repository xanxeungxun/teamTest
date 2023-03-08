package com.iei.story.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.story.model.service.StoryService;
import com.iei.story.model.vo.Story;

/**
 * Servlet implementation class StoryWriteFrmServlet
 */
@WebServlet(name = "StoryWriteFrm", urlPatterns = { "/storyWriteFrm.do" })
public class StoryWriteFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoryWriteFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1인코딩
		request.setCharacterEncoding("utf-8");
		//2값추출
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		int storyNo = Integer.parseInt(request.getParameter("storyNo"));
		//3비즈니스로직
		StoryService service = new StoryService();
		Story story = service.selectOneStory(storyNo);
		
		//4결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/story/storyWriteFrm.jsp");
		request.setAttribute("bookNo", bookNo);
		request.setAttribute("story", story);
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
