<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/mypageDefault.css">
</head>
<style>
    .check-content{
        padding-left: 10px;
    }
    .check-quit-reason>label{
        display: flex;
        padding: 3px;
    }
    [name="quit-reason"],[name="quit-agreement"]{
        margin-right: 7px;
    }
    .check-pw>.check-title{
        padding-top: 40px;
    }
    .check-pw .input-form{
        width: 40%;
    }
    .check-notice{
        background-color: #eeeeeee6;
        height: 30px;
        line-height: 30px;
        padding-left: 10px;
        font-size: 14px;
        border-radius: 4px;
        margin-top: 10px;
    }
    .check-agree{
        text-align: center;
        padding: 30px;
        padding-top: 50px;
    }
    .userId{
    	color: #e98ead;
    	font-family: ns-bold;
    }
</style>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
    <div class="page-content mypage-content">
    	<%@include file="/WEB-INF/views/user/myPageMenu.jsp" %>
    	<div class="mypage-detail">
    		<div class="mypage-title page-title">회원 탈퇴</div>
	        <form action="/deleteUser.do" method="post">
	            <div class="content-wrap">
	                <div class="detail-title">Q.탈퇴하는 이유가 무엇인가요?</div>
	                <div class="check-quit-reason check-content">
	                    <label><input type="checkbox" name="quit-reason" id="quit-reason1" value="1">원하는 작품이 부족해서</label>
	                    <label><input type="checkbox" name="quit-reason" id="quit-reason2" value="2">회원 혜택이 부족해서</label>
	                    <label><input type="checkbox" name="quit-reason" id="quit-reason3" value="3">시스템 오류가 잦아서</label>
	                    <label><input type="checkbox" name="quit-reason" id="quit-reason4" value="4">불만, 불편 사항에 대한 응대가 늦어서</label>
	                    <label><input type="checkbox" name="quit-reason" id="quit-reason5" value="5">자주 사용하지 않아서</label>
	                    <label><input type="checkbox" name="quit-reason" id="quit-reason6" value="6">개인정보 및 보안이 우려되어서</label>
	                    <label><input type="checkbox" name="quit-reason" id="quit-reason7" value="7">기타</label>
	                </div>
	                <div class="check-pw">
	                    <div class="detail-title">본인 확인을 위해 <span class="userId"><%=loginUser.getUserId() %></span> 계정의 비밀번호를 입력해주세요.</div>
	                    <div>
	                        <input type="password" name="checkPw" id="checkPw" placeholder="비밀번호 입력" class="input-form">
	                    </div>
	                    <div class="check-notice">※ 탈퇴가 완료된 계정은 다시 복구할 수 없습니다.</div>
	                </div>
	                <div class="check-agree">
	                    <label><input type="checkbox" name="quit-agreement" id="quit-agreement" value="agree">위 내용을 이해했으며, 모두 동의합니다.</label>
	                </div>
	            </div>
	            <div class="foot-btn">
	                <a href="#" class="btn bc33">취소</a>
	                <button type="submit" class="btn bc6">회원 탈퇴</button>
	            </div>
	        </form>
    	</div>
    </div>
    <%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>