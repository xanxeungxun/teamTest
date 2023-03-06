package com.iei.assistmodal.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.user.model.service.UserService;

/**
 * Servlet implementation class AssistPointServlet
 */
@WebServlet(name = "AssistPoint", urlPatterns = { "/assistPoint.do" })
public class AssistPointServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssistPointServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int bookNo = Integer.parseInt(request.getParameter("bookNo"));
		String loginUser = request.getParameter("loginUser");
		String bookWriter = request.getParameter("bookWriter");
		int userPoint = Integer.parseInt(request.getParameter("userPoint"));
		int inputPoint = Integer.parseInt(request.getParameter("inputPoint"));
		
		UserService service = new UserService();
		int result = service.updateAssistPoint(loginUser, bookWriter, userPoint, inputPoint);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "후원성공");
			request.setAttribute("msg", "작가에게 후원하셨습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "후원실패");
			request.setAttribute("msg", "포인트가 부족합니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/storyList.do?bookNo="+bookNo);
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
