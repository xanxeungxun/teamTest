package com.iei.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.mypage.service.MyPageService;
import com.iei.mypage.vo.FavBookPageData;

/**
 * Servlet implementation class MyPageFavBookListServlet
 */
@WebServlet(name = "MyPageFavBookList", urlPatterns = { "/myPageFavBookList.do" })
public class MyPageFavBookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageFavBookListServlet() {
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
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		
		//3. 비즈니스 로직
		MyPageService service = new MyPageService();
		FavBookPageData fbpd = service.selectFavList(userNo, reqPage);
		
		//4. 결과 처리 ... 페이지 이동
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/user/myPageFavBookList.jsp");
		
		request.setAttribute("favList", fbpd.getFavList());
		request.setAttribute("pageNavi", fbpd.getPageNavi());
		request.setAttribute("start", fbpd.getStart());
		
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
