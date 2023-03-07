package com.iei.mypage.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.user.model.service.UserService;

/**
 * Servlet implementation class PointRechargeServlet
 */
@WebServlet(name = "PointRecharge", urlPatterns = { "/pointRecharge.do" })
public class PointRechargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PointRechargeServlet() {
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
		int price = Integer.parseInt(request.getParameter("paymentMoney"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		//3. 비즈니스 로직
		UserService service = new UserService();
		//update user_tbl set user_point=? where user_no=?
		int result = service.updateUserPoint(price, userNo);
		
		//4. 결과 처리
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
