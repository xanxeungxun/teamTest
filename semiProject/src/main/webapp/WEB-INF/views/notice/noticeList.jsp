<%@page import="java.util.ArrayList"%>
<%@page import="com.iei.notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
    	String pageNavi = (String)request.getAttribute("pageNavi");
    	int start = (int)request.getAttribute("start");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/notice.css">
</head>
<body>

	<%@include file="/WEB-INF/views/common/header.jsp" %>
		<div class="page-content">
			<div class="notice-wrap">
				<div class="notice-header">
					<span>공지사항</span>
					<a href="#" class="header-a notice-a">공지사항</a>
					<a href="#" class="header-a news-a">언론보도</a>
					<a href="/noticeWriteFrm.do" class="news-btn btn1">공지사항 작성</a>
				</div>
				<table class="notice-tbl">
					<%for(int i=0;i<list.size();i++) {%>
						<%Notice n = list.get(i); %>
							<tr class="notice-tr">
									<td class="notice-td">
										<a href="/noticeView.do"><%=n.getNoticeTitle() %></a>
										<div><%=n.getRegDate() %></div>
									</td>
							</tr>
					<%} %>
				</table>
				<div id="pageNavi"><%=pageNavi %></div>
			</div>
		</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>