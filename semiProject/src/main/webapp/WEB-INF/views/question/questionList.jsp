<%@page import="java.util.ArrayList"%>
<%@page import="com.iei.question.model.vo.QuestionVo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<QuestionVo> list = (ArrayList<QuestionVo>) request.getAttribute("questionList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

					<button id="write-btn1">버튼테스트</button>
				</div>
				<thead>
					<tr class="question-tr">
						<td class="question-td">문의번호</td>
						<td class="question-td">ID</td>
						<td class="question-td">이름</td>
						<td class="question-td">제목</td>
						<td class="question-td">작성일자</td>
						<td class="question-td">답변여부</td>
						<td class="question-td">답변자명</td>
						<td class="question-td">답변자ID</td>
						<td class="question-td">답변일자</td>
					</tr>
				</thead>
				<tbody>
					<%
					for (int i = 0; i < list.size(); i++) {
					%>
					<%
					QuestionVo n = list.get(i);
					%>
					<tr class="question-tr">
						<td class="question-td"><%=n.getQuestionNo()%></td>
						<td class="question-td"><%=n.getQuestionUserId()%></td>
						<td class="question-td"><%=n.getQuestionName()%></td>
						<td class="question-td"><a
							href="/question/viewQuestion.do?questionNo=<%=n.getQuestionNo()%>"><%=n.getQuestionTitle()%></a></td>
						<td class="question-td"><%=n.getEnrollDate()%></td>
						<td class="question-td"><%=n.getAnswerYn()%></td>
						<td class="question-td"><%=n.getAnswerUserName()%></td>
						<td class="question-td"><%=n.getAnswerUserId()%></td>
						<td class="question-td"><%=n.getAnswerDate()%></td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>