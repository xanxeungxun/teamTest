package com.iei.cal.model.vo;

public class Cal {
	private int checkNo;
	private String checkDay;
	private int userNo;
	public int getCheckNo() {
		return checkNo;
	}
	public void setCheckNo(int checkNo) {
		this.checkNo = checkNo;
	}
	public String getCheckDay() {
		return checkDay;
	}
	public void setCheckDay(String checkDay) {
		this.checkDay = checkDay;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public Cal(int checkNo, String checkDay, int userNo) {
		super();
		this.checkNo = checkNo;
		this.checkDay = checkDay;
		this.userNo = userNo;
	}
	public Cal() {
		super();
		// TODO Auto-generated constructor stub
	}
}
