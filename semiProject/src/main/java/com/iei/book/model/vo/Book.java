package com.iei.book.model.vo;

public class Book {

	private int BookNo;
	
	private int GenreCode;
	private String GenreName;
	
	private String bookTitle;
	
	private String bookWriterId;
	private String bookWriterNick;
	
	private String bookExp;
	private String coverpath;
	private String bookStatus;
	private String bookDate;
	
	
	public Book(int bookNo, int genreCode, String genreName, String bookTitle, String bookWriterId,
			String bookWriterNick, String bookExp, String coverpath, String bookStatus, String bookDate) {
		super();
		BookNo = bookNo;
		GenreCode = genreCode;
		GenreName = genreName;
		this.bookTitle = bookTitle;
		this.bookWriterId = bookWriterId;
		this.bookWriterNick = bookWriterNick;
		this.bookExp = bookExp;
		this.coverpath = coverpath;
		this.bookStatus = bookStatus;
		this.bookDate = bookDate;
	}


	public Book() {
		super();
		// TODO Auto-generated constructor stub
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


	public String getGenreName() {
		return GenreName;
	}


	public void setGenreName(String genreName) {
		GenreName = genreName;
	}


	public String getBookTitle() {
		return bookTitle;
	}


	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}


	public String getBookWriterId() {
		return bookWriterId;
	}


	public void setBookWriterId(String bookWriterId) {
		this.bookWriterId = bookWriterId;
	}


	public String getBookWriterNick() {
		return bookWriterNick;
	}


	public void setBookWriterNick(String bookWriterNick) {
		this.bookWriterNick = bookWriterNick;
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


	public String getBookStatus() {
		return bookStatus;
	}


	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}


	public String getBookDate() {
		return bookDate;
	}


	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	
	
	
	
	

}//Book
