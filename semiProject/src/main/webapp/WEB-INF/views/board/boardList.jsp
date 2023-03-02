<%@page import="com.iei.board.model.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<Board> list = (ArrayList<Board>)request.getAttribute("list");
    	String pageNavi = (String)request.getAttribute("pageNavi");
    	int start = (int)request.getAttribute("start");
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
				<a href="/boardWriteFrm.do" class="news-btn btn1">자유게시판 작성</a>
			</div>
			<table class="board-tbl">
			<%for(int i=0;i<list.size();i++) {%>
				<%Board b = list.get(i); %>
				<tr class="board-tr">
					<td class="board-td title-td"><a href="/boardView.do?boardNo=<%=b.getBoardNo()%>"><span class="title-span"><%=b.getBoardTitle() %></span></a>
						<div><span class="writer-span"><%=b.getBoardWriter() %></span> <span class="date-span"><%=b.getboardDate() %></span></div>
					</td>
					<td class="board-td read-td">
						조회수 : <%=b.getReadCount() %>
					</td>
				</tr>
			<%} %>
			</table>
			<div id="pageNavi"><%=pageNavi %></div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>