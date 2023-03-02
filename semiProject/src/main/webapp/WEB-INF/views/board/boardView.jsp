<%@page import="com.iei.board.model.vo.BoardComment"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iei.board.model.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	Board b = (Board)request.getAttribute("b");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/board.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
		<div class="page-content">
			<div class="board-wrap">
				<div class="board-header">
				<span>자유게시판</span>
				</div>
				<table class="board-tbl">
					<tr class="board-tr">
						<td class="board-td">
						<input type="hidden" name="boardNo" value="<%=b.getBoardNo() %>">
							<span><%=b.getBoardTitle() %></span>
							<div><%=b.getboardDate() %></div>
						</td>
					</tr>
					<tr class="board-tr">
						<td class="board-td">
							<div><%=b.getBoardContent() %></div>
						</td>					
					</tr>
				</table>
				
				
			
			</div>
		</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>