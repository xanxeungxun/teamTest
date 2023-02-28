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
			</div>
			<table class="notice-tbl">
				<tr class="notice-tr">
					<td class="notice-td">
						<span>공지사항 제목</span>
						<div>2023-02-28</div>
					</td>
					<td>
						<span>조회수 : </span>
					</td>
					<td>
						<span>작성자 : </span>
					</td>
				</tr>
			</table>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>