package com.iei.book.model.vo;

import java.util.ArrayList;

public class BookListData {
	
	private ArrayList<Book> bookList;
	private String pageNavi;
	private int start;

	
	public BookListData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BookListData(ArrayList<Book> bookList, String pageNavi, int start) {
		super();
		this.bookList = bookList;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	

	public BookListData(ArrayList<Book> bookList, int start) {
		super();
		this.bookList = bookList;
		this.start = start;
	}

	public ArrayList<Book> getBookList() {
		return bookList;
	}

	public void setBookList(ArrayList<Book> bookList) {
		this.bookList = bookList;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

}
