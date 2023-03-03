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
    <div class="searchIdPw-wrap loginJoin-wrap page-content">
        <div class="loginJoin-title page-title">비밀번호 재설정</div>
        <div class="pw-email-msg">새 비밀번호를 설정할 수 있도록 이메일로 메세지가 전송됩니다.</div>
        <form action="/searchPw.do" method="post">
            <div class="input-wrap inputbox">
                <input type="text" name="inputId" id="inputId" class="input-box input-form" placeholder="아이디">
                <input type="email" name="inputEmail" id="inputEmail" class="input-box input-form" placeholder="이메일 주소">
            </div>
            <button type="submit" class="btn bc66">찾기</button>
        </form>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>