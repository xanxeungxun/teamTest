<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String searchId = (String)request.getAttribute("searchId");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/default.css">
</head>
<style>
	.searchId-wrap{
		margin: 0 auto;
		width: 340px;
	}
	.login-btn{
		width: 100%;
		text-align: center;
	}
</style>
<body>
	<div class="page-content searchId-wrap">
		<%if(searchId == null) { %>
			<div>회원정보가 없습니다.</div>
		<%} else {%>
			<div>회원님의 아이디는 <span><%=searchId %></span>입니다.</div>
			<a href="/loginFrm.do" class="btn bc6 login-btn">로그인</a>
		<%} %>
	</div>
</body>
</html>