<%@page import="com.iei.bookListManage.model.vo.BookListManageVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.iei.question.model.vo.QuestionVo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<BookListManageVo> list = (ArrayList<BookListManageVo>) request.getAttribute("list");
String pageNavi = (String)request.getAttribute("pageNavi");
int start = (int)request.getAttribute("start");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작품 관리</title>
<link rel="stylesheet" href="/css/bookListManage.css">
</head>
<body>

	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="bookListManage-wrap">
			<div class="bookListManage-header">
				<span>작품 관리</span>
			</div>
			<table class="bookListManage-tbl">
				<%
				if (list.size() < 1) {
				%>
				<tr class="bookListManage-tr">
					<td class="bookListManage-td">등록된 작품이 없습니다.</td>
				</tr>
				<%
				} else {
				%>
				
				<thead>
					<tr class="bookListManage-tr">
					
						<td class="bookListManage-td" style="width:6%">순번</td>
						<td class="bookListManage-td" style="width:6%">작품번호</td>
						<td class="bookListManage-td" style="width:6%">장르코드</td>
						<td class="bookListManage-td" style="width:57%">작품명</td>
						<td class="bookListManage-td" style="width:8%">작가명</td>
						<td class="bookListManage-td" style="width:10%">등록일</td>
						<td class="bookListManage-td" style="width:9%">연재상태</td>
						<td class="bookListManage-td" style="width:10%">삭제하기</td>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < list.size(); i++) {
					%>
					<%
					BookListManageVo q = list.get(i);
					%>
					<tr class="bookListManage-tr">
						<td class="bookListManage-td"><%=i+start %></td>
						<td class="bookListManage-td"><%=q.getBookNo() %></td>
						<td class="bookListManage-td"><%=q.getGenreCode() %></td>
						<td class="bookListManage-td"><a
							href="/bookListManage/BookListManageView.do?bookListManageNo=<%=q.getBookNo()%>"><%=q.getBookTitle()%></a></td>
						<td class="bookListManage-td"><%=q.getBookWriter()%></td>
						<td class="bookListManage-td"><%=q.getBookDate() %></td>
						<td class="bookListManage-td"><button id="delBtn">삭제하기</button></td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
			<br>
			<div id="pageNavi"><%=pageNavi %>
			<br>
		</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>