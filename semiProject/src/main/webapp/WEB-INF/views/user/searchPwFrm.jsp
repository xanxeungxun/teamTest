<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/loginJoin.css">
<style>
	.pw-email-msg{
	    font-size: 11px;
	    text-align: center;
	}
</style>
</head>
<body>
    <div class="searchIdPw-wrap loginJoin-wrap">
        <div class="loginJoin-title">비밀번호 찾기</div>
        <form action="/searchPw.do" method="post">
            <div class="input-wrap inputbox">
                <input type="text" name="inputId" id="inputId" class="input-box" placeholder="아이디"><br>
                <input type="email" name="inputEmail" id="inputEmail" class="input-box" placeholder="이메일 주소"><br>
            </div>
            <button type="submit" class="btn">찾기</button>
        </form>
        <div class="pw-email-msg">찾은 비밀번호는 이메일로 메시지가 전송됩니다.</div>
    </div>
</body>
</html>