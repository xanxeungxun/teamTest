package com.iei.userManage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.userManage.model.service.UserManageService;

@WebServlet(name = "ChangeUserLevel", urlPatterns = { "/changeUserLevel.do" })
public class ChangeUserLevelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ChangeUserLevelServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 인코딩
		request.setCharacterEncoding("utf-8");
		//2 값 추출
		int no = Integer.parseInt(request.getParameter("userNo"));
		int level = Integer.parseInt(request.getParameter("userLevel"));
		
		//3 비즈니스 로직
		UserManageService service = new UserManageService();
		int result = service.changeUserLevel(no,level);
		
		//4 결과 처리
		RequestDispatcher view
		= request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "변경 성공");
			request.setAttribute("msg", "회원 등급을 변경하였습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/userManage/userManageList.do?reqPage=1");
		}else {
			request.setAttribute("title", "변경 실패");
			request.setAttribute("msg", "회원 등급 변경에 실패하였습니다.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/userManage/userManageList.do?reqPage=1");
		}
		view.forward(request, response);
			
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
