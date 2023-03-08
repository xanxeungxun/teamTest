package com.iei.mypage.vo;

public class FavoriteBook {
	
	private int favBookNo;
	private int bookNo;
	private int userNo;
	
	private int genreCode;
	private String genreName;
	private String bookTitle;
	private String bookWriter;
	private String coverPath;
	private String bookDate;
	private String userNick;
	
	
	public FavoriteBook(int favBookNo, int bookNo, int userNo, int genreCode, String genreName, String bookTitle,
			String bookWriter, String coverPath, String bookDate, String userNick) {
		super();
		this.favBookNo = favBookNo;
		this.bookNo = bookNo;
		this.userNo = userNo;
		this.genreCode = genreCode;
		this.genreName = genreName;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		this.coverPath = coverPath;
		this.bookDate = bookDate;
		this.userNick = userNick;
	}


	public FavoriteBook() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getUserNick() {
		return userNick;
	}


	public void setUserNick(String userNick) {
		this.userNick = userNick;
	}


	public int getFavBookNo() {
		return favBookNo;
	}


	public void setFavBookNo(int favBookNo) {
		this.favBookNo = favBookNo;
	}


	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public int getUserNo() {
		return userNo;
	}


	public void setUserNo(int userNo) {
		this.userNo = userNo;
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


	public String getBookWriter() {
		return bookWriter;
	}


	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}


	public String getCoverPath() {
		return coverPath;
	}


	public void setCoverPath(String coverPath) {
		this.coverPath = coverPath;
	}


	public String getBookDate() {
		return bookDate;
	}


	public void setBookDate(String bookDate) {
		this.bookDate = bookDate;
	}
	

}
