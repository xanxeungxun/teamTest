package com.iei.report.model.vo;

public class ReportVo {
	private int reportNo; //신고번호
	private String reporterId; //신고자
	private String reportTitle; //신고제목
	private String reportContent;  //신고내용
	private int reportType;  //신고 종류
	private String reportDate; //신고 일자
	private String bookNo;  // 신고 게시물 (소설게시판) - (게시물신고)
	private String boardNo; // 신고 게시물 (자유게시판) - (게시물신고)
	private String fileName; //보여질 파일 이름
	private String filePatch; //저장될 파일 이름
	public ReportVo(int reportNo, String reporterId, String reportTitle, String reportContent, int reportType,
			String reportDate, String bookNo, String boardNo, String fileName, String filePatch) {
		super();
		this.reportNo = reportNo;
		this.reporterId = reporterId;
		this.reportTitle = reportTitle;
		this.reportContent = reportContent;
		this.reportType = reportType;
		this.reportDate = reportDate;
		this.bookNo = bookNo;
		this.boardNo = boardNo;
		this.fileName = fileName;
		this.filePatch = filePatch;
	}
	public ReportVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReportNo() {
		return reportNo;
	}
	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}
	public String getReporterId() {
		return reporterId;
	}
	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
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
	public int getReportType() {
		return reportType;
	}
	public void setReportType(int reportType) {
		this.reportType = reportType;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
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
		return "ReportVo [reportNo=" + reportNo + ", reporterId=" + reporterId + ", reportTitle=" + reportTitle
				+ ", reportContent=" + reportContent + ", reportType=" + reportType + ", reportDate=" + reportDate
				+ ", bookNo=" + bookNo + ", boardNo=" + boardNo + ", fileName=" + fileName + ", filePatch=" + filePatch
				+ "]";
	}
	
	
	
	
	
}
