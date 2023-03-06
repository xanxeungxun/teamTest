package com.iei.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.mypage.service.MyPageService;

/**
 * Servlet implementation class DeleteUploadBookServlet
 */
@WebServlet(name = "DeleteUploadBook", urlPatterns = { "/deleteUploadBook.do" })
public class DeleteUploadBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUploadBookServlet() {
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
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		String bookWriter = request.getParameter("bookWriter");
		
		//3. 비즈니스 로직
		MyPageService service = new MyPageService();
		int result = service.deleteUploadBook(bookNo);
		
		//4. 결과 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			request.setAttribute("title", "삭제 성공");
			request.setAttribute("msg", "해당 작품이 삭제되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/uploadBookList.do?userId="+bookWriter+"&reqPage=1");
			
		} else {
			request.setAttribute("title", "삭제 실패");
			request.setAttribute("msg", "관리자에게 문의하세요");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/uploadBookList.do?userId="+bookWriter+"&reqPage=1"); 
		}
		
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
