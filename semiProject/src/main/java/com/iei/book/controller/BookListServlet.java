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
import com.iei.book.model.vo.BookListData;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet(name = "BookList", urlPatterns = { "/bookList.do" })
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.인코딩
		request.setCharacterEncoding("utf-8");
		
		//2.값추출
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		
		//3.비즈니스로직
		BookService service = new BookService();
		BookListData bld = service.selectAllBook(reqPage);
		
		//4결과처리
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
