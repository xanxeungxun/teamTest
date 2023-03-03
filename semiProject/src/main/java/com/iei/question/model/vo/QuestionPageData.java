package com.iei.question.model.vo;

import java.util.ArrayList;

public class QuestionPageData {
	private ArrayList<QuestionVo> list;
	private String pageNavi;
	private int start;
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
	
	

}
