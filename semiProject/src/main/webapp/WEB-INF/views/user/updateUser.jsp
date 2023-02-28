<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file = "/WEB-INF/views/common/header.jsp" %>

	<div class="page-content">
		<div>회원정보 변경</div>
		<div class="line"></div>
		
		<div>
			<form action="/updateUser.do" method="post">
				<div>
					<label for="profilePic">프로필 사진</label>
					<div class="profileImage"></div>
					<img src="#" width="80px">
					<div>파일을 선택해주세요</div>
					<a href="/profileFileDown.do">파일 선택</a>
				</div> 
				<div>
					<label for="userNick">닉네임</label>
					<input type="text" name="userNick" id="userNick">
				</div>
				<div>
					<label for="userId">아이디</label>
					<input type="text" name="userId" id="userId">
				</div>
				<div>
					<label for="userPhone">전화번호</label>
					<input type="text" name="userPhone" id="userPhone">
				</div>
				<div>
					<label for="userEmail">이메일</label>
					<input type="text" name="userEmail" id="userEmail">
				</div>
				<div>
					<label for="userPw">비밀번호</label>
					<input type="password" name="userPw" id="userPw" placeholder="현재 비밀번호">
					<input type="password" name="newPw" id="newPw" placeholder="새 비밀번호">
					<input type="password" name="newPwCh" id="newPwCh" placeholder="새 비밀번호 확인">
					<div>
						<div>비밀번호 변경 시 유의사항</div>
						<ul>
							<li>8자 이상, 영문/숫자/특수문자 중 2가지 이상 입력해주세요.</li>
							<li>연속된 3자 이상의 같은 문자는 제한합니다.</li>
							<li>ID와 같은 비밀번호는 사용할 수 없습니다.</li>
						</ul>
					</div>
				</div>
				
				<div class="line"></div>
				<a href="#">취소</a>
				<button type="submit">정보 수정</button>
			</form>
		</div>
	</div>
</body>
</html>