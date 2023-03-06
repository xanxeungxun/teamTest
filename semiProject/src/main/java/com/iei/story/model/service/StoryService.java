package com.iei.story.model.service;

import java.sql.Connection;

import com.iei.story.model.dao.StoryDao;
import com.iei.story.model.vo.Story;

import common.JDBCTemplate;

public class StoryService {

	StoryDao dao;

	public StoryService() {
		super();
		dao = new StoryDao();
	}

	public Story selectOneStory(int storyNo) {
		Connection conn = JDBCTemplate.getConnection();
		
		Story s = dao.selectOneStory(conn,storyNo);
		
		JDBCTemplate.close(conn);
		return s;
	}
	
	
	
}
