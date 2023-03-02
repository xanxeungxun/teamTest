package com.iei.question.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.question.model.service.NoticeService;
import com.iei.question.model.vo.Notice;
import com.iei.question.model.vo.NoticePageData;
@WebServlet(name = "NoticeList", urlPatterns = { "/noticeList.do" })
public class NoticeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NoticeListServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1 인코딩
		request.setCharacterEncoding("utf-8");
		//2 값추출
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		//3 비즈니스 로직
		NoticeService service = new NoticeService();
		NoticePageData npd = service.selectNoticeList(reqPage);
		//reqPage  를 주어서 몇번째 페이지를 주라고 요청할것임.
		
		//4 결과 처리
		RequestDispatcher view =
		request.getRequestDispatcher("/WEB-INF/views/question/noticeList.jsp");
		request.setAttribute("list", npd.getList());
		request.setAttribute("pageNavi", npd.getPageNavi());
		request.setAttribute("start", npd.getStart());
			view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
