package com.iei.question.model.vo;

import java.util.ArrayList;

public class QuestionPageData {
	private ArrayList<QuestionVo> list;
	private String pageNavi;
	private int start;
	private String searchValue;
	private String searchType;
	
	
	public String getSearchValue() {
		return searchValue;
	}
	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public QuestionPageData() {
		super();
	}
	public QuestionPageData(ArrayList<QuestionVo> list, String pageNavi, int start) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	public ArrayList<QuestionVo> getList() {
		return list;
	}
	public void setList(ArrayList<QuestionVo> list) {
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
	@Override
	public String toString() {
		return "QuestionPageData [list=" + list + ", pageNavi=" + pageNavi + ", start=" + start + ", searchValue="
				+ searchValue + ", searchType=" + searchType + "]";
	}
	
	

}
