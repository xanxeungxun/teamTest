package com.iei.book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.board.model.service.BoardService;
import com.iei.board.model.vo.BoardPageData;
import com.iei.book.model.service.BookService;
import com.iei.book.model.vo.BookListData;

/**
 * Servlet implementation class BookListCompleteServlet
 */
@WebServlet(name = "BookListComplete", urlPatterns = { "/bookListComplete.do" })
public class BookListCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListCompleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		
		BookService service = new BookService();
		BookListData bld = service.selectAllBookComplete(reqPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/book/bookList.jsp");
		request.setAttribute("bookList", bld.getBookList());
		request.setAttribute("naviCode", bld.getPageNavi());
		request.setAttribute("start", bld.getStart());
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
