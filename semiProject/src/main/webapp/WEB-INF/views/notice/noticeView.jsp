<%@page import="com.iei.notice.model.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	Notice n = (Notice)request.getAttribute("n");
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/notice.css">
<style>
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
	}
	.noticeContentDiv{
		min-height: 400px;
		padding-top: 70px;
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
				<button class="news-btn btn1" onclick="noticeDelete(<%=n.getNoticeNo()%>);">삭제</button>
				<a  class="news-btn btn1" href="/noticeUpdateFrm.do?noticeNo=<%=n.getNoticeNo() %>">수정</a>
				<%} %>
			</div>
			<table class="notice-tbl">
				<tr class="notice-tr">
					<td class="notice-td">
						<span class="title-span"><%=n.getNoticeTitle() %></span>
						<div><span class="date-span"><%=n.getRegDate() %></span></div>
					</td>
				</tr>
				<tr class="notice-tr">
					<td class="notice-td">
						<div class="noticeContentDiv"><%=n.getNoticeContent() %></div>
					</td>					
				</tr>
			</table>
			
			<a class="news-btn btn1" href="/noticeList.do?reqPage=1">목록보기</a>
		</div>
	</div>
	
	
	<script>
		function noticeDelete(noticeNo) {
			if(confirm("게시글을 삭제하시겠습니까?")){
				location.href="/deleteNotice.do?noticeNo="+noticeNo;
			}
		}
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>