package com.iei.story.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iei.story.model.service.StoryService;
import com.iei.user.model.vo.User;

/**
 * Servlet implementation class LikeStoryServlet
 */
@WebServlet(name = "LikeStory", urlPatterns = { "/likeStory.do" })
public class LikeStoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeStoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		StoryService service = new StoryService();
		int result = service.insertFavoriteBook(bookNo, userNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "관심작품 등록");
			request.setAttribute("msg", "관식작품으로 등록하셨습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "등록실패");
			request.setAttribute("msg", "관심작품으로 등록할 수 없습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/storyList.do?bookNo="+bookNo);
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
