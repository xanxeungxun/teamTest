package com.iei.report.model.vo;

import java.util.ArrayList;

public class ReportPageData {
	private ArrayList<ReportVo> list;
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
	public ReportPageData() {
		super();
	}
	public ReportPageData(ArrayList<ReportVo> list, String pageNavi, int start) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	public ArrayList<ReportVo> getList() {
		return list;
	}
	public void setList(ArrayList<ReportVo> list) {
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
		return "ReportPageData [list=" + list + ", pageNavi=" + pageNavi + ", start=" + start + ", searchValue="
				+ searchValue + ", searchType=" + searchType + "]";
	}

}
