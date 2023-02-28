<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>아이디 찾기</h1>
	<form action="/searchId.do" method="post">
		<input type="text" name="inputEmail" id="inputEmail" placeholder="이메일 주소"><br>
		<button type="submit">찾기</button>
	</form>
</body>
</html>