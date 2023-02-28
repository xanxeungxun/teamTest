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
</head>
<body>
	<div class="page-content">
	<%if(searchId == null) { %>
		<div>회원정보가 없습니다.</div>
	<%} else {%>
		<div>회원님의 아이디는 <span><%=searchId %></span>입니다.</div>
		<a href="/loginFrm.do">로그인</a>
	<%} %>
	</div>
</body>
</html>