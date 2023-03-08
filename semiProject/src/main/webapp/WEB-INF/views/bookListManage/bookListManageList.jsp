<%@page import="com.iei.bookListManage.model.vo.BookListManageVo"%>
<%@page import="java.util.ArrayList"%>

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
<style>
.bookListManage-td>.ttd{
text-align:left;
padding:0;
width:50px;
}
.bookListManage-tr{
text-align:center; 
}
.text-inline{
text-align:left;
padding-left:50px;
padding-right:50px;
display:block;
height:19px;
white-space: no-wrap;
overflow: hidden;
text-overflow: ellipsis;
}
.text td{
font-size:14px;
}
</style>
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
						<td class="bookListManage-td" style="width:6%">품번</td>
						<td class="bookListManage-td" style="width:10%">장르코드</td>
						<td class="bookListManage-td ttd" style="width:40%">작품명</td>
						<td class="bookListManage-td" style="width:8%">작가명</td>
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
					<tr class="bookListManage-tr text">
						<td class="bookListManage-td"><%=i+start %></td>
						<td class="bookListManage-td"><%=q.getBookNo() %></td>
						<td class="bookListManage-td"><%=q.getGenreName() %>
						<td class="bookListManage-td">
						<a class="text-inline" href="/storyList.do?bookNo=<%=q.getBookNo()%>">
						<%=q.getBookTitle()%></a></td>
						<td class="bookListManage-td"><%=q.getBookWriter() %></td>
						<td class="bookListManage-td">
						<%
						if(q.getBookStatus() == 1 ){
						%>
						연재중
						<%
						}else if(q.getBookStatus() == 2 ){
						%>
						완결
						<%} %>
						
						</td>
						<td class="bookListManage-td"><button class="btn bc1 bs1 delBtn" style="font-size:14px;">삭제하기</button></td>
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
<script>
	$(".delBtn").on("click",function(){
		//해당 테이블의 해당 게시물을 제거하는 쿼리 불러옴
		const test = $(this).parent().prev().prev().prev().prev().prev().text();
		console.log(test);
		location.href="/deleteBook.do?delBook="+test;
		//무조건 서블릿으로 보내야 한다
		
	});
	

</script>
</body>
</html>