package com.iei.mypage.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.mypage.service.MyPageService;

/**
 * Servlet implementation class DeleteFavBookServlet
 */
@WebServlet(name = "DeleteFavBook", urlPatterns = { "/deleteFavBook.do" })
public class DeleteFavBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFavBookServlet() {
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
		int favBookNo = Integer.parseInt(request.getParameter("favBookNo"));
		int userNo = Integer.parseInt(request.getParameter("userNo"));
		
		//3. 비즈니스로직
		MyPageService service = new MyPageService();
		int result = service.deleteFavBook(favBookNo);
		
		//4. 결과 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			request.setAttribute("title", "삭제 성공");
			request.setAttribute("msg", "게시글이 삭제되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/myPageFavBookList.do?userNo="+userNo);
			
		} else {
			request.setAttribute("title", "삭제 실패");
			request.setAttribute("msg", "관리자에게 문의하세요");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/myPageFavBookList.do?userNo="+userNo); 
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
