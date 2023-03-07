package com.iei.book.model.vo;

import java.util.ArrayList;

public class SearchPageData {

		private ArrayList<Book> searchList;
		private String pageNavi;
		private int begin;
		
		public SearchPageData() {
			super();
			// TODO Auto-generated constructor stub
		}

		public SearchPageData(ArrayList<Book> searchList, String pageNavi, int begin) {
			super();
			this.searchList = searchList;
			this.pageNavi = pageNavi;
			this.begin = begin;
		}

		public ArrayList<Book> getSearchList() {
			return searchList;
		}

		public void setList(ArrayList<Book> searchList) {
			this.searchList = searchList;
		}

		public String getPageNavi() {
			return pageNavi;
		}

		public void setPageNavi(String pageNavi) {
			this.pageNavi = pageNavi;
		}

		public int getBegin() {
			return begin;
		}

		public void setBegin(int begin) {
			this.begin = begin;
		}
		
		
		
}
