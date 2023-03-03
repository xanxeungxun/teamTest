package com.iei.bookListManage.model.vo;

public class BookListManageVo {
	
	private int bookNo; // 책 번호
	private int genreCode; // 장르코드
	private String bookTitle; // 작품 이름
	private String bookWriter; //작가 명
	private int bookStatus; //작품 상태
	private String bookDate; //작품 등록일
	private String genreName; //장르 네임
	
	
	
	public BookListManageVo() {
		super();
	}


	public BookListManageVo(int bookNo, int genreCode, String bookTitle, String bookWriter, int bookStatus,
			String bookDate, String genreName) {
		super();
		this.bookNo = bookNo;
		this.genreCode = genreCode;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		this.bookStatus = bookStatus;
		this.bookDate = bookDate;
		this.genreName = genreName;
	}







	@Override
	public String toString() {
		return "BookListManageVo [bookNo=" + bookNo + ", genreCode=" + genreCode + ", bookTitle=" + bookTitle
				+ ", bookWriter=" + bookWriter + ", bookStatus=" + bookStatus + ", bookDate=" + bookDate
				+ ", genreName=" + genreName + "]";
	}


	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public int getGenreCode() {
		return genreCode;
	}


	public void setGenreCode(int genreCode) {
		this.genreCode = genreCode;
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


	public String getGenreName() {
		return genreName;
	}


	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}




}
