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
				<span>문의사항 답변 등록/수정</span>
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
						<div>아이디<%=question.getQuestionUserId() %><br>닉네임<%=question.getQuestionName() %></div>
					</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td" colspan="3">
						<%=question.getQuestionContent() %>
					</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td">
						<input class="input-form" type="text" id="answerTitle" value="<%=question.getAnswerTitle()%>"></input>
					</td>
					<td class="question-td">
						<div><%=question.getAnswerDate() %></div>
					</td>
					<td class="question-td">
						<div>관리자 아이디<%=question.getAnswerUserId() %> <br>관리자 닉네임 <%=question.getAnswerUserName() %></div>
					</td>
				</tr>
				<tr class="question-tr">
					<td class="question-td" colspan="3">
						<textarea class="input-form" id="answerContent"><%=question.getAnswerContent() %></textarea>
					</td>
				</tr>
			</table>
			<div class="btn-position">
				<button class="btn bc1 bs1" id="editBtn" onclick="writeAnswer()">작성 완료</button>
			</div>
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