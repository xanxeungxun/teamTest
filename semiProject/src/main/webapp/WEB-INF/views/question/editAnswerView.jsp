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
				<span>문의사항 답변 등록/수정</span>
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
						<input type="text" id="answerTitle" value="<%=question.getAnswerTitle()%>"></input>
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
						<textarea id="answerContent"><%=question.getAnswerContent() %></textarea>
					</td>
				</tr>
			</table>
			<button onclick="writeAnswer()">작성 완료</button>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>

<script>
	function writeAnswer(){
		
		//ajax 통신에 사용 될 객체를 만듬
		let inputData = {
			questionNo : "<%=question.getQuestionNo()%>",
			answerTitle : document.querySelector("#answerTitle").value,
			answerContent : document.querySelector("#answerContent").value
		};
		
		
		$.ajax({
		    url:"/question/editAnswer.do",
		    type:"GET",
		    dataType:"",
		    data:inputData,
		    success: function(result) {
				alert("답변이 작성되었습니다.");
				location.href = '/question/viewQuestion.do?questionNo=<%=question.getQuestionNo()%>'
		    },
		    error: function(result){
		    	alert("오류가 발생했습니다.");
		    }
		});		
	}
</script>
</html>