package com.iei.story.controller;

import java.io.IOException;
import java.security.Provider.Service;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.iei.story.model.service.StoryService;

/**
 * Servlet implementation class InsertStoryCommentServlet
 */
@WebServlet(name = "InsertStoryComment", urlPatterns = { "/insertStoryReComment.do" })
public class InsertStoryReCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStoryReCommentServlet() {
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
		int commentRef = Integer.parseInt(request.getParameter("commentRef"));
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		int storyNo = Integer.parseInt(request.getParameter("storyNo"));
		String userId = request.getParameter("userId");
		String commentCnt = request.getParameter("commentCnt");

		//비즈니스로직
		StoryService service = new StoryService();
		int result = service.insertStoryReComment(bookNo,storyNo,userId,commentCnt,commentRef);
		
		//결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) { //입력성공
			request.setAttribute("title", "성공");
			request.setAttribute("msg", "댓글 작성 완료");
			request.setAttribute("icon", "success");
		}else{ //입력실패
			request.setAttribute("title", "실패");
			request.setAttribute("msg", "댓글 작성 실패");
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
