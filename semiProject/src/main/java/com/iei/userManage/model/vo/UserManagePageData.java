package com.iei.userManage.model.vo;

import java.util.ArrayList;

public class UserManagePageData {
	private ArrayList<UserManageVo> list;
	private String pageNavi;
	private int start;
	public UserManagePageData() {
		super();
	}
	public UserManagePageData(ArrayList<UserManageVo> list, String pageNavi, int start) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	public ArrayList<UserManageVo> getList() {
		return list;
	}
	public void setList(ArrayList<UserManageVo> list) {
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
