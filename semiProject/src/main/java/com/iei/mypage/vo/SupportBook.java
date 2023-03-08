package com.iei.mypage.vo;

public class SupportBook {
	private int supportNo;
	private int bookNo;
	private int userNo;
	private int totalSupportMoney;
	
	private int genreCode;
	private String genreName;
	private String bookTitle;
	private String bookWriter;
	private String coverPath;
	private String bookDate;
	
	private String recvUserId;
	private String recvUserNick;
	
	public String getRecvUserNick() {
		return recvUserNick;
	}


	public void setRecvUserNick(String recvUserNick) {
		this.recvUserNick = recvUserNick;
	}


	public SupportBook(int supportNo, int bookNo, int userNo, int totalSupportMoney, int genreCode, String genreName,
			String bookTitle, String bookWriter, String coverPath, String bookDate, String recvUserId,
			String recvUserNick) {
		super();
		this.supportNo = supportNo;
		this.bookNo = bookNo;
		this.userNo = userNo;
		this.totalSupportMoney = totalSupportMoney;
		this.genreCode = genreCode;
		this.genreName = genreName;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		this.coverPath = coverPath;
		this.bookDate = bookDate;
		this.recvUserId = recvUserId;
		this.recvUserNick = recvUserNick;
	}


	public String getRecvUserId() {
		return recvUserId;
	}


	public void setRecvUserId(String recvUserId) {
		this.recvUserId = recvUserId;
	}


	public SupportBook() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getSupportNo() {
		return supportNo;
	}

	public void setSupportNo(int supportNo) {
		this.supportNo = supportNo;
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

	public int getTotalSupportMoney() {
		return totalSupportMoney;
	}

	public void setTotalSupportMoney(int totalSupportMoney) {
		this.totalSupportMoney = totalSupportMoney;
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
