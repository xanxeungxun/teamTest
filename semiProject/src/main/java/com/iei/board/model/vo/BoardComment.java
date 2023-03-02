package com.iei.board.model.vo;

public class BoardComment {
	private int boardCommentNo;
	private String boardCommnetWriter;
	private String boardCommentContent;
	private String boardCommentDate;
	private int boardRef;
	private int boardCommentRef;
	public int getBoardCommentNo() {
		return boardCommentNo;
	}
	public void setBoardCommentNo(int boardCommentNo) {
		this.boardCommentNo = boardCommentNo;
	}
	public String getBoardCommnetWriter() {
		return boardCommnetWriter;
	}
	public void setBoardCommnetWriter(String boardCommnetWriter) {
		this.boardCommnetWriter = boardCommnetWriter;
	}
	public String getBoardCommentContent() {
		return boardCommentContent;
	}
	public void setBoardCommentContent(String boardCommentContent) {
		this.boardCommentContent = boardCommentContent;
	}
	public String getBoardCommentDate() {
		return boardCommentDate;
	}
	public void setBoardCommentDate(String boardCommentDate) {
		this.boardCommentDate = boardCommentDate;
	}
	public int getBoardRef() {
		return boardRef;
	}
	public void setBoardRef(int boardRef) {
		this.boardRef = boardRef;
	}
	public int getBoardCommentRef() {
		return boardCommentRef;
	}
	public void setBoardCommentRef(int boardCommentRef) {
		this.boardCommentRef = boardCommentRef;
	}
	public BoardComment(int boardCommentNo, String boardCommnetWriter, String boardCommentContent,
			String boardCommentDate, int boardRef, int boardCommentRef) {
		super();
		this.boardCommentNo = boardCommentNo;
		this.boardCommnetWriter = boardCommnetWriter;
		this.boardCommentContent = boardCommentContent;
		this.boardCommentDate = boardCommentDate;
		this.boardRef = boardRef;
		this.boardCommentRef = boardCommentRef;
	}
	public BoardComment() {
		super();
		// TODO Auto-generated constructor stub
	}
}
