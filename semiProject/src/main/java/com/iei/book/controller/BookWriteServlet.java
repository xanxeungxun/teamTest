package com.iei.book.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.book.model.service.BookService;
import com.iei.book.model.vo.Book;
import com.iei.story.model.vo.Story;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BookWriteServlet
 */
@WebServlet(name = "BookWrite", urlPatterns = { "/bookWrite.do" })
public class BookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1인코딩
		request.setCharacterEncoding("utf-8");
		
		//2값추출
		String root = getServletContext().getRealPath("/"); //webapp폴더의 절대경로 구하기
		String saveDirectory = root+"upload/cover-image";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8", new DefaultFileRenamePolicy());
		//request-->MultipartRequest로 변환 완료. <-- 파일업로드가 완료되는 시점
		
		String bookTitle = mRequest.getParameter("bookTitle");
		String bookWriter = mRequest.getParameter("bookWriter");
		int genreCode = Integer.parseInt(mRequest.getParameter("genre"));
		String bookExp = mRequest.getParameter("bookExp");
		String coverpath = mRequest.getFilesystemName("coverpath");
		if(coverpath == null) {
			coverpath = "quokka2.png";
		}
		Book b = new Book();
		b.setBookExp(bookExp);
		b.setBookTitle(bookTitle);
		b.setBookWriterId(bookWriter);
		b.setCoverpath(coverpath);
		b.setGenreCode(genreCode);
		//여기까지 Book
		
		String storyName = mRequest.getParameter("storyName");
		String storyContent = mRequest.getParameter("storyContent");
		String storyAfter = mRequest.getParameter("storyAfter");
		Story s = new Story();
		s.setStoryAfter(storyAfter);
		s.setStoryContent(storyContent);
		s.setStoryName(storyName);
		//여기까지 Story
		
		
		//3비즈니스로직
		BookService service = new BookService();
		int result = service.insertBook(b,s);
		
		//4결과처리
		if(result>0) { //작품 등록 성공
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "작품 등록 완료");
			request.setAttribute("msg", "멋져요! 작품이 등록되었습니다.");
			request.setAttribute("icon", "success");
			request.setAttribute("loc", "/bookList.do?reqPage=1");
			view.forward(request, response);
		}else {//작품 등록 실패
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
			request.setAttribute("title", "작품 등록 실패");
			request.setAttribute("msg", "오류. 관리자에게 문의하세요");
			request.setAttribute("icon", "error");
			request.setAttribute("loc", "/bookList.do?reqPage=1");
			view.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
