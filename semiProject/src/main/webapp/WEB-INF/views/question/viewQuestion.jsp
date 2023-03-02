<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.iei.question.model.vo.QuestionVo"%>
    <%
    	QuestionVo question = (QuestionVo)request.getAttribute("questionResult");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/notice.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="notice-wrap">
			<div class="notice-header">
				<span>문의사항 상세보기</span>
			</div>
			<table class="notice-tbl">
				<tr class="notice-tr">
					<td class="notice-td">
						<span><%=question.getQuestionTitle()%></span>
					</td>
					<td class="notice-td">
						<div><%=question.getEnrollDate() %></div>
					</td>
					<td class="notice-td">
						<div><%=question.getQuestionUserId() %> / <%=question.getQuestionName() %></div>
					</td>
				</tr>
				<tr class="notice-tr">
					<td class="notice-td" colspan="3">
						<%=question.getQuestionContent() %>
					</td>
				</tr>
				<tr class="notice-tr">
					<td class="notice-td">
						<span><%=question.getAnswerTitle()%></span>
					</td>
					<td class="notice-td">
						<div><%=question.getAnswerDate() %></div>
					</td>
					<td class="notice-td">
						<div><%=question.getAnswerUserId() %> / <%=question.getAnswerUserName() %></div>
					</td>
				</tr>
				<tr class="notice-tr">
					<td class="notice-td" colspan="3">
						<%=question.getAnswerContent() %>
					</td>
				</tr>
			</table>
			<button onclick="location.href = '/question/editAnswerView.do?questionNo=<%=question.getQuestionNo()%>'">답변 입력/수정</button>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>