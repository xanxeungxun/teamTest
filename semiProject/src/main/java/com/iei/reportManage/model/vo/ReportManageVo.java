package com.iei.reportManage.model.vo;

public class ReportManageVo {
	private int reportNo; //신고번호
	private int reporterNo; //신고인
	private int susNo;  //피신고인
	private String reportTitle; //신고제목
	private String reportContent;  //신고내용
	private String reportFile; //파일 첨부
	private int reportStyle;  //신고 종류
	private String reportDate; //신고 일자
	private int storyCommentNo; //댓글 번호 (소설게시판) - (댓글신고)
	private int bookNo;  // 신고 게시물 (소설게시판) - (게시물신고)
	private int boardCommentNo; // 댓글 번호 (자유게시판) - (댓글신고)
	private int boardNo; // 신고 게시물 (자유게시판) - (게시물신고)
	private String filename; //보여질 파일 이름
	private String filepatch; //저장될 파일 이름
	
	
	
	
	
	
	public ReportManageVo() {
		super();
		// TODO Auto-generated constructor stub
	}






	public ReportManageVo(int reportNo, int reporterNo, int susNo, String reportTitle, String reportContent,
			String reportFile, int reportStyle, String reportDate, int storyCommentNo, int bookNo, int boardCommentNo,
			int boardNo, String filename, String filepatch) {
		super();
		this.reportNo = reportNo;
		this.reporterNo = reporterNo;
		this.susNo = susNo;
		this.reportTitle = reportTitle;
		this.reportContent = reportContent;
		this.reportFile = reportFile;
		this.reportStyle = reportStyle;
		this.reportDate = reportDate;
		this.storyCommentNo = storyCommentNo;
		this.bookNo = bookNo;
		this.boardCommentNo = boardCommentNo;
		this.boardNo = boardNo;
		this.filename = filename;
		this.filepatch = filepatch;
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






	public String getReportFile() {
		return reportFile;
	}






	public void setReportFile(String reportFile) {
		this.reportFile = reportFile;
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






	public String getFilename() {
		return filename;
	}






	public void setFilename(String filename) {
		this.filename = filename;
	}






	public String getFilepatch() {
		return filepatch;
	}






	public void setFilepatch(String filepatch) {
		this.filepatch = filepatch;
	}






	@Override
	public String toString() {
		return "ReportManageVo [reportNo=" + reportNo + ", reporterNo=" + reporterNo + ", susNo=" + susNo
				+ ", reportTitle=" + reportTitle + ", reportContent=" + reportContent + ", reportFile=" + reportFile
				+ ", reportStyle=" + reportStyle + ", reportDate=" + reportDate + ", storyCommentNo=" + storyCommentNo
				+ ", bookNo=" + bookNo + ", boardCommentNo=" + boardCommentNo + ", boardNo=" + boardNo + ", filename="
				+ filename + ", filepatch=" + filepatch + "]";
	}
	
	
}
