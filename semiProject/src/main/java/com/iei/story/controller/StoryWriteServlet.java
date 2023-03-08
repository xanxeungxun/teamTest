package com.iei.story.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.book.model.service.BookService;
import com.iei.story.model.service.StoryService;
import com.iei.story.model.vo.Story;

/**
 * Servlet implementation class StoryWriteServlet
 */
@WebServlet(name = "StoryWrite", urlPatterns = { "/storyWrite.do" })
public class StoryWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoryWriteServlet() {
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
		String storyName = request.getParameter("storyName");
		String storyContent = request.getParameter("storyContent");
		String storyAfter = request.getParameter("storyAfter");
		Story s = new Story();
		s.setStoryNo(storyNo);
		s.setStoryAfter(storyAfter);
		s.setStoryContent(storyContent);
		s.setStoryName(storyName);
		
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		
		//3비즈니스로직
		StoryService service = new StoryService();
		int result = service.updateStory(s);
		
		//4결과처리
		if(result>0) { //작품 등록 성공
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "작품 수정 완료");
			request.setAttribute("msg", "작품이 성공적으로 수정되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/storyList.do?bookNo="+bookNo);
			view.forward(request, response);
		}else {//작품 등록 실패
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "작품 수정 실패");
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
