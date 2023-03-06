package com.iei.userManage.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.iei.userManage.model.dao.UserManageDao;
import com.iei.userManage.model.vo.UserManagePageData;
import com.iei.userManage.model.vo.UserManageVo;

import common.JDBCTemplate;

public class UserManageService {
	private UserManageDao dao;

	public UserManageService() {
		super();
		dao = new UserManageDao();
	}
	
	
	// 회원 전체 목록 확인
	public UserManagePageData selectAllUserManageList(int reqPage){
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;
		//reqPage가 1 페이지면 => 최신글 1~10번
		//reqPage가 2 페이지면 => 최신글 11~20번
		//reqPage가 3 페이지면 => 최신글 21~30번
		//reqPage == 4 -> 31~40
		int end = numPerPage*reqPage;
		int start = end - numPerPage + 1;
		ArrayList<UserManageVo> list = dao.selectAllUserManageList(conn,start,end);
		//페이징제작 시작
		//전체페이지 수를 계산 -> 총 게시물 수를 조회
		int totalCount = dao.selectUserManageCount(conn);
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
		pageNavi += "<a class='page-item' href='/userManage/userManageList.do?reqPage="+(pageNo-1)+"'>";
		pageNavi += "<span class='material-icons'>chevron_left</span>";
		pageNavi += "</a></li>";
		}
		//페이지 숫자
		for(int i=0;i<pageNaviSize;i++) {
		if(pageNo == reqPage) {
		pageNavi += "<li>";
		pageNavi += "<a class='page-item active-page' href='/userManage/userManageList.do?reqPage="+(pageNo)+"'>";
		pageNavi += pageNo;
		pageNavi += "</a></li>";
		}else {
		pageNavi += "<li>";
		pageNavi += "<a class='page-item' href='/userManage/userManageList.do?reqPage="+(pageNo)+"'>";
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
		pageNavi += "<a class='page-item' href='/userManage/userManageList.do?reqPage="+(pageNo)+"'>";
		pageNavi += "<span class='material-icons'>chevron_right</span>";
		pageNavi += "</a></li>";
		}
		pageNavi += "</ul>";
		JDBCTemplate.close(conn);
		UserManagePageData npd = new UserManagePageData(list, pageNavi, start);
		return npd;
		
	}
	
	
	// 작품 상세 보기
	public UserManageVo selectOneUserManage(String userManageNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		UserManageVo result = dao.selectOneUserManage(conn, userManageNo);
		JDBCTemplate.close(conn);

		return result;
	}


	public int blockUser(String blockUser) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.blockUser(conn, blockUser);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}





	public int changeUserLevel(int no, int level) {
		Connection conn = JDBCTemplate.getConnection();
		int result = dao.changeUserLevel(conn,no,level);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	


}
