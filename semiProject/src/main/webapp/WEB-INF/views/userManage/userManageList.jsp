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
</head>
<body>
<script src="/js/jquery-3.6.3.min.js"></script>
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
					<td class="userManage-td" style="width:calc(100%/10)">순번</td>
						<td class="userManage-td kk" style="width:calc(100%/10)">유저코드</td>
						<td class="userManage-td" style="width:calc(100%/10)">아이디</td>
						<td class="userManage-td" style="width:calc(100%/10)">이름</td>
						<td class="userManage-td" style="width:calc(100%/10)">닉네임</td>
						<td class="userManage-td" style="width:calc(100%/10)">전화번호</td>
						<td class="userManage-td" style="width:calc(100%/10)">등급</td>
						<td class="userManage-td" style="width:calc(100%/10)">가입일</td>
						<td class="userManage-td" style="width:calc(100%/10)">이메일</td>
						<td colspan="2" class="userManage-td" style="width:calc(100%/10)">등급변경</td>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < list.size(); i++) {
					%>
					<%
					UserManageVo u = list.get(i);
					%>
					<td>
					<tr class="userManage-tr">
						<td class="userManage-td"><%=i+start %></td>
						<td class="userManage-td kk"><%=u.getUserNo() %></td>
						<td class="userManage-td"><%=u.getUserId() %></td>
						<td class="userManage-td"><%=u.getUserName() %>
						<td class="userManage-td"><%=u.getUserNick() %></td>
						<td class="userManage-td"><%=u.getUserPhone() %></td>
						<td class="userManage-td">
						<% if(u.getUserLevel() == 1 ){%>관리자
						<%}else if(u.getUserLevel() == 2 ){%>일반
						<%}else if(u.getUserLevel() == 3 ){%>블락
						<%}else if(u.getUserLevel() == 4 ){%>탈퇴<%} %>
						</td>
						<td class="userManage-td"><%=u.getUserEnroll() %></td>
						<td class="userManage-td"><%=u.getUserEmail() %></td>
						<td class="userManage-td">
    			<%if(u.getUserLevel()==1){ %>
    			<select class="input-form">
    					<option value="1" selected>관리자</option>
    					<option value="2">일반</option>
    					<option value="3">블락</option>
    				</select>
    			<%}else if(u.getUserLevel()==2){ %>
    			<select class="input-form">
    					<option value="1">관리자</option>
    					<option value="2" selected>일반</option>
    					<option value="3">블락</option>
    				</select>
    			<%}else if(u.getUserLevel()==3){ %>
    			<select class="input-form">
    					<option value="1">관리자</option>
    					<option value="2">일반</option>
    					<option value="3" selected>블락</option>
    				</select>
    			<%} %>
    			</td>
    			<td colspan="2">
						<button type="button" class="btn bc1 bs1 delBtn">등급변경</button>
    			</td>
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