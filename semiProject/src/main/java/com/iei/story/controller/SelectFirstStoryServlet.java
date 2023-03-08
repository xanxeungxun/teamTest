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
 * Servlet implementation class SelectFirstStoryServlet
 */
@WebServlet(name = "SelectFirstStory", urlPatterns = { "/selectFirstStory.do" })
public class SelectFirstStoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectFirstStoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("utf-8");
		
		//값추출
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		
		//비즈니스로직
		StoryService service = new StoryService();
		int storyNo = service.selectFirstStory(bookNo);
		
		//결과처리

		RequestDispatcher view = request.getRequestDispatcher("/storyView.do?storyNo="+storyNo+"&bookNo="+bookNo);
	
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
