<%@page import="java.util.ArrayList"%>
<%@page import="com.iei.question.model.vo.QuestionVo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<QuestionVo> list = (ArrayList<QuestionVo>) request.getAttribute("list");
String pageNavi = (String)request.getAttribute("pageNavi");
int start = (int)request.getAttribute("start");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 게시판</title>
<link rel="stylesheet" href="/css/question.css">


</head>
<body>
<script src="/js/jquery-3.6.3.min.js"></script>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="question-wrap">
			<div class="question-header">
				<span>문의사항</span>
			</div>
			<%-- 검색 폼 태그 시작 --%>
			<div class="div-form-box">
				<form id="searchForm" action="/question/searchQuestion.do">
					<select id="searchType" class="select" name="searchType">
						<%-- 검색 선택 구간 --%>
						<option value="1" id="select2">제목</option>
						<option value="2" id="select2">작성자</option>
					</select> <input type="hidden" name="searchValue" id="hiddenSearchValue">
				</form>
				<input type="text" id="searchValue" class="select"
					onkeydown="javascript:if(event.keyCode==13) searchQuestion()">
				<button onclick="searchQuestion()" class="select bttn" id="search">검색</button>
			</div>
			<%-- 검색 폼 태그 종료 --%>
			<%-- 검색 미 입력시 나올 alert 띄우기 시작 --%>
			<script>
				function searchQuestion(){
					if($("#searchValue").val() == ""){
						alert("검색어를 입력해 주세요.");
						return;
					}
					$("#hiddenSearchValue").val($("#searchValue").val());
					$("#searchForm").submit();
				}
			</script>
			<%-- 검색 미 입력시 나올 alert 띄우기 종료 --%>
			<table class="question-tbl">
				<%
				if (list.size() < 1) {
				%>
				<%
				if(loginUser !=null && loginUser.getUserLevel() ==2) {
				%>
				<div class="write-btd-wrap">
					<button id="write-btn1" class="btn bc1 bs1">문의 게시물 작성</button>
				</div>
				<%}%>
				<button id="write-btn1" class="btn bc1 bs1"
					style="visibility: hidden;">문의 게시물 작성</button>
				<tr class="question-tr">
					<td class="question-td">문의사항이 없습니다.</td>
				</tr>
				<%
				} else {
				%>

				<%
				if(loginUser !=null && loginUser.getUserLevel() ==2) {
				%>
				<div class="write-btd-wrap">
					<%-- 문의 게시물 작성 버튼 --%>
					<button id="write-btn1" class="btn bc1 bs1">문의 게시물 작성</button>
				</div>
				<%}%>
				<button id="write-btn1" class="btn bc1 bs1"
					style="visibility: hidden;">문의 게시물 작성</button>
				<thead>
					<tr class="question-tr ttr">
						<td class="question-td ttd" style="width: 6%">번호</td>
						<td class="question-td ttd" style="width: 10%">종류</td>
						<td class="question-td ttd" style="width: 40%">제목</td>
						<td class="question-td ttd" style="width: 8%">작성자</td>
						<td class="question-td ttd" style="width: 10%">작성일</td>
						<td class="question-td ttd" style="width: 9%">답변여부</td>
						<td class="question-td ttd" style="width: 10%">답변일자</td>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < list.size(); i++) {
					%>
					<%
					QuestionVo q = list.get(i);
					%>

					<tr class="question-tr ttr">
						<td class="question-td ttd"><%=i+start %></td>
						<td class="question-td ttd">
							<% if(q.getQuestionType() == 1 ){%>이용안내 <%}else if(q.getQuestionType() == 2 ){%>시스템오류
							<%}else if(q.getQuestionType() == 3 ){%>결제 <%}else if(q.getQuestionType() == 4 ){%>건의사항
							<%}else if(q.getQuestionType() == 5 ){%>기타 <%}else if(q.getQuestionType() == 6 ){%>신고
							<%} %>
						</td>
						<%-- 게시물 제목 --%>
						<td class="question-td ttd">
							<% if(loginUser !=null && loginUser.getUserLevel() == 2||loginUser !=null && loginUser.getUserLevel() == 1) {%>
							<a
							href="/question/viewQuestion.do?questionNo=
							<%=q.getQuestionNo()%>"><%=q.getQuestionTitle()%></a>
							<%}else{%> <%=q.getQuestionTitle()%><%} %>
						</td>
						<td class="question-td ttd"><%=q.getQuestionName()%></td>
						<%-- 작성자 --%>
						<td class="question-td ttd"><%=q.getEnrollDate()%></td>
						<td class="question-td ttd">
							<%if(q.getAnswerYn().equals("y")) {%> 답변완료 <%}else if(q.getAnswerYn().equals("n")){ %>
							미답변 <%} %>
						</td>

						<td class="question-td ttd">
							<%if(q.getAnswerDate().equals("n")){ %> 답변 대기중 <%}else{ %> <%=q.getAnswerDate()%>
							<%} %>
						</td>
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
	$("#write-btn1").on("click",function(){
		const loginUser = $(this).parent().parent().children().find('tr').eq(2).children().eq(1).text();
		console.log(loginUser);
		location.href =  '/questionWriteFrm.do';
	});

</script>
</body>
</html>