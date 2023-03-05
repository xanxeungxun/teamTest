package com.iei.book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.book.model.service.BookService;
import com.iei.book.model.vo.Book;
import com.iei.story.model.vo.Story;

/**
 * Servlet implementation class BookViewServlet
 */
@WebServlet(name = "BookView", urlPatterns = { "/storyList.do" })
public class StoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoryListServlet() {
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
		int bookNo = Integer.parseInt(request.getParameter("bookNo")); //<--이 값을 가지고 그 작품의 정보&가진 스토리 가져와야 함
		
		//3비즈니스로직
		BookService service = new BookService();
		Book b = service.selectOneBook(bookNo); //<--클릭한 작품의 bookNo로 그 작품의 정보를 불러옴
		ArrayList<Story> storyList = service.selectStoryList(bookNo); //<--클릭한 작품의 bookNo로 그 작품의 스토리 목록을 불러옴
		
		//4결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/book/storyList.jsp");
		request.setAttribute("b", b);
		request.setAttribute("storyList", storyList);
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
