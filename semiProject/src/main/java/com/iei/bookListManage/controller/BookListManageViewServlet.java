package com.iei.bookListManage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.bookListManage.model.service.BookListManageService;
import com.iei.bookListManage.model.vo.BookListManageVo;

// 질문 상세 조회
@WebServlet(name = "bookListManageView", urlPatterns = { "/bookListManage/bookListManageView.do" })
public class BookListManageViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookListManageViewServlet() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BookListManageService service = new BookListManageService();
		
		String bookListManageNo = request.getParameter("bookListManageNo");
		
		BookListManageVo result = service.selectOneBookListManage(bookListManageNo);
		
		request.setAttribute("bookListManageResult", result);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/bookListManage/bookListManageView.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
