package com.iei.story.model.vo;

public class StoryComment {

	int storyCommentNo ;
	String userId;
	int storyNo;
	int bookNo;
	String storyCommentContent;
	String commentDate;
	int storyCommentRef;
	
	
	public StoryComment() {
		super();
		// TODO Auto-generated constructor stub
	}


	public StoryComment(int storyCommentNo, String userId, int storyNo, int bookNo, String storyCommentContent,
			String commentDate, int storyCommentRef) {
		super();
		this.storyCommentNo = storyCommentNo;
		this.userId = userId;
		this.storyNo = storyNo;
		this.bookNo = bookNo;
		this.storyCommentContent = storyCommentContent;
		this.commentDate = commentDate;
		this.storyCommentRef = storyCommentRef;
	}


	public int getStoryCommentNo() {
		return storyCommentNo;
	}


	public void setStoryCommentNo(int storyCommentNo) {
		this.storyCommentNo = storyCommentNo;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getStoryNo() {
		return storyNo;
	}


	public void setStoryNo(int storyNo) {
		this.storyNo = storyNo;
	}


	public int getBookNo() {
		return bookNo;
	}


	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}


	public String getStoryCommentContent() {
		return storyCommentContent;
	}


	public void setStoryCommentContent(String storyCommentContent) {
		this.storyCommentContent = storyCommentContent;
	}


	public String getCommentDate() {
		return commentDate;
	}


	public void setCommentDate(String commentDate) {
		this.commentDate = commentDate;
	}


	public int getStoryCommentRef() {
		return storyCommentRef;
	}


	public void setStoryCommentRef(int storyCommentRef) {
		this.storyCommentRef = storyCommentRef;
	}
	
	
	
}
