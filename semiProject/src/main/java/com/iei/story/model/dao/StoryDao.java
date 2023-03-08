package com.iei.story.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.story.model.vo.Story;
import com.iei.story.model.vo.StoryComment;

import common.JDBCTemplate;

public class StoryDao {

	public Story selectOneStory(Connection conn, int storyNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Story s = null;
		String query = "select * from story where story_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, storyNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				s = new Story();
				
				s.setBookNo(rset.getInt("book_no"));
				s.setReadCount(rset.getInt("read_count"));
				s.setStoryAfter(rset.getString("story_after"));
				s.setStoryContent(rset.getString("story_content"));
				s.setStoryName(rset.getString("story_name"));
				s.setStoryNo(rset.getInt("story_no"));
				s.setStoryTime(rset.getString("story_time"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return s;
	}

	public int insetStory(Connection conn, int bookNo,Story s) {
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

	public int deleteStory(Connection conn, int no) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="delete story where story_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
	}

	public int insertStoryComment(Connection conn, int bookNo, int storyNo, String userId, String commentCnt) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into story_comment values(STORY_COMMENT_SEQ.nextval,?,?,?,?,sysdate,STORY_COMMENT_SEQ.nextval)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, storyNo);
			pstmt.setInt(3, bookNo);
			pstmt.setString(4, commentCnt);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<StoryComment> selectAllComment(Connection conn, int storyNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<StoryComment> StoryComment = new ArrayList<StoryComment>();
		String query = "select * from Story_Comment where story_no=? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, storyNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				StoryComment c = new StoryComment();
				c.setBookNo(rset.getInt("book_no"));
				c.setCommentDate(rset.getString("story_comment_date"));
				c.setStoryCommentContent(rset.getString("story_comment_content"));
				c.setStoryCommentNo(rset.getInt("story_comment_no"));
				c.setStoryCommentRef(rset.getInt("story_comment_ref"));
				c.setStoryNo(rset.getInt("story_no"));
				c.setUserId(rset.getString("user_id"));
				
				StoryComment.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return StoryComment;
	}

	
	
}
