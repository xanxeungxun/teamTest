<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/loginJoin.css">
<link rel="stylesheet" href="/css/searchIdPwFrm.css">
</head>
<body>
    <div class="searchIdPw-wrap">
        <div class="loginJoin-title">아이디 찾기</div>
        <form action="/searchId.do" method="post">
            <div class="input-wrap">
                <input type="email" name="inputEmail" id="inputEmail" class="input-box" placeholder="이메일 주소"><br>
            </div>
            <button type="submit" class="btn">찾기</button>
        </form>
    </div>
</body>
</html>