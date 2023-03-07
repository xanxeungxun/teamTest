package com.iei.book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.book.model.service.BookService;

/**
 * Servlet implementation class UpdateEndBookServlet
 */
@WebServlet(name = "UpdateEndBook", urlPatterns = { "/updateEndBook.do" })
public class UpdateEndBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEndBookServlet() {
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
		
		//3비즈니스로직
		BookService service = new BookService();
		int result = service.updateEndBook(bookNo);
		
		//4결과처리
		if(result>0) { 
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "완결작품 전환");
			request.setAttribute("msg", "완결작품으로 전환하였습니다");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/storyList.do?bookNo="+bookNo);
			view.forward(request, response);
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "전환 실패");
			request.setAttribute("msg", "오류. 관리자에게 문의하세요");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/bookList.do?reqPage=1");
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
