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

	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="question-wrap">
			<div class="question-header">
				<span>문의사항</span>
			</div>
			<table class="question-tbl">
				<%
				if (list.size() < 1) {
				%>
				<%
				if(loginUser !=null && loginUser.getUserLevel() ==2) {
				%>
				<div class="write-btd-wrap">
					<button id="write-btn1" class="btn bc1 bs1">
					문의 게시물 작성</button>
				</div>
				<%}%>
					<button id="write-btn1" class="btn bc1 bs1" style="visibility:hidden;">
					문의 게시물 작성</button>
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
				<button id="write-btn1" class="btn bc1 bs1">
					문의 게시물 작성</button>
				</div>
					<%}%>
					<button id="write-btn1" class="btn bc1 bs1" style="visibility:hidden;">
					문의 게시물 작성</button>
				<thead>
					<tr class="question-tr">
						<td class="question-td" style="width:6%">번호</td>
						<td class="question-td" style="width:10%">종류</td>
						<td class="question-td" style="width:40%">제목</td>
						<td class="question-td" style="width:8%">작성자</td>
						<td class="question-td" style="width:10%">작성일</td>
						<td class="question-td" style="width:9%">답변여부</td>
						<td class="question-td" style="width:10%">답변일자</td>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < list.size(); i++) {
					%>
					<%
					QuestionVo q = list.get(i);
					%>
						<% String y = "y"; %>
						<% String n = "n"; %>
						
					<tr class="question-tr">
						<td class="question-td"><%=i+start %></td>
						<%--- --%>
						<td class="question-td">
						<% if(q.getQuestionType() == 1 ){%>이용안내
						<%}else if(q.getQuestionType() == 2 ){%>시스템오류
						<%}else if(q.getQuestionType() == 3 ){%>결제
						<%}else if(q.getQuestionType() == 4 ){%>건의사항
						<%}else if(q.getQuestionType() == 5 ){%>기타
						<%}else if(q.getQuestionType() == 6 ){%>신고<%} %>
						</td>
						<td class="question-td"><a
							href="/question/viewQuestion.do?questionNo=<%=q.getQuestionNo()%>"><%=q.getQuestionTitle()%></a></td>
						<td class="question-td"><%=q.getQuestionName()%></td><%-- 작성자 --%>
						<td class="question-td">
						
						<%=q.getEnrollDate()%>
					
						</td>
						<td class="question-td">
						<%if(q.getAnswerYn().equals("y")) {%>
						답변완료
						<%}else if(q.getAnswerYn().equals("n")){ %>
						미답변
						<%} %>
						</td>
						
						<td class="question-td">
						<%if(q.getAnswerDate().equals("n")){ %>
						답변 대기중
						<%}else{ %>
						<%=q.getAnswerDate()%>
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