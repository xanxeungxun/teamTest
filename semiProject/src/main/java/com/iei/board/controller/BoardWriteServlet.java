package com.iei.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.board.model.service.BoardService;
import com.iei.board.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BoardWriteServlet
 */
@WebServlet(name = "BoardWrite", urlPatterns = { "/boardWrite.do" })
public class BoardWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//2.값추출
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root+"upload/board";
		int maxSize = 10*1024*1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "utf-8", new DefaultFileRenamePolicy());
		Board b = new Board();
		b.setBoardTitle(mRequest.getParameter("boardTitle"));
		b.setBoardWriter(mRequest.getParameter("boardWriter"));
		b.setBoardContent(mRequest.getParameter("boardContent"));
		b.setFileName(mRequest.getOriginalFileName("upfile"));
		b.setFilePath(mRequest.getFilesystemName("upfile"));
		//3. 비즈니스로직
		BoardService service = new BoardService();
		int result = service.insertBoard(b);
		//4. 결과철
		RequestDispatcher view = request.getRequestDispatcher("/boardList.do?reqPage=1");
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
