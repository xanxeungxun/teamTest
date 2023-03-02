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
 * Servlet implementation class NoticeUpdateServlet
 */
@WebServlet(name = "NoticeUpdate", urlPatterns = { "/noticeUpdate.do" })
public class NoticeUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateServlet() {
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
		Notice n = new Notice();
		n.setNoticeNo(Integer.parseInt(request.getParameter("noticeNo")));
		n.setNoticeTitle(request.getParameter("noticeTitle"));
		n.setNoticeContent(request.getParameter("noticeContent"));
		//3.비즈니스 로직
		NoticeService service = new NoticeService();
		int result = service.updateNotice(n);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/noticeView.do?noticeNo="+n.getNoticeNo());
		if(result>0) {
			System.out.println("변경성공");
		}else {
			System.out.println("수정실패");
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
