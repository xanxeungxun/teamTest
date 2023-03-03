package com.iei.bookListManage.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.bookListManage.model.dao.BookListManageDao;
import com.iei.bookListManage.model.vo.BookListManagePageData;
import com.iei.bookListManage.model.vo.BookListManageVo;

import common.JDBCTemplate;

public class BookListManageService {
	private BookListManageDao dao;

	public BookListManageService() {
		super();
		dao = new BookListManageDao();
	}
	
	
	// 문의 전체 목록 확인
	public BookListManagePageData selectAllBookListManageList(int reqPage){
		
		Connection conn = JDBCTemplate.getConnection();
		
		int numPerPage = 10;
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		
		ArrayList<BookListManageVo> list = dao.selectAllBookListManageList(conn,start,end);
		int totalCount = dao.selectBookListManageCount(conn);
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage + 1;
		}
		int pageNaviSize = 5;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize +1;
		String pageNavi = "<ul class='pagination circle-style'>";
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/bookListManage/bookListManageList.do?reqPage="+(pageNo-1)+"'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/bookListManage/bookListManageList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/bookListManage/bookListManageList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		if(pageNo <= totalPage) {
			pageNavi += "<hr>";
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/bookListManage/bookListManageList.do?reqPage="+(pageNo)+"'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		JDBCTemplate.close(conn);
		BookListManagePageData npd = new BookListManagePageData(list, pageNavi, start);
		return npd;
	}
	
	
	// 작품 상세 보기
	public BookListManageVo selectOneBookListManage(String bookListManageNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		BookListManageVo result = dao.selectOneBookListManage(conn, bookListManageNo);
		JDBCTemplate.close(conn);

		return result;
	}
	


}
