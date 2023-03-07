package com.iei.book.model.vo;

public class Book {

	private int bookNo;
	private int storyCount;
	
	private int genreCode;
	private String genreName;
	
	private String bookTitle;
	
	private String bookWriterId;
	private String bookWriterNick;
	
	private String bookExp;
	private String coverpath;
	private String bookStatus;
	private String bookDate;
	
	private int bookStatusNum;
	
	public int getBookStatusNum() {
		return bookStatusNum;
	}

	public void setBookStatusNum(int bookStatusNum) {
		this.bookStatusNum = bookStatusNum;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookNo, int storyCount, int genreCode, String genreName, String bookTitle, String bookWriterId,
			String bookWriterNick, String bookExp, String coverpath, String bookStatus, String bookDate) {
		super();
		this.bookNo = bookNo;
		this.storyCount = storyCount;
		this.genreCode = genreCode;
		this.genreName = genreName;
		this.bookTitle = bookTitle;
		this.bookWriterId = bookWriterId;
		this.bookWriterNick = bookWriterNick;
		this.bookExp = bookExp;
		this.coverpath = coverpath;
		this.bookStatus = bookStatus;
		this.bookDate = bookDate;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getStoryCount() {
		return storyCount;
	}

	public void setStoryCount(int storyCount) {
		this.storyCount = storyCount;
	}

	public int getGenreCode() {
		return genreCode;
	}

	public void setGenreCode(int genreCode) {
		this.genreCode = genreCode;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
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
