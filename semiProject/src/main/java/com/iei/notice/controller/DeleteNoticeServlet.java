package com.iei.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.notice.model.service.NoticeService;
import com.iei.notice.model.vo.Notice;

/**
 * Servlet implementation class DeleteNoticeServlet
 */
@WebServlet(name = "DeleteNotice", urlPatterns = { "/deleteNotice.do" })
public class DeleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNoticeServlet() {
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
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		//3. 비즈니스로직
		NoticeService service = new NoticeService();
		Notice n = service.deleteNotice(noticeNo);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/noticeList.do?reqPage=1");
		if(n != null) {
			System.out.println("삭제성공");
		}else {
			System.out.println("삭제실패");
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
