package com.iei.story.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.book.model.vo.Book;
import com.iei.story.model.service.StoryService;
import com.iei.story.model.vo.Story;
import com.iei.story.model.vo.StoryComment;

/**
 * Servlet implementation class StoryViewServlet
 */
@WebServlet(name = "StoryView", urlPatterns = { "/storyView.do" })
public class StoryViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoryViewServlet() {
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
		int storyNo = Integer.parseInt(request.getParameter("storyNo"));
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		
		//3비즈니스로직
		StoryService service = new StoryService();
		Book b = service.selectOneBook(bookNo);
		Story s = service.selectOneStory(storyNo);
		ArrayList<StoryComment> storyCommentList = service.selectAllComment(storyNo);
		
		//4결과처리
		request.setAttribute("s", s);
		request.setAttribute("b", b);
		request.setAttribute("cl", storyCommentList);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/story/storyView.jsp");
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
