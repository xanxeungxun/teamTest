package com.iei.mypage.controller;

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
		int updatePrice = Integer.parseInt(request.getParameter("myPointPlusPrice"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		//3. 비즈니스 로직
		UserService service = new UserService();
		//update user_tbl set user_point=? where user_no=?
		int result = service.updateUserPoint(updatePrice, userNo);
		
		//4. 결과 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			//session 정보 수정
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute("loginUser");
			loginUser.setUserPoint(updatePrice);
			
			request.setAttribute("title", "결제 성공");
			request.setAttribute("msg", "포인트가 수정되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/myPageMain.do?userNo="+userNo);
			
		} else {
			request.setAttribute("title", "결제 실패");
			request.setAttribute("msg", "관리자에게 문의하세요");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/myPageMain.do?userNo="+userNo); 
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
