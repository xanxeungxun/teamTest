package com.iei.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.user.model.service.UserService;
import com.iei.user.model.vo.User;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet(name = "Join", urlPatterns = { "/join.do" })
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
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
		User u = new User();
		u.setUserId(request.getParameter("userId"));
		u.setUserName(request.getParameter("userName"));
		u.setUserNick(request.getParameter("userNick"));
		u.setUserPhone(request.getParameter("userPhone"));
		u.setUserPw(request.getParameter("userPw"));
		u.setUserEmail(request.getParameter("userEmail"));
		
		//3. 비즈니스 로직
		UserService service = new UserService();
		int result = service.inserUser(u);
		
		//4. 결과 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			request.setAttribute("title", "회원가입 성공");
			request.setAttribute("msg", "환영합니다. "+u.getUserName()+"님!");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/");
		} else {
			request.setAttribute("title", "회원가입 실패");
			request.setAttribute("msg", "다시 시도해주세요.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/");
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
