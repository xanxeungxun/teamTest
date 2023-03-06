package com.iei.mypage.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.book.model.vo.Book;
import com.iei.mypage.service.MyPageService;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UpdateBookServlet
 */
@WebServlet(name = "UpdateBook", urlPatterns = { "/updateBook.do" })
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
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
		//2-1. 파일이 업로드될 경로 지정
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/cover-image"; //notice 폴더에 저장할거야
		
		//2-2. 파일 업로드 최대용량 설정 (일반적으로 웹은 최대 10MB)
		int maxSize = 10*1024*1024; //= 10MB
		
		//2-3. multipart/form-data에서 데이터를 꺼내기위한 객체 변환
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		int bookNo = Integer.parseInt(mRequest.getParameter("bookNo"));
		String coverpath = mRequest.getFilesystemName("book-img-upfile");
		int bookStatus = Integer.parseInt(mRequest.getParameter("status"));
		String bookTitle = mRequest.getParameter("bookTitle");
		String bookExp = mRequest.getParameter("bookExp");
		int genreCode = Integer.parseInt(mRequest.getParameter("genre"));
		
		Book updateBook = new Book();
		updateBook.setCoverpath(coverpath);
		updateBook.setBookStatusNum(bookStatus);
		updateBook.setBookTitle(bookTitle);
		updateBook.setBookExp(bookExp);
		updateBook.setGenreCode(genreCode);
		
		//3. 비즈니스 로직
		MyPageService service = new MyPageService();
		int result = service.updateBook(updateBook, bookNo);
		
		//4. 결과 처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		
		if(result>0) {
			request.setAttribute("title", "수정 성공");
			request.setAttribute("msg", "해당 작품의 설정이 수정되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/updateBookFrm.do?bookNo="+bookNo);
			
		} else {
			request.setAttribute("title", "수정 실패");
			request.setAttribute("msg", "관리자에게 문의하세요");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/updateBookFrm.do?bookNo="+bookNo); 
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
