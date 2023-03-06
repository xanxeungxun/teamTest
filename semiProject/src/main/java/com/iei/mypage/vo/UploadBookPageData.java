package com.iei.mypage.vo;

import java.util.ArrayList;

public class UploadBookPageData {
	private ArrayList<UploadBook> upList;
	private String pageNavi;
	private int start;
	public UploadBookPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UploadBookPageData(ArrayList<UploadBook> upList, String pageNavi, int start) {
		super();
		this.upList = upList;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	public ArrayList<UploadBook> getUpList() {
		return upList;
	}
	public void setUpList(ArrayList<UploadBook> upList) {
		this.upList = upList;
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
