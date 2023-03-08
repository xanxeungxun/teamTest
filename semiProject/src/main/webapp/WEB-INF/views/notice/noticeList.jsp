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
<style>
	#pageNavi{
		margin-top: 20px;
		margin-bottom: 20px;
	}
	.date-span{
		font-size: 12px;
		color: #a8a8a8;
	}
	.notice-td{
		height: 80px;
		margin-bottom: 20px;
	}
	.title-span{
		font-size: 17px;
		cursor: pointer;
	}
	
	.notice-tbl tr:hover{
		background-color: #f8f8f8ee;
	}
</style>
</head>
<body>

	<%@include file="/WEB-INF/views/common/header.jsp" %>
		<div class="page-content">
			<div class="notice-wrap">
				<div class="notice-header">
					<span>공지사항</span>
					<%if(loginUser!=null && loginUser.getUserLevel()==1) {%>
					<a href="/noticeWriteFrm.do" class="news-btn btn1">공지사항 작성</a>
					<%} %>
				</div>
				<table class="notice-tbl">
					<%for(int i=0;i<list.size();i++) {%>
						<%Notice n = list.get(i); %>
							<tr class="notice-tr">
									<td class="notice-td">
										<a href="/noticeView.do?noticeNo=<%=n.getNoticeNo()%>"><span class="title-span"><%=n.getNoticeTitle() %></span></a>
										<div><span class="date-span"><%=n.getRegDate() %></span></div>
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