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
 * Servlet implementation class DeleteStoryCommentServlet
 */
@WebServlet(name = "DeleteStoryComment", urlPatterns = { "/deleteStoryComment.do" })
public class DeleteStoryCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteStoryCommentServlet() {
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
		int storyCommentNo = Integer.parseInt(request.getParameter("storyCommentNo"));
		
		//3비즈니스로직
		StoryService service = new StoryService();
		int result = service.deleteStoryComment(storyNo,bookNo,storyCommentNo);
		
		//4결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) { //성공
			request.setAttribute("title", "성공");
			request.setAttribute("msg", "댓글 삭제 완료");
			request.setAttribute("icon", "success");
		}else{ //실패
			request.setAttribute("title", "실패");
			request.setAttribute("msg", "댓글 삭제 실패");
			request.setAttribute("icon", "error");
		}
		
		request.setAttribute("loc", "/storyView.do?storyNo="+storyNo+"&bookNo="+bookNo);
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
