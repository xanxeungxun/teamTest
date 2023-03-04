package com.iei.user.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchPwServlet
 */
@WebServlet(name = "SearchPw", urlPatterns = { "/searchPw.do" })
public class SearchPwServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPwServlet() {
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
		String inputId = request.getParameter("inputId");
		String inputEmail = request.getParameter("inputEmail");
		
		//3. 비즈니스 로직
		MailSender sender = new MailSender();
		String searchPw = sender.sendMail(inputId, inputEmail);
		
		
		//4. 결과 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(searchPw == null) {
			//비번 찾기 실패
			request.setAttribute("title", "비밀번호를 찾지 못했습니다.");
			request.setAttribute("msg", "아이디와 이메일 주소를 다시 입력해주세요.");
			request.setAttribute("icon", "warning");
			request.setAttribute("loc", "/searchPwFrm.do");
			
		} else {
			//비번 찾기 성공
			request.setAttribute("title", "이메일이 성공적으로 전송되었습니다.");
			request.setAttribute("msg", "이메일을 확인해주세요.");
			request.setAttribute("icon", "success");
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
