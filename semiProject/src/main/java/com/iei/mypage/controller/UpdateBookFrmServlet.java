package com.iei.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.book.model.vo.Book;
import com.iei.mypage.service.MyPageService;
import com.iei.mypage.vo.UploadBook;

/**
 * Servlet implementation class UpdateBookFrmServlet
 */
@WebServlet(name = "UpdateBookFrm", urlPatterns = { "/updateBookFrm.do" })
public class UpdateBookFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookFrmServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("uft-8");
		
		//2. 값 추출
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		
		//3. 비즈니스 로직
		MyPageService service = new MyPageService();
		//해당 작품 불러오기
		Book book = service.selectOneBook(bookNo);
		
		//4. 결과 처리 ... 페이지 이동
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/user/updateBookFrm.jsp");
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
