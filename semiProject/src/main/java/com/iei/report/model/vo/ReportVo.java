package com.iei.report.model.vo;

public class ReportVo {
	private int reportNo; //신고번호
	private String reporterId; //신고자
	private String reportTitle; //신고제목
	private String reportContent;  //신고내용
	private int reportType;  //신고 종류
	private String reportDate; //신고 일자
	private	String bobType; //신고 게시판 명
	private int bobNo;	//신고 게시물 넘버
	private String bobTitle; //신고 게시물 타이틀
	private String fileName; //보여질 파일 이름
	private String filePatch; //저장될 파일 이름
	public ReportVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReportVo(int reportNo, String reporterId, String reportTitle, String reportContent, int reportType,
			String reportDate, String bobType, int bobNo, String bobTitle, String fileName, String filePatch) {
		super();
		this.reportNo = reportNo;
		this.reporterId = reporterId;
		this.reportTitle = reportTitle;
		this.reportContent = reportContent;
		this.reportType = reportType;
		this.reportDate = reportDate;
		this.bobType = bobType;
		this.bobNo = bobNo;
		this.bobTitle = bobTitle;
		this.fileName = fileName;
		this.filePatch = filePatch;
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
	public String getBobType() {
		return bobType;
	}
	public void setBobType(String bobType) {
		this.bobType = bobType;
	}
	public int getBobNo() {
		return bobNo;
	}
	public void setBobNo(int bobNo) {
		this.bobNo = bobNo;
	}
	public String getBobTitle() {
		return bobTitle;
	}
	public void setBobTitle(String bobTitle) {
		this.bobTitle = bobTitle;
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
				+ ", bobType=" + bobType + ", bobNo=" + bobNo + ", bobTitle=" + bobTitle + ", fileName=" + fileName
				+ ", filePatch=" + filePatch + "]";
	}
	
	
	
	
}
