package com.iei.story.controller;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.story.model.service.StoryService;

/**
 * Servlet implementation class InsertStoryCommentServlet
 */
@WebServlet(name = "InsertStoryComment", urlPatterns = { "/insertStoryComment.do" })
public class InsertStoryCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStoryCommentServlet() {
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
		int storyNo = Integer.parseInt(request.getParameter("storyNo"));
		String userId = request.getParameter("userId");
		String commentCnt = request.getParameter("commentCnt");

		//비즈니스로직
		StoryService service = new StoryService();
		int result = service.insertStoryComment(bookNo,storyNo,userId,commentCnt);
		
		
		//결과처리
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
