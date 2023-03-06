<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.iei.question.model.vo.QuestionVo"%>
<%
QuestionVo question = (QuestionVo) request.getAttribute("questionResult");
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
				<span>문의사항 상세보기</span>
			</div>
			<table class="question-tbl">
				<tr class="question-tr">
					<td class="question-td-2" colspan="4">문의사항</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td" style="width: 30%"><span><%=question.getQuestionTitle()%></span>
					</td>
					<td class="question-td" style="width: 10%">
						<div><%=question.getEnrollDate()%></div>
					</td>
					<td class="question-td" style="width: 10%">
						<div>
							아이디
							<%=question.getQuestionUserId()%>
							<br> 닉네임
							<%=question.getQuestionName()%></div>
					</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td" colspan="3" style="padding-left: 30px;">
						<%=question.getQuestionContent().replace("\r\n", "<br>")%> <%-- 작성자 게시물 --%>
					</td>
				</tr>
				<%if (question.getAnswerUserId().equals("n")) {%>
				<tr class="question-tr">
					<td class="question-td-2" colspan="4">답변</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td" colspan="4">등록된 답변이 없습니다.</td>
				</tr>
				<br>
				<%} else {%>
				<tr class="question-tr">
					<td class="question-td-2" colspan="4">답변</td>
				</tr>
				<tr class="question-tr">

					<td class="question-td">
						<%-- 관리자 게시물 제목 --%> <span>
						<%=question.getAnswerTitle()%></span>
					</td>
					<td class="question-td">
						<div><%=question.getAnswerDate()%></div>
					</td>
					<td class="question-td">
						<div>
							관리자 아이디 <%=question.getAnswerUserId()%>
							<br>관리자 닉네임
							<%=question.getAnswerUserName()%></div>
					</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td" colspan="3" style="padding-left: 30px;">
						<%=question.getAnswerContent().replace("\n", "<br>")%>
					</td>
				</tr>
				<%}%>
			</table>
			<br>
			<%-- 답변 입력 및 수정 --%>
			<%if (loginUser.getUserLevel() == 1) {%>
			<div class="btn-position">
				<button class="btn bc1 bs1" id="editBtn"
					onclick="location.href = 
'/question/editAnswerView.do?questionNo=<%=question.getQuestionNo()%>'">
					답변 입력/수정</button>
			</div>
			<%}%>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>