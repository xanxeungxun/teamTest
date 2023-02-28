<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
					<tr class="notice-tr">
						<td class="notice-td">공지사항 제목</td>
					</tr>
					<tr class="notice-tr">
						<td class="notice-td">공지사항 제목</td>
					</tr>
					<tr class="notice-tr">
						<td class="notice-td">공지사항 제목</td>
					</tr>
				</table>
			</div>
		</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>