<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="/css/loginJoin.css">
<link rel="stylesheet" href="/css/login.css">
</head>
<style>
.page-content>* {
	margin: 0 auto;
}

.searchIdPw-box {
	background-color: rgb(238, 238, 238);
	box-sizing: border-box;
	border-radius: 5px;
}

form {
	width: 340px;
}

/*아이디/비번 찾기 박스*/
.searchIdPw-wrap {
	text-align: right;
	font-size: 12px;
	padding-bottom: 10px;
	padding-right: 10px;
	margin-bottom: 10px;
}

.searchIdPw-wrap>a {
	text-decoration: none;
}

.searchIdPw-wrap>a:hover {
	color: #807991;
}

div>.btn {
	padding: 0;
}
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="loginJoin-wrap page-content">
		<div class="loginJoin-title page-title">로그인</div>
		<form action="login.do" method="post">
			<div class="searchIdPw-box">
				<div class="input-wrap">
					<input type="text" name="signId" id="signId"
						class="input-box input-form" placeholder="아이디"> <input
						type="password" name="signPw" id="signPw"
						class="input-box input-form" placeholder="비밀번호">
				</div>

				<div class="searchIdPw-wrap">
					<a href="/searchIdFrm.do">아이디</a> <span>/</span> <a
						href="/searchPwFrm.do">비밀번호</a> <span> 찾기</span>
				</div>
			</div>

			<div>
				<button type="submit" class="btn bc6">로그인</button>
				<br> <a href="/join.do" class="btn bc33 a-btn">회원가입</a>
			</div>
		</form>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>