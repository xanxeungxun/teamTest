package com.iei.report.model.vo;

public class ReportVo {
	private int reportNo; //신고번호
	private int reporterId; //신고인
	private int susNo;
	private String reportTitle; //신고제목
	private String reportContent;  //신고내용
	private int reportStyle;  //신고 종류
	private String reportDate; //신고 일자
	private int bookNo;  // 신고 게시물 (소설게시판) - (게시물신고)
	private int boardNo; // 신고 게시물 (자유게시판) - (게시물신고)
	private String fileName; //보여질 파일 이름
	private String filePatch; //저장될 파일 이름
	
	
	public ReportVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportVo(int reportNo, int reporterId, int susNo, String reportTitle, String reportContent, int reportStyle,
			String reportDate, int bookNo, int boardNo, String fileName, String filePatch) {
		super();
		this.reportNo = reportNo;
		this.reporterId = reporterId;
		this.susNo = susNo;
		this.reportTitle = reportTitle;
		this.reportContent = reportContent;
		this.reportStyle = reportStyle;
		this.reportDate = reportDate;
		this.bookNo = bookNo;
		this.boardNo = boardNo;
		this.fileName = fileName;
		this.filePatch = filePatch;
	}
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	public int getReporterId() {
		return reporterId;
	}
	public void setReporterId(int reporterId) {
		this.reporterId = reporterId;
	}
	public int getSusNo() {
		return susNo;
	}
	public void setSusNo(int susNo) {
		this.susNo = susNo;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
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
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePatch() {
		return filePatch;
	}
	public void setFilePatch(String filePatch) {
		this.filePatch = filePatch;
	}
	@Override
	public String toString() {
		return "ReportVo [reportNo=" + reportNo + ", reporterId=" + reporterId + ", susNo=" + susNo + ", reportTitle="
				+ reportTitle + ", reportContent=" + reportContent + ", reportStyle=" + reportStyle + ", reportDate="
				+ reportDate + ", bookNo=" + bookNo + ", boardNo=" + boardNo + ", fileName=" + fileName + ", filePatch="
				+ filePatch + "]";
	}
	
	
	
	
	
	
	
	
	
}
