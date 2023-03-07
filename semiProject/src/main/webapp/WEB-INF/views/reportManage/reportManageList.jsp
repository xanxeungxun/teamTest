<%@page import="com.iei.reportManage.model.vo.*"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<ReportManageVo> list = (ArrayList<ReportManageVo>) request.getAttribute("list");
String pageNavi = (String)request.getAttribute("pageNavi");
int start = (int)request.getAttribute("start");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신고 관리</title>
<link rel="stylesheet" href="/css/reportManage.css">
</head>
<body>
<script src="/js/jquery-3.6.3.min.js">
</script>
<style>
.reportManage-tr{
	text-align:center;
}
</style>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="reportManage-wrap">
			<div class="reportManage-header">
				<span>신고 관리</span>
			</div>
			<table class="reportManage-tbl">
				<%
				if (list.size() < 1) {
				%>
				<tr class="reportManage-tr">
					<td class="reportManage-td">신고된 내용이 없습니다.</td>
				</tr>
				<%
				} else {
				%>
				<thead>
					<tr class="reportManage-tr">
						<td class="reportManage-td" style="width:5%;padding:10px;">순번</td>
						<td class="reportManage-td kk" style="width:5%;">신고자</td>
						<td class="reportManage-td" style="width:5%;">신고내용</td>
						<td class="reportManage-td" style="width:10%;">종류</td>
						<td class="reportManage-td" style="width:10%;">신고일자</td>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < list.size(); i++) {
					%>
					<%
					ReportManageVo u = list.get(i);
					%>
					<tr class="reportManage-tr">
						<td class="reportManage-td"style="font-size:14px;"><%=i+start %></td>
						<td class="reportManage-td kk"style="font-size:14px;"><%=u.getReportNo() %></td>
						<td class="reportManage-td"style="font-size:14px;"><%=u.getReporterNo()%></td>
						<td class="reportManage-td"style="font-size:14px;"><%=u.getReportContent() %>
						<td class="reportManage-td"style="font-size:14px;">
						<% if(u.getReportStyle() == 1 ){%>유저
						<%}else if(u.getReportStyle() == 2 ){%>게시판
						<%}else if(u.getReportStyle() == 3 ){%>소설<%} %></td>
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
		const userNo = $(this).parent().parent().children().eq(1).text();
		console.log(userNo);
		const userLevel = $(this).parent().prev().children().val();
		console.log(userLevel);
		location.href="/changeUserLevel.do?userNo="+userNo+"&userLevel="+userLevel;
	});
$(".kk").hide();
</script>
</body>
</html>