package com.iei.report.controller;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iei.board.model.vo.Board;
import com.iei.bookListManage.model.service.BookListManageService;
import com.iei.bookListManage.model.vo.BookListManagePageData;
import com.iei.bookListManage.model.vo.BookListManageVo;
import com.iei.user.model.vo.User;

@WebServlet(name = "ReportWriteFrm", urlPatterns = { "/report/reportWriteFrm.do" })
public class ReportWriteFrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReportWriteFrmServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1인코딩
		request.setCharacterEncoding("utf-8");
		// 2값추출
		// 3비즈니스 로직
		BookListManageService service = new BookListManageService();
		
		
		int reportNo = 
	Integer.parseInt(request.getParameter("bookNo") != null ? request.getParameter("bookNo")  : request.getParameter("boardNo"));
		if(request.getParameter("bookNo") != null) {
			BookListManageVo list = service.selectAllBook(reportNo);
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			// 4결과처리
			if (loginUser != null && loginUser.getUserLevel() == 2) {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/report/reportWriteFrm.jsp");
				request.setAttribute("list", list);

				view.forward(request, response);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/");
				view.forward(request, response);
			}
		
		
		
		
		
		}else if(request.getParameter("boardNo") != null) {
			Board list2 = service.selectAllBoard(reportNo);
			HttpSession session = request.getSession();
			User loginUser = (User) session.getAttribute("loginUser");
			// 4결과처리
			if (loginUser != null && loginUser.getUserLevel() == 2) {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/report/reportWriteFrm.jsp");
				request.setAttribute("list2", list2);

				view.forward(request, response);
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/");
				view.forward(request, response);
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
