package com.iei.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iei.board.model.service.BoardService;
import com.iei.board.model.vo.BoardComment;

/**
 * Servlet implementation class InsertBoardCommentServlet
 */
@WebServlet(name = "InsertBoardComment", urlPatterns = { "/insertBoardComment.do" })
public class InsertBoardCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		BoardComment bc = new BoardComment();
		bc.setBoardCommentContent(request.getParameter("boardCommentContent"));
		bc.setBoardCommnetWriter(request.getParameter("boardCommentWriter"));
		bc.setBoardRef(Integer.parseInt(request.getParameter("boardRef")));
		bc.setBoardCommentRef(Integer.parseInt(request.getParameter("boardCommentRef")));
		BoardService service = new BoardService();
		int result = service.insertBoardComment(bc);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "성공");
			request.setAttribute("msg", "댓글 작성 완료");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "실패");
			request.setAttribute("msg", "댓글 작성 실패");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/boardView.do?boardNo="+bc.getBoardRef());
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
