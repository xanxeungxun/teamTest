package com.iei.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iei.user.model.service.UserService;
import com.iei.user.model.vo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name = "Login", urlPatterns = { "/login.do" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String signId = request.getParameter("signId");
		String signPw = request.getParameter("signPw");
		
		User u = new User();
		u.setUserId(signId);
		u.setUserPw(signPw);
		
		//3. 비즈니스 로직
		UserService service = new UserService();
		User loginUser = service.selectOneUser(u);
		
		//4. 결과 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(loginUser == null) {
			//아이디, 비번 틀린 경우
			request.setAttribute("title", "로그인 실패");
			request.setAttribute("msg", "아이디 또는 비밀번호를 확인해주세요.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/");
			
		} else {
			//아이디, 비번 일치하는 경우
			if(loginUser.getUserLevel() == 4) {
				//탈퇴 회원
				request.setAttribute("title", "회원 조회 불가능");
				request.setAttribute("msg", "로그인 권한이 없습니다.");
				request.setAttribute("icon", "warning");
				request.setAttribute("loc", "/");
				
			} else {
				//관리자, 일반유저, 블락유저
				//session에 회원정보 저장
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", loginUser);
				request.setAttribute("title", "로그인 성공");
				request.setAttribute("msg", "환영합니다.");
				request.setAttribute("icon", "success");
				request.setAttribute("loc", "/");
			}
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
