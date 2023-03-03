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
				<tr class="question-tr">
					<td class="question-td">문의사항이 없습니다.</td>
				</tr>
				<%
				} else {
				%>
				
				<div class="write-btd-wrap">
					<%-- 문의 게시물 작성 버튼 --%>
					<button id="write-btn1" class="btn bc1 bs1" onclick="location.href =  '/questionWriteFrm.do';">문의 게시물 작성</button>
				</div>
				<thead>
					<tr class="question-tr">
						<td class="question-td" style="width:6%">번호</td>
						<td class="question-td" style="width:6%">종류</td>
						<td class="question-td" style="width:57%">제목</td>
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
					<tr class="question-tr">
						<td class="question-td"><%=i+start %></td>
						<td class="question-td"></td>
						<td class="question-td"><a
							href="/question/viewQuestion.do?questionNo=<%=q.getQuestionNo()%>"><%=q.getQuestionTitle()%></a></td>
						<td class="question-td"><%=q.getQuestionName()%></td>
						<td class="question-td"><%=q.getEnrollDate()%></td>
						<td class="question-td">&emsp;<%=q.getAnswerYn()%>&emsp;</td>
						
						<td class="question-td"><%=q.getAnswerDate()%></td>
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