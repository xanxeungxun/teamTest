package com.iei.cal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.iei.user.model.service.UserService;
import com.iei.user.model.vo.User;

/**
 * Servlet implementation class CalEventServlet
 */
@WebServlet(name = "CalEvent", urlPatterns = { "/calEvent.do" })
public class CalEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalEventServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		String userId = request.getParameter("userId");
		//3. 비즈니스로직
		UserService service = new UserService();
		User u = service.selectOneUserCal(userId);
		//4. 결과처리
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
		gson.toJson(u,out);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
