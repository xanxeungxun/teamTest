package com.iei.book.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.iei.book.model.dao.BookDao;
import com.iei.book.model.vo.Book;
import com.iei.book.model.vo.BookListData;
import com.iei.book.model.vo.SearchPageData;
import com.iei.story.model.vo.Story;

import common.JDBCTemplate;

public class BookService {

	BookDao dao;

	public BookService() {
		super();
		dao = new BookDao();
	}

	public BookListData selectAllBook(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		int numPerPage = 10; //한 페이지당 보여줄 작품 개수
		
		//end : 해당 페이지(reqPage)에서 보여줄 작품의 마지막 번호
		//start : 해당 페이지(reqPage)보여줄 작품의 시작 번호
		int end = numPerPage * reqPage; // 보여줄작품개수*요청페이지
		int start = (end - numPerPage) + 1;
		ArrayList<Book> bookList = dao.seletAllBook(conn,start,end);
		
		//페이징 제작
		//필요한 전체 페이지수 구하기 <-- 일단 전체 작품 수 알아야함
		int totalCount = dao.selectBookCount(conn); //전체 작품수
		int totalPage = (int) Math.ceil((double)totalCount/numPerPage); //네비게이터 전체 페이지수
		int naviSize = 5;
		int naviStart = ( ((reqPage-1)/naviSize) * naviSize )+1;
		//↑내가 5번페이지가 보고싶으면, navi시작번호는 1번임, 6페이지부터 5임
		// 그래서 (0 * 5)+1 = 1나와야함  
		String naviCode = "<ul class='pagination circle-style'>";
		if(naviStart != 1) {//네비시작숫자가 1이상(5,11,16...)생겨야함
			naviCode += "<li>";
			naviCode += "<a class='page-item' href='/bookList.do?reqPage="+(naviStart-1)+"'>";
			naviCode += "<span class='material-icons'>chevron_left";
			naviCode += "</span></a></li>";
		}
		for(int i=0 ; i<naviSize ; i++) {
			if(naviStart == reqPage) { //요청한 페이지가 1,6,11..일때
				naviCode += "<li>";
				naviCode += "<a class='page-item active-page' href='/bookList.do?reqPage="+naviStart+"'>";
				naviCode += naviStart;
				naviCode += "</a></li>";
			}else {
				naviCode += "<li>";
				naviCode += "<a class='page-item' href='/bookList.do?reqPage="+naviStart+"'>";
				naviCode += naviStart;
				naviCode += "</a></li>";
			}
			naviStart++;
			if(totalPage < naviStart) {
				break;
			}
		}//숫자넣기for문
		if(naviStart <= totalPage) {
			naviCode += "<li>";
			naviCode += "<a class='page-item' href='/bookList.do?reqPage="+(naviStart)+"'>";
			naviCode += "<span class='material-icons'>chevron_right";
			naviCode += "</span></a></li>";
		}
		naviCode += "</ul>";
		

		JDBCTemplate.close(conn);
		
		BookListData bld = new BookListData(bookList, naviCode, start);
		return bld;
	}

	public Book selectOneBook(int bookNo) {
		Connection conn = JDBCTemplate.getConnection();
		Book b = dao.selectOneBook(conn,bookNo);
		
		JDBCTemplate.close(conn);
		return b;
	}

	public ArrayList<Story> selectStoryList(int bookNo) {
		// 해당 작품이 가지고 있는 Story의 목록을 뽑아주는 서비스
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Story> storyList = dao.selectStoryList(conn,bookNo);
		JDBCTemplate.close(conn);
		return storyList;
	}
	
	public int insertBook(Book b, Story s) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.insertBook(conn,b);
		if(result==0) {
			JDBCTemplate.rollback(conn);
		}else {
			int bookNo = dao.selectBookNo(conn);
			result = dao.insertStory(conn,bookNo,s);
				if(result==0) {
					JDBCTemplate.rollback(conn);
				}else {
					JDBCTemplate.commit(conn);
				}//story등록성공
		}//book등록성공
		
