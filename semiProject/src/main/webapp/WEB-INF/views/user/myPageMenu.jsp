<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>마이페이지</h1>
	<ul>
		<li>
			<a href="/uploadBookCheck.do?reqPage=1">나의 작품</a>
			<ul>
				<li><a href="/uploadBookCheck.do?reqPage=1">투고한 작품 확인</a></li>
			</ul>
		</li>
		<li>
			<a href="#">나의 책갈피</a>
			<ul>
				<li><a href="#">관심작품 목록</a></li>
				<li><a href="#">후원작품 목록</a></li>
			</ul>
		</li>
		<li>
			<a href="#">개인</a>
			<ul>
				<li><a href="/updateUser.do">회원정보 변경</a></li>
				<li><a href="#">회원 탈퇴</a></li>
			</ul>
		</li>
	</ul>
</body>
</html>