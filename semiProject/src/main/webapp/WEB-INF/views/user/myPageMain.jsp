<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file =  "/WEB-INF/views/user/myPageMenu.jsp"%>

	<div>
		<div>
			<div>프로필사진</div>
			<h3>닉네임나오는곳</h3>
			<div>이메일나오는곳</div>
			<div>
				<div>
					<a href="#">쪽지함</a>
				</div>
				<div>
					<a href="#">포인트 충전</a>
				</div>
			</div>
			<a href="#">로그아웃</a>
		</div>
		<div>
			<div>나의 포인트 : <span class="myPoint">0</span>P</div>
		</div>
	</div>
</body>
</html>