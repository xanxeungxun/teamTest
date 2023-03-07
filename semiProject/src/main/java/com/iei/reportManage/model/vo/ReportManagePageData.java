package com.iei.reportManage.model.vo;

import java.util.ArrayList;

public class ReportManagePageData {
	private ArrayList<ReportManageVo> list;
	private String pageNavi;
	private int start;
	public ReportManagePageData() {
		super();
	}
	public ReportManagePageData(ArrayList<ReportManageVo> list, String pageNavi, int start) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	public ArrayList<ReportManageVo> getList() {
		return list;
	}
	public void setList(ArrayList<ReportManageVo> list) {
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
