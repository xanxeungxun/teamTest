package com.iei.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.mypage.service.MyPageService;
import com.iei.user.model.service.UserService;

/**
 * Servlet implementation class DeleteFavBookServlet
 */
@WebServlet(name = "DeleteFavBook", urlPatterns = { "/deleteFavBook.do" })
public class DeleteFavBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFavBookServlet() {
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
		int favBookNo = Integer.parseInt(request.getParameter("favBookNo"));
		
		//3. 비즈니스로직
		MyPageService service = new MyPageService();
		int result = service.deleteFavBook(favBookNo);
		
		//4. 결과 처리
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
