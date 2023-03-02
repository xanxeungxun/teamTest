package kr.or.iei.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.notice.model.dao.NoticeDao;
import kr.or.iei.notice.model.vo.Notice;
import kr.or.iei.notice.model.vo.NoticeComment;
import kr.or.iei.notice.model.vo.NoticePageData;
import kr.or.iei.notice.model.vo.NoticeViewData;

public class NoticeService {
	private NoticeDao dao;

	public NoticeService() {
		super();
		dao = new NoticeDao();
		// TODO Auto-generated constructor stub
	}

	public int insertNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertNotice(conn,n);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public NoticePageData selectNoticeList(int reqPage) {
		//reqPage  를 주어서 몇번째 페이지를 주라고 요청할것임.
		Connection conn = JDBCTemplate.getConnection();
		//1. 한 페이지당 게시물 수 지정 -> 1페이지당 게시물 10개를 보여줄 것임.
		int numPerPage = 10;
		//reqPage가 1 페이지면 => 최신글 1~10번
		//reqPage가 2 페이지면 => 최신글 11~20번
		//reqPage가 3 페이지면 => 최신글 21~30번
		//reqPage == 4 -> 31~40
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		ArrayList<Notice> list = dao.selectNoticeList(conn,start,end);
		//페이징제작 시작
		//전체페이지 수를 계산 -> 총 게시물 수를 조회
		int totalCount = dao.selectNoticeCount(conn);
		//전체 페이지 수 계산
		int totalPage = 0;
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage + 1;
		}
		//네이게이션 사이즈
		int pageNaviSize = 5;
		//페이지 네비게이션 시작번호
		//reqPage  1 ~ 5  : 1 2 3 4 5
		//reqPage  6 ~ 10 : 6 7 8 9 10
		//reqPage 11 ~ 15 : 11 12 13 14 15
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize +1;
		//페이지 네이게이션 제작 시작
		String pageNavi = "<ul class='pagination circle-style'>";
		//이전버튼
		if(pageNo != 1) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/noticeList.do?reqPage="+(pageNo-1)+"'>";
			pageNavi += "<span class='material-icons'>chevron_left</span>";
			pageNavi += "</a></li>";
		}
		//페이지 숫자
		for(int i=0;i<pageNaviSize;i++) {
			if(pageNo == reqPage) {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item active-page' href='/noticeList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}else {
				pageNavi += "<li>";
				pageNavi += "<a class='page-item' href='/noticeList.do?reqPage="+(pageNo)+"'>";
				pageNavi += pageNo;
				pageNavi += "</a></li>";
			}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		//다음버튼
		if(pageNo <= totalPage) {
			pageNavi += "<li>";
			pageNavi += "<a class='page-item' href='/noticeList.do?reqPage="+(pageNo)+"'>";
			pageNavi += "<span class='material-icons'>chevron_right</span>";
			pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		JDBCTemplate.close(conn);
		NoticePageData npd = new NoticePageData(list, pageNavi, start);
		return npd;
	}

	public NoticeViewData selectOneNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateReadCount(conn,noticeNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
			Notice n = dao.selectOneNotice(conn,noticeNo); 
			//1 - 일반 댓글 조회
			ArrayList<NoticeComment> commentList
			= dao.selectNotcieComment(conn,noticeNo);
			//2 - 대댓글 조회
			ArrayList<NoticeComment> reCommentList
			= dao.selectRecommentList(conn,noticeNo);
			NoticeViewData nvd = new NoticeViewData(n,commentList,reCommentList);
			
			
			JDBCTemplate.close(conn);
			return nvd;
		}else {
			JDBCTemplate.rollback(conn);
			JDBCTemplate.close(conn);
			return null;
		}
		
	
	}

	public Notice getNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice n = dao.selectOneNotice(conn, noticeNo);
		JDBCTemplate.close(conn);
		return n;
	}

	public Notice deleteNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice n = dao.selectOneNotice(conn, noticeNo);
		int result = dao.deleteNotice(conn, noticeNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
			n = null;
		}
		JDBCTemplate.close(conn);
		
		return n;
	}

	public int updateNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateNotice(conn,n);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertNoticeComment(NoticeComment nc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.insertNoticeComment(conn,nc);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateNoticeComment(NoticeComment nc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.updateNoticeComment(conn, nc);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteNoticeComment(int ncNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.deleteNoticeComment(conn, ncNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	
	

}
