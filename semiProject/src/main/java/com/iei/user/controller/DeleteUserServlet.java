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
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet(name = "DeleteUser", urlPatterns = { "/deleteUser.do" })
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
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
		HttpSession session = request.getSession(false);
		User loginUser = (User)session.getAttribute("loginUser");
		
		String userId = loginUser.getUserId();
		
		//탈퇴 위한 비밀번호
		String checkPw = request.getParameter("checkPw");
		
		//3. 비즈니스 로직
		UserService service = new UserService();
		int result = service.deleteUser(userId, checkPw);
		
		//4. 결과 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			request.setAttribute("title", "탈퇴 성공");
			request.setAttribute("msg", "탈퇴가 완료되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/logout.do"); //탈퇴 후 로그아웃 처리
			
		} else {
			request.setAttribute("title", "탈퇴 실패");
			request.setAttribute("msg", "비밀번호를 다시 확인해주세요.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/deleteUserFrm.do"); //마이페이지로 돌아감
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
