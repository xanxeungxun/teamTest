package com.iei.cal.model.vo;

public class CalCheck {
	private String title;
	private String start;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public CalCheck(String title, String start) {
		super();
		this.title = title;
		this.start = start;
	}
	public CalCheck() {
		super();
		// TODO Auto-generated constructor stub
	}
}
