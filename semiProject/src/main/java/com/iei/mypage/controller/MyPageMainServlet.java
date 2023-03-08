package com.iei.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.mypage.service.MyPageService;
import com.iei.user.model.service.UserService;
import com.iei.user.model.vo.User;

/**
 * Servlet implementation class MyPageMainServlet
 */
@WebServlet(name = "MyPageMain", urlPatterns = { "/myPageMain.do" })
public class MyPageMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageMainServlet() {
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
		String userId = request.getParameter("userId");
		
		//3. 비즈니스 로직
		MyPageService service = new MyPageService();
		User u = service.selectOneUser(userId);
		
		//4. 페이지 이동
		if(u != null) {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/user/myPageMain.jsp");
			request.setAttribute("u", u);
			
			view.forward(request, response);
			
		} else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			
			request.setAttribute("title", "접근 제한");
			request.setAttribute("msg", "로그인한 회원만 마이페이지를 조회할 수 있습니다.");
			request.setAttribute("icon", "info");
			request.setAttribute("loc", "/");
			
			view.forward(request, response);
			
			return;
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
