package com.iei.mypage.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.book.model.vo.Book;
import com.iei.mypage.dao.MyPageDao;
import com.iei.mypage.vo.FavBookPageData;
import com.iei.mypage.vo.FavoriteBook;
import com.iei.mypage.vo.SupBookPageData;
import com.iei.mypage.vo.SupportBook;
import com.iei.mypage.vo.UploadBook;
import com.iei.mypage.vo.UploadBookPageData;
import com.iei.user.model.vo.User;

import common.JDBCTemplate;

public class MyPageService {
	
	private MyPageDao dao;

	public MyPageService() {
		super();
		dao = new MyPageDao();
	}
	
	public FavBookPageData selectFavList(int userNo, int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		/*1. 한 페이지당 게시물 수 지정 -> 10개*/
		int numPerPage = 10;
		/*reqPage가 1페이지면 -> 최신글 1~10번
		reqPage가 2페이지면 -> 최신글 11~20번
		reqPage가 3페이지면 -> 최신글 21~30번
		*reqPage : 요청페이지
		ex) reqPage == 4 -> 31~40 
		... 규칙: 4*10 = 40
		*/
		int end = numPerPage * reqPage; //마지막 페이지
		int start = end - numPerPage + 1; //시작 페이지 ... 한 페이지당 시작하는 게시물번호
		
		ArrayList<FavoriteBook> favList = dao.selectFavList(conn, userNo, start, end);
		
		//recv_user_nick 조회
		for(FavoriteBook fb : favList) {
			String writerUserId = fb.getBookWriter();
			String writerUserNick = dao.selectUserNick(conn, writerUserId);
			
			fb.setUserNick(writerUserNick);
		}
		
		/*<페이징 제작 시작>*/
		/*한페이지당 게시물 수 : 10
		총 게시물 수 : 222
		→ 총 23개 페이지 필요*/
		//전체 페이지 수를 계산하려면 -> 먼저 총 게시물 수 조회 필요
		int totalCount = dao.selectFavBookCount(conn, userNo);
		
		//전체 페이지 수 계산
		/*한페이지 당 게시물 수 : 10
		총 게시물 수 80 -> 8페이지 필요
		90 -> 9페이지 필요
		100 -> 10페이지 필요 ...*/
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage; //페이지 개수... 1페이지,2페이지...
		} else { //나머지 있는 경우 ... 1페이지 더 추가
			totalPage = totalCount/numPerPage + 1;
		}
		
		//페이지네비게이션 사이즈
		int pageNaviSize = 5;
		
		//페이지네비게이션 시작번호 = pageNo
		/*reqPage 1~5 : 1 2 3 4 5
		reqPage 6~10 : 6 7 8 9 10
		reqPage 11~15 : 11 12 13 14 15 ...*/
		//int pageNo = reqPage - 2;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		//((reqPage-1)/5)*5 + 1
		/*reqPage 1~5 : 1부터 시작
		reqPage 6~10 : 6부터 시작
		reqPage 11~15 : 11부터 시작*/
		
		//페이지네비게이션 제작 시작
		String pageNavi = "<ul class='pagination circle-style'>";
		
