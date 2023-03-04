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
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet(name = "UpdateUserFrm", urlPatterns = { "/updateUserFrm.do" })
public class UpdateUserFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserFrmServlet() {
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
		//프로필 이미지
		User u = new User();
		u.setUserNick(request.getParameter("userNick"));
		u.setUserPhone(request.getParameter("userPhone"));
		u.setUserEmail(request.getParameter("userEmail"));
		u.setUserPw(request.getParameter("newPw"));
		
		//3. 비즈니스 로직
		UserService service = new UserService();
		int result = service.updateUser(u);
		
		//4. 화면 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/user/updateUserFrm.jsp");
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
