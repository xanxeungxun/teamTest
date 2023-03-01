package com.iei.book.model.vo;

public class Book {

	private int BookNo;
	private int GenreCode;
	private String bookTitle;
	private String bookWriter;
	private String bookExp;
	private String coverpath;
	private int bookStatus;
	private String bookDate;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Book(int bookNo, int genreCode, String bookTitle, String bookWriter, String bookExp, String coverpath,
			int bookStatus, String bookDate) {
		super();
		BookNo = bookNo;
		GenreCode = genreCode;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		this.bookExp = bookExp;
		this.coverpath = coverpath;
		this.bookStatus = bookStatus;
		this.bookDate = bookDate;
	}


	public int getBookNo() {
		return BookNo;
	}


	public void setBookNo(int bookNo) {
		BookNo = bookNo;
	}


	public int getGenreCode() {
		return GenreCode;
	}


	public void setGenreCode(int genreCode) {
		GenreCode = genreCode;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public String getBookWriter() {
		return bookWriter;
	}


	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}


	public String getBookExp() {
		return bookExp;
	}


	public void setBookExp(String bookExp) {
		this.bookExp = bookExp;
	}


	public String getCoverpath() {
		return coverpath;
	}


	public void setCoverpath(String coverpath) {
		this.coverpath = coverpath;
	}


	public int getBookStatus() {
		return bookStatus;
	}


	public void setBookStatus(int bookStatus) {
		this.bookStatus = bookStatus;
	}


	public String getBookDate() {
		return bookDate;
	}


	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	
	
	
	
	
}//Book
