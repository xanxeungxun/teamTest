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
<link rel="stylesheet" href="/css/report.css">
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp"%>
	<div class="page-content">
		<div class="report-wrap">
			<div class="report-header">
				<span>문의사항 상세보기</span>
			</div>
			<table class="report-tbl">
				<tr class="report-tr">
					<td class="report-td-2" colspan="4">문의사항</td>
				</tr>
				<tr class="report-tr">
					<td class="report-td" style="width: 30%"><span><%=report.getreportTitle()%></span>
					</td>
					<td class="report-td" style="width: 10%">
						<div><%=report.getEnrollDate()%></div>
					</td>
					<td class="report-td" style="width: 10%">
						<div>
							아이디
							<%=report.getreportUserId()%>
							<br> 닉네임
							<%=report.getreportName()%></div>
					</td>
				</tr>
				<tr class="report-tr">
					<td class="report-td" colspan="3" style="padding-left: 30px;">
						<%=report.getreportContent().replace("\r\n", "<br>")%> <%-- 작성자 게시물 --%>
					</td>
				</tr>
				<%if (report.getAnswerUserId().equals("n")) {%>
				<tr class="report-tr">
					<td class="report-td-2" colspan="4">답변</td>
				</tr>
				<tr class="report-tr">
					<td class="report-td" colspan="4">등록된 답변이 없습니다.</td>
				</tr>
				<br>
				<%} else {%>
				<tr class="report-tr">
					<td class="report-td-2" colspan="4">답변</td>
				</tr>
				<tr class="report-tr">

					<td class="report-td">
						<%-- 관리자 게시물 제목 --%> <span>
						<%=report.getAnswerTitle()%></span>
					</td>
					<td class="report-td">
						<div><%=report.getAnswerDate()%></div>
					</td>
					<td class="report-td">
						<div>
							관리자 아이디 <%=report.getAnswerUserId()%>
							<br>관리자 닉네임
							<%=report.getAnswerUserName()%></div>
					</td>
				</tr>
				<tr class="report-tr">
					<td class="report-td" colspan="3" style="padding-left: 30px;">
						<%=report.getAnswerContent().replace("\n", "<br>")%>
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
'/report/editAnswerView.do?questionNo=<%=question.getQuestionNo()%>'">
					답변 입력/수정</button>
			</div>
			<%}%>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp"%>
</body>
</html>