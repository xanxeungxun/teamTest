<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/loginJoin.css">
<link rel="stylesheet" href="/css/joinFrm.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="loginJoin-wrap join-wrap">
			<div class="loginJoin-title page-title">회원가입</div>
	        <form action="/join.do" method="post">
	            <div class="join-input-wrap">

                    <div>
                        <span class="material-symbols-outlined check-circle">check_circle</span>
                        <input type="text" name="userId" id="userId" placeholder="아이디" class="input-form">
                        <span class="reg-msg"></span>
                    </div>
                    <div>
                        <span class="material-symbols-outlined check-circle">check_circle</span>
                        <input type="password" name="userPw" id="userPw" placeholder="비밀번호" class="input-form">
                        <span class="reg-msg"></span>
                    </div>
                    <div>
                        <span class="material-symbols-outlined check-circle">check_circle</span>
                        <input type="password" name="userPwCh" id="userPwCh" placeholder="비밀번호 확인" class="input-form">
                        <span class="reg-msg"></span>
                    </div>
                    <div>
                        <span class="material-symbols-outlined check-circle">check_circle</span>
                        <input type="text" name="userNick" id="userNick" placeholder="닉네임" class="input-form">
                        <span class="reg-msg"></span>
                    </div>
                    <div>
                        <span class="material-symbols-outlined check-circle">check_circle</span>
                        <input type="text" name="userName" id="userName" placeholder="이름" class="input-form">
                        <span class="reg-msg"></span>
                    </div>
                    <div>
                        <span class="material-symbols-outlined check-circle">check_circle</span>
                        <input type="text" name="userPhone" id="userPhone" placeholder="전화번호('-' 포함)" class="input-form">
                        <span class="reg-msg"></span>
                    </div>
	            	<div>
                        <span class="material-symbols-outlined check-circle">check_circle</span>
                        <input type="text" name="userEmail" id="userEmail" placeholder="이메일 주소" class="input-form">
                        <button type="button" name="emailCheck" id="emailCheck" class="btn bc66 email-btn">이메일 인증</button>
                        <span class="reg-msg"></span>
                        <div id="auth" style="display:none;">
							<input type="text" id="authCode" placeholder="인증번호입력">
							<button class="btn bc2" id="authBtn">인증하기</button>
							<span id="timeZone"></span>
						</div>
						<span id="authMsg"></span>
                    </div>
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
	                                <label for="agreement1"><input type="checkbox" name="agreement" id="agreement1" class="must-check" required>이용약관 동의(필수)</label>
	                            </div>
	                            <a href="/agreeContent1.do">약관 보기 ></a>
	                        </div>
	                        <div>
	                            <label for="agreement2"><input type="checkbox" name="agreement" id="agreement2">알림 수신동의(선택)</label>
	                        </div>
	                        <div>
	                            <div>
	                                <label for="agreement3"><input type="checkbox" name="agreement" id="agreement3">성별, 생년 정보 제공 동의(선택)</label>
	                            </div>
	                            <a href="/agreeContent2.do">내용 확인 ></a>
	                        </div>
	                    </div>
	                    <div class="privacyAgreement">
	                        <div>
	                            <label for="privacyAgreement"><input type="checkbox" name="agreement" id="privacyAgreement" class="must-check" required>개인정보 수집 및 이용 동의(필수)</label>
	                        </div>
	                        <a href="/agreeContent3.do">내용 확인 ></a>
	                    </div>
	                </div>
	            </div>
	            <button type="submit" class="btn bc4 submit-btn">회원가입 완료</button>
	        </form>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
    <script src="js/join.js"></script>
</body>
</html>