<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/searchIdPwFrm.css">
</head>
<body>
    <div class="searchIdPw-wrap">
        <div class="loginJoin-title">비밀번호 찾기</div>
        <form action="/searchPw.do" method="post">
            <div class="input-wrap inputbox">
                <input type="text" name="inputId" id="inputId" class="input-box" placeholder="아이디"><br>
                <input type="email" name="inputEmail" id="inputEmail" class="input-box" placeholder="이메일 주소"><br>
            </div>
            <button type="submit" class="btn">찾기</button>
        </form>
        <div class="pw-email-msg">새 비밀번호를 설정할 수 있도록 이메일로 메세지가 전송됩니다.</div>
    </div>
</body>
</html>