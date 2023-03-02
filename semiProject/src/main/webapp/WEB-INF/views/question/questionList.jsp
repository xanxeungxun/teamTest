<%@page import="java.util.ArrayList"%>
<%@page import="com.iei.question.model.vo.QuestionVo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<QuestionVo> list = (ArrayList<QuestionVo>)request.getAttribute("questionList");
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
					<span>문의사항</span>
				</div>
				<table class="notice-tbl">
					<% if(list.size() < 1) {%>
						<tr class="notice-tr">
							<td class="notice-td">
								문의사항이 없습니다.
							</td>
						</tr>
					<%} else {%>
					
					<thead>
						<tr class="notice-tr">
							<td class="notice-td">문의번호</td>
							<td class="notice-td">ID</td>
							<td class="notice-td">이름</td>
							<td class="notice-td">제목</td>
							<td class="notice-td">작성일자</td>
							<td class="notice-td">답변여부</td>
							<td class="notice-td">답변자명</td>
							<td class="notice-td">답변자ID</td>
							<td class="notice-td">답변일자</td>
						</tr>
					</thead>
					<tbody>
						<%for(int i=0;i<list.size();i++) {%>
							<%QuestionVo n = list.get(i); %>
								<tr class="notice-tr">
									<td class="notice-td"><%=n.getQuestionNo() %></td>
									<td class="notice-td"><%=n.getQuestionUserId() %> </td>
									<td class="notice-td"><%=n.getQuestionName() %></td>
									<td class="notice-td"><a href="/question/viewQuestion.do?questionNo=<%=n.getQuestionNo()%>"><%=n.getQuestionTitle() %></a></td>
									<td class="notice-td"><%=n.getEnrollDate() %></td>
									<td class="notice-td"><%=n.getAnswerYn() %></td>
									<td class="notice-td"><%=n.getAnswerUserName() %></td>
									<td class="notice-td"><%=n.getAnswerUserId() %></td>
									<td class="notice-td"><%=n.getAnswerDate() %></td>
								</tr>
						<%} }%>
					</tbody>
				</table>
			</div>
		</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>