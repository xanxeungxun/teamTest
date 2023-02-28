package com.iei.reportList.model.vo;

public class ReportList {
	private int reportNo;
	private int reporterNo;
	private int susNo;
	private String reportContent;
	private int reportStyle;
	private String reportDate;
	private int storyCommentNo;
	private int bookNo;
	private int boardCommentNo;
	private int boardNo;
	
	
	
	public ReportList() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ReportList(int reportNo, int reporterNo, int susNo, String reportContent, int reportStyle, String reportDate,
			int storyCommentNo, int bookNo, int boardCommentNo, int boardNo) {
		super();
		this.reportNo = reportNo;
		this.reporterNo = reporterNo;
		this.susNo = susNo;
		this.reportContent = reportContent;
		this.reportStyle = reportStyle;
		this.reportDate = reportDate;
		this.storyCommentNo = storyCommentNo;
		this.bookNo = bookNo;
		this.boardCommentNo = boardCommentNo;
		this.boardNo = boardNo;
	}



	public int getReportNo() {
		return reportNo;
	}



	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}



	public int getReporterNo() {
		return reporterNo;
	}



	public void setReporterNo(int reporterNo) {
		this.reporterNo = reporterNo;
	}



	public int getSusNo() {
		return susNo;
	}



	public void setSusNo(int susNo) {
		this.susNo = susNo;
	}



	public String getReportContent() {
		return reportContent;
	}



	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}



	public int getReportStyle() {
		return reportStyle;
	}



	public void setReportStyle(int reportStyle) {
		this.reportStyle = reportStyle;
	}



	public String getReportDate() {
		return reportDate;
	}



	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}



	public int getStoryCommentNo() {
		return storyCommentNo;
	}



	public void setStoryCommentNo(int storyCommentNo) {
		this.storyCommentNo = storyCommentNo;
	}



	public int getBookNo() {
		return bookNo;
	}



	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}



	public int getBoardCommentNo() {
		return boardCommentNo;
	}



	public void setBoardCommentNo(int boardCommentNo) {
		this.boardCommentNo = boardCommentNo;
	}



	public int getBoardNo() {
		return boardNo;
	}



	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	
	

}
