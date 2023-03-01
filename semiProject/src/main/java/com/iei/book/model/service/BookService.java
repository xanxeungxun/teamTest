package com.iei.book.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.book.model.dao.BookDao;
import com.iei.book.model.vo.Book;

import common.JDBCTemplate;

public class BookService {

	BookDao dao;

	public BookService() {
		super();
		dao = new BookDao();
	}

	public ArrayList<Book> selectAllBook() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> bookList = dao.seletAllBook(conn);
		
		return bookList;
	}
	
	
	
}