		return result;
	}
	public int updateEndBook(int bookNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateEndBook(conn,bookNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		return result;
	}

	
	
	
	//검색창(승훈)
	public SearchPageData selectSearchBook(String searchKeyword, int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10; //한 페이지당 보여줄 작품 개수
		
		//end : 해당 페이지(reqPage)에서 보여줄 작품의 마지막 번호
		//begin : 해당 페이지(reqPage)보여줄 작품의 시작 번호
		int end = numPerPage * reqPage; // 보여줄작품개수*요청페이지
		int begin = (end - numPerPage) + 1;
		ArrayList<Book> searchList = dao.selectSearchBook(conn,searchKeyword, end, begin);
		
		// 페이징 제작
		// 필요한 전체 페이지수 구하기 <-- 일단 전체 작품 수 알아야함
		int searchCount = dao.selectSearchBookCount(conn,searchKeyword); // 전체 작품수
		int searchPage = (int) Math.ceil((double) searchCount / numPerPage); // 네비게이터 전체 페이지수
		int naviSize = 5;
		int naviStart = (((reqPage - 1) / naviSize) * naviSize) + 1;
		// ↑내가 5번페이지가 보고싶으면, navi시작번호는 1번임, 6페이지부터 5임
		// 그래서 (0 * 5)+1 = 1나와야함
		String naviCode = "<ul class='pagination circle-style'>";
		if (naviStart != 1) {// 네비시작숫자가 1이상(5,11,16...)생겨야함
			naviCode += "<li>";
			naviCode += "<a class='page-item' href='/search.do?reqPage=" + (naviStart - 1) + "&searchKeyword=" + searchKeyword + "'>";
			naviCode += "<span class='material-icons'>chevron_left";
			naviCode += "</span></a></li>";
		}
		for (int i = 0; i < naviSize; i++) {
			if (naviStart == reqPage) { // 요청한 페이지가 1,6,11..일때
				naviCode += "<li>";
				naviCode += "<a class='page-item active-page' href='/search.do?reqPage=" + naviStart + "&searchKeyword=" + searchKeyword + "'>";
				naviCode += naviStart;
				naviCode += "</a></li>";
			} else {
				naviCode += "<li>";
				naviCode += "<a class='page-item' href='/search.do?reqPage=" + naviStart + "&searchKeyword=" + searchKeyword + "'>";
				naviCode += naviStart;
				naviCode += "</a></li>";
			}
			naviStart++;
			if (searchPage < naviStart) {
				break;
			}
		} // 숫자넣기for문
		if (naviStart <= searchPage) {
			naviCode += "<li>";
			naviCode += "<a class='page-item' href='/search.do?reqPage=" + (naviStart) + "&searchKeyword=" + searchKeyword + "'>";
			naviCode += "<span class='material-icons'>chevron_right";
			naviCode += "</span></a></li>";
		}
		naviCode += "</ul>";

		JDBCTemplate.close(conn);

		SearchPageData spd = new SearchPageData(searchList, naviCode, begin);
		return spd;
		
	}

	public ArrayList<Book> mainViewBook() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> viewList = dao.mainViewBook(conn);
		JDBCTemplate.close(conn);
		return viewList;
	}
	public ArrayList<Book> mainViewBook2() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Book> viewList2 = dao.mainViewBook2(conn);
		JDBCTemplate.close(conn);
		return viewList2;
	}

	public BookListData selectGenreBook(int selectGenreCode, int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		int numPerPage = 10; //한 페이지당 보여줄 작품 개수
		
		//end : 해당 페이지(reqPage)에서 보여줄 작품의 마지막 번호
		//start : 해당 페이지(reqPage)보여줄 작품의 시작 번호
		int end = numPerPage * reqPage; // 보여줄작품개수*요청페이지
		int start = (end - numPerPage) + 1;
		ArrayList<Book> genreList = dao.selectGenreBook(conn,selectGenreCode,start,end);
		
		
		//페이징 제작
		//필요한 전체 페이지수 구하기 <-- 일단 전체 작품 수 알아야함
		int totalCount = dao.selectBookCount(conn); //전체 작품수
		int totalPage = (int) Math.ceil((double)totalCount/numPerPage); //네비게이터 전체 페이지수
		int naviSize = 5;
		int naviStart = ( ((reqPage-1)/naviSize) * naviSize )+1;
		//↑내가 5번페이지가 보고싶으면, navi시작번호는 1번임, 6페이지부터 5임
		// 그래서 (0 * 5)+1 = 1나와야함  
		String naviCode = "<ul class='pagination circle-style'>";
		if(naviStart != 1) {//네비시작숫자가 1이상(5,11,16...)생겨야함
			naviCode += "<li>";
			naviCode += "<a class='page-item' href='/selectGenre.do?reqPage="+(naviStart-1)+"'>";
			naviCode += "<span class='material-icons'>chevron_left";
			naviCode += "</span></a></li>";
		}
		for(int i=0 ; i<naviSize ; i++) {
			if(naviStart == reqPage) { //요청한 페이지가 1,6,11..일때
				naviCode += "<li>";
				naviCode += "<a class='page-item active-page' href='/selectGenre.do?reqPage="+naviStart+"'>";
				naviCode += naviStart;
				naviCode += "</a></li>";
			}else {
				naviCode += "<li>";
				naviCode += "<a class='page-item' href='/selectGenre.do?reqPage="+naviStart+"'>";
				naviCode += naviStart;
				naviCode += "</a></li>";
			}
			naviStart++;
			if(totalPage < naviStart) {
				break;
			}
		}//숫자넣기for문
		if(naviStart <= totalPage) {
			naviCode += "<li>";
			naviCode += "<a class='page-item' href='/selectGenre.do?reqPage="+(naviStart)+"'>";
			naviCode += "<span class='material-icons'>chevron_right";
			naviCode += "</span></a></li>";
		}
		naviCode += "</ul>";
		

		JDBCTemplate.close(conn);
		
		BookListData bld = new BookListData(genreList, naviCode, start);
		return bld;
	}

	public int selectScore(int bookNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int score = dao.selectScore(conn,bookNo);
		JDBCTemplate.close(conn);
		return score;
	}


	
		

	

	
	
	
	
	
	
	
}
