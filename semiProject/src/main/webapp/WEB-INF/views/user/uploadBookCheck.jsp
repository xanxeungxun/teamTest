<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@include file="/WEB-INF/views/user/myPageMenu.jsp" %>
	
	<div class="page-content">
		<div>투고한 작품 확인</div>
		<div class="line"></div>
		
		<table>
			<tr>
				<td rowspan="5">이미지</td>
				<td>작품제목</td>
			</tr>
			<tr>
				<td>장르</td>
			</tr>
			<tr>
				<td>조회수</td>
			</tr>
			<tr>
				<td>작품 등록일</td>
			</tr>
			<tr>
				<td><a href="#">수정</a></td>
				<td><a href="#">삭제</a></td>
			</tr>
		</table>
		
	</div>
</body>
</html>