package com.iei.book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.book.model.service.BookService;
import com.iei.book.model.vo.BookListData;

/**
 * Servlet implementation class SelectGenreServlet
 */
@WebServlet(name = "SelectGenre", urlPatterns = { "/selectGenre.do" })
public class SelectGenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectGenreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		
		//2. 값 추출
		int selectGenreCode = Integer.parseInt(request.getParameter("genre"));
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		
		//3. 비즈니스 로직
		BookService service = new BookService();
		BookListData bld = service.selectGenreBook(selectGenreCode, reqPage);
		
		//4. 결과 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/user/selectGenre.jsp");
		
		request.setAttribute("genreList", bld.getBookList());
		request.setAttribute("pageNavi", bld.getPageNavi());
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
