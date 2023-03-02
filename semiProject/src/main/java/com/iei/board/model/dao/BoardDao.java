package com.iei.board.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.board.model.vo.Board;
import com.iei.board.model.vo.BoardComment;

import common.JDBCTemplate;

public class BoardDao {

	public ArrayList<Board> selectBoardList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Board> list = new ArrayList<Board>();
		String query = "select * from(select rownum as rnum, n.* from(SELECT BOARD_NO, BOARD_TITLE, BOARD_WRITER, READ_COUNT, board_Date FROM BOARD ORDER BY 1 DESC)n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Board b = new Board();
				b.setBoardNo(rset.getInt("board_no"));
				b.setBoardTitle(rset.getString("board_title"));
				b.setBoardWriter(rset.getString("board_writer"));
				b.setReadCount(rset.getInt("read_count"));
				b.setboardDate(rset.getString("board_date"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public int selectBoardCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from board";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return totalCount;
	}

	public int insertBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into board values(board_seq.nextval,?,?,?,0,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardWriter());
			pstmt.setString(3, b.getBoardContent());
			pstmt.setString(4, b.getFileName());
			pstmt.setString(5, b.getFilePath());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateReadCount(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update board set read_count = read_count+1 where board_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Board selectOneBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Board n = null;
		String query = "select * from board where board_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				n = new Board();
				n.setFileName(rset.getString("filename"));
				n.setFilePath(rset.getString("filepath"));
				n.setBoardContent(rset.getString("board_content"));
				n.setBoardNo(rset.getInt("board_no"));
				n.setBoardTitle(rset.getString("board_title"));
				n.setBoardWriter(rset.getString("board_writer"));
				n.setReadCount(rset.getInt("read_count"));
				n.setboardDate(rset.getString("board_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return n;
	}

	public int deleteBoard(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from board where board_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateBoard(Connection conn, Board b) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update board set board_title=?, board_content=?, filename=?, filepath=? where board_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getBoardTitle());
			pstmt.setString(2, b.getBoardContent());
			pstmt.setString(3, b.getFileName());
			pstmt.setString(4, b.getFilePath());
			pstmt.setInt(5, b.getBoardNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertBoardComment(Connection conn, BoardComment bc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into board_comment values(board_comment_seq.nextval,?,?,to_char(sysdate,'yyyy-mm-dd'),?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bc.getBoardCommnetWriter());
			pstmt.setString(2, bc.getBoardCommentContent());
			pstmt.setInt(3, bc.getBoardRef());
			pstmt.setString(4, (bc.getBoardCommentRef()==0)?null:String.valueOf(bc.getBoardCommentRef()));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateBoardComment(Connection conn, BoardComment bc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update board_comment set board_comment_content=? where board_comment_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bc.getBoardCommentContent());
			pstmt.setInt(2, bc.getBoardCommentNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<BoardComment> selectBoardComment(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BoardComment> list = new ArrayList<BoardComment>();
		String query = "select * from board_comment where board_ref=? and board_comment_ref is null order by 1";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				BoardComment bc = new BoardComment();
				bc.setBoardCommentContent(rset.getString("board_comment_content"));
				bc.setBoardCommentDate(rset.getString("board_comment_date"));
				bc.setBoardCommentNo(rset.getInt("board_comment_no"));
				bc.setBoardCommentRef(rset.getInt("board_comment_ref"));
				bc.setBoardCommnetWriter(rset.getString("board_comment_writer"));
				bc.setBoardRef(rset.getInt("board_ref"));
				list.add(bc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

	public ArrayList<BoardComment> selectReCommentList(Connection conn, int boardNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BoardComment> list = new ArrayList<BoardComment>();
		String query = "select * from board_comment where board_ref=? and board_comment_ref is not null order by 1";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, boardNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				BoardComment bc = new BoardComment();
				bc.setBoardCommentContent(rset.getString("board_comment_content"));
				bc.setBoardCommentDate(rset.getString("board_comment_date"));
				bc.setBoardCommentNo(rset.getInt("board_comment_no"));
				bc.setBoardCommentRef(rset.getInt("board_comment_ref"));
				bc.setBoardCommnetWriter(rset.getString("board_comment_writer"));
				bc.setBoardRef(rset.getInt("board_ref"));
				list.add(bc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return list;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
