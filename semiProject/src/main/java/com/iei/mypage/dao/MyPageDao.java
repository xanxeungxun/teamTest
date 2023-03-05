package com.iei.mypage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.mypage.vo.FavoriteBook;
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
	
}
