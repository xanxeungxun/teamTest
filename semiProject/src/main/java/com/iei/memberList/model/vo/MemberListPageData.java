package com.iei.memberList.model.vo;

import java.util.ArrayList;

public class MemberListPageData {
	private ArrayList<MemberList> list;
	private String pageNavi;
	private int start;
	public MemberListPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberListPageData(ArrayList<MemberList> list, String pageNavi, int start) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	public ArrayList<MemberList> getList() {
		return list;
	}
	public void setList(ArrayList<MemberList> list) {
		this.list = list;
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
