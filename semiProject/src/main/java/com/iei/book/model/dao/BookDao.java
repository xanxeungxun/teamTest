package com.iei.book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.book.model.vo.Book;
import com.iei.story.model.vo.Story;

import common.JDBCTemplate;

public class BookDao {

	public ArrayList<Book> seletAllBook(Connection conn,int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		String query = "select * from(select rownum as rnum, (select count(*) as count from story where book_no=n.book_no) as story_count, n.* from(select b.book_no, b.genre_code ,g.genre_name, b.book_title, b.book_writer, u.user_nick, b.book_exp, b.coverpath, case b.book_status when 1 then '연재중' else '완결' end as book_status, b.book_date from genre g, book b, user_tbl u where g.genre_code = b.genre_code and b.BOOK_WRITER = u.USER_id order by 1 desc)n) where rnum between ? and ?";
		
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book b = new Book();
				b.setBookDate(rset.getString("book_date"));
				b.setBookExp(rset.getString("book_exp"));
				b.setBookNo(Integer.parseInt(rset.getString("book_no")));
				b.setBookStatus(rset.getString("book_status"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookWriterId(rset.getString("book_writer"));
				b.setBookWriterNick(rset.getString("user_nick"));
				b.setCoverpath(rset.getString("coverpath"));
				b.setGenreCode(Integer.parseInt(rset.getString("genre_code")));
				b.setGenreName(rset.getString("genre_name"));
				b.setStoryCount(Integer.parseInt(rset.getString("story_count")));
				
				bookList.add(b);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return bookList;
	}

	public int selectBookCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query ="select count(*) as count from book";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int selectBookNo(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int bookNo = 0;
		String query ="select max(book_no)as book_no from book";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				bookNo = rset.getInt("book_no");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return bookNo;
	}
	
	public Book selectOneBook(Connection conn, int bookNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Book b = null;
		String query ="select b.book_no, b.genre_code, g.genre_name, b.book_title, b.book_writer, u.user_nick, b.book_exp, b.coverpath, case b.book_status when 1 then '연재중' else '완결' end as book_status, b.book_date,(select count(*) from story s where b.book_no = s.BOOK_NO) as story_count from genre g, book b, user_tbl u where g.genre_code = b.genre_code and b.BOOK_WRITER = u.USER_id and b.book_no=?";		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				b = new Book();
			
				b.setBookDate(rset.getString("book_date"));
				b.setBookExp(rset.getString("book_exp"));
				b.setBookNo(rset.getInt("book_no"));
				b.setBookStatus(rset.getString("book_status"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookWriterId(rset.getString("book_writer"));
				b.setBookWriterNick(rset.getString("user_nick"));
				b.setCoverpath(rset.getString("coverpath"));
				b.setGenreCode(rset.getInt("genre_code"));
				b.setGenreName(rset.getString("genre_name"));
				b.setStoryCount(rset.getInt("story_count"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return b;
	}

	public ArrayList<Story> selectStoryList(Connection conn, int bookNo) {
		PreparedStatement pstmt = null;
		ArrayList<Story> storyList = new ArrayList<Story>();
		ResultSet rset = null;
		String query ="select rownum, a.* from (select s.STORY_NO, s.BOOK_NO , s.STORY_NAME,s.STORY_CONTENT,s.STORY_AFTER,s.STORY_TIME,s.READ_COUNT from story s, book b where s.book_no = b.BOOK_NO)a where a.book_no = ? order by 1 desc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookNo);
			rset = pstmt.executeQuery();

			while(rset.next()) {
				Story s = new Story();
				s.setBookNo(rset.getInt("book_no"));
				s.setReadCount(rset.getInt("read_count"));
				s.setStoryAfter(rset.getString("story_after"));
				s.setStoryContent(rset.getString("story_content"));
				s.setStoryName(rset.getString("story_name"));
				s.setStoryNo(rset.getInt("story_no"));
				s.setStoryTime(rset.getString("story_time"));
				s.setRownum(rset.getInt("rownum"));
				
				storyList.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return storyList;
	}


	public int insertBook(Connection conn, Book b) {
		PreparedStatement pstmt = null;
		int result=0;
		String query ="insert into book values(BOOK_SEQ.NEXTVAL,?,?,?,?,?,default,sysdate)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getGenreCode());
			pstmt.setString(2, b.getBookTitle());
			pstmt.setString(3, b.getBookWriterId());
			pstmt.setString(4, b.getBookExp());
			pstmt.setString(5, b.getCoverpath());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertStory(Connection conn, int bookNo, Story s) {
		PreparedStatement pstmt = null;
		int result=0;
		String query ="insert into story values(story_SEQ.NEXTVAL,?,?,?,sysdate,default,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookNo);
			pstmt.setString(2, s.getStoryName());
			pstmt.setString(3, s.getStoryAfter());
			pstmt.setString(4, s.getStoryContent());
			
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	public int updateEndBook(Connection conn, int bookNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update book set book_status=2 where book_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}


	//검색창(승훈)
	public ArrayList<Book> selectSearchBook(Connection conn, String searchKeyword, int end, int begin) {

		PreparedStatement pstmt = null;
		ArrayList<Book> searchList = new ArrayList<Book>();
		ResultSet rset = null;
		//String query = "select book_title from book where book_title like ?";
		String query = "select * from(select rownum as rnum, (select count(*) as count from story where book_no=n.book_no) as story_count, n.* from(select b.book_no, b.genre_code ,g.genre_name, b.book_title, b.book_writer, u.user_nick, b.book_exp, b.coverpath, case b.book_status when 1 then '연재중' else '완결' end as book_status, b.book_date from genre g, book b, user_tbl u where g.genre_code = b.genre_code and b.BOOK_WRITER = u.USER_id and b.book_title like ? order by 1 desc)n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setInt(2, begin);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()){
				Book b = new Book();
				b.setBookDate(rset.getString("book_date"));
				b.setBookExp(rset.getString("book_exp"));
				b.setBookNo(Integer.parseInt(rset.getString("book_no")));
				b.setBookStatus(rset.getString("book_status"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookWriterId(rset.getString("book_writer"));
				b.setBookWriterNick(rset.getString("user_nick"));
				b.setCoverpath(rset.getString("coverpath"));
				b.setGenreCode(Integer.parseInt(rset.getString("genre_code")));
				b.setGenreName(rset.getString("genre_name"));
				b.setStoryCount(Integer.parseInt(rset.getString("story_count")));
				
				searchList.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return searchList;
	}
	public int selectSearchBookCount(Connection conn, String searchKeyword) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query ="select count(book_title) as count from book where book_title like ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result = rset.getInt("count");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Book> mainViewBook(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> viewList = new ArrayList<Book>();
		String query="SELECT *FROM (SELECT ROWNUM AS rnum, (SELECT COUNT(*) AS count FROM story WHERE book_no=n.book_no) AS story_count, n.*FROM (SELECT b.book_no, b.genre_code, g.genre_name, b.book_title, b.book_writer, u.user_nick, b.book_exp, b.coverpath, CASE b.book_status WHEN 1 THEN '연재중' ELSE '완결' END AS book_status, b.book_date FROM genre g, book b, user_tbl u WHERE g.genre_code = b.genre_code AND b.BOOK_WRITER = u.USER_id ORDER BY 1 DESC)n WHERE ROWNUM <= 6) WHERE rnum >= 1";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book b = new Book();
				b.setBookDate(rset.getString("book_date"));
				b.setBookExp(rset.getString("book_exp"));
				b.setBookNo(Integer.parseInt(rset.getString("book_no")));
				b.setBookStatus(rset.getString("book_status"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookWriterId(rset.getString("book_writer"));
				b.setBookWriterNick(rset.getString("user_nick"));
				b.setCoverpath(rset.getString("coverpath"));
				b.setGenreCode(Integer.parseInt(rset.getString("genre_code")));
				b.setGenreName(rset.getString("genre_name"));
				b.setStoryCount(Integer.parseInt(rset.getString("story_count")));
				
				viewList.add(b);
			
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return viewList;
	}

	public ArrayList<Book> mainViewBook2(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Book> viewList2 = new ArrayList<Book>();
		String query="SELECT *FROM (SELECT ROWNUM AS rnum, (SELECT COUNT(*) AS count FROM story WHERE book_no=n.book_no) AS story_count, n.*FROM (SELECT b.book_no, b.genre_code, g.genre_name, b.book_title, b.book_writer, u.user_nick, b.book_exp, b.coverpath, CASE b.book_status WHEN 1 THEN '연재중' ELSE '완결' END AS book_status, b.book_date FROM genre g, book b, user_tbl u WHERE g.genre_code = b.genre_code AND b.BOOK_WRITER = u.USER_id ORDER BY 1 )n WHERE ROWNUM <= 6) WHERE rnum >= 3";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Book b2 = new Book();
				b2.setBookDate(rset.getString("book_date"));
				b2.setBookExp(rset.getString("book_exp"));
				b2.setBookNo(Integer.parseInt(rset.getString("book_no")));
				b2.setBookStatus(rset.getString("book_status"));
				b2.setBookTitle(rset.getString("book_title"));
				b2.setBookWriterId(rset.getString("book_writer"));
				b2.setBookWriterNick(rset.getString("user_nick"));
				b2.setCoverpath(rset.getString("coverpath"));
				b2.setGenreCode(Integer.parseInt(rset.getString("genre_code")));
				b2.setGenreName(rset.getString("genre_name"));
				b2.setStoryCount(Integer.parseInt(rset.getString("story_count")));
				
				viewList2.add(b2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return viewList2;
	}

	public ArrayList<Book> selectGenreBook(Connection conn, int selectGenreCode, int start, int end) {
		PreparedStatement pstmt = null;
		ArrayList<Book> genreList = new ArrayList<Book>();
		ResultSet rset = null;
		//String query = "select book_title from book where book_title like ?";
		String query = "select * from(select rownum as rnum, (select count(*) as count from story where book_no=n.book_no) as story_count, n.* from(select b.book_no, b.genre_code ,g.genre_name, b.book_title, b.book_writer, u.user_nick, b.book_exp, b.coverpath, case b.book_status when 1 then '연재중' else '완결' end as book_status, b.book_date from genre g, book b, user_tbl u where b.genre_code = ? order by 1 desc)n) where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, selectGenreCode);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()){
				Book b = new Book();
				b.setBookDate(rset.getString("book_date"));
				b.setBookExp(rset.getString("book_exp"));
				b.setBookNo(Integer.parseInt(rset.getString("book_no")));
				b.setBookStatus(rset.getString("book_status"));
				b.setBookTitle(rset.getString("book_title"));
				b.setBookWriterId(rset.getString("book_writer"));
				b.setBookWriterNick(rset.getString("user_nick"));
				b.setCoverpath(rset.getString("coverpath"));
				b.setGenreCode(Integer.parseInt(rset.getString("genre_code")));
				b.setGenreName(rset.getString("genre_name"));
				b.setStoryCount(Integer.parseInt(rset.getString("story_count")));
				
				genreList.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return genreList;
	}



	

	

	
	
}//BookDao
