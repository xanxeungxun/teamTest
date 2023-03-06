package com.iei.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.mypage.vo.FavoriteBook;
import com.iei.mypage.vo.SupportBook;
import com.iei.mypage.vo.UploadBook;
import com.iei.user.model.vo.User;

import common.JDBCTemplate;

public class MyPageDao {

	public ArrayList<FavoriteBook> selectFavList(Connection conn, int userNo, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<FavoriteBook> favList = new ArrayList<>();
		
		String query = "select * from (select rownum as rnum, fb.* from (select fav_book_no, book_no, genre_code, genre_name, book_title, book_writer, coverpath, book_date from favorite_book join book using(book_no) join genre using(genre_code) where user_no=? order by 1 desc) fb) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				FavoriteBook fb = new FavoriteBook();
				
				fb.setFavBookNo(rset.getInt("fav_book_no"));
				fb.setBookNo(rset.getInt("book_no"));
				fb.setGenreCode(rset.getInt("genre_code"));
				fb.setGenreName(rset.getString("genre_name"));
				fb.setBookTitle(rset.getString("book_title"));
				fb.setBookWriter(rset.getString("book_writer"));
				fb.setCoverPath(rset.getString("coverpath"));
				fb.setBookDate(rset.getString("book_date"));
				
				favList.add(fb);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return favList;
	}
	
	public User selectOneUser(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		User u = null;
		
		String query = "select * from user_tbl where user_id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				u = new User();
				
				u.setUserEnroll(rset.getString("user_enroll"));
				u.setUserId(rset.getString("user_id"));
				u.setUserLevel(rset.getInt("user_level"));
				u.setUserName(rset.getString("user_name"));
				u.setUserNick(rset.getString("user_nick"));
				u.setUserNo(rset.getInt("user_no"));
				u.setUserPhone(rset.getString("user_phone"));
				u.setUserPic(rset.getString("user_pic"));
				u.setUserPoint(rset.getInt("user_point"));
				u.setUserPw(rset.getString("user_pw"));
				u.setUserEmail(rset.getString("user_email"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return u;
	}

	public int deleteFavBook(Connection conn, int favBookNo) {
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		String query = "delete from favorite_book where fav_book_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, favBookNo);
			
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int selectFavBookCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = "select count(*) as cnt from favorite_book"; //별칭 : cnt
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return totalCount;
	}

	public ArrayList<SupportBook> selectSupList(Connection conn, int userNo, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<SupportBook> supList = new ArrayList<>();
		
		String query = "select * from (select rownum as rnum, sb.* from (select support_no, book_no, total_support_money, genre_code, genre_name, book_title, book_writer, coverpath, book_date from support_book join book using(book_no) join genre using(genre_code) where user_no=? order by 1 desc) sb) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				SupportBook sb = new SupportBook();
				
				sb.setSupportNo(rset.getInt("support_no"));
				sb.setBookNo(rset.getInt("book_no"));
				sb.setGenreCode(rset.getInt("genre_code"));
				sb.setGenreName(rset.getString("genre_name"));
				sb.setBookTitle(rset.getString("book_title"));
				sb.setBookWriter(rset.getString("book_writer"));
				sb.setCoverPath(rset.getString("coverpath"));
				sb.setBookDate(rset.getString("book_date"));
				sb.setTotalSupportMoney(rset.getInt("total_support_money"));
				
				supList.add(sb);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return supList;
	}

	public int selectSupBookCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int totalCount = 0;
		
		String query = "select count(*) as cnt from support_book"; //별칭 : cnt
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				totalCount = rset.getInt("cnt");
				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return totalCount;
	}

	public ArrayList<UploadBook> selectUpList(Connection conn, String bookWriter, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<UploadBook> upList = new ArrayList<>();
		
		String query = "select * from (select rownum as rnum, ub.* from (select book_no, genre_code, genre_name, book_title, book_writer, coverpath, book_date from book join genre using(genre_code) where book_writer=? order by 1 desc) ub) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bookWriter);
			pstmt.setInt(1, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				UploadBook ub = new UploadBook();
				ub.setBookNo(rset.getInt("book_no"));
				ub.setGenreCode(rset.getInt("genre_code"));
				ub.setGenreName(rset.getString("genre_name"));
				ub.setBookTitle(rset.getString("book_title"));
				ub.setBookWriter(rset.getString("book_writer"));
				ub.setCoverPath(rset.getString("coverpath"));
				ub.setBookDate(rset.getString("book_date"));
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
