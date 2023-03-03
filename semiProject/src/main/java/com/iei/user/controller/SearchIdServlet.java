package com.iei.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.user.model.service.UserService;

/**
 * Servlet implementation class SearchIdServlet
 */
@WebServlet(name = "SearchId", urlPatterns = { "/searchId.do" })
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdServlet() {
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
		String inputEmail = request.getParameter("inputEmail");
		
		//3. 비즈니스 로직
		UserService service = new UserService();
		String searchId = service.selectUserId(inputEmail);
		
		//4. 화면 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/user/searchId.jsp");
		
		request.setAttribute("searchId", searchId);
		
		view.forward(request, response);
		
		/*RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(searchId != null) {
			request.setAttribute("title", "아이디를 찾았습니다!");
			request.setAttribute("msg", "회원님의 아이디는 "+searchId+" 입니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/loginFrm.do");
		} else {
			request.setAttribute("title", "회원정보가 없습니다.");
			request.setAttribute("msg", "이메일 주소를 확인해주세요.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/searchIdFrm.do");
		}
		
		view.forward(request, response);*/
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
