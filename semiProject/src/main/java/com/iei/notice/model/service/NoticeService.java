package com.iei.notice.model.service;

import java.sql.Connection;

import com.iei.notice.model.dao.NoticeDao;
import com.iei.notice.model.vo.Notice;
import com.iei.notice.model.vo.NoticePageData;

import common.JDBCTemplate;

public class NoticeService {
	private NoticeDao dao;

	public NoticeService() {
		super();
		dao = new NoticeDao();
	}

	public int insertNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertNotice(conn, n);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public NoticePageData selectNoticeList() {
		return null;
	}
}
