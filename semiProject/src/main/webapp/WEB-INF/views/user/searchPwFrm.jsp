<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/loginJoin.css">
<link rel="stylesheet" href="/css/default.css">
<style>
	.searchIdPw-wrap>form{
		margin: 0 auto;
		width: 340px
	}
	.pw-email-msg{
		font-size: 12px;
		margin-bottom: 5px;
		text-align: center;
	}
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
    <div class="searchIdPw-wrap loginJoin-wrap page-content">
        <div class="loginJoin-title page-title">비밀번호 찾기</div>
        <div class="pw-email-msg">찾은 비밀번호는 가입시 입력한 이메일로 메시지가 전송됩니다.</div>
        <form action="/searchPw.do" method="post">
            <div class="input-wrap inputbox">
                <input type="text" name="inputId" id="inputId" class="input-box input-form" placeholder="아이디">
                <input type="email" name="inputEmail" id="inputEmail" class="input-box input-form" placeholder="이메일 주소">
            </div>
            <button type="submit" class="btn bc4">찾기</button>
        </form>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>