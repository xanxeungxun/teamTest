package com.iei.bookListManage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.bookListManage.model.vo.BookListManageVo;

import common.JDBCTemplate;

public class BookListManageDao {
	
	
	// 전체 목록 조회
	public ArrayList<BookListManageVo> selectAllBookListManageList(Connection conn,int start,int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookListManageVo> list = new ArrayList<BookListManageVo>();
		String query = "select * from(select rownum as rnum, n.* from(select book_no,b.genre_code,genre_name,book_title,book_writer,book_status,book_date from book a join genre b on a.genre_code = b.genre_code order by 1 desc)n)where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				BookListManageVo n = new BookListManageVo();
				n.setBookNo(rset.getInt("book_no"));
				n.setGenreCode(rset.getInt("genre_code"));
				n.setGenreName(rset.getString("genre_name"));
				n.setBookTitle(rset.getString("book_title"));
				n.setBookWriter(rset.getString("book_writer"));
				n.setBookStatus(rset.getInt("book_status"));
				n.setBookDate(rset.getString("book_date"));
				list.add(n);
				System.out.println(list.toString());
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
	
	
	// 문의 상세 조회
	public BookListManageVo selectOneBookListManage(Connection conn, String bookListManageNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BookListManageVo result = new BookListManageVo();
		String query = "SELECT * FROM QUESTION WHERE QUESTION_NO = ?";
		
		
		System.out.println("========= EXECUTED QUERY =========");
		System.out.println("questionNo : " + bookListManageNo);
		System.out.println(query);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bookListManageNo));
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
//				result.setQuestionNo(rset.getInt("QUESTION_NO"));
//				result.setQuestionUserId(rset.getString("QUESTION_USER_ID"));
//				result.setQuestionName(rset.getString("QUESTION_USER_ID"));
//				result.setQuestionTitle(rset.getString("QUESTION_TITLE"));
//				result.setQuestionType(rset.getString("QUESTION_TYPE"));
//				result.setQuestionContent(rset.getString("QUESTION_CONTENT"));
//				result.setEnrollDate(rset.getString("ENROLL_DATE"));
//				result.setAnswerYn(rset.getString("ANSWER_YN"));
//				result.setAnswerUserName(rset.getString("ANSWER_USER_NAME"));
//				result.setAnswerUserId(rset.getString("ANSWER_USER_ID"));
//				result.setAnswerTitle(rset.getString("ANSWER_TITLE"));
//				result.setAnswerContent(rset.getString("ANSWER_CONTENT"));
//				result.setAnswerDate(rset.getString("ANSWER_DATE"));
				
				System.out.println("========= OUTPUT VALUES =========");
				System.out.println(result.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return result;
	}
	

	public int selectBookListManageCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int totalCount = 0;
		String query = "select count(*) as cnt from book";
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


	

}
