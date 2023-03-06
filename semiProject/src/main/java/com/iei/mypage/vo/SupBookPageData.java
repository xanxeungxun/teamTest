package com.iei.mypage.vo;

import java.util.ArrayList;

public class SupBookPageData {
	private ArrayList<SupportBook> supList;
	private String pageNavi;
	private int start;
	
	
	public SupBookPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SupBookPageData(ArrayList<SupportBook> supList, String pageNavi, int start) {
		super();
		this.supList = supList;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	
	
	public ArrayList<SupportBook> getSupList() {
		return supList;
	}
	public void setSupList(ArrayList<SupportBook> supList) {
		this.supList = supList;
	}
	public String getPageNavi() {
		return pageNavi;
	}
	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	

}
