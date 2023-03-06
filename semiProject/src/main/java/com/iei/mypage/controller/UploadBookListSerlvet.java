package com.iei.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.mypage.service.MyPageService;
import com.iei.mypage.vo.UploadBookPageData;

/**
 * Servlet implementation class UploadBookListSerlvet
 */
@WebServlet(name = "UploadBookList", urlPatterns = { "/uploadBookList.do" })
public class UploadBookListSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadBookListSerlvet() {
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
		String bookWriter = request.getParameter("userId");
		int reqPage = Integer.parseInt(request.getParameter("reqPage"));
		
		//3. 비즈니스 로직
		MyPageService service = new MyPageService();
		UploadBookPageData ubpd = service.selectUpList(bookWriter, reqPage);
		
		//4. 결과 처리 ... 페이지 이동
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/user/uploadBookList.jsp");
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
