<%@page import="com.iei.userManage.model.vo.*"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<UserManageVo> list = (ArrayList<UserManageVo>) request.getAttribute("list");
String pageNavi = (String)request.getAttribute("pageNavi");
int start = (int)request.getAttribute("start");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<link rel="stylesheet" href="/css/userManage.css">
<script>

</script>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="userManage-wrap">
			<div class="userManage-header">
				<span>회원 관리</span>
			</div>
			<table class="userManage-tbl">
				<%
				if (list.size() < 1) {
				%>
				<tr class="userManage-tr">
					<td class="userManage-td">조회된 회원이 없습니다.</td>
				</tr>
				<%
				} else {
				%>
				
				<thead>
					<tr class="userManage-tr">
					<td class="userManage-td" style="width:calc(100%/8)">순번</td>
						<td class="userManage-td" style="width:calc(100%/8)">아이디</td>
						<td class="userManage-td" style="width:calc(100%/8)">이름</td>
						<td class="userManage-td" style="width:calc(100%/8)">닉네임</td>
						<td class="userManage-td" style="width:calc(100%/8)">전화번호</td>
						<td class="userManage-td" style="width:calc(100%/8)">등급</td>
						<td class="userManage-td" style="width:calc(100%/8)">가입일</td>
						<td class="userManage-td" style="width:calc(100%/8)">이메일</td>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < list.size(); i++) {
					%>
					<%
					UserManageVo q = list.get(i);
					%>
					<tr class="userManage-tr">
						<td class="userManage-td"><%=i+start %></td>
						<td class="userManage-td"><%=q.getUserId() %></td>
						<td class="userManage-td"><%=q.getUserName() %>
						<td class="userManage-td"><%=q.getUserNick() %></td>
						<td class="userManage-td"><%=q.getUserPhone() %></td>
						<td class="userManage-td">
						<%
						if(q.getUserLevel() == 1 ){
						%>
						관리자
						<%
						}else if(q.getUserLevel() == 2 ){
						%>
						일반
						<%
						}else if(q.getUserLevel() == 3 ){
						%>
						블락
						<%
						}else if(q.getUserLevel() == 4 ){
						%>
						탈퇴
						<%} %>
						</td>
						<td class="userManage-td"><%=q.getUserEnroll() %></td>
						<td class="userManage-td"><%=q.getUserEmail() %></td>
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