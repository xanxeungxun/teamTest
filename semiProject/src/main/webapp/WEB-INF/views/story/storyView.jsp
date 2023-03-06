<%@page import="com.iei.story.model.vo.Story"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    Story s = (Story)request.getAttribute("s");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=s.getStoryName() %></title>
</head>
<body>

<%=s.getStoryName() %>

</body>
</html>