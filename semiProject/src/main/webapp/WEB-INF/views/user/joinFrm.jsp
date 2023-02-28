<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/joinFrm.css">
</head>
<body>
	<div class="join-wrap">
		<div class="loginJoin-title">회원가입</div>
        <form action="/join.do" method="post">
            <div class="join-input-wrap">
                <input type="text" name="userId" id="userId" placeholder="아이디">
                <span class="reg-msg"></span>
                <input type="password" name="userPw" id="userPw" placeholder="비밀번호">
                <input type="password" name="userPwCh" id="userPwCh" placeholder="비밀번호 확인">
                <span class="reg-msg"></span>
                <input type="text" name="userNick" id="userNick" placeholder="닉네임">
                <input type="text" name="userName" id="userName" placeholder="이름">
                <input type="text" name="userPhone" id="userPhone" placeholder="전화번호">
                <input type="text" name="userEmail" id="userEmail" placeholder="이메일 주소">
            </div>
            <div class="join-agree-wrap">
                <div class="allAgree-box">
                    <input type="checkbox" id="allAgreement">
                    <label for="allAgreement">전체 약관 동의</label>
                </div>
                <div class="agree-box">
                    <div class="usingAgreement">
                        <div>
                            <div>
                                <input type="checkbox" id="agreement">
                                <label for="agreement">이용약관 동의(필수)</label>
                            </div>
                            <a href="#">약관 보기 ></a>
                        </div>
                        <div>
                            <input type="checkbox" id="agreement">
                            <label for="agreement">알림 수신동의(선택)</label>
                        </div>
                        <div>
                            <div>
                                <input type="checkbox" id="agreement">
                                <label for="agreement">성별, 생년 정보 제공 동의(선택)</label>
                            </div>
                            <a href="#">내용 확인 ></a>
                        </div>
                    </div>
                    <div class="privacyAgreement">
                        <div>
                            <input type="checkbox" id="privacyAgreement">
                            <label for="privacyAgreement">개인정보 수집 및 이용 동의(필수)</label>
                        </div>
                        <a href="#">내용 확인 ></a>
                    </div>
                </div>
            </div>
            <div class="btn">
                <button type="submit">회원가입 완료</button>
            </div>
        </form>
	</div>
</body>
</html>