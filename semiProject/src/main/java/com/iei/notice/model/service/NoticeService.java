package com.iei.notice.model.service;

import com.iei.notice.model.dao.NoticeDao;

public class NoticeService {
	private NoticeDao dao;

	public NoticeService() {
		super();
		dao = new NoticeDao();
	}
}
