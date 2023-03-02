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
<style>
	.searchIdPw-wrap>form{
		margin: 0 auto;
		width: 340px
	}
	form>span{
		font-size: 12px;
	}
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="searchIdPw-wrap loginJoin-wrap page-content">
        <div class="loginJoin-title page-title">아이디 찾기</div>
        <form action="/searchId.do" method="post">
        	<span>아이디는 가입시 입력한 이메일을 통해 찾을 수 있습니다.</span>
            <div class="input-wrap">
                <input type="email" name="inputEmail" id="inputEmail" class="input-box input-form" placeholder="이메일 주소">
            </div>
            <button type="submit" class="btn bc66">찾기</button>
        </form>
    </div>
</body>
</html>