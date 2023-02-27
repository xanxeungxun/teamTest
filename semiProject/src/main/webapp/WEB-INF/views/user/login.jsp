<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>로그인</h1>
	<form action="login.do" method="post">
		<div>
			<div>
				<input type="text" name="signId" id="signId" placeholder="아이디"><br>
				<input type="password" name="signPw" id="signPw" placeholder="비밀번호">
			</div>
			
			<div>
				<a href="#">아이디</a>
				<span>/</span>
				<a href="#">비밀번호</a>
				<span> 찾기</span>
			</div>
		</div>
				
		<div>
			<button type="submit">로그인</button><br>
			<button type="button">취소</button>
		</div>
	</form>
	
</body>
</html>