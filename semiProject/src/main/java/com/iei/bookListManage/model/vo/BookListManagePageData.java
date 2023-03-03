package com.iei.bookListManage.model.vo;

import java.util.ArrayList;

public class BookListManagePageData {
	private ArrayList<BookListManageVo> list;
	private String pageNavi;
	private int start;
	public BookListManagePageData() {
		super();
	}
	public BookListManagePageData(ArrayList<BookListManageVo> list, String pageNavi, int start) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	public ArrayList<BookListManageVo> getList() {
		return list;
	}
	public void setList(ArrayList<BookListManageVo> list) {
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
