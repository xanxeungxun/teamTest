<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<div>회원가입</div>
		<table>
			<tr>
				<td><input type="text" name="userId" id="userId" placeholder="아이디"></td>
			</tr>
			<tr>
				<td><span class="reg-msg"></span><td>
			</tr>
			<tr>
				<td><input type="text" name="userPw" id="userPw" placeholder="비밀번호"><td>
				<td><input type="text" name="userPwCh" id="userPwCh" placeholder="비밀번호 확인"></td>
				<td><span class="reg-msg"></span></td>
			</tr>
			<tr>
				<td><input type="text" name="userNick" id="userNick" placeholder="닉네임"></td>
			</tr>
		</table>
		
	</div>
</body>
</html>