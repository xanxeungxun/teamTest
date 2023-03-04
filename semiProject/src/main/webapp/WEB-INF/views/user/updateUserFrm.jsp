<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="/css/mypageDefault.css">
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
</head>
<style>
    div>.user-bold{
        font-family: ns-m;
    }
    .content-wrap>div{
        padding: 15px 0px 15px 0px;
    }
    .content-wrap>div:first-child{
        padding-top: 20px;
    }
    .profile>.material-icons{
        font-size: 80px;
        color: #ccc
    }
    .profile{
        overflow: hidden;
        margin-top: 10px;
    }
    .profile>div{
        float: left;
    }
    .profile-file{
        overflow: hidden;
        padding-top: 20px;
        padding-bottom: 20px;
    }
    .profile>div>*{
        float: left;
    }
    .page-content .upfile-name{
        height: 44px;
        margin: 0;
        width: 480px;
        margin-left: 20px;
    }
    .profile-file>.upfile{
        width: 100px;
        height: 44px;
        padding: 0;
        text-align: center;
        line-height: 44px;
    }

    .input-form{
        margin: 10px 0px 10px 0px;
    }
    .pw-change-notice{
        padding: 10px 0px 10px 0px;
        font-size: 14px;
    }
    [type="password"]{
        width: 40%;
    }
    .pw-change-notice>ul{
        padding: 5px;
        list-style-position: inside;
    }
    .pw-change-notice li{
        padding: 3px 0px 3px 0px;
    }
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content mypage-content">
		<%@include file="/WEB-INF/views/user/myPageMenu.jsp" %>
		<div class="mypage-detail">
			<div class="mypage-title page-title">회원정보 변경</div>
	        <form action="/updateUser.do" method="post">
	            <div class="content-wrap">
	                <div>
	                    <label for="profilePic" class="bold user-bold">프로필 사진</label>
	                    <div class="profile">
	                        <div class="material-icons">account_circle</div>
	                        <div class="profile-file">
	                            <div class="upfile-name input-form">파일을 선택해주세요</div>
	                            <label for="profile-upfile" class="btn bc4 upfile">파일 선택</label>
	                            <input type="file" name="profile-upfile" id="profile-upfile" style="display:none">
	                        </div>
	                    </div>
	                </div> 
	                <div>
	                    <label for="userNick" class="bold user-bold">닉네임</label>
	                    <input type="text" name="userNick" id="userNick" class="input-form" value="<%=loginUser.getUserNick()%>">
	                </div>
	                <div>
	                    <label for="userId" class="bold user-bold">아이디</label>
	                    <input type="text" name="userId" id="userId" class="input-form" value="<%=loginUser.getUserId()%>" readonly>
	                </div>
	                <div>
	                    <label for="userPhone" class="bold user-bold">전화번호</label>
	                    <input type="text" name="userPhone" id="userPhone" class="input-form" value="<%=loginUser.getUserPhone()%>">
	                </div>
	                <div>
	                    <label for="userEmail" class="user-bold">이메일</label>
	                    <input type="text" name="userEmail" id="userEmail" class="input-form" value="<%=loginUser.getUserEmail()%>">
	                </div>
	                <div>
	                    <label for="userPw" class="bold user-bold">비밀번호</label>
	                    <input type="password" name="userPw" id="userPw" placeholder="현재 비밀번호" class="input-form">
	                    <input type="password" name="newPw" id="newPw" placeholder="새 비밀번호" class="input-form">
	                    <input type="password" name="newPwCh" id="newPwCh" placeholder="새 비밀번호 확인" class="input-form">
	                    <div class="pw-change-notice">
	                        <div class="bold">비밀번호 변경 시 유의사항</div>
	                        <ul>
	                            <li>· 8자 이상, 영문/숫자/특수문자 중 2가지 이상 입력해주세요.</li>
	                            <li>· 연속된 3자 이상의 같은 문자는 제한합니다.</li>
	                            <li>· ID와 같은 비밀번호는 사용할 수 없습니다.</li>
	                        </ul>
	                    </div>
	                </div>
	            </div>
	            <div class="foot-btn">
	                <a href="#" class="btn bc33">취소</a>
	                <button type="submit" class="btn bc6">정보 수정</button>
	            </div>
	        </form>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>