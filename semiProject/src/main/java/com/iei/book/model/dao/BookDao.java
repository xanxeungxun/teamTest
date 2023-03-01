package com.iei.book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iei.book.model.vo.Book;

public class BookDao {

	public ArrayList<Book> seletAllBook(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		String query ="";
		
		
		return bookList;
	}

	
	
}//BookDao
