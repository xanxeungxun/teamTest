package com.iei.story.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.iei.book.model.dao.BookDao;
import com.iei.book.model.vo.Book;
import com.iei.story.model.dao.StoryDao;
import com.iei.story.model.vo.Story;
import com.iei.story.model.vo.StoryComment;

import common.JDBCTemplate;

public class StoryService {

	StoryDao dao;
	BookDao bDao;

	public StoryService() {
		super();
		dao = new StoryDao();
		bDao = new BookDao();
	}

	public Story selectOneStory(int storyNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.plusView(conn,storyNo);
		
		Story s = null;
		
		if(result>0) {
			JDBCTemplate.commit(conn);
			s = dao.selectOneStory(conn,storyNo);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return s;
	}

	public int insertStory(int bookNo,Story s) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insetStory(conn,bookNo,s);
		
		if(result==0) {
			JDBCTemplate.rollback(conn);
		}else {
			JDBCTemplate.commit(conn);
		}//story등록성공
		
		return result;
	}

	public Book selectOneBook(int bookNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		Book b = bDao.selectOneBook(conn, bookNo);
		JDBCTemplate.close(conn);
		return b;
	}

	public int deleteStroy(String storyNo) {
		Connection conn = JDBCTemplate.getConnection();
		StringTokenizer sT = new StringTokenizer(storyNo,"/");
		
		int result = 0;
		while(sT.hasMoreTokens()) {
			int no = Integer.parseInt(sT.nextToken());
			result = dao.deleteStory(conn,no);
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int insertStoryComment(int bookNo, int storyNo, String userId, String commentCnt) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = dao.insertStoryComment(conn,bookNo,storyNo,userId,commentCnt);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<StoryComment> selectAllComment(int storyNo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<StoryComment> StoryComment = dao.selectAllComment(conn,storyNo);
		
		JDBCTemplate.close(conn);
		return StoryComment;
	}
	public int insertFavoriteBook(int bookNo, int userNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.selectLikeBook(conn, bookNo, userNo);
		if(result == 0) {
			result = dao.insertFavoriteBook(conn, bookNo, userNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}else {
			JDBCTemplate.close(conn);
			return -1;
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateStoryComment(int storyNo, int bookNo, int storyCommentNo, String storyCommentContent) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateStoryComment(conn,storyNo,bookNo,storyCommentNo, storyCommentContent);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteStoryComment(int storyNo, int bookNo, int storyCommentNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteStoryComment(conn, storyCommentNo,storyNo,bookNo);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}

	public int selectFirstStory(int bookNo) {
		Connection conn = JDBCTemplate.getConnection();
		int storyNo = dao.selectFirstStory(conn,bookNo);
		
		JDBCTemplate.close(conn);
		return storyNo;
	}
	
	
	
}
