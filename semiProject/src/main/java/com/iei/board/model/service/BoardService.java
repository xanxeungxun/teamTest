package com.iei.board.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.board.model.dao.BoardDao;
import com.iei.board.model.vo.Board;
import com.iei.board.model.vo.BoardComment;
import com.iei.board.model.vo.BoardPageData;
import com.iei.board.model.vo.BoardViewData;

import common.JDBCTemplate;

public class BoardService {
	private BoardDao dao;

	public BoardService() {
		super();
		dao = new BoardDao();
	}

	public BoardPageData selectBoardList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		//1. 한 페이지당 게시물 수 지정 -> 10개
		int numPerPage = 10;
		//reqPage가 1페이지면 -> 최신글 1~10번
		//reqPage가 2페이지면 -> 최신글 11~20번
		//reqPage == 4 -> 31~40
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		ArrayList<Board> list = dao.selectBoardList(conn,start,end);
		
		//페이징제작 시작
		//전체페이지 수를 계산 -> 총 게시물 수를 조회
		int totalCount = dao.selectBoardCount(conn);
		//전체 페이지 수 계산
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage + 1;
		}
		
		//네비게이션 사이즈
		int pageNaviSize = 5;
		
		//페이지네비게이션 시작번호
		//reqPage 1~5  : 1 2 3 4 5
		//reqPage 6~10 : 6 7 8 9 10
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		
		//페이지 네비게이션 제작 시작
		String pageNavi = "<ul class='pagination circle-style'>";
		//이전버튼
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/boardList.do?reqPage="+(pageNo-1)+"'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		//페이지 숫자
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/boardList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/boardList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음버튼
		if(pageNo <= totalPage) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/boardList.do?reqPage="+(pageNo)+"'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		
		
		JDBCTemplate.close(conn);
		BoardPageData bpd = new BoardPageData(list, pageNavi, start);
		return bpd;
	}

	public int insertBoard(Board b) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertBoard(conn, b);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public BoardViewData selectOneBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateReadCount(conn, boardNo);
		if(result > 0) {
			JDBCTemplate.commit(conn);
			Board b = dao.selectOneBoard(conn, boardNo);
			ArrayList<BoardComment> commentList = dao.selectBoardComment(conn, boardNo);
			ArrayList<BoardComment> reCommentList = dao.selectReCommentList(conn, boardNo);
			BoardViewData bvd = new BoardViewData(b, commentList, reCommentList);
			JDBCTemplate.close(conn);
			return bvd;
		}else {
			JDBCTemplate.rollback(conn);
			JDBCTemplate.close(conn);
			return null;
		}
	}

	public Board deleteBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		Board b = dao.selectOneBoard(conn, boardNo);
		int result = dao.deleteBoard(conn, boardNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
			b = null;
		}
		JDBCTemplate.close(conn);
		return b;
	}

	public Board getBoard(int boardNo) {
		Connection conn = JDBCTemplate.getConnection();
		Board b = dao.selectOneBoard(conn, boardNo);
		JDBCTemplate.close(conn);
		return b;
	}

	public int updateBoard(Board b) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateBoard(conn, b);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertBoardComment(BoardComment bc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertBoardComment(conn, bc);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateBoardComment(BoardComment bc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateBoardComment(conn, bc);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteBoardComment(int boardCommentNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteBoardComment(conn, boardCommentNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
