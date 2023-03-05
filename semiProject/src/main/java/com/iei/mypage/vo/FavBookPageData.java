package com.iei.mypage.vo;

import java.util.ArrayList;

public class FavBookPageData {
	private ArrayList<FavoriteBook> favList;
	private String pageNavi;
	private int start;
	
	
	public FavBookPageData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FavBookPageData(ArrayList<FavoriteBook> favList, String pageNavi, int start) {
		super();
		this.favList = favList;
		this.pageNavi = pageNavi;
		this.start = start;
	}
	
	
	public ArrayList<FavoriteBook> getFavList() {
		return favList;
	}
	public void setFavList(ArrayList<FavoriteBook> favList) {
		this.favList = favList;
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
