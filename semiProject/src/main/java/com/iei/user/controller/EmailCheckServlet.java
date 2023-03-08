package com.iei.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailCheckServlet
 */
@WebServlet(name = "EmailCheck", urlPatterns = { "/emailCheck.do" })
public class EmailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailCheckServlet() {
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
		String inputEmail = request.getParameter("userEmail");
		
		//3. 비즈니스 로직
		MailSender sender = new MailSender();
		String email = sender.sendEmailCheck(inputEmail);
		
		
		//4. 결과 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(email == null) {
			request.setAttribute("title", "인증번호 전송 성공");
			request.setAttribute("msg", "회원님의 인증번호가 전송되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/joinFrm.do");
			
		} else {
			request.setAttribute("title", "인증번호 전송 실패");
			request.setAttribute("msg", "회원님의 인증번호 전송이 실패되었습니다.");
			request.setAttribute("icon", "wraning");
			request.setAttribute("loc", "/joinFrm.do");
			
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
