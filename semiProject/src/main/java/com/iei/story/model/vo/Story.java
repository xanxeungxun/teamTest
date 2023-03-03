package com.iei.story.model.vo;

public class Story {

	private int storyNo;
	private int bookNo;
	private String storyName;
	private String storyContent;
	private String storyAfter;
	private String storyTime;
	private int readCount;
	
	
	public Story() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Story(int storyNo, int bookNo, String storyName, String storyContent, String storyAfter, String storyTime,
			int readCount) {
		super();
		this.storyNo = storyNo;
		this.bookNo = bookNo;
		this.storyName = storyName;
		this.storyContent = storyContent;
		this.storyAfter = storyAfter;
		this.storyTime = storyTime;
		this.readCount = readCount;
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


	public String getStoryName() {
		return storyName;
	}


	public void setStoryName(String storyName) {
		this.storyName = storyName;
	}


	public String getStoryContent() {
		return storyContent;
	}


	public void setStoryContent(String storyContent) {
		this.storyContent = storyContent;
	}


	public String getStoryAfter() {
		return storyAfter;
	}


	public void setStoryAfter(String storyAfter) {
		this.storyAfter = storyAfter;
	}


	public String getStoryTime() {
		return storyTime;
	}


	public void setStoryTime(String storyTime) {
		this.storyTime = storyTime;
	}


	public int getReadCount() {
		return readCount;
	}


	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	
	
	
	
	

}
