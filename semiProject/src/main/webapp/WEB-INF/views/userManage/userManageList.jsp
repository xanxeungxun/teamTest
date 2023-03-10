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
<script src="/js/jquery-3.6.3.min.js">
</script>
<style>
.userManage-tr{
	text-align:center;
}
.tt {
	background: #F2F1F3;
}
.write-btd-wrap{
margin:0;
}
.bb:hover{
background:#F7F7F7;
}
/*검색창 css 만들기 시작*/
.div-form-box{
	color:red;
	width: 1200px;
	overflow:hidden;
	height:40px;
	font-size:14px;
}
.div-form-box #searchType{
	padding-left:10px;
	width:76.72px;
}
/*검색바 전체디자인*/
.div-form-box .select{
	height:40px;
	float:left;
	font-size:14px;
	box-sizing:border-box;
}
/*검색어 바*/
.div-form-box>#searchValue{
	padding-left:10px;
	width:123px;
	height:40px;
	box-sizing:border-box;
	font-size:14px;
}
.div-form-box .bttn{
	box-sizing:border-box;
	width:127px;
}
/*검색창 css 만들기 끝*/
</style>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="userManage-wrap">
			<div class="userManage-header">
				<span>회원 관리</span>
			</div>
			
			<%-- 검색 폼 태그 시작 --%>
			<div class="div-form-box">
				<form id="searchForm" action="/userManage/searchUserManage.do">
					<select id="searchType" class="select bc333" name="searchType"
						style="background: #fff; border: 1px solid #CCC;">
						<%-- 검색 선택 구간 --%>
						<option value="1" id="select2">아이디</option>
						<option value="2" id="select2">닉네임</option>
					</select> <input type="hidden" name="searchValue" id="hiddenSearchValue">
				</form>
				<input type="text" id="searchValue" class="select bc333"
					style="background: #fff; border: 1px solid #CCC;"
					onkeydown="javascript:if(event.keyCode==13) searchUserManage()">
				<button onclick="searchUserManage()" class="select bttn bc333"
					id="search" style="background: #fff; border: 1px solid #CCC;">검색</button>
			</div>
			<%-- 검색 폼 태그 종료 --%>
			<%-- 검색 미 입력시 나올 alert 띄우기 시작 --%>
			<script>
				function searchUserManage() {
					if ($("#searchValue").val() == "") {
						alert("검색어를 입력해 주세요.");
						return;
					}
					$("#hiddenSearchValue").val($("#searchValue").val());
					$("#searchForm").submit();
				}
			</script>
			<%-- 검색 미 입력시 나올 alert 띄우기 종료 --%>
			
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
				<br>
				<thead>
					<tr class="userManage-tr" style="background:#F2F1F3;">
					<td class="userManage-td" style="width:7.2%;padding:10px;">순번</td>
						<td class="userManage-td kk" style="width:5%;">유저코드</td>
						<td class="userManage-td" style="width:6%;">아이디</td>
						<td class="userManage-td" style="width:13%;">이름</td>
						<td class="userManage-td" style="width:10%;">닉네임</td>
						<td class="userManage-td" style="width:15%;">전화번호</td>
						<td class="userManage-td" style="width:10%;">이메일</td>
						<td class="userManage-td" style="width:15%;">가입일</td>
						<td class="userManage-td" style="width:8%;">등급</td>
						<td colspan="2" class="userManage-td" style="width:10%">등급변경</td>
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
						<td rowspan="2"class="userManage-td"style="font-size:14px;"><%=i+start %></td>
						<td rowspan="2"class="userManage-td kk"style="font-size:14px;"><%=u.getUserNo() %></td>
						<td rowspan="2"class="userManage-td"style="font-size:14px;"><%=u.getUserId() %></td>
						<td rowspan="2"class="userManage-td"style="font-size:14px;"><%=u.getUserName() %>
						<td rowspan="2"class="userManage-td"style="font-size:14px;"><%=u.getUserNick() %></td>
						<td rowspan="2"class="userManage-td" style="font-size:14px;"><%=u.getUserPhone() %></td>
						<td rowspan="2"class="userManage-td"style="font-size:14px;"><%=u.getUserEmail() %></td>
						<td rowspan="2"class="userManage-td"style="font-size:14px;"><%=u.getUserEnroll() %></td>
						<td rowspan="2"class="userManage-td"style="font-size:14px;">
						<% if(u.getUserLevel() == 1 ){%>관리자
						<%}else if(u.getUserLevel() == 2 ){%>일반
						<%}else if(u.getUserLevel() == 3 ){%>블락
						<%}else if(u.getUserLevel() == 4 ){%>탈퇴<%} %>
						</td>
						<td rowspan="2" colspan="2"class="userManage-td"style="font-size:14px;">
    			<%if(u.getUserLevel()==1){ %>
    			<select class="input-form"style="font-size:14px;height:30px;padding:0;width:78px;margin-left:3.5px;border-radius:0;">
    					<option value="1" selected>관리자</option>
    					<option value="2">일반</option>
    					<option value="3">블락</option>
    				</select>
    			<%}else if(u.getUserLevel()==2){ %>
    			<select class="input-form"style="font-size:14px;height:30px;padding:0;width:78px;margin-left:3.5px;border-radius:0;">
    					<option value="1">관리자</option>
    					<option value="2" selected>일반</option>
    					<option value="3">블락</option>
    				</select>
    			<%}else if(u.getUserLevel()==3){ %>
    			<select class="input-form"style="font-size:14px;height:30px;padding:0;width:78px;margin-left:3.5px;border-radius:0;">
    					<option value="1">관리자</option>
    					<option value="2">일반</option>
    					<option value="3" selected>블락</option>
    				</select>
    			<%} %>
						<button type="button" class="btn bc1 bs1 delBtn"style="font-size:12px;border-radius:0;border:0px;width:78px;">등급변경</button>
    				</td>
    			</tr>
					<tr class="userManage-tr"></tr>
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
		const userNo = $(this).parent().parent().children().prev().eq(1).text();
		console.log(userNo);
		const userLevel = $(this).prev().val();
		console.log(userLevel);
		location.href="/changeUserLevel.do?userNo="+userNo+"&userLevel="+userLevel;
	});
$(".kk").hide();
</script>
</body>
</html>