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
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="notice-wrap">
			<div class="notice-header">
				<span>공지사항</span>
			</div>
			<table class="notice-tbl">
				<tr class="notice-tr">
					<td class="notice-td">
						<span><%=n.getNoticeTitle() %></span>
						<div><%=n.getRegDate() %></div>
					</td>
				</tr>
				<tr class="notice-tr">
					<td class="notice-td">
						<div><%=n.getNoticeContent() %></div>
					</td>					
				</tr>
			</table>
			<div>
				<a href="/noticeUpdateFrm.do?noticeNo=<%=n.getNoticeNo() %>">수정</a>
				<button onclick="noticeDelete(<%=n.getNoticeNo()%>);">삭제</button>
			</div>
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