		//이전버튼 
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/myPageFavBookList.do?userNo="+userNo+"&reqPage="+(pageNo-1)+"'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>"; //구글 아이콘 ... <
			pageNavi += "</a></li>";
		}
		
		//페이지 숫자 ... < 1 2 3 4 5 >
		for(int i=0; i<pageNaviSize; i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				//현재 페이지는 active-page 클래스 추가 ... 색 다르게 적용
				pageNavi += "<a class='page-item active-page' href='/myPageFavBookList.do?userNo="+userNo+"&reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			} else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/myPageFavBookList.do?userNo="+userNo+"&reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++; //페이지번호+1 ... 다음페이지
			
			if(pageNo>totalPage) { //페이지번호가 전체페이지수보다 크면 for문 빠져나감
				break;
			}
		}
		
		//다음버튼
		if(pageNo <= totalPage) { //다음버튼이 만들어지는 조건
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/myPageFavBookList.do?userNo="+userNo+"&reqPage="+(pageNo)+"'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>"; //구글 아이콘 ... >
			pageNavi += "</a></li>";
		}
		
		pageNavi += "</ul>";
		
		JDBCTemplate.close(conn);
		FavBookPageData fbpd = new FavBookPageData(favList, pageNavi, start);
		
		return fbpd;
	}
	
	public User selectOneUser(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		
		User u = dao.selectOneUser(conn, userId);
		
		JDBCTemplate.close(conn);
		
		return u;
	}

	public int deleteFavBook(int favBookNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.deleteFavBook(conn, favBookNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	public SupBookPageData selectSupList(int userNo, int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		/*1. 한 페이지당 게시물 수 지정 -> 10개*/
		int numPerPage = 10;
		/*reqPage가 1페이지면 -> 최신글 1~10번
		reqPage가 2페이지면 -> 최신글 11~20번
		reqPage가 3페이지면 -> 최신글 21~30번
		*reqPage : 요청페이지
		ex) reqPage == 4 -> 31~40 
		... 규칙: 4*10 = 40
		*/
		int end = numPerPage * reqPage; //마지막 페이지
		int start = end - numPerPage + 1; //시작 페이지 ... 한 페이지당 시작하는 게시물번호
		
		ArrayList<SupportBook> supList = dao.selectSupList(conn, userNo, start, end);
		
		//recv_user_nick 조회
		for(SupportBook sb : supList) {
			String recvUserId = sb.getBookWriter();
			String recvUserNick = dao.selectUserNick(conn, recvUserId);
			
			sb.setRecvUserNick(recvUserNick);
		}
		
		/*<페이징 제작 시작>*/
		/*한페이지당 게시물 수 : 10
		총 게시물 수 : 222
		→ 총 23개 페이지 필요*/
		//전체 페이지 수를 계산하려면 -> 먼저 총 게시물 수 조회 필요
		int totalCount = dao.selectSupBookCount(conn,userNo);
		
		//전체 페이지 수 계산
		/*한페이지 당 게시물 수 : 10
		총 게시물 수 80 -> 8페이지 필요
		90 -> 9페이지 필요
		100 -> 10페이지 필요 ...*/
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage; //페이지 개수... 1페이지,2페이지...
		} else { //나머지 있는 경우 ... 1페이지 더 추가
			totalPage = totalCount/numPerPage + 1;
		}
		
		//페이지네비게이션 사이즈
		int pageNaviSize = 5;
		
		//페이지네비게이션 시작번호 = pageNo
		/*reqPage 1~5 : 1 2 3 4 5
		reqPage 6~10 : 6 7 8 9 10
		reqPage 11~15 : 11 12 13 14 15 ...*/
		//int pageNo = reqPage - 2;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		//((reqPage-1)/5)*5 + 1
		/*reqPage 1~5 : 1부터 시작
		reqPage 6~10 : 6부터 시작
		reqPage 11~15 : 11부터 시작*/
		
		//페이지네비게이션 제작 시작
		String pageNavi = "<ul class='pagination circle-style'>";
		
		//이전버튼 
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/myPageSupBookList.do?userNo="+userNo+"&reqPage="+(pageNo-1)+"'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>"; //구글 아이콘 ... <
			pageNavi += "</a></li>";
		}
		
		//페이지 숫자 ... < 1 2 3 4 5 >
		for(int i=0; i<pageNaviSize; i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				//현재 페이지는 active-page 클래스 추가 ... 색 다르게 적용
				pageNavi += "<a class='page-item active-page' href='/myPageSupBookList.do?userNo="+userNo+"&reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			} else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/myPageSupBookList.do?userNo="+userNo+"&reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++; //페이지번호+1 ... 다음페이지
			
			if(pageNo>totalPage) { //페이지번호가 전체페이지수보다 크면 for문 빠져나감
				break;
			}
		}
		
		//다음버튼
		if(pageNo <= totalPage) { //다음버튼이 만들어지는 조건
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/myPageSupBookList.do?userNo="+userNo+"&reqPage="+(pageNo)+"'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>"; //구글 아이콘 ... >
			pageNavi += "</a></li>";
		}
		
		pageNavi += "</ul>";
		
		JDBCTemplate.close(conn);
		SupBookPageData sbpd = new SupBookPageData(supList, pageNavi, start);
		
		return sbpd;
	}

	public UploadBookPageData selectUpList(String bookWriter, int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		/*1. 한 페이지당 게시물 수 지정 -> 10개*/
		int numPerPage = 10;
		/*reqPage가 1페이지면 -> 최신글 1~10번
		reqPage가 2페이지면 -> 최신글 11~20번
		reqPage가 3페이지면 -> 최신글 21~30번
		*reqPage : 요청페이지
		ex) reqPage == 4 -> 31~40 
		... 규칙: 4*10 = 40
		*/
		int end = numPerPage * reqPage; //마지막 페이지
		int start = end - numPerPage + 1; //시작 페이지 ... 한 페이지당 시작하는 게시물번호
		
		ArrayList<UploadBook> upList = dao.selectUpList(conn, bookWriter, start, end);
		
		/*<페이징 제작 시작>*/
		/*한페이지당 게시물 수 : 10
		총 게시물 수 : 222
		→ 총 23개 페이지 필요*/
		//전체 페이지 수를 계산하려면 -> 먼저 총 게시물 수 조회 필요
		int totalCount = dao.selectUploadBookCount(conn, bookWriter);
		
		//전체 페이지 수 계산
		/*한페이지 당 게시물 수 : 10
		총 게시물 수 80 -> 8페이지 필요
		90 -> 9페이지 필요
		100 -> 10페이지 필요 ...*/
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage; //페이지 개수... 1페이지,2페이지...
		} else { //나머지 있는 경우 ... 1페이지 더 추가
			totalPage = totalCount/numPerPage + 1;
		}
		
		//페이지네비게이션 사이즈
		int pageNaviSize = 5;
		
		//페이지네비게이션 시작번호 = pageNo
		/*reqPage 1~5 : 1 2 3 4 5
		reqPage 6~10 : 6 7 8 9 10
		reqPage 11~15 : 11 12 13 14 15 ...*/
		//int pageNo = reqPage - 2;
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize + 1;
		//((reqPage-1)/5)*5 + 1
		/*reqPage 1~5 : 1부터 시작
		reqPage 6~10 : 6부터 시작
		reqPage 11~15 : 11부터 시작*/
		
		//페이지네비게이션 제작 시작
		String pageNavi = "<ul class='pagination circle-style'>";
		
		//이전버튼 
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/uploadBookList.do?userId="+bookWriter+"&reqPage="+(pageNo-1)+"'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>"; //구글 아이콘 ... <
			pageNavi += "</a></li>";
		}
		
		//페이지 숫자 ... < 1 2 3 4 5 >
		for(int i=0; i<pageNaviSize; i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				//현재 페이지는 active-page 클래스 추가 ... 색 다르게 적용
				pageNavi += "<a class='page-item active-page' href='/uploadBookList.do?userId="+bookWriter+"&reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			} else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/uploadBookList.do?userId="+bookWriter+"&reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++; //페이지번호+1 ... 다음페이지
			
			if(pageNo>totalPage) { //페이지번호가 전체페이지수보다 크면 for문 빠져나감
				break;
			}
		}
		
		//다음버튼
		if(pageNo <= totalPage) { //다음버튼이 만들어지는 조건
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/uploadBookList.do?userId="+bookWriter+"&reqPage="+(pageNo)+"'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>"; //구글 아이콘 ... >
			pageNavi += "</a></li>";
		}
		
		pageNavi += "</ul>";
		
		JDBCTemplate.close(conn);
		UploadBookPageData ubpd = new UploadBookPageData(upList, pageNavi, start);
		
		return ubpd;
	}

	public Book selectOneBook(int bookNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		Book book = dao.selectOneBook(conn, bookNo);
		
		JDBCTemplate.close(conn);
		
		return book;
	}

	public int updateBook(Book updateBook) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.updateBook(conn, updateBook);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else { 
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	public int deleteUploadBook(int bookNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.deleteUploadBook(conn, bookNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		} else { 
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}



}
