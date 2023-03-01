package com.iei.book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.book.model.vo.Book;

import common.JDBCTemplate;

public class BookDao {

	public ArrayList<Book> seletAllBook(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		String query ="select b.book_no, g.genre_name, b.book_title, b.book_writer, u.user_nick, b.book_exp, b.coverpath, case b.book_status when 1 then '연재중' else '완결' end as book_status, b.book_date from genre g, book b, user_tbl u where g.genre_code = b.genre_code and b.BOOK_WRITER = u.USER_id";
		
		try {
			pstmt=conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book b = new Book();
				b.setBookDate(rset.getString("book_date"));
				b.setBookExp(rset.getString("book_exp"));
				b.setBookNo(Integer.parseInt(rset.getString("book_no")));
				b.setBookStatus(rset.getString("book_status"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookWriterId(rset.getString("book_writer"));
				b.setBookWriterNick(rset.getString("user_nick"));
				b.setCoverpath(rset.getString("coverpath"));
				b.setGenreCode(Integer.parseInt(rset.getString("genre_code")));
				b.setGenreName(rset.getString("genre_name"));
				
				bookList.add(b);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return bookList;
	}

	
	
}//BookDao
