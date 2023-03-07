package com.iei.search.controller;

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
import com.iei.book.model.vo.SearchPageData;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(name = "Search", urlPatterns = { "/search.do" })
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		String searchKeyword = request.getParameter("searchKeyword");
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		//3. 비즈니스로직
		BookService service = new BookService();
		SearchPageData spd = service.selectSearchBook(searchKeyword,reqPage);
		//4. 결과처리
		//4-1. 결과를 처리할 jsp파일을 지정
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/search/search.jsp");
		//4-2. 화면구현에 필요한 데이터 등록
		request.setAttribute("searchList", spd.getSearchList());
		request.setAttribute("naviCode", spd.getPageNavi());
		request.setAttribute("begin", spd.getBegin());
		//4-3. jsp페이지로 사용자 이름
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
