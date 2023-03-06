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
<link rel="stylesheet" href="/css/question.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="question-wrap">
			<div class="question-header">
				<span>문의사항 상세보기</span>
			</div>
			<table class="question-tbl">
				<tr class="question-tr">
					<td class="question-td">
						<span><%=question.getQuestionTitle()%></span>
					</td>
					<td class="question-td">
						<div><%=question.getEnrollDate() %></div>
					</td>
					<td class="question-td">
						<div>아이디 <%=question.getQuestionUserId() %> <br>
						닉네임 <%=question.getQuestionName() %></div>
					</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td" colspan="3" style="padding-left:30px;">
						<%=question.getQuestionContent().replace("\r\n","<br>") %>
					</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td">
						<span><%=question.getAnswerTitle()%></span>
					</td>
					<td class="question-td">
						<div><%=question.getAnswerDate() %></div>
					</td>
					<td class="question-td">
						<div>관리자 아이디<%=question.getAnswerUserId() %> <br>관리자 닉네임 <%=question.getAnswerUserName() %></div>
					</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td" colspan="3" style="padding-left:30px;">
						<%=question.getAnswerContent().replace("\n","<br>") %>
					</td>
				</tr>
			</table>
			<div class="btn-position">
			<button class="btn bc1 bs1" id="editBtn" onclick="location.href = '/question/editAnswerView.do?questionNo=<%=question.getQuestionNo()%>'">답변 입력/수정</button>
			</div>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>