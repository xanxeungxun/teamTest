package com.iei.book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iei.user.model.vo.User;

/**
 * Servlet implementation class BookWriteFrmServlet
 */
@WebServlet(name = "BookWriteFrm", urlPatterns = { "/bookWriteFrm.do" })
public class BookWriteFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookWriteFrmServlet() {
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
		HttpSession session = request.getSession();
		User u = (User)session.getAttribute("loginUser");
		
		if(u == null) { //로그인이 안 된 경우
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "로그인이 필요한 서비스입니다");
			request.setAttribute("msg", "로그인 후 이용해주세요");
			request.setAttribute("icon", "warning");
			request.setAttribute("loc", "/loginFrm.do");
			view.forward(request, response);
		}
	
		//3비즈니스로직
		
		//4결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/book/bookWriteFrm.jsp");
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
