package com.iei.cal.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.cal.model.service.CalService;
import com.iei.cal.model.vo.Cal;

/**
 * Servlet implementation class SelectCalCheckServlet
 */
@WebServlet(name = "SelectCalCheck", urlPatterns = { "/selectCalCheck.do" })
public class SelectCalCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectCalCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		CalService service = new CalService();
		ArrayList<Cal> list = service.selectAllCalCheck();
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/cal/cal.jsp");
		request.setAttribute("c", list);
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
