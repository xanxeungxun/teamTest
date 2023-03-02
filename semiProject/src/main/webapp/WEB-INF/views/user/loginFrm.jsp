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
<style>
	.searchIdPw-box {
    background-color: rgb(238, 238, 238);
    box-sizing: border-box;
    border-radius: 5px;
	}
	
	/*아이디/비번 찾기 박스*/
	.searchIdPw-wrap{
	    text-align: right;
	    font-size: 12px;
	    padding-bottom: 10px;
	    padding-right: 10px;
	    margin-bottom: 10px;
	}
	
	.searchIdPw-wrap>a{
	    text-decoration: none;
	}
</style>
<body>
    <div class="loginJoin-wrap">
        <div class="loginJoin-title">로그인</div>
        <form action="login.do" method="post">
            <div class="searchIdPw-box">
                <div class="input-wrap">
                    <input type="text" name="signId" id="signId" class="input-box" placeholder="아이디"><br>
                    <input type="password" name="signPw" id="signPw" class="input-box" placeholder="비밀번호">
                </div>
                
                <div class="searchIdPw-wrap">
                    <a href="/searchIdFrm.do">아이디</a>
                    <span>/</span>
                    <a href="/searchPwFrm.do">비밀번호</a>
                    <span> 찾기</span>
                </div>
            </div>
                    
            <div>
                <button type="submit" class="btn">로그인</button><br>
                <button type="button" class="btn">회원가입</button>
            </div>
        </form>
    </div>
</body>
</html>