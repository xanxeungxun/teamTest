package com.iei.report.model.vo;

import java.util.ArrayList;

public class ReportPageData {
	private ArrayList<ReportVo> list;
	private String pageNavi;
	private int start;
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
	
	

}
