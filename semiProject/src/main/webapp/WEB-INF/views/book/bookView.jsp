<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int bookNo = (int)request.getAttribute("bookNo");
    %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=bookNo %></title>
</head>
<body>
	<h1><%=bookNo %></h1>
</body>
</html>