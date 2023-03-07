package com.iei.bookListManage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iei.bookListManage.model.service.BookListManageService;
import com.iei.user.model.vo.User;


@WebServlet(name = "DeleteBook", urlPatterns = { "/deleteBook.do" })
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public DeleteBookServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("utf-8");
		//값추출
		
		int bookNo = Integer.parseInt(request.getParameter("delBook"));
		
		//비즈니스 로직
		BookListManageService service = new BookListManageService();
		int result = service.deleteBookListManage(bookNo);
		HttpSession session = request.getSession();  
		User loginUser = (User)session.getAttribute("loginUser");
		//4결과처리
		
		if(loginUser!=null&&loginUser.getUserLevel()==1) {
		
		//결과처리
		RequestDispatcher view
		= request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "삭제성공");
			request.setAttribute("msg", "게시글이 삭제되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/bookListManage/bookListManageList.do?reqPage=1");
		}else {
			request.setAttribute("title", "삭제실패");
			request.setAttribute("msg", "관리자에게 문의하세요.");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/bookListManage/bookListManageList.do?reqPage=1");
		}
		view.forward(request, response);
		}
	
		RequestDispatcher view =
			request.getRequestDispatcher("/");
			view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
