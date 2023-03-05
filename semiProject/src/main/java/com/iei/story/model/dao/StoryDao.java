package com.iei.story.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iei.story.model.vo.Story;

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

	
	
}